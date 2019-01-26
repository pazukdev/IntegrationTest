package common.cucumber.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is marker annotation for classes containing tests with structure which created according to possibility of
 * mapping their methods to .future files steps
 *
 * @author Siarhei Sviarkaltsau
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Cucumberable {}
