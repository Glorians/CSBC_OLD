package com.geekhub_android.csbc.Model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Subject(
    var id: Long? = 0,
    var parity: Int? = 0,
    var name: String? = "",
    var classroom: Int? = 0,
    var number: Int? = 0,
    var teacher: String? = "",
    var type: String? = "",
    var day: Int? = 0
)

