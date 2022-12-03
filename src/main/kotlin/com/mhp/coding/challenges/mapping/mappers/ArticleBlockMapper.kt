package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleBlockMapper {
    fun map(articleBlock: ArticleBlock): ArticleBlockDto {
        return  object: ArticleBlockDto {
            override val sortIndex= articleBlock.sortIndex
        }
    }
    fun map(articleBlocks: Set<ArticleBlock>): Collection<ArticleBlockDto> {
        var articleBlockDtos: Collection<ArticleBlockDto> = emptyList()

        for (articleBlock in articleBlocks) {
            articleBlockDtos += map(articleBlock)
        }
        return Collections.emptyList()
    }
}