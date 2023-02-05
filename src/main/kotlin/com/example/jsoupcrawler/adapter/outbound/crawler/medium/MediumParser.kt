package com.example.jsoupcrawler.adapter.outbound.crawler.medium

import com.example.jsoupcrawler.adapter.outbound.crawler.Parser
import org.jsoup.nodes.Document

enum class MediumParser : Parser {
    TITLE {
        override fun parse(doc: Document): String {
            return try {
                doc.select("meta[property=og:title]").attr("content")
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }
    }, SUMMARY {
    override fun parse(doc: Document): String {
        return try {
            val content = doc.select("p.pw-post-body-paragraph")[0].text()
            when {
                content.length > 200 -> content.substring(0, 200)
                else -> content
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }
},
    TIMESTAMP;
    override fun parse(doc: Document): String {
        return try {
            doc.select(".pw-published-date > span")[0].text()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}
