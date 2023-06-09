package com.brakai.mytrip.remote.util


import com.brakai.mytrip.remote.exception.ApiExceptionApp
import retrofit2.Response

fun <A : Any> Response<A>.bodyOrException(): A = body().let { body ->
    if (isSuccessful && body != null) body else throw ApiExceptionApp("api request failed")
}
