package {{ cookiecutter.package_name }}.core.base

import com.github.s0nerik.reduxdroid.core.ActionDispatcher
import com.github.s0nerik.reduxdroid.core.StateStore
import com.github.s0nerik.reduxdroid.viewmodel.ReduxViewModel
import {{ cookiecutter.package_name }}.core.util.CoroutineContextHolder
import {{ cookiecutter.package_name }}.core.util.ResourceResolver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
        store: StateStore,
        res: ResourceResolver,
        dispatcher: ActionDispatcher,
        ctx: CoroutineContextHolder
) : ReduxViewModel(store, dispatcher), ResourceResolver by res, CoroutineContextHolder by ctx, CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + main

    override fun onCleared() {
        job.cancel()
    }
}
