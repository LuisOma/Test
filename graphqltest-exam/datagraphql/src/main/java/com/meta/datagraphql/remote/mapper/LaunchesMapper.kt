package com.meta.datagraphql.remote.mapper

import com.meta.datagraphql.GetLaunchesQuery
import com.meta.datagraphql.domain.business.LaunchModel
import com.meta.datagraphql.domain.business.child.MissionModel

class LaunchesMapper {
    companion object {
        fun fromApolloResultToLaunchModel(apolloLaunchModel: GetLaunchesQuery.Launch?): LaunchModel {
            return apolloLaunchModel?.let {
                LaunchModel(
                    id = it.id,
                    site = it.site,
                    mission = MissionModel(
                        name = it.mission?.name,
                        missionPatch = it.mission?.missionPatch
                    )
                )
            } ?: LaunchModel(
                id = "",
                site = "",
                mission = null
            )
        }
    }
}