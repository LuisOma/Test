package com.meta.datagraphql.domain.business.child

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MissionModel(
    var name: String? = "",
    var missionPatch: String? = ""
) : Parcelable
