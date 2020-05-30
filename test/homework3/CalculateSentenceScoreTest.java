package homework3;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateSentenceScoreTest {
   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void testNullMap() {
      try {
         double var1 = Analyzer.calculateSentenceScore((Map)null, "This is a test .");
         Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is null", 0.0D == var1);
      } catch (Exception var3) {
         Assert.fail("calculateSentenceScore throws " + var3 + " when input Map is null");
      }

   }

   @Test
   public void testEmptyMap() {
      try {
         double var1 = Analyzer.calculateSentenceScore(new HashMap(), "This is a test .");
         Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is empty", 0.0D == var1);
      } catch (Exception var3) {
         Assert.fail("calculateSentenceScore throws " + var3 + " when input Map is empty");
      }

   }

   @Test
   public void testNullSentence() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, (String)null);
         Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is null", 0.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when input sentence is null");
      }

   }

   @Test
   public void testEmptySentence() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "");
         Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is empty", 0.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when input sentence is empty");
      }

   }

   @Test
   public void testSentenceContainsNoValidWords() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "$");
         Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence contains no valid words", 0.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when input sentence contains no valid words");
      }

   }

   @Test
   public void testAllWordsInSentenceAndScoresAreInts() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);
      var1.put("cat", 2.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "dog cat");
         Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have integer scores", 2.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when all words in Map are in sentence and have integer scores");
      }

   }

   @Test
   public void testAllWordsInSentenceAndScoresAreDoubles() {
      HashMap var1 = new HashMap();
      var1.put("dog", 1.7D);
      var1.put("cat", 1.9D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "dog cat");
         Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have floating-point scores", Math.abs(1.8D - var2) < 1.0E-6D);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when all words in Map are in sentence and have floating-point scores");
      }

   }

   @Test
   public void testSomeWordsNotInMap() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);
      var1.put("cat", 1.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "dog cat gorilla");
         Assert.assertTrue("calculateSentenceScore does not return correct value when some words in sentence are not in input Map", 1.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when some words in sentence are not in input Map");
      }

   }

   @Test
   public void testIgnoreInvalidWords() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);
      var1.put("cat", 0.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "dog $pig cat");
         Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains invalid words", 1.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when input sentence contains invalid words");
      }

   }

   @Test
   public void testCaseInsensitivity() {
      HashMap var1 = new HashMap();
      var1.put("dog", 2.0D);
      var1.put("cat", 0.0D);

      try {
         double var2 = Analyzer.calculateSentenceScore(var1, "DOG cat");
         Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains words with uppercase letters", 1.0D == var2);
      } catch (Exception var4) {
         Assert.fail("calculateSentenceScore throws " + var4 + " when input sentence contains words with uppercase letters");
      }

   }
}