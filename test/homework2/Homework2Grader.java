package homework2;


import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;

// 
// Decompiled by Procyon v0.5.36
// 

public class Homework2Grader
{
    public static void main(final String[] array) {
        final Result runClasses = JUnitCore.runClasses(new Class[] { HtmlValidatorTest.class });
        final int failureCount = runClasses.getFailureCount();
        final int i = runClasses.getRunCount() - failureCount;
        if (i == 1) {
            System.out.println("1 test passed.");
        }
        else {
            System.out.println(i + " tests passed.");
        }
        if (failureCount == 1) {
            System.out.println("1 test failed.");
        }
        else {
            System.out.println(failureCount + " tests failed.");
        }
        if (failureCount == 0) {
            System.out.println("Great job! Your score for this assignment would be 100%");
        }
        else {
            final int j = (int)(i / (double)(failureCount + i) * 100.0);
            int k = 1;
            for (final Failure failure : runClasses.getFailures()) {
                if (failure.getMessage() == null) {
                    final Throwable exception = failure.getException();
                    System.out.println("#" + k + ". A test threw " + exception + " at " + exception.getStackTrace()[0]);
                }
                else if (failure.getException() instanceof AssertionError) {
                    System.out.println("#" + k + ". " + failure.getMessage());
                }
                else {
                    System.out.println("#" + k + ". " + failure.getException() + " occurs at " + failure.getException().getStackTrace()[0]);
                }
                ++k;
            }
            System.out.println("Your score for this assignment would be " + j + "%\n");
        }
    }
}
