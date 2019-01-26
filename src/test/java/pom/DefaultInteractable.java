package pom;

/**
 * @author Siarhei Sviarkaltsau
 */
public interface DefaultInteractable {

    /**
     * method should interact with any UI form (form, page, popup, ect.) most common (and actually in some cases
     * most short as well) way
     */
    DefaultInteractable interactDefaultWay();

    DefaultInteractable acceptDefaultWay();
}
