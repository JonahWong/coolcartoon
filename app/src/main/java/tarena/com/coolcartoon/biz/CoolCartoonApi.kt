package tarena.com.coolcartoon.biz

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import tarena.com.coolcartoon.BuildConfig
import tarena.com.coolcartoon.model.ChapterComics
import tarena.com.coolcartoon.model.responses.BookCategoryResponse
import tarena.com.coolcartoon.model.responses.BookResultResponse
import tarena.com.coolcartoon.model.responses.ChapterResponse

/**
 * Created by jonah on 05/07/2017.
 */
interface CoolCartoonApi {

    @GET("category")
    fun categories(@Query("key") key: String = BuildConfig.COOL_CARTOON_APPLICATION_KEY): Observable<BookCategoryResponse>

    @GET("chapter")
    fun chapters(@Query("comicName") comicName: String, @Query("skip") skip: Int = 0, @Query("key") key: String = BuildConfig.COOL_CARTOON_APPLICATION_KEY): Observable<ChapterResponse>

    @GET("book")
    fun books(@Query("type") type: String, @Query("skip") skip: Int = 0, @Query("finish") finish: Int = -1, @Query("key") key: String = BuildConfig.COOL_CARTOON_APPLICATION_KEY): Observable<BookResultResponse>

    @GET("chapterContent")
    fun comicPix(@Query("comicName") comicName: String, @Query("id") chapterId: Int, @Query("key") key: String = BuildConfig.COOL_CARTOON_APPLICATION_KEY): Observable<ChapterComics>


}