package tarena.com.coolcartoon.model

import android.arch.persistence.room.Entity

/**
 * Created by jonah on 04/07/2017.
 */
data class ChapterComics(var comicName: String,
                         var chapterId: Int,
                         var imageList: ArrayList<ComicImage>) {
}