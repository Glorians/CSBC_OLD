package com.geekhub_android.csbc.Model

data class Group(
    val name: String,
    val subgroup: Char,
    val listSubject: MutableList<Subject>
)

