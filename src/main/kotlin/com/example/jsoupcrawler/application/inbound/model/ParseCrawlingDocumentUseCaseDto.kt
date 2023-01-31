package com.example.jsoupcrawler.application.inbound.model

import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse

data class ParseCrawlingDocumentUseCaseDto(
    val platform: String,
    val title: String,
    val summary: String,
    val createdAt: String
) {
    companion object {
        fun empty(): ParseCrawlingDocumentUseCaseDto {
            return ParseCrawlingDocumentUseCaseDto(
                platform = "",
                title = "",
                summary = "",
                createdAt = ""
            )
        }

        fun from(platform: String, crawlerResponse: CrawlerResponse): ParseCrawlingDocumentUseCaseDto {
            return ParseCrawlingDocumentUseCaseDto(
                platform = platform,
                title = crawlerResponse.title,
                summary = crawlerResponse.summary,
                createdAt = crawlerResponse.createdAt
            )
        }
    }
}
