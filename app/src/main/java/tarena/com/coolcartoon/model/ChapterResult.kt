package tarena.com.coolcartoon.model

/**
 * Created by jonah on 04/07/2017.
 */
data class ChapterResult(var total: Int,
                         var comicName: String,
                         var chapterList: ArrayList<Chapter>?,
                         var limit: Int,
                         var skip: Int)
