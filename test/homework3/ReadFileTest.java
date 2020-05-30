package homework3;

import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadFileTest {
   protected static final String DIRECTORY = "./TestFiles/Homework3/";

   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void testNull() {
      try {
         List var1 = Analyzer.readFile((String)null);
         if (var1 == null) {
            Assert.fail("readFile should return empty List when input filename is null");
         } else {
            Assert.assertTrue("readFile should return empty List when input filename is null", var1.isEmpty());
         }
      } catch (Exception var2) {
         Assert.fail("readFile throws " + var2 + " when input filename is null");
      }

   }

   @Test
   public void testInvalidFilename() {
      try {
         List var1 = Analyzer.readFile("invalid name!");
         if (var1 == null) {
            Assert.fail("readFile should return empty List when input file cannot be read");
         } else {
            Assert.assertTrue("readFile should return empty List when input file cannot be read", var1.isEmpty());
         }
      } catch (Exception var2) {
         Assert.fail("readFile throws " + var2 + " when input file cannot be read");
      }

   }

   @Test
   public void testTextOneSentence() {
      File var1 = new File("./test1.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test1.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test1.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with one sentence");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with one sentence");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has one sentence");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(var3.getText()));
      } catch (Exception var4) {
         Assert.fail("readFile throws " + var4 + " when processing file with one sentence");
      }

   }

   @Test
   public void testScoreOneSentence() {
      File var1 = new File("./test2.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test2.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test2.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with one sentence");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with one sentence");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has one sentence");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 2 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(var3.getText()));
      } catch (Exception var4) {
         Assert.fail("readFile throws " + var4 + " when processing file with one sentence");
      }

   }

   @Test
   public void testMultipleSentencesPositiveScores() {
      File var1 = new File("./test3.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test3.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test3.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with multiple sentences");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with multiple sentences");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has multiple sentences");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "this is a test".equals(var3.getText()));
         Sentence var4 = (Sentence)var2.get(1);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has multiple sentences");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 1 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "dogs are so cute".equals(var4.getText()));
         Sentence var5 = (Sentence)var2.get(2);
         if (var5 == null) {
            Assert.fail("readFile contains null Sentence when file has multiple sentences");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 2 == var5.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "testing is boring".equals(var5.getText()));
      } catch (Exception var6) {
         Assert.fail("readFile throws " + var6 + " when processing file with multiple sentences");
      }

   }

   @Test
   public void testMultipleSentencesNegativeScores() {
      File var1 = new File("./test4.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test4.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test4.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with multiple sentences");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with multiple sentences");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == var2.size());
         Sentence var3 = (Sentence)var2.get(1);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has multiple sentences");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -1 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "dogs are so cute".equals(var3.getText()));
         Sentence var4 = (Sentence)var2.get(2);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has multiple sentences");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -2 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "testing is boring".equals(var4.getText()));
      } catch (Exception var5) {
         Assert.fail("readFile throws " + var5 + " when processing file with multiple sentences");
      }

   }

   @Test
   public void testIgnoreInvalidSentenceWithNoScore() {
      File var1 = new File("./test5.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test5.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test5.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with invalid sentences that contain no score");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no score");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no score", 2 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "this is a test".equals(var3.getText()));
         Sentence var4 = (Sentence)var2.get(1);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 1 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "dogs are so cute".equals(var4.getText()));
      } catch (Exception var5) {
         Assert.fail("readFile throws " + var5 + " when processing file with invalid sentences that contain no score");
      }

   }

   @Test
   public void testIgnoreInvalidSentenceWithNoText() {
      File var1 = new File("./test6.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test6.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test6.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with invalid sentences that contain no text");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no text");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no text", 2 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "this is a test".contains(var3.getText()));
         Sentence var4 = (Sentence)var2.get(1);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 1 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "dogs are so cute".contains(var4.getText()));
      } catch (Exception var5) {
         Assert.fail("readFile throws " + var5 + " when processing file with invalid sentences that contain no text");
      }

   }

   @Test
   public void testIgnoreInvalidSentenceWithScoreOutsideRange() {
      File var1 = new File("./test7.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test7.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test7.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with sentences that have score outside valid range");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with invalid sentences that have score outside valid range");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score outside valid range", 2 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "this is a test".equals(var3.getText()));
         Sentence var4 = (Sentence)var2.get(1);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 1 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "dogs are so cute".equals(var4.getText()));
      } catch (Exception var5) {
         Assert.fail("readFile throws " + var5 + " when processing file with sentences that have score outside valid range");
      }

   }

   @Test
   public void testIgnoreInvalidSentenceWithScoreNotAnInteger() {
      File var1 = new File("./test8.txt");
      if (!var1.exists()) {
         Assert.fail("Could not run test for readFile: be sure that test8.txt is in your project root directory or the directory where you started Java.");
      }

      try {
         List var2 = Analyzer.readFile("./test8.txt");
         if (var2 == null) {
            Assert.fail("readFile returns null when processing file with sentences that have score that is not an integer");
         }

         if (var2.isEmpty()) {
            Assert.fail("readFile returns empty List when processing file with invalid sentences that have score that is not an integer");
         }

         Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score that is not an integer", 2 == var2.size());
         Sentence var3 = (Sentence)var2.get(0);
         if (var3 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 0 == var3.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "this is a test".equals(var3.getText()));
         Sentence var4 = (Sentence)var2.get(1);
         if (var4 == null) {
            Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
         }

         Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 1 == var4.getScore());
         Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "dogs are so cute".equals(var4.getText()));
      } catch (Exception var5) {
         Assert.fail("readFile throws " + var5 + " when processing file with sentences that have score that is not an integer");
      }

   }
}