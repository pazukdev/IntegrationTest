package testcore;

import lombok.extern.java.Log;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

@Log
public class ScreenshotTestRule implements MethodRule {

    static {
        LogUtils.setupLogger(log);
    }

    public static final ThreadLocal<Class<? extends WebDriver>> specificWebDriver = new ThreadLocal<>();

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                long start = 0;
                try {
                    start = System.currentTimeMillis();
                    final SpecificDriver spDriverAnn = frameworkMethod.getAnnotation(SpecificDriver.class);
                    if (spDriverAnn != null) {
                        specificWebDriver.set(spDriverAnn.value());
                    }
                    System.out.println(Thread.currentThread().getName() + "#" + System.currentTimeMillis()
                            + " TEST STARTED " + frameworkMethod.toString());
                    statement.evaluate();
                } catch (final Throwable t) {
                    OnTestFailsUtil.captureScreenshot(o, frameworkMethod.getName());
                    OnTestFailsUtil.checkFatalError(t, o);
                    OnTestFailsUtil.checkPopupLoading(t, o);
                    throw t; // rethrow to allow the failure to be reported to JUnit
                } finally {
                    ((AbstractUITest) o).quitSpecificDriver();
                    specificWebDriver.remove();
                    processFlowRelatedInfo((AbstractUITest) o);
                    System.out.println(Thread.currentThread().getName()
                            + "#" + System.currentTimeMillis() + " TEST FINISHED "
                                    + frameworkMethod.toString() + " " + (System.currentTimeMillis() - start));
                }
            }

        };
    }

    // non-public methods

    private void processFlowRelatedInfo(final AbstractUITest test) {
        logFlowData(test);
        createJSON(test);
    }

    private void logFlowData(final AbstractUITest test) {
        final FlowPath pathFormer = test.getFlowPathFormer();
        pathFormer.setEndFlowDetailedTime(pathFormer.createDetailedFlowTimePath());

        log.info(pathFormer.getFlowReport());
        log.info(test.getFlowCollectorArgumentsCreator().getSyntaxReport(pathFormer));
    }

    private void createJSON(final AbstractUITest test) {
        new FlowCollector().createJSONFlow(test.getFlowCollectorArgumentsCreator());
    }

}



















