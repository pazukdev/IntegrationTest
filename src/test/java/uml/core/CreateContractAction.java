package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateContractAction implements Action {

    private final TestContext context;
    private final SimpleAction simpleAction;
    private final Contract contract;

    public static CreateContractAction create(@Nonnull final TestContext context,
                                              @Nonnull final SimpleAction simpleAction,
                                              @Nonnull final Contract contract) {
        return new CreateContractAction(context, simpleAction, contract);
    }

    @Override
    public Boolean perform() {
        processContractPage(ContractCreationPage.create(context));
        return true;
    }

    private void processContractPage(@Nonnull final ContractCreationPage page) {
        simpleAction.clearInputAndSendKeys(page.getContractDataField(), contract.getContractData());
        simpleAction.clickAndWaitForLoading(page.getAcceptButton());
    }

}
