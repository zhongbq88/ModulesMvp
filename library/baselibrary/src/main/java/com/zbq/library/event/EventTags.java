package com.zbq.library.event;

/**
 * Created by baixiaokang on 16/11/16.
 */

public interface EventTags {
    /**
     * 登录成功
     */
    String ON_USER_LOGIN = "ON_USER_LOGIN";
    int FLASH_INIT_UI = 0x0001;
    int JUMP_TO_MAIN = 0x0002;
    int SHOW_TAB_LIST = 0x0003;
    /**
     * 发布公开成功
     */
    int ON_RELEASE_OPEN = 0x0004;
}
