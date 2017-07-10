package tarena.com.coolcartoon.model.room_data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jonah on 04/07/2017.
 */
@Entity(tableName = "book")
data class BookEntity(var name: String,
                      @ColumnInfo(name = "category_name") var type: String,
                      var area: String,
                      var des: String,
                      var finish: Boolean,
                      var lastUpdate: Int,
                      var coverImg: String) {
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0
}