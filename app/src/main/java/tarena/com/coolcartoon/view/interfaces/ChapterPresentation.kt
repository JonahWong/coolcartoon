package tarena.com.coolcartoon.view.interfaces

import tarena.com.coolcartoon.model.ChapterEntity

/**
 * Created by jonah on 07/07/2017.
 */
interface ChapterPresentation {
    fun scrollTo(position: Int)
    fun chapterAddedAt(position: Int)
    fun showChapters(chapters: List<ChapterEntity>)
}