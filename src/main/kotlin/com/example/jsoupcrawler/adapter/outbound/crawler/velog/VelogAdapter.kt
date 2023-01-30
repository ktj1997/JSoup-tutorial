package com.example.jsoupcrawler.adapter.outbound.crawler.velog

import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPort
import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class VelogAdapter : CrawlerPort {

    override fun parseDocument(url: String): CrawlerResponse {

        val doc = Jsoup.connect(url).get()

        return CrawlerResponse(
            title = VelogParser.TITLE.parse(doc),
            summary = VelogParser.SUMMARY.parse(doc),
            createdAt = VelogParser.TIMESTAMP.parse(doc)
        );
    }
}