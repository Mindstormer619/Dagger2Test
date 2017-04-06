package me.darthsid.dagger2test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope @Retention(RetentionPolicy.RUNTIME) @Documented
public @interface MainActivityScope {
}