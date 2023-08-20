package com.example.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests()
//                .requestMatchers("/css/**", "/images/**", "/js/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/user/loginPage")
//                .loginProcessingUrl("/user/loginPage")
//                .permitAll();
////                .successHandler(로그인 성공 시 실행할 커스터마이즈드 핸들러)
////                .failureHandler(로그인 실패 시 실행할 커스터마이즈드 핸들러);
//
//        http
//                .sessionManagement()
//                .invalidSessionUrl("/user/loginPage")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll();
//
//
//        //CSRF 토큰
//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//
//        return http.build();
//    }


}
