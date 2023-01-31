package com.example.jsoupcrawler.application.inbound

import com.example.jsoupcrawler.application.inbound.model.ParseCrawlingDocumentUseCaseDto

interface ParseCrawlingDocumentUseCase {
    fun getDocument(url: String): ParseCrawlingDocumentUseCaseDto
}
