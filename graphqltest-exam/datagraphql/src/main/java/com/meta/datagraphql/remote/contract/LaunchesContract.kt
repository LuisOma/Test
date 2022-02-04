package com.meta.datagraphql.remote.contract

import com.meta.datagraphql.domain.business.ResponseState

interface LaunchesContract {
    suspend fun getLaunches(pageSize: Int): ResponseState<Any?>
}