package com.app.nbapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val website: List<String>,
    val youtube: List<String>,
    @SerializedName("source_code")
    val sourceCode: List<String>
)