
package com.tinesoft.gwt.pixlr.showcase.client.place;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.google.inject.BindingAnnotation;

/**
 * Default Place a.k.a. MainPage.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface DefaultPlace {}
