package ru.vyakhirev.core_impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class ViewModelFactoryProvider
@Inject constructor(
    private val creators: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val found = creators.entries.find {
            modelClass.isAssignableFrom(it.key)
        }
        val creator = found?.value
            ?: throw ClassNotFoundException("no model provided with for ${modelClass.simpleName}")
        return creator as T
    }
}
//@Suppress("UNCHECKED_CAST")
//class ViewModelFactoryProvider
//@Inject constructor(
//    private val creators: Map<Class<out ViewModel>,
//            @JvmSuppressWildcards Provider<ViewModel>>
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val creator = creators[modelClass]
//            ?: creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
//            ?: throw IllegalArgumentException("Unknown ViewModel class $modelClass")
//
//        return try { creator.get() as T } catch (e: Exception) { throw RuntimeException(e) }
//    }
//}