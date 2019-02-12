package uml.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Siarhei Sviarkaltsau
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @NonNull
    private final String name;
    @NonNull
    private final String password;

    public static User createDefault() {
        return new User("User", "Password");
    }

}
