package com.example.jsoupcrawler.adapter.inbound.model

data class SubmitDocumentRequest(
    val platform: String,
    val title: String,
    val summary: String,
    val createdAt: String
)
