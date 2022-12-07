package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.stereotype.Service
import kotlin.collections.sortedBy as sortedBy

@Service
class ArticleService(
    private val mapper: ArticleMapper,
) {
    fun list(): List<ArticleDto> {
        val articles = ArticleRepository.all()

        val articleDtoList = articles.map { mapper.map(it)}
        articleDtoList.forEach { it ->
            it.blocks?.sortedBy { it.sortIndex }
        }
        return articleDtoList
    }

    fun articleForId(id: Long): ArticleDto? {
        val article = ArticleRepository.findBy(id)
        return mapper.map(article)
    }

    fun create(articleDto: ArticleDto): ArticleDto {
        val article = mapper.map(articleDto)
        ArticleRepository.create(article)
        return mapper.map(article)
    }
}
