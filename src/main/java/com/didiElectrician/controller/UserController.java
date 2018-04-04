package com.didiElectrician.controller;

import com.didiElectrician.domain.Client;
import com.didiElectrician.domain.Electrician;
import com.didiElectrician.service.ClientService;
import com.didiElectrician.service.ElectricianService;
import com.didiElectrician.util.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ElectricianService electricianService;

    private static final Logger logger = Logger.getLogger(UserController.class.toString());

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String mobile, String password,String userType, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        if (userType == null || "".equals(userType)) {
            return JsonUtil.toObject(map).toString();
        }
        if("0".equals(userType)) {
            Client client = new Client();
            client.setMobile(mobile);
            client.setPassword(password);
            if(clientService.login(client)) {
                subjectLogin(mobile, password, map);
            }
        }else if("1".equals(userType)) {
            Electrician electrician = new Electrician();
            electrician.setMobile(mobile);
            electrician.setPassword(password);
            if(electricianService.login(electrician)) {
                subjectLogin(mobile, password, map);
            }
        }else {
            return JsonUtil.toObject(map).toString();
        }

        return JsonUtil.toObject(map).toString();
    }

    private void subjectLogin(String mobile, String password, Map<String, Object> map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(mobile, password);

            subject.login(token);

        logger.info("==========" + mobile + "=========="  + "登录成功");
        map.put("success",true);
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpSession session){
        Map<String,Object> map = new HashMap<>();
        map.put("success",false);
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
//            session.removeAttribute("user");
            map.put("success",true);
        }
        return JsonUtil.toObject(map).toString();
    }
}
