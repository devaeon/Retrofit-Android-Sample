package com.devaeon.core.data.resource

import android.content.Context
import com.devaeon.common.ResourceProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(@ApplicationContext private val context: Context) : ResourceProvider {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

    override fun <T> getString(resId: Int, vararg formatArgs: T): String {
        return context.getString(resId, *formatArgs)
    }
}
