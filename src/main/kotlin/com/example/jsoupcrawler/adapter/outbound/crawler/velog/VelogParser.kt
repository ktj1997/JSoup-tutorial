package com.example.jsoupcrawler.adapter.outbound.crawler.velog

import com.example.jsoupcrawler.adapter.outbound.crawler.Parser
import org.jsoup.nodes.Document

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
                val summaryTextArea:String  = doc.select("div.atom-one").text()
                summaryTextArea.substring(0,200)
            }catch (e: Exception){
                e.printStackTrace()
                ""
            }
        }
    },
    TIMESTAMP {
        override fun parse(doc: Document): String {
            return try{
                doc.select(".information > span")[2].text()
            }catch (e: Exception){
                e.printStackTrace()
                ""
            }
        }

    }


}