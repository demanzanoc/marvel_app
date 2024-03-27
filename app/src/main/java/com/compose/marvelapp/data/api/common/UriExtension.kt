package com.compose.marvelapp.data.api.common

const val NON_SECURE_PROTOCOL = "http://"
const val SECURE_PROTOCOL = "https://"

fun String.toSecureUri() = replace(NON_SECURE_PROTOCOL, SECURE_PROTOCOL)