package action.abstraction;

/**
 * @author Wladimir Litvinov
 */
@FunctionalInterface
public interface Action<T> {

    T perform();

}
