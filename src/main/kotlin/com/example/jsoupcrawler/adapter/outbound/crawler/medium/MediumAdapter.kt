package com.example.jsoupcrawler.adapter.outbound.crawler.medium

import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPort
import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPortProperties
import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component(CrawlerPortProperties.medium)
class MediumAdapter : CrawlerPort {
    override fun parseDocument(url: String): CrawlerResponse {

        val doc = Jsoup.connect(url).get()

        return CrawlerResponse(
            title = MediumParser.TITLE.parse(doc),
            summary = MediumParser.SUMMARY.parse(doc),
            createdAt = MediumParser.TIMESTAMP.parse(doc)
        )
    }
}