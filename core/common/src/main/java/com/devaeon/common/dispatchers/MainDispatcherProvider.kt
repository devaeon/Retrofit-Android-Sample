package com.devaeon.common.dispatchers

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainDispatcherProvider @Inject constructor() : CoroutineDispatcherProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
    override val default = Dispatchers.Default
}
