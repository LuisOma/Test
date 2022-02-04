package com.meta.datagraphql.domain.business.error

sealed class ErrorState : Throwable() {
    object Network : ErrorState()
    data class TransactionError(
        val code: String? = null,
        val results: List<String?>? = null,
        override val message: String? = null
    ) : ErrorState()
    data class NetworkError(override val message: String?) : ErrorState()
}