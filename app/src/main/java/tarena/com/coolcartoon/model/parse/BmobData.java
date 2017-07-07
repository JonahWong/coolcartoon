package tarena.com.coolcartoon.model.parse;

import android.os.Handler;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import tarena.com.coolcartoon.model.User;

/**
 * Created by tarena on 2017/7/5.
 */

public class BmobData {
    /**
     * 登陆成功
     */
    private static final int LOGIN_SUCCESS = 230;
    /**
     * 登陆失败
     */
    private static final int LOGIN_FAILED = 848;
    /**
     * 登陆到Bmon(用户管理后台)
     * @param user
     */
    public void login(User user, final Handler handler){
        user.save(new SaveListener() {
            @Override
            public void done(Object o, BmobException e) {
                if (e==null){
                    //登陆成功
                    handler.sendEmptyMessage(LOGIN_SUCCESS);
                }else {
                    //登陆失败
                    handler.sendEmptyMessage(LOGIN_FAILED);
                }
            }

            @Override
            public void done(Object o, Object o2) {

            }
        });
    }
}
