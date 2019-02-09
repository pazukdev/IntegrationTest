package uml.core;

/**
 * @author Wladimir Litvinov
 */
@FunctionalInterface
public interface Action<T> {

    T perform();

}
