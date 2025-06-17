package com.app.nbapp.data.remote.dto


import com.app.nbapp.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val rank: Int,
    val id: String,
    val logo: String,
    val description: String,
    val type: String,
    val whitepaper: Whitepaper,
    val symbol: String,
    val tags: List<Tag>,
    val links: Links,
    val message: String,
    val name: String,

    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,

    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("team")
    val team: List<TeamMember>,
)

fun CoinDetailDto.toCoinDetail() = CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    team = team
)