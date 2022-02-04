package com.meta.datagraphql.domain.business.error

interface ErrorHandler {
    fun getError(code: Int? = 0, throwable: Throwable): ErrorState
}