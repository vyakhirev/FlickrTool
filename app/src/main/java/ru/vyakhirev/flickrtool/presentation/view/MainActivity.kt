package ru.vyakhirev.flickrtool.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.Photo
import ru.vyakhirev.flickrtool.presentation.viewmodel.ListPhotosViewModel

class MainActivity : AppCompatActivity(), ListPhotosFragment.OnPhotoClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigation()
    }

    lateinit var viewModel: ListPhotosViewModel
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView? = searchItem.actionView as SearchView

        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    subscriber.onNext(query!!)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    subscriber.onNext(newText!!)
                    return false
                }
            })
        })
            .map {
                it.toLowerCase(Locale.ROOT).trim()
            }
            .debounce(250, TimeUnit.MILLISECONDS)
            .distinct()
            .filter {
                it.isNotBlank()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("tux", it)
            }
        return true
    }

    private fun setupNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        bottomNavigation.findViewById<BottomNavigationItemView>(R.id.action_search).visibility=View.GONE
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            val nav_Controller = findNavController(R.id.nav_host_fragment)
            when (it.itemId) {

                R.id.action_list -> {
                    nav_Controller.navigate(R.id.ListPhotosFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_favoritesPhoto -> {
                    nav_Controller.navigate(R.id.FavoritesPhotosFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_settings -> {
                    nav_Controller.navigate(R.id.BigPhotoFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_search -> {
                }
            }
            false
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPhotoClick(photo: Photo) {
//        val nav_Controller=findNavController(R.id.nav_host_fragment)
//        nav_Controller.navigate(R.id.BigPhotoFragment)
    }
}
