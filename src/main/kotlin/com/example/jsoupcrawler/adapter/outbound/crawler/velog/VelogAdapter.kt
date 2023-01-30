package com.example.jsoupcrawler.adapter.outbound.crawler.velog

import com.example.jsoupcrawler.application.outbound.crawler.CrawlerPort
import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse
import org.jsoup.nodes.Document
import org.springframework.stereotype.Component

@Component
class VelogAdapter : CrawlerPort {

    override fun parseDocument(url: String): CrawlerResponse {

        val doc : Document = Document(url)

        return CrawlerResponse(
            title = VelogParser.TITLE.parse(doc),
            summary = VelogParser.SUMMARY.parse(doc),
            createdAt = VelogParser.TIMESTAMP.parse(doc)
        );
    }

    private fun castToLocalDateTime(timeStamp: String){
    }
}