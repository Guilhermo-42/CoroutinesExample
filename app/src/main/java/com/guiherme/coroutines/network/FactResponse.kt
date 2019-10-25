package com.guiherme.coroutines.network

import java.io.Serializable

data class FactResponse(
    var id: String,
    var factDescription: String
) : Serializable