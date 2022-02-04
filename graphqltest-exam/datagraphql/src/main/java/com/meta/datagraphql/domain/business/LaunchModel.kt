package com.meta.datagraphql.domain.business

import android.os.Parcelable
import com.meta.datagraphql.domain.business.child.MissionModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchModel(
    var id: String? = "",
    var site: String? = "",
    var mission: MissionModel? = null
) : Parcelable