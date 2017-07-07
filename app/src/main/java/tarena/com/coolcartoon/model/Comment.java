package tarena.com.coolcartoon.model;

import cn.bmob.v3.BmobObject;

/**
 * 评论实体类
 * Created by tarena on 2017/7/7.
 */

public class Comment extends BmobObject {
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论对应的帖子
     */
    private int postId;
    /**
     * 评论该帖的人
     */
    private String author;

    public int getPost() {
        return postId;
    }

    public void setPost(int postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
