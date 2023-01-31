package com.example.jsoupcrawler.adapter.outbound.crawler

import org.jsoup.nodes.Document

interface Parser {
    fun parse(doc: Document): String
}
