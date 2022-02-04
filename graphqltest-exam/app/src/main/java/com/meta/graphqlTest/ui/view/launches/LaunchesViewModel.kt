package com.meta.graphqlTest.ui.view.launches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meta.datagraphql.domain.business.ResponseState
import com.meta.datagraphql.domain.repository.LaunchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LaunchesViewModel : ViewModel() {

    private val PAGE_SIZE = 10
    private val launchesRepository = LaunchesRepository(Dispatchers.IO)
    val onGetLaunchesResponse = MutableLiveData<ResponseState<Any?>>()


     fun getLaunches() {
         onGetLaunchesResponse.value = ResponseState.Loading
        viewModelScope.launch {
            val res = launchesRepository.getLaunches(PAGE_SIZE)
            launch(Dispatchers.Main) {
                onGetLaunchesResponse.value = res
            }
        }
    }
}