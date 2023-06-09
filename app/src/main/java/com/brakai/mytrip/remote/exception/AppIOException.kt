package com.brakai.mytrip.remote.exception

import java.io.IOException

open class AppIOException(
    message: String = "",
    override val type: ExceptionType = ExceptionType.ERROR
) : IOException(message), AppException
