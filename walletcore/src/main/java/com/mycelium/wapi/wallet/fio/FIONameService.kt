package com.mycelium.wapi.wallet.fio

import com.fasterxml.jackson.annotation.JsonProperty
import com.mycelium.wapi.wallet.WalletAccount
import java.io.Serializable
import java.util.*

data class RegisteredFIOName(@JsonProperty("name") val name: String,
                             @JsonProperty("expireDate") val expireDate: Date) : Serializable

data class FIODomain(@JsonProperty("domain") val domain: String,
                     @JsonProperty("expireDate") val expireDate: Date,
                     @JsonProperty("public") val isPublic: Boolean) : Serializable
