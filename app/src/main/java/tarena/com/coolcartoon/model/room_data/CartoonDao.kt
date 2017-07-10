package tarena.com.coolcartoon.model.room_data

import android.arch.persistence.room.*
import io.reactivex.Flowable
import tarena.com.coolcartoon.model.ChapterEntity
import tarena.com.coolcartoon.model.ComicImageEntity

/**
 * Created by jonah on 07/07/2017.
 */
@Dao
interface CartoonDao {
    @Query("select * from category")
    fun getCartoonCategoriesFromDb(): Flowable<List<CategoryEntity>>

    @Query("select * from book")
    fun getCartoonBooksFromDb(): Flowable<List<BookEntity>>

    @Query("select * from chapter")
    fun getCartoonChaptersFromDb(): Flowable<List<ChapterEntity>>

    @Query("select * from image")
    fun getCartoonImagesFromDb(): Flowable<List<ComicImageEntity>>

    //singular insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonCategory(category: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonBook(book: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonChapter(chapter: ChapterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonImage(image: ComicImageEntity)

    //Bulk insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonCategories(categories: List<CategoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonBooks(books: List<BookEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonChapters(chapters: List<ChapterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartoonImages(images: List<ComicImageEntity>)

    //singular update
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonCategory(category: CategoryEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonBook(book: BookEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonChapter(chapter: ChapterEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonImage(image: ComicImageEntity)

    //bulk update
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonCategories(categories: List<CategoryEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonBooks(books: List<BookEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonChapters(chapters: List<ChapterEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCartoonImages(images: List<ComicImageEntity>)

    @Query("select * from category where _id = :p0")
    fun getCartoonCategory(id: Long): CategoryEntity

    @Query("select * from book where _id = :p0")
    fun getCartoonBook(id: Long): BookEntity

    @Query("select * from chapter where _id = :p0")
    fun getCartoonChapter(id: Long): ChapterEntity

    @Query("select * from image where _id = :p0")
    fun getCartoonImage(id: Long): ComicImageEntity
}