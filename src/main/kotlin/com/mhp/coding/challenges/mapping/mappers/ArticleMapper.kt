package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleMapper{

@Autowired
lateinit var articleBlockMapper: ArticleBlockMapper
    fun map(article: Article?): ArticleDto = ArticleDto(
        article?.id!!,
        article.title,
        article.description!!,
        article.author!!,
        articleBlockMapper.map(article.blocks)
    )



    // Not part of the challenge / Nicht Teil dieser Challenge.
    fun map(articleDto: ArticleDto?): Article = Article(
        title = "An Article",
        blocks = emptySet(),
        id = 1,
        lastModified = Date()
    )
}
