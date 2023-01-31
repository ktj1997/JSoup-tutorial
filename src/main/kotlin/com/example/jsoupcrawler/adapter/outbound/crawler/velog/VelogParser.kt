package com.example.jsoupcrawler.adapter.outbound.crawler.velog

import com.example.jsoupcrawler.adapter.outbound.crawler.Parser
import org.jsoup.nodes.Document
import java.time.LocalDate

enum class VelogParser : Parser {
    TITLE {
        override fun parse(doc: Document): String {
            return try {
                doc.title()
            } catch (e: Exception) {
                ""
            }
        }
    },
    SUMMARY {
        override fun parse(doc: Document): String {
            return try {
                doc.select("div.atom-one > p")
                    .map { it.text() }
                    .joinToString("")
                    .take(200)
            } catch (e: Exception) {
                ""
            }
        }
    },
    TIMESTAMP {
        override fun parse(doc: Document): String {
            try {
                val dateExpression = doc.select(".information > span")[2].text()
                return when {
                    dateExpression.endsWith("전") -> {
                        val dayRange = dateExpression.split("전")[0].trim()
                        when {
                            dayRange.endsWith("분") || dayRange == "방금" -> LocalDate.now().toString()
                            else -> LocalDate.now().plusDays((dayRange[0] - '0').toLong()).toString()
                        }
                    }
                    else -> dateExpression
                }
            } catch (e: Exception) {
                return ""
            }
        }
    }
}
