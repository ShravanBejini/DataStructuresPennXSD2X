package homework3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateScoresTest {
   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void testNull() {
      try {
         Map var1 = Analyzer.calculateScores((Set)null);
         if (var1 == null) {
            Assert.fail("calculateScores should return empty Map when input is null");
         }

         Assert.assertTrue("calculateScores should return empty Map when input is null", var1.isEmpty());
      } catch (Exception var2) {
         Assert.fail("calculateScores throws " + var2 + " when input is null");
      }

   }

   @Test
   public void testEmpty() {
      try {
         Map var1 = Analyzer.calculateScores(new HashSet());
         if (var1 == null) {
            Assert.fail("calculateScores should return empty Map when input is empty");
         }

         Assert.assertTrue("calculateScores should return empty Map when input is empty", var1.isEmpty());
      } catch (Exception var2) {
         Assert.fail("calculateScores throws " + var2 + " when input is empty");
      }

   }

   @Test
   public void testSingleWord() {
      Word var1 = new Word("apple");
      var1.increaseTotal(2);
      var1.increaseTotal(1);
      HashSet var2 = new HashSet();
      var2.add(var1);

      try {
         Map var3 = Analyzer.calculateScores(var2);
         if (var3 == null) {
            Assert.fail("calculateScores returns null when input has a single Word");
         } else if (var3.isEmpty()) {
            Assert.fail("calculateScores returns empty Map when input has a single Word");
         }

         Assert.assertTrue("calculateScores has wrong number of elements when input has a single Word", 1 == var3.size());
         Assert.assertTrue("calculateScores has wrong key for element when input has a single Word", var3.containsKey("apple"));
         double var4 = (Double)var3.get("apple");
         Assert.assertTrue("calculateScores has wrong score value for element when input has a single Word", Math.abs(1.5D - var4) <= 1.0E-5D);
      } catch (Exception var6) {
         Assert.fail("calculateScores throws " + var6 + " when input has a single Word");
      }

   }

   @Test
   public void testMultipleWords() {
      Word var1 = new Word("apple");
      var1.increaseTotal(2);
      var1.increaseTotal(1);
      Word var2 = new Word("banana");
      var2.increaseTotal(1);
      HashSet var3 = new HashSet();
      var3.add(var1);
      var3.add(var2);

      try {
         Map var4 = Analyzer.calculateScores(var3);
         if (var4 == null) {
            Assert.fail("calculateScores returns null when input has multiple Words");
         } else if (var4.isEmpty()) {
            Assert.fail("calculateScores returns empty Map when input has multiple Words");
         }

         Assert.assertTrue("calculateScores has wrong number of elements when input has multiple Words", 2 == var4.size());
         Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", var4.containsKey("apple"));
         Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", var4.containsKey("banana"));
         double var5 = (Double)var4.get("apple");
         Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", Math.abs(1.5D - var5) <= 1.0E-5D);
         var5 = (Double)var4.get("banana");
         Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", 1.0D == var5);
      } catch (Exception var7) {
         Assert.fail("calculateScores throws " + var7 + " when input has multiple Words");
      }

   }

   @Test
   public void testIgnoreNullWord() {
      Word var1 = new Word("apple");
      var1.increaseTotal(2);
      var1.increaseTotal(1);
      HashSet var2 = new HashSet();
      var2.add(var1);
      var2.add((Object)null);

      try {
         Map var3 = Analyzer.calculateScores(var2);
         if (var3 == null) {
            Assert.fail("calculateScores returns null when input contains a null Word");
         } else if (var3.isEmpty()) {
            Assert.fail("calculateScores returns empty Map when input contains a null Word");
         }

         Assert.assertTrue("calculateScores has wrong number of elements when input contains a null Word", 1 == var3.size());
         Assert.assertTrue("calculateScores has wrong key for element when input contains a null Word", var3.containsKey("apple"));
         double var4 = (Double)var3.get("apple");
         Assert.assertTrue("calculateScores has wrong score value for element when input contains a null Word", Math.abs(1.5D - var4) < 1.0E-5D);
      } catch (Exception var6) {
         Assert.fail("calculateScores throws " + var6 + " when input contains a null Word");
      }

   }
}