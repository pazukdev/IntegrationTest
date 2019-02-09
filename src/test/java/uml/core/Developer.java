package uml.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@Setter
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Developer {

    private final String name;
    private String country;
    private Integer age;

    public static Developer createDefault() {
        Developer defaultDeveloper = new Developer("Alex");
        defaultDeveloper.setCountry("Belarus");
        defaultDeveloper.setAge(61);
        return defaultDeveloper;
    }

    public static Developer createFromSearchResultPage(@Nonnull final DeveloperSearchResultPage page) {
        Developer actualDeveloper = null;
        // some steps to create developer from page data
        return actualDeveloper;
    }

}
