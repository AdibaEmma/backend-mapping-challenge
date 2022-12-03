package com.mhp.coding.challenges.mapping.controllers

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.services.ArticleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController(
    private val articleService: ArticleService
) {
    @GetMapping
    fun list(): ResponseEntity<List<ArticleDto>> =
        ResponseEntity<List<ArticleDto>>(articleService.list(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun details(@PathVariable id: Long): ResponseEntity<ArticleDto> {
        val articleDto = articleService.articleForId(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity<ArticleDto>(articleDto, HttpStatus.OK)
    }


    @PostMapping
    fun create(@RequestBody articleDto: ArticleDto): ResponseEntity<ArticleDto> =
        ResponseEntity<ArticleDto>(articleService.create(articleDto), HttpStatus.CREATED)
}
