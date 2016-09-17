package com.saltyfish;

import com.saltyfish.common.utils.PasswordEncode;

import java.text.DecimalFormat;
import java.util.Scanner;

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

        Double longitudeDegree, longitudeMinute, longitudeSecond, latitudeDegree, latitudeMinute, latitudeSecond;
        Scanner scanner = new Scanner(System.in);
        longitudeDegree = scanner.nextDouble();
        longitudeMinute = scanner.nextDouble();
        longitudeSecond = scanner.nextDouble();
        latitudeDegree = scanner.nextDouble();
        latitudeMinute = scanner.nextDouble();
        latitudeSecond = scanner.nextDouble();
        Double longitude = longitudeDegree + longitudeMinute / 600 + longitudeSecond / 6000;
        Double latitude = latitudeDegree + latitudeMinute / 600 + latitudeSecond / 6000;
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println("经度：" + df.format(longitude) + "," + "纬度:" + df.format(latitude));
    }
}
