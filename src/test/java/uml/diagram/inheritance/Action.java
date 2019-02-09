package uml.diagram.inheritance;

/**
 * @author Wladimir Litvinov
 */
@FunctionalInterface
public interface Action<T> {

    T perform();

}
