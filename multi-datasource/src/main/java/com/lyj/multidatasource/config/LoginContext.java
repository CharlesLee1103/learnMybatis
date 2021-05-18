package com.lyj.multidatasource.config;

import lombok.Builder;
import lombok.Data;

/**
 * @author heran
 * @version 1.0, 2020-02-11 19:28
 */
public class LoginContext {

    private static ThreadLocal<LoginUser> loginUserThreadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        loginUserThreadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return loginUserThreadLocal.get();
    }

    public static void clear() {
        loginUserThreadLocal.remove();
    }

    @Data
    @Builder
    public static class LoginUser {
        /**
         * SSO登录的用户名
         */
        private String ssoName;

        /**
         * 优先kefu-test-user的Cookie用户名
         */
        private String cookieName;

        private String tenant;
    }
}
