package uml.diagram.composition;

/**
 * @author Wladimir Litvinov
 */
@FunctionalInterface
public interface Action<T> {

    T perform();

}
