package com.meta.graphqlTest.ui.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.meta.datagraphql.domain.business.LaunchModel
import com.meta.graphqlTest.R
import com.meta.graphqlTest.base.BaseAdapter
import com.meta.graphqlTest.databinding.LaunchItemBinding
import com.meta.graphqlTest.utils.Constants

class LaunchesAdapter(private val context: Context): BaseAdapter<LaunchModel, LaunchItemBinding>() {

    override fun getLayout(): Int = R.layout.launch_item

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<LaunchItemBinding>,
        position: Int
    ) {
        holder.binding.launchId.text = context.getString(R.string.launch_id, itemList[position].id)


        holder.binding.launchSite.text = context.getString(R.string.launch_site, itemList[position].site)
        holder.binding.missionName.text = context.getString(R.string.mission_name, itemList[position].mission?.name)

        Glide.with(context)
            .load(itemList[position].mission?.missionPatch?:Constants.NO_IMAGE_URL)
            .into(holder.binding.missionImage)
    }




}