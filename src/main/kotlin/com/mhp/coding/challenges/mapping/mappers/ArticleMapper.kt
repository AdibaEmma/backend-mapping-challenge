package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.models.dto.ImageDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.*
import org.springframework.stereotype.Component
import java.util.*

@Component
class ArticleMapper{
    fun map(article: Article?): ArticleDto {
        return ArticleDto(
            id = article?.id,
            title = article?.title!!,
            description = article.description,
            author = article.author,
            blocks = article.blocks.map { mapArticleBlockToDto(it) }.toList() as Collection<ArticleBlockDto>
        )
    }

    fun mapArticleBlockToDto(articleBlock: ArticleBlock): ArticleBlockDto? {
        return when (articleBlock) {
            is TextBlock -> TextBlockDto(
                text =  articleBlock.text,
                sortIndex = articleBlock.sortIndex
            )
            is ImageBlock -> ImageBlockDto(
                image = mapImageToDto(articleBlock.image),
                sortIndex = articleBlock.sortIndex
            )
            is GalleryBlock -> GalleryBlockDto(
                images = articleBlock.images.map { mapImageToDto(it!!) },
                sortIndex = articleBlock.sortIndex
            )

            is VideoBlock -> VideoBlockDto(
                url = articleBlock.url,
                type = articleBlock.type,
                sortIndex = articleBlock.sortIndex
            )
            else -> {return null}
        }
    }

    fun mapImageToDto(image: Image?): ImageDto {
        return ImageDto(
            id = image!!.id,
            url = image.url,
            imageSize = image.imageSize
        )
    }


    // Not part of the challenge / Nicht Teil dieser Challenge.
    fun map(articleDto: ArticleDto?): Article = Article(
        title = "An Article",
        blocks = emptySet(),
        id = 1,
        lastModified = Date()
    )
}
