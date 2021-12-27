package com.hendisantika.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kotlin-keycloak-demo
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/12/21
 * Time: 09.57
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/api")
class KeycloakController {
    @GetMapping("/example")
    @PreAuthorize("hasRole('USER')")
    fun getUserInfo(): ResponseEntity<String> =
        ResponseEntity.ok("User info")

    @GetMapping("/example/admin")
    @PreAuthorize("hasRole('ADMIN')")
    fun getAdminInfo(): ResponseEntity<String> =
        ResponseEntity.ok("User info")

    @GetMapping("/public/example")
    fun getPublicInfo(): ResponseEntity<String> =
        ResponseEntity.ok("Public info")
}