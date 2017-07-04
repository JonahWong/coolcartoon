package tarena.com.coolcartoon.model

/**
 * Created by jonah on 04/07/2017.
 */
data class ResultEntity(var total: Int,
                        var limit: Int,
                        var bookList: ArrayList<Book>?) {
}