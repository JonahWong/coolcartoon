package tarena.com.coolcartoon.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jonah on 04/07/2017.
 */
@Entity(tableName = "image")
data class ComicImageEntity(
        @ColumnInfo(name = "imageUrl") var imageUrl: String,
        @ColumnInfo(name = "imageId") var id: Int,
        @ColumnInfo(name = "chapterId") var chapterId: Int) {

    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0

    /*companion object {
        val serialVersionUID: Long = 1L
    }*/
}