/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter.config;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Component
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface UseCase {}
