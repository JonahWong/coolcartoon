package tarena.com.coolcartoon.model

/**
 * 帖子实体类
 * Created by tarena on 2017/7/5.
 */
data class Post(
        /**
         * 帖子标题
         */
        var title:String,
        /**
         * 帖子内容
         */
        var content:String,
        /**
         * 帖子作者
         */
        var author:String,
        /**
         * 帖子的赞数
         */
        var likes:Int,
        /**
         * 帖子图片的集合（图片路径字符串拼接）
         */
        var imgs:String)