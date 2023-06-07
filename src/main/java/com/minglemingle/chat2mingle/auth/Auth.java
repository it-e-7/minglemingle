package com.minglemingle.chat2mingle.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {

    public enum Role { ADMIN, USER }
    public enum AccountStatus { NEED_PERMISSION_TO_CHAT }
    public Role role() default Role.USER;
    public AccountStatus status() default AccountStatus.NEED_PERMISSION_TO_CHAT;

}
