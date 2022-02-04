package com.meta.datagraphql.domain.business.error

import com.apollographql.apollo3.exception.ApolloNetworkException
import java.net.SocketException

class ErrorHandlerState : ErrorHandler {

    override fun getError(
        code: Int?,
        throwable: Throwable
    ): ErrorState {
        return when (code) {
            700 -> ErrorState.TransactionError(message = throwable.message.orEmpty())
            else -> when (throwable) {
                is ApolloNetworkException -> ErrorState.Network
                is SocketException -> ErrorState.Network
                else -> {
                    ErrorState.Network
                }
            }
        }
    }
}