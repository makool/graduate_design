package com.didiElectrician;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm.SaltStyle;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.LinkedHashMap;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * 
	 * @Title: dataSource
	 * @Description: TODO
	 * @param @return
	 * @return DataSource
	 * @throws
	 */
	@Bean
	public DataSource dataSource() {

		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/didi?useUnicode=true&amp;charaterEncoding=utf-8&" +
				"zeroDateTimeBehavior=convertToNull");
		ds.setUser("root");
		ds.setPassword("root");//
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setAcquireIncrement(5);
		ds.setInitialPoolSize(10);
		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(60);
		ds.setMaxIdleTime(120);
		return ds;
	}

	/**
	 * 
	 * @Title: sessionFactory
	 * @Description: TODO
	 * @param @return
	 * @return SqlSessionFactoryBean
	 * @throws
	 */
	@Bean
	public SqlSessionFactoryBean sessionFactory() {

		SqlSessionFactoryBean sFactoryBean = new SqlSessionFactoryBean();
		sFactoryBean.setDataSource(dataSource());

		String packageSearchPath = "classpath*:com/didiElectrician/dao/*.xml";
		Resource[] resources = null;
		try {
			resources = new PathMatchingResourcePatternResolver()
					.getResources(packageSearchPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sFactoryBean.setMapperLocations(resources);
		sFactoryBean.setTypeAliasesPackage("com.didiElectrician.domain.po");

		return sFactoryBean;
	}

	/**
	 * 
	 * @Title: sessionTemplate
	 * @Description: TODO
	 * @param @return
	 * @return SqlSessionTemplate
	 * @throws
	 */
	@Bean(name = "msg_sqlSessionTemplate")
	public SqlSessionTemplate sessionTemplate() {

		SqlSessionTemplate sst = null;
		try {
			sst = new SqlSessionTemplate(sessionFactory().getObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sst;
	}

	/**
	 * 
	 * @Title: defaultAdvisorAutoProxyCreator
	 * @Description: TODO
	 * @param @return
	 * @return DefaultAdvisorAutoProxyCreator
	 * @throws
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

		return new DefaultAdvisorAutoProxyCreator();
	}

	/**
	 * 
	 * @Title: lifecycleBeanPostProcessor
	 * @Description: TODO
	 * @param @return
	 * @return LifecycleBeanPostProcessor
	 * @throws
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 
	 * @Title: AuthorizationAttributeSourceAdvisor
	 * @Description: TODO
	 * @param @return
	 * @return AuthorizationAttributeSourceAdvisor
	 * @throws
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor AuthorizationAttributeSourceAdvisor() {

		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(defaultWebSecurityManager());
		return advisor;
	}

	/**
	 * 
	 * @Title: ShiroFilterFactoryBean
	 * @Description: TODO
	 * @param @return
	 * @return ShiroFilterFactoryBean
	 * @throws
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean ShiroFilterFactoryBean() {

		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(defaultWebSecurityManager());
		factoryBean.setLoginUrl("/index.jsp");
		factoryBean.setSuccessUrl("/index");

		LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
		filterChainDefinitionMap.put("/user/login", "anon");//表示可以匿名访问
		filterChainDefinitionMap.put("/user/register","anon");

		filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
		filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
		//未授权界面;
		factoryBean.setUnauthorizedUrl("/403");

		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return factoryBean;
	}

	/**
	 * 
	 * @Title: defaultWebSecurityManager
	 * @Description: TODO
	 * @param @return
	 * @return DefaultWebSecurityManager
	 * @throws
	 */
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager() {

		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(jdbcAuthenticationRealm());
		return manager;
	}

	/**
	 * 
	 * @Title: jdbcAuthenticationRealm
	 * @Description: TODO
	 * @param @return
	 * @return JdbcRealm
	 * @throws
	 */
	@Bean
	public JdbcRealm jdbcAuthenticationRealm() {

		JdbcRealm realm = new JdbcRealm();

		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		SimpleCredentialsMatcher matcher = new SimpleCredentialsMatcher();

		credentialsMatcher.setHashAlgorithmName("SHA-256");
		realm.setDataSource(dataSource());
		realm.setCredentialsMatcher(matcher);
		realm.setAuthenticationCacheName("shiro.authorizationCache");
		realm.setAuthenticationQuery("select user.password from (select password,mobile from client union select password,mobile from electrician) user where user.mobile = ?");
		realm.setSaltStyle(SaltStyle.NO_SALT);
		realm.setUserRolesQuery("select r.role_text from role r, user_role ur  where ur.user_id= ? and ur.role_id = r.role_id");
		realm.setPermissionsQuery("select p.permission from role r, role_permission rp, permission p where r.role_text = ? and rp.role_id = r.role_id and rp.permission_id = p.permission_id");
		realm.setPermissionsLookupEnabled(true);

		return realm;
	}



	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

	}

}
