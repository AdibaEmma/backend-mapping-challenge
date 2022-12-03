package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleMapper{
val articleBlockMapper = Mappers.getMapper(ArticleBlockMapper::class.java)
    fun map(article: Article?): ArticleDto = ArticleDto(
        article?.id!!,
        article.title,
        article.description!!,
        article.author!!,
        articleBlockMapper.toDTO(article.blocks)!!
    )

    // Not part of the challenge / Nicht Teil dieser Challenge.
    fun map(articleDto: ArticleDto?): Article = Article(
        title = "An Article",
        blocks = emptySet(),
        id = 1,
        lastModified = Date()
    )
}
