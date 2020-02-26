package com.geekhub_android.csbc

data class Teacher(
    val name: String,
    val listGroup: MutableList<Group>,
    val listSubject: MutableList<Subject>
)