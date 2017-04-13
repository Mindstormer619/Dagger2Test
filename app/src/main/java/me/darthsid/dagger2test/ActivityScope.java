package me.darthsid.dagger2test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by darthsid on 13/4/17.
 */

@Scope @Documented @Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
