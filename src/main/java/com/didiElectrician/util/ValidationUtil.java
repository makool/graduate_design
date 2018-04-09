package com.didiElectrician.util;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.didiElectrician.domain.Client;

import java.util.ArrayList;
import java.util.List;
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

    public static List<String> validateClient(Client client) {
        List<String> list = new ArrayList<>();
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        //检查密码
        if(!client.getPassword().matches(regex)) {
            list.add("密码格式错误");
        }

        //检查用户名
        if (client.getUsername() == null || "".equals(client.getUsername())) {
            list.add("用户名为空");
        }

        //检查密保和密保答案
        if (client.getSecurityQuestion() == null || client.getSecutityAnswer() != null) {
            list.add("密保和密保答案不能为空");
        }

        //检查地址
        if (client.getAddressId() == null || "".equals(client.getAddressId())) {
            list.add("地址不能为空");
        }

        return list;
    }
}
