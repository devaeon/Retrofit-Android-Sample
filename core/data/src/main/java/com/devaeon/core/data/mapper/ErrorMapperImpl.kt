package com.devaeon.core.data.mapper

import com.devaeon.common.ErrorMapper
import com.devaeon.common.ResourceProvider
import com.devaeon.core.data.R
import java.io.IOException
import javax.inject.Inject

class ErrorMapperImpl @Inject constructor(private val resourceProvider: ResourceProvider) :
    ErrorMapper {

    override operator fun invoke(throwable: Throwable): String =
        getUserMessage(throwable, resourceProvider)

    private fun getUserMessage(exception: Throwable, resourceProvider: ResourceProvider): String {
        return when (exception) {
            is IOException -> resourceProvider.getString(R.string.unable_to_read_or_write_data_please_check)
            is NullPointerException -> resourceProvider.getString(R.string.an_unexpected_error_occurred_please_restart_the_app_and_try_again)
            else -> resourceProvider.getString(
                R.string.an_unknown_error_occurred_please_contact_support, exception.localizedMessage
            )
        }
    }

}