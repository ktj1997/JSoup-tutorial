package com.example.jsoupcrawler.application

import com.example.jsoupcrawler.application.inbound.ParseCrawlingDocumentUseCase
import com.example.jsoupcrawler.application.inbound.model.ParseCrawlingDocumentUseCaseDto
import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPort
import com.example.jsoupcrawler.domain.BlogType
import org.springframework.stereotype.Service

@Service
class CrawlingService(
    private val crawlerPort: CrawlerPort
) : ParseCrawlingDocumentUseCase {

    override fun getDocument(url: String): ParseCrawlingDocumentUseCaseDto {
        val blog = BlogType.decide(url)

        return when {
            blog == BlogType.ETC -> ParseCrawlingDocumentUseCaseDto.empty()
            else -> ParseCrawlingDocumentUseCaseDto.from(blog.name,crawlerPort.parseDocument(url))
        }
    }


}