package tarena.com.coolcartoon.model

import tarena.com.coolcartoon.model.room_data.BookEntity

/**
 * Created by jonah on 04/07/2017.
 */
data class BookResult(var total: Int,//no use
                      var limit: Int,
                      var skip: Int,//no use
                      var bookList: ArrayList<BookEntity>?) {
}