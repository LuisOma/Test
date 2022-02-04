package com.meta.datagraphql.domain.repository

import com.meta.datagraphql.domain.business.ResponseState
import com.meta.datagraphql.remote.launches.LaunchesRemote
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class LaunchesRepository(
    private val dispatcher: CoroutineContext
) {
    suspend fun getLaunches(pageSize: Int): ResponseState<Any?> {
        var remote : ResponseState<Any?>
        withContext(dispatcher){
            remote = LaunchesRemote().getLaunches(pageSize)
        }
        return remote
    }
}