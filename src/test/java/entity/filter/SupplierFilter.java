package entity.filter;

import com.generation_p.gptour_autotests.consts.ExternalSupplier;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Siarhei Sviarkaltsau
 */
@Component
@RequiredArgsConstructor
@Getter
public class SupplierFilter implements SearchFilter {

    @NonNull
    private final Set<String> supplierCodes;


    public SupplierFilter(final ExternalSupplier supplier) {
        this(ExternalSupplier.collectSupplierCodesSet(supplier));
    }

    @Override
    public String toString() {
        return "supplier filter: " + supplierCodes;
    }

}













