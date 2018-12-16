package com.cultivated.app.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(DatabaseAutoCreator.class)
public @interface AutoCreateDataBase {
}
