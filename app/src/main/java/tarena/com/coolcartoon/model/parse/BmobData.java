package tarena.com.coolcartoon.model.parse;

import android.os.Handler;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import tarena.com.coolcartoon.model.Comment;
import tarena.com.coolcartoon.model.Post;
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
     *
     * @param user
     */
    public void login(User user, final Handler handler) {
        user.save(new SaveListener() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    //登陆成功
                    handler.sendEmptyMessage(LOGIN_SUCCESS);
                } else {
                    //登陆失败
                    handler.sendEmptyMessage(LOGIN_FAILED);
                }
            }

            @Override
            public void done(Object o, Object o2) {

            }
        });
    }

    /**
     * 创建帖子
     *
     * @param post 帖子实体类
     */
    public static void creatPost(Post post) {
        post.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    //贴子创建成功
                } else {
                    //帖子创建失败
                }
            }
        });
    }

    /**
     * 查询某人的所有帖子
     * @param username
     */
    public static void queryPost(String username){
        BmobQuery<Post> query = new BmobQuery<>();
        query.addWhereEqualTo("author",username);
        query.findObjects(new FindListener<Post>() {
            @Override
            public void done(List<Post> list, BmobException e) {
                if (e==null){
                    //查询成功，查询到的条数是 list.size
                }else{
                    //查询失败
                }
            }
        });
    }

    /**
     * 删除某一条帖子
     * @param post
     * @param username
     */
    public static void deletePost(Post post,String username){
        post.remove("username");
        post.update(post.getObjectId(),new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e==null){
                    //删除成功
                }else{
                    //删除失败
                }
            }
        });
    }

    /**
     * 发布评论
     *
     * @param comment
     */
    public static void relaseComment(Comment comment) {
        comment.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    //发布评论成功
                } else {
                    //发布评论失败
                }
            }
        });
    }

    /**
     * 查询某个帖子下所有的评论
     */
    public static void queryCommentFormPost(Post post){
        BmobQuery<Comment> query = new BmobQuery<>();
        query.addWhereEqualTo("post",new BmobPointer(post));
        query.include("author");
        query.findObjects(new FindListener<Comment>() {
            @Override
            public void done(List<Comment> list, BmobException e) {
                if (e==null){
                    //查询成功
                }else{
                    //查询失败
                }
            }
        });
    }

    /**
     * 删除评论
     */
    public static void deleteComment(Comment comment,Post post){
        //删除一条评论需要到这条帖子的信息，然后根据帖子的信息，删除
        comment.remove(post.getObjectId());
        comment.update(comment.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e==null){
                    //删除成功
                }else{
                    //删除失败
                }
            }
        });
    }

}
