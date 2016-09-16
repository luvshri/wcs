package com.saltyfish;

import com.saltyfish.common.utils.PasswordEncode;

/**
 * Created by weck on 16/9/2.
 * <p>
 * 测试主类
 */
public class TestMain {
    public static void main(String args[]) {
        String salt = PasswordEncode.generateSalt();
        String password = "123";
        String encodedPassword = PasswordEncode.getHashedPassword(password, salt);
        boolean v = PasswordEncode.verify(encodedPassword, password, salt);
        System.out.println("salt:" + salt + "\n" + "password:" + password + "\n"
                + "encodedPassword:" + encodedPassword + "\n" + "verify:" + v + "\n");
        System.out.println(System.currentTimeMillis());
    }
}
