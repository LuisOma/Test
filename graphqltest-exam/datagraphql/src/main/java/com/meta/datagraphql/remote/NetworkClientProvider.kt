package com.meta.datagraphql.remote

interface NetworkClientProvider<T> {
    fun getBaseUrl(): String
    fun getClient(): T
}