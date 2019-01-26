package action.abstraction;

/**
 * @author Siarhei Sviarkaltsau
 */
public interface UndoableAction extends Action {

    Action getUndo();

}
