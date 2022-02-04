package com.meta.datagraphql.domain.business

import com.meta.datagraphql.domain.business.error.ErrorState

sealed class ResponseState<out T> {
    object Loading : ResponseState<Nothing>()
    class Success<T>(val data: T) : ResponseState<T>()
    class Error<T>(val throwable: ErrorState) : ResponseState<T>()
}