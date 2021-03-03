  
package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.security.login.SecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityService userDetailsService;
	
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //ログインを実際にやる物の設定
    	auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静的リソースに対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers("/style.css");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //ログイン不要でアクセス可能に設定
                .antMatchers("/login","/makeNewCompanyAccount","/makeNewCompanyAccount/make").permitAll()
                //さらにマスター権限（MASTER）がないとアクセスできない
                .antMatchers("/confinguration","/makeNewUser","/resultMakeNewUser").hasAuthority(Authority.master)
                //上記以外は直リンク禁止
                .anyRequest().authenticated()
            .and()
            .formLogin()
                //ログイン処理のパス
                .loginProcessingUrl("/login")
                //ログインページ
                .loginPage("/login")
                //ログインエラー時の遷移先 ※パラメーターに「error」を付与
                .failureUrl("/login?error")
                //ログイン成功時の遷移先
                .defaultSuccessUrl("/home",true)
                //ログイン時のキー：ユーザーID テスト時コメントアウトする
                .usernameParameter("userId")
                //ログイン時のパスワード テスト時コメントアウトする
                .passwordParameter("password")
            .and()
            .logout()
                //ログアウト時の遷移先 POSTでアクセス
                .logoutSuccessUrl("/login");
    }

    //パスワードのアルゴリズムをBCryptに設定
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}