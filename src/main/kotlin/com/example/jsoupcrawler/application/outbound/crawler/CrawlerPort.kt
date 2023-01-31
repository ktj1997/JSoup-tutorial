package com.example.jsoupcrawler.application.outbound.crawler

import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse
import com.example.jsoupcrawler.domain.BlogType

interface CrawlerPort {
    fun parseDocument(url: String): CrawlerResponse
}

object CrawlerPortProperties {

    const val velog = "velogCrawler"
    const val tistory = "tistoryCrawler"
    const val naverblog = "naverBlogCrawler"
    const val medium = "mediumCrawler"

    fun getMatchedCrawlerName(type: BlogType): String {
        return when {
            type === BlogType.VELOG -> velog
            type === BlogType.TISTORY -> tistory
            type === BlogType.NAVERBLOG -> naverblog
            type === BlogType.MEDIUM -> medium
            else -> "notExist"
        }
    }
}
