package tarena.com.coolcartoon.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jonah on 04/07/2017.
 */
@Entity(tableName = "chapter")
data class ChapterEntity(var name: String, var chapterId: Int, var comicName: String) {
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0
}