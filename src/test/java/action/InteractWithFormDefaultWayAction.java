package action;

import action.abstraction.Action;
import org.springframework.beans.factory.annotation.Autowired;
import pom.DefaultInteractable;

/**
 * @author Siarhei Sviarkaltsau
 */
public class InteractWithFormDefaultWayAction implements Action {

    @Autowired
    public DefaultInteractable form;

    @Override
    public void perform() {
        form.interactDefaultWay();
    }
}
