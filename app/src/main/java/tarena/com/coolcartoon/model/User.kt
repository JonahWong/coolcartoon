package tarena.com.coolcartoon.model

import cn.bmob.v3.BmobUser

/**
 * 用户实体类
 * Created by tarena on 2017/7/5.
 */
data class User(
        /**
         * 经验值
         */
        var experience: String,
        /**
         * 是否VIP
         */
        var isVIP: Boolean,
        /**
         * 头像Bmob路径
         */
        var headerPath: String) : BmobUser()