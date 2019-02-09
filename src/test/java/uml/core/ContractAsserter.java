package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractAsserter implements Asserter {

    private final TestContext context;
    private final Contract expectedContract;

    public static ContractAsserter create(@Nonnull final TestContext context,
                                          @Nonnull final Contract expectedContract) {
        return new ContractAsserter(context, expectedContract);
    }

    @Override
    public Boolean perform() {
        checkActualContract();
        return true;
    }

    private void checkActualContract() {
        final Contract actual = createActualContract();
        Assert.assertEquals("Wrong contract data", actual, expectedContract);
    }

    private Contract createActualContract() {
        ContractInfoPage page = ContractInfoPage.create(context);
        return Contract.createFromContractInfoPageData(page);
    }

}
