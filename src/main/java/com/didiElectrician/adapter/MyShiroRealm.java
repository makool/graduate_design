//package com.didiElectrician.adapter;
//
//import com.didiElectrician.domain.Client;
//import com.didiElectrician.domain.Electrician;
//import com.didiElectrician.domain.Permission;
//import com.didiElectrician.domain.Role;
//import com.didiElectrician.service.ClientService;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.logging.Logger;
//
//@Configuration
//public class MyShiroRealm extends AuthorizingRealm {
//
//    private static final Logger logger = Logger.getLogger(MyShiroRealm.class.toString());
//
//    @Autowired
//    public ClientService clientService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        logger.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        Client client  = (Client) principals.getPrimaryPrincipal();
////        for(Role role:client.getRoleList()){
////            authorizationInfo.addRole(role.getRole());
////            for(Permission p:role.getPermissions()){
////                authorizationInfo.addStringPermission(p.getPermission());
////            }
////        }
//        return authorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        logger.info("MyShiroRealm.doGetAuthenticationInfo()");
//        //获取用户的输入的账号.
//        String mobile = (String)token.getPrincipal();
//        //通过username从数据库中查找 User对象，如果找到，没找到.
//        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        Client client = clientService.selectByPrimaryKey(mobile);
//        logger.info("----->>mobile="+mobile);
//        if(client == null){
//            return null;
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                client, //用户名
//                client.getPassword(), //密码
//                getName()  //realm name
//        );
//        return authenticationInfo;
//    }
//}
