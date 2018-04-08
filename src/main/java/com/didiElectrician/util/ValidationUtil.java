package com.didiElectrician.util;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Logger logger = Logger.getLogger(ValidationUtil.class.toString());

    public static boolean validateMobile(String mobile) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if(mobile.length() != 11){
            logger.info("手机号应为11位数");
        }else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(mobile);
            boolean isMatch = m.matches();
            if (isMatch) {
                logger.info("您的手机号" + mobile + "是正确格式@——@");
            } else {
                logger.info("您的手机号" + mobile + "是错误格式！！！");
            }
        }
        return false;
    }

    public static boolean validatePassword(String password) {
        return true;
    }

    public static String getVerificationCode(){
        Random random = new Random();
        int number = random.nextInt(1000000);
        String verificationCode = String.valueOf(number);
        int length = verificationCode.length();
        for(int i = length; i < 6; i++) {
            verificationCode = "0" + verificationCode;
        }
        return verificationCode;
    }

}
