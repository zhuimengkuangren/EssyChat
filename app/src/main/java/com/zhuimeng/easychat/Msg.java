package com.zhuimeng.easychat;

/**
 * Created by zhuimeng on 2017/9/17.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 1;
    public static final int TYPE_SEND = 0;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
