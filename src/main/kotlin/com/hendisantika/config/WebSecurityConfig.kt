package com.hendisantika.config

import org.keycloak.adapters.springsecurity.KeycloakConfiguration
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-keycloak-demo
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/12/21
 * Time: 09.49
 * To change this template use File | Settings | File Templates.
 */
@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : KeycloakWebSecurityConfigurerAdapter() {

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        val keycloakAuthenticationProvider = keycloakAuthenticationProvider()
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(SimpleAuthorityMapper())
        auth.authenticationProvider(keycloakAuthenticationProvider)
    }
}