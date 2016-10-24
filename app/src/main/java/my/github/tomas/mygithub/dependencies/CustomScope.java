package my.github.tomas.mygithub.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Tomas on 24/10/2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {


}