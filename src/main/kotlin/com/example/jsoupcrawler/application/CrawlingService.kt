package com.example.jsoupcrawler.application

import com.example.jsoupcrawler.application.inbound.ParseCrawlingDocumentUseCase
import com.example.jsoupcrawler.application.inbound.model.ParseCrawlingDocumentUseCaseDto
import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPort
import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPortProperties
import com.example.jsoupcrawler.domain.BlogType
import org.springframework.stereotype.Service

@Service
class CrawlingService(
    private val crawlerPorts: Map<String, CrawlerPort>
) : ParseCrawlingDocumentUseCase {

    override fun getDocument(url: String): ParseCrawlingDocumentUseCaseDto {
        val blog = BlogType.decide(url)

        if (blog === BlogType.ETC) {
            return ParseCrawlingDocumentUseCaseDto.empty()
        }

        val crawlerName = CrawlerPortProperties.getMatchedCrawlerName(blog)
        val crawler = crawlerPorts.get(crawlerName) ?: throw RuntimeException("Can't find proper crawler")

        return ParseCrawlingDocumentUseCaseDto.from(blog.name, crawler.parseDocument(url))
    }
}
