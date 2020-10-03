package ru.vyakhirev.flickrtool

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var listPhotoMediator: ListPhotoMediator

    @Inject
    lateinit var favoritesPhotoMediator: FavoritesPhotoMediator

    @Inject
    lateinit var getPhotoSearchUseCase: GetPhotoSearchUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        MainComponent.create((application as AppWithFacade).getFacade()).inject(this)
        setSupportActionBar(findViewById(R.id.toolbar))
//        listPhotoMediator.openListPhotoScreen(R.id.fragmentContainer,supportFragmentManager)
        setupNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView = searchItem.actionView as SearchView

        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
                getPhotoSearchUseCase.execute(it, 1, 25)
            }
        return true
    }

    private fun setupNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        bottomNavigation.findViewById<BottomNavigationItemView>(R.id.action_search).visibility=
//            View.INVISIBLE
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
//            val nav_Controller = findNavController(R.id.nav_host_fragment)
            when (it.itemId) {

                R.id.action_list -> {
                    listPhotoMediator.openListPhotoScreen(
                        R.id.fragmentContainer,
                        supportFragmentManager
                    )
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_favoritesPhoto -> {
                    favoritesPhotoMediator.openFavoritesPhotoScreen(
                        R.id.fragmentContainer,
                        supportFragmentManager
                    )
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_settings -> {
//                    nav_Controller.navigate(R.id.BigPhotoFragment)
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

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, fragment.tag)
        transaction.commit()
    }
}
