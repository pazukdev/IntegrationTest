package common.cucumber;

/**
 * This interface should be implemented to make Cucumber test case be able to run config-based JUnit tests
 *
 * @author Siarhei Sviarkaltsau
 */
public interface JUnitTestClassRunable {

    /**
     * "Hub" method for connection of Cucumber test case to independent JUnit test. The method choose test match to
     * "Examples" table data and then run it.
     */
    void chooseAndPerformTest(final String... args);

}
