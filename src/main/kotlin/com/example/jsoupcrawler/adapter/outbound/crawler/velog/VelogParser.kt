package com.example.jsoupcrawler.adapter.outbound.crawler.velog

import com.example.jsoupcrawler.adapter.outbound.crawler.Parser
import org.jsoup.nodes.Document
import java.time.LocalDate

enum class VelogParser : Parser {
    TITLE {
        override fun parse(doc: Document): String {
            return try{
                doc.title()
            }catch (e: Exception){
                e.printStackTrace()
                ""
            }
        }
    },
    SUMMARY {
        override fun parse(doc: Document): String {
            return try{
                val content = doc.select("div.atom-one").text().substring(0,200)
                return when{
                    content.length > 200 -> content.substring(0,200)
                    else -> content
                }
            }catch (e: Exception){
                e.printStackTrace()
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
                e.printStackTrace()
                return ""
            }
        }
    }
}