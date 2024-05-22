package com.cocinamingle.network.impl.interceptor

import com.cocinamingle.network.api.constants.NetworkConstants.APP_ID
import com.cocinamingle.network.api.constants.NetworkConstants.AUTHORIZATION_KEY
import com.cocinamingle.network.api.constants.NetworkConstants.TYPE
import com.cocinamingle.network.api.interceptors.AuthorizationInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptorImpl @Inject constructor(
) : AuthorizationInterceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url
        val appKey = "ba544d2b19bb883d3307bc0bd53b7e36"
        val appId = "47b17b97"
        val type = "public"

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter(AUTHORIZATION_KEY, appKey)
            .addQueryParameter(APP_ID, appId)
            .addQueryParameter(TYPE, type)
            .build()

        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}
