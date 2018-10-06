package {{ cookiecutter.package_name }}.core.base

import com.github.s0nerik.reduxdroid.core.ActionDispatcher
import com.github.s0nerik.reduxdroid.core.StateStore
import com.github.s0nerik.reduxdroid.viewmodel.ReduxViewModel
import {{ cookiecutter.package_name }}.core.util.ResourceResolver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
        store: StateStore,
        private val res: ResourceResolver,
        dispatcher: ActionDispatcher,
        uiContext: CoroutineContext = Dispatchers.Main,
        bgContext: CoroutineContext = Dispatchers.Default,
        ioContext: CoroutineContext = Dispatchers.IO
) : ReduxViewModel(store, dispatcher), ResourceResolver by res, CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + uiContext

    protected val uiContext = job + uiContext
    protected val bgContext = job + bgContext
    protected val ioContext = job + ioContext

    override fun onCleared() {
        job.cancel()
    }
}