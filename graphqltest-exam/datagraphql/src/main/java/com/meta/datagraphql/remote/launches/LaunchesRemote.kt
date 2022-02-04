package com.meta.datagraphql.remote.launches

import com.meta.datagraphql.GetLaunchesQuery
import com.meta.datagraphql.domain.business.ResponseState
import com.meta.datagraphql.domain.business.error.ErrorState
import com.meta.datagraphql.remote.ApolloClient
import com.meta.datagraphql.remote.contract.LaunchesContract
import com.meta.datagraphql.remote.mapper.LaunchesMapper
import kotlinx.coroutines.coroutineScope

class LaunchesRemote : LaunchesContract {
    override suspend fun getLaunches(pageSize: Int): ResponseState<Any?> = coroutineScope {

        var responseState: ResponseState<Any?>
        try {
           val response = ApolloClient.getClient().query(GetLaunchesQuery(pageSize))
                .execute().data?.launches?.launches?.map {
                    LaunchesMapper.fromApolloResultToLaunchModel(it)
                }
            responseState = ResponseState.Success(response)

        }catch (e: ErrorState){
            responseState = ResponseState.Error(e)
        }
        responseState
        }
    }



