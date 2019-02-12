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

    private final String skill;
    private String country;
    private Integer age;

    public static Developer createDefault() {
        final String skill = "python";
        final String country = "India";
        final Integer age = 14;
        return create(skill, country, age);
    }

    public static Developer create(@Nonnull final String skill,
                                   @Nonnull final String country,
                                   @Nonnull final Integer age) {
        Developer developer = new Developer(skill);
        developer.setCountry(country);
        developer.setAge(age);
        return developer;
    }

    public static Developer createFromSearchResultPage(@Nonnull final DeveloperSearchResultPage page) {
        Developer actualDeveloper = null;
        // some steps to create developer from page data
        return actualDeveloper;
    }

}
