package com.meta.graphqlTest.ui.view.launches

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.meta.datagraphql.domain.business.LaunchModel
import com.meta.datagraphql.domain.business.ResponseState
import com.meta.graphqlTest.R
import com.meta.graphqlTest.base.BaseFragment
import com.meta.graphqlTest.databinding.FragmentLaunchesBinding
import com.meta.graphqlTest.ui.adapter.LaunchesAdapter

class LaunchesFragment: BaseFragment<FragmentLaunchesBinding,LaunchesViewModel>() {

    private var launchesAdapter : LaunchesAdapter? = null

    override fun getFragment(): Int = R.layout.fragment_launches

    override fun getViewModel(): Class<LaunchesViewModel> = LaunchesViewModel::class.java

    override fun init() {
        viewModel.getLaunches()
    }

    override fun observe() {
       viewModel.onGetLaunchesResponse.observe(viewLifecycleOwner, Observer {
           if (it != null) {
               when(it){
                   is ResponseState.Loading -> {
                       binding.loading.visibility = View.VISIBLE
                   }
                   is ResponseState.Error -> {Toast.makeText(requireContext(),it.throwable.message, Toast.LENGTH_LONG).show()
                       binding.loading.visibility = View.GONE
                   }
                   is ResponseState.Success -> {launchesAdapter?.addItems(it.data as List<LaunchModel>)
                       binding.loading.visibility = View.GONE
                   }
               }


           }
       })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchesAdapter = LaunchesAdapter(requireContext())
        binding.launchesRecycler.adapter = launchesAdapter
        binding.launchesRecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}