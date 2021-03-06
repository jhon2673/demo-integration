package cc.mrbird.browser;

import cc.mrbird.handler.MyAuthenticationAccessDeniedHandler;
import cc.mrbird.handler.MyAuthenticationFailureHandler;
import cc.mrbird.handler.MyAuthenticationSucessHandler;
import cc.mrbird.session.MySessionExpiredStrategy;
import cc.mrbird.validate.code.ValidateCodeFilter;
import cc.mrbird.validate.smscode.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/13 16:52
 * @Version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private MySessionExpiredStrategy sessionExpiredStrategy;

    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
//        return jdbcTokenRepository;
        return null;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .accessDeniedHandler(authenticationAccessDeniedHandler)
                .and()
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // ??????????????????????????????
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // ????????????????????????????????????
                .formLogin() // ????????????
                // http.httpBasic() // HTTP Basic
                .loginPage("/authentication/require") // ???????????? URL
                .loginProcessingUrl("/login") // ?????????????????? URL
                .successHandler(authenticationSucessHandler) // ??????????????????
                .failureHandler(authenticationFailureHandler) // ??????????????????
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600) // remember ????????????????????????
                .userDetailsService(userDetailService)
                .and()
                .authorizeRequests() // ????????????
                .antMatchers("/authentication/require", "/login.html", "/code/image", "/code/sms", "/signout/success").permitAll() // ???????????? URL ????????????
                .anyRequest()  // ????????????
                .authenticated() // ???????????????
                .and()
                .sessionManagement()
                .invalidSessionUrl("/session/invalid")
                .maximumSessions(1)
                .expiredSessionStrategy(sessionExpiredStrategy)
                .and()
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessUrl("/signout/success")
                .deleteCookies("JSESSIONID")
                .and().csrf().disable();
    }
}
