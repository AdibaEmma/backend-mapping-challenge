package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper

@Mapper
interface ArticleBlockMapper {
    @InheritInverseConfiguration
    fun toEntity(articleBlockDto: ArticleBlockDto): ArticleBlock

    fun toDTO(articleBlock: ArticleBlock): ArticleBlockDto

    @InheritInverseConfiguration
    fun toEntity(articleBlockDtos: Collection<ArticleBlockDto>?): Collection<ArticleBlock>?

    fun toDTO(articleBlocks: Collection<ArticleBlock>?): Collection<ArticleBlockDto>?
}