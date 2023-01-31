package com.example.jsoupcrawler.domain

import java.lang.Exception

enum class BlogType {
    VELOG, TISTORY, NAVERBLOG, MEDIUM, ETC;

    companion object {
        fun decide(url: String): BlogType {
            return try {
                val pattern = "(https?://)([^/]+)(.*)".toRegex()
                val domain =
                    pattern.find(url)?.groupValues?.get(2) ?: throw RuntimeException("Invalid URL")

                when {
                    domain.startsWith("velog.io", true) -> VELOG
                    domain.startsWith("blog.naver.com", true) -> NAVERBLOG
                    domain.endsWith("tistory.com", true) -> TISTORY
                    domain.startsWith("medium.com", true) -> MEDIUM
                    else -> ETC
                }
            } catch (e: Exception) {
                ETC
            }
        }
    }
}
