package com.syntax_institut.whatssyntax.data.model

data class Contact(
    val name: String,
    val number: String,
    var image: Int,
    val status: Status?
)