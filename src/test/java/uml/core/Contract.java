package uml.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Contract {

    private final String contractData;

    public static Contract createDefault() {
        return new Contract("Some contract data");
    }

    public static Contract createFromContractInfoPageData(@Nonnull final ContractInfoPage page) {
        return new Contract(page.getContractInfo().getText());
    }

}
