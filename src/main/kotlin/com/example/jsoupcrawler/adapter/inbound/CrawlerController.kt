package com.example.jsoupcrawler.adapter.inbound

import com.example.jsoupcrawler.application.inbound.ParseCrawlingDocumentUseCase
import com.example.jsoupcrawler.application.inbound.model.ParseCrawlingDocumentUseCaseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/document")
class CrawlerController(
    private val parseCrawlingDocumentUseCase: ParseCrawlingDocumentUseCase
) {

    @GetMapping("/parse")
    fun parseDocument(
        @RequestParam url: String
    ): ResponseEntity<ParseCrawlingDocumentUseCaseDto> {
        return ResponseEntity.ok(
            parseCrawlingDocumentUseCase.getDocument(url)
        )
    }

    @PostMapping("/submit")
    fun submitDocument() {

    }
}