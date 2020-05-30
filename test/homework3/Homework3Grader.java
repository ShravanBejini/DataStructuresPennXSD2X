package homework3;

import java.util.Iterator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Homework3Grader {
   public static void main(String[] var0) {
      Result var1 = JUnitCore.runClasses(new Class[]{CalculateScoresTest.class, CalculateSentenceScoreTest.class, AllWordsTest.class, ReadFileTest.class});
      int var2 = var1.getFailureCount();
      int var3 = var1.getRunCount() - var2;
      if (var3 == 1) {
         System.out.println("1 test passed.");
      } else {
         System.out.println(var3 + " tests passed.");
      }

      if (var2 == 1) {
         System.out.println("1 test failed.");
      } else {
         System.out.println(var2 + " tests failed.");
      }

      if (var2 == 0) {
         System.out.println("Great job!");
      } else {
         int var4 = (int)((double)var3 / (double)(var2 + var3) * 100.0D);
         int var5 = 1;

         for(Iterator var6 = var1.getFailures().iterator(); var6.hasNext(); ++var5) {
            Failure var7 = (Failure)var6.next();
            Throwable var8;
            if (var7.getMessage() == null) {
               var8 = var7.getException();
               System.out.println("#" + var5 + ". A test threw " + var8 + " at " + var8.getStackTrace()[0]);
            } else {
               var8 = var7.getException();
               if (var8 instanceof AssertionError) {
                  System.out.println("#" + var5 + ". " + var7.getMessage());
               } else {
                  System.out.println("#" + var5 + ". " + var7.getException() + " occurs at " + var7.getException().getStackTrace()[0]);
               }
            }
         }

         System.out.println("Your score for this assignment would be " + var4 + "%\n");
      }

   }
}