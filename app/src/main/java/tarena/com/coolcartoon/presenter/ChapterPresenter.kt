package tarena.com.coolcartoon.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import tarena.com.coolcartoon.biz.CoolCartoonApi
import tarena.com.coolcartoon.model.Chapter
import tarena.com.coolcartoon.model.ChapterEntity
import tarena.com.coolcartoon.model.responses.ChapterResponse
import tarena.com.coolcartoon.model.room_data.CartoonDao
import tarena.com.coolcartoon.view.interfaces.ChapterPresentation
import javax.inject.Inject

/**
 * Created by jonah on 07/07/2017.
 */
class ChapterPresenter @Inject constructor(val cartoonDao: CartoonDao, val cartoonApi: CoolCartoonApi) {

    val compositeDisposable = CompositeDisposable()
    val chapters = ArrayList<ChapterEntity>()

    var presentation: ChapterPresentation? = null

    fun onCreate(chapterPresentation: ChapterPresentation) {
        presentation = chapterPresentation
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }


    fun loadCartoonChapters(comicName: String) {
        //先判断数据库中那个有没有数据，是，则从数据库加载；否，则从网络加载，然后存到数据库
        //将subscribe方法返回值 —— Disposable 实例添加到 compositeDisposable，便于后面资源释放
        compositeDisposable.add(cartoonDao.getCartoonChaptersFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    chapters.clear()
                    chapters.addAll(it)
                    (chapters.size - 1).takeIf { it >= 0 }?.let {
                        presentation?.chapterAddedAt(it)
                    }
                }))

        presentation?.showChapters(chapters)

        compositeDisposable.add(cartoonApi.chapters(comicName)//网络加载
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    response ->
                    response.result.chapterList!!.map {
                        // 将result里的comicName字段设置到每一个ChapterEntity对象中
                        ChapterEntity(it.name, it.id, response.result.comicName)
                    }
                }
                .doOnNext {
                    cartoonDao.insertCartoonChapters(it)
                }
                /*.flatMap { response -> Observable.fromIterable(response.result.chapterList)
                        .map { chapter: Chapter ->
                    ChapterEntity(chapter.name, chapter.id, response.result.comicName)
                }}*/
                .subscribe({
                    presentation?.showChapters(it) //从内存中设置适配器
                }))


    }


//        cartoonDao 存入数据库（放在RxJava的哪个操作里）


}


