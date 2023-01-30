package com.example.jsoupcrawler.application.outbound.crawler

import com.example.jsoupcrawler.application.outbound.crawler.model.CrawlerResponse

interface CrawlerPort {

    fun parseDocument(url:String) : CrawlerResponse
}