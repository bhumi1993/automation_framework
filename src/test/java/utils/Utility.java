package test.java.utils;
public class Utility {

    public static final long WAIT_TIME_SEC = 1000 * 3;

    public static void Halt(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception e) {
            StackTraceElement[] strackElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement ele : strackElements) {
                System.err
                        .println(String.format("Error during Halt.\nClass name: %s\nMethod name: %s\nLine number: %d\n",
                                ele.getClassName(), ele.getMethodName(), ele.getLineNumber()));
            }
        }
    }
}
