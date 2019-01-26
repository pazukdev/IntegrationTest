package common.cucumber;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import test.searchfilter.product.flight.AbstractFlightSearchFilterIT.OfferFilterFormSupplierFilterIT;
import test.searchfilter.product.flight.AbstractFlightSearchFilterIT.SearchFormAirlineFilterIT;
import test.searchfilter.product.flight.AbstractFlightSearchFilterIT.SearchFormDirectFlightFilterIT;
import test.searchfilter.product.flight.AbstractFlightSearchFilterIT.SearchFormFlightClassFilterIT;
import test.searchfilter.product.flight.AbstractFlightSearchFilterIT.SearchFormSupplierFilterIT;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Siarhei Sviarkaltsau
 */
@Log
@RequiredArgsConstructor
public class ConfigToTestMapper {

    static {
        LogUtils.setupLogger(log);
    }

    private static final String FILE_PATH = "./src/test/resources/testdescription/flight_search_filter_test_list.txt";
    private static final String CLASS_NAME_MARKER = "com.generation_p";

    @NonNull
    private final Boolean fromFile;
    private boolean debug;

    public Map<String, Class> createMap() {
        return fromFile ? createMapFromFile() : createMapProgrammatically();
    }

    public String createKey(final String... args) {
        String key = "";
        for (final String arg : args) {
            key += "[" + arg.replaceAll(" ", "") + "]";
        }
        if (debug) {
            log.info(key);
        }
        return key;
    }

    // non-public methods

    private Map<String, Class> createMapProgrammatically() {
        final Map<String, Class> map = new HashMap<>();

        map.put(createKey("flight offer entity.filter form", "supplier"), OfferFilterFormSupplierFilterIT.class);
        map.put(createKey("flight search form", "supplier"), SearchFormSupplierFilterIT.class);
        map.put(createKey("flight search form", "direct flight"), SearchFormDirectFlightFilterIT.class);
        map.put(createKey("flight search form", "flight class"), SearchFormFlightClassFilterIT.class);
        map.put(createKey("flight search form", "airline"), SearchFormAirlineFilterIT.class);

        return map;
    }

    private Map<String, Class> createMapFromFile() {
        final Map<String, Class> map = new HashMap<>();

        for (final String sourceLine : getDataStringList()) {
            processLine(sourceLine, map);
        }

        return map;
    }

    private void processLine(final String sourceLine, final Map<String, Class> map) {
        if (!sourceLine.contains(CLASS_NAME_MARKER)) return;
        final List<String> testData = getTestDataListFromSourceLine(sourceLine);
        map.put(getKeyFromTestData(testData), getValueFromTestData(testData));
    }

    private List<String> getTestDataListFromSourceLine(String sourceLine) {
        sourceLine = sourceLine.replaceAll(" ", "");
        sourceLine = sourceLine.substring(1, sourceLine.length() - 1);
        return Arrays.asList((sourceLine.split("\\|")));
    }

    private List<String> getDataStringList() {
        List<String> lines = null;
        try (final BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        if (debug) {
            Objects.requireNonNull(lines).forEach(log::info);
        }
        return lines;
    }

    private String getKeyFromTestData(final List<String> testData) {
        return createKey(excludeClassNameFromTestData(testData).toArray(new String[0]));
    }

    private Class getValueFromTestData(final List<String> testData) {
        try {
            return Class.forName(getClassNameFromTestData(testData));
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getClassNameFromTestData(final List<String> testData) {
        for (final String element : testData) {
            if (element.contains(CLASS_NAME_MARKER)) {
                return element;
            }
        }
        return null;
    }

    private List<String> excludeClassNameFromTestData(final List<String> testData) {
        final List<String> copyOfTestData = new ArrayList<>(testData);
        copyOfTestData.removeIf(item -> item.contains(CLASS_NAME_MARKER));
        return copyOfTestData;
    }

}

























