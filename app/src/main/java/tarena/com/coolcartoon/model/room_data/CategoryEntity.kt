package tarena.com.coolcartoon.model.room_data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *
 * Created by jonah on 04/07/2017.
 */
@Entity(tableName = "category")
data class CategoryEntity(var name: String){
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0
}


