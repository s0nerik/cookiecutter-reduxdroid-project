package {{ cookiecutter.package_name }}.core

import com.github.s0nerik.reduxdroid.core.di.AppModule
import {{ cookiecutter.package_name }}.core.util.ContextHolder
import {{ cookiecutter.package_name }}.core.util.MainContextHolder
import {{ cookiecutter.package_name }}.core.util.ResourceResolver
import {{ cookiecutter.package_name }}.core.util.ResourceResolverImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.android.Main

internal class Module : AppModule({
    single { ResourceResolverImpl(get()) } bind ResourceResolver::class

    single {
        MainContextHolder(main = kotlinx.coroutines.Dispatchers.Main, io = Dispatchers.IO, bg = Dispatchers.Default)
    } bind ContextHolder::class
})