package tarena.com.coolcartoon.model.room_data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import tarena.com.coolcartoon.model.ChapterEntity
import tarena.com.coolcartoon.model.ComicImageEntity

/**
 * Created by jonah on 07/07/2017.
 */
@Database(entities = arrayOf(BookEntity::class, CategoryEntity::class, ChapterEntity::class, ComicImageEntity::class), version = 1, exportSchema = false)
abstract class CoolDatabase: RoomDatabase() {
    abstract fun coolDao(): CartoonDao
}