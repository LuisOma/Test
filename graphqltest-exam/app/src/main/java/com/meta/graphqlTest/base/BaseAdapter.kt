package com.meta.graphqlTest.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any, VB : ViewDataBinding>
    : RecyclerView.Adapter<BaseAdapter.Companion.BaseViewHolder<VB>>() {

    var itemList = mutableListOf<T>()
    var emptyItems = MutableLiveData<Boolean>()

    fun addItems(items: List<T>) {
        itemList = if (items.isNotEmpty()) {
            items as MutableList<T>
        } else {
            mutableListOf()
        }
        notifyDataSetChanged()
        emptyItems.postValue(items.isEmpty())
    }

    fun removeItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    var listener: ((view: View, item: T, position: Int) -> Unit)? = null
    var itemView = getLayout()

    abstract fun getLayout(): Int

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<VB>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayout(),
            parent,
            false
        )
    )


    companion object {
        class BaseViewHolder<VB : ViewDataBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }
}