package com.example.cryptomonitoring.service

import com.example.cryptomonitoring.model.Crypto
import com.example.cryptomonitoring.model.CryptoList
import retrofit2.http.GET

interface CryptoAPI {

    @GET("cryptolist.json")
    suspend fun getCryptoList(): CryptoList

    @GET("crypto.json")
    suspend fun getCrypto(): Crypto


}