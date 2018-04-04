//package com.didiElectrician.config;
//
//import com.didiElectrician.domain.Client;
//import com.didiElectrician.domain.Permission;
//import com.didiElectrician.domain.Role;
//import com.didiElectrician.service.ClientService;
//import com.didiElectrician.service.PermissionService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ShiroRealm extends AuthorizingRealm {
//    private Logger logger =  LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private ClientService clientService;
//
//    @Autowired
//    private PermissionService permissionService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
//        Client client = clientService.selectByPrimaryKey((String)principalCollection.getPrimaryPrincipal());
//
//        //把principals放session中 key=userId value=principals
//        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(client.getMobile()),SecurityUtils.getSubject().getPrincipals());
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        //赋予角色
////        for(Role userRole:client.getRole()){
////            info.addRole(userRole.getName());
////        }
//
//        //赋予权限
////        for(Permission permission:permissionService.getByUserId(user.getId())){
//////            if(StringUtils.isNotBlank(permission.getPermCode()))
////            info.addStringPermission(permission.getPermission());
////        }
//
//        //设置登录次数、时间
////        userService.updateUserLogin(user);
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());
//
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String userName=token.getUsername();
//        logger.info(userName+token.getPassword());
//
//        Client client = clientService.selectByPrimaryKey((String)token.getPrincipal());
//        if (client != null) {
////            byte[] salt = Encodes.decodeHex(user.getSalt());
////            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
//            //设置用户session
//            Session session = SecurityUtils.getSubject().getSession();
//            session.setAttribute("client", client);
//            return new SimpleAuthenticationInfo(userName,client.getPassword(),getName());
//        } else {
//            return null;
//        }
////        return null;
//    }
//
//}