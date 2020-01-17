package com.example.mpp.noty.shared

import kotlin.coroutines.CoroutineContext

expect val defaultDispatcher: CoroutineContext
expect val uiDispatcher: CoroutineContext
