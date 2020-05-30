package homework3;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AllWordsTest {
   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void testNull() {
      try {
         Set var1 = Analyzer.allWords((List)null);
         if (var1 == null) {
            Assert.fail("allWords should return empty Set when input is null");
         }

         Assert.assertTrue("allWords should return empty Set when input is null", var1.isEmpty());
      } catch (Exception var2) {
         Assert.fail("allWords throws " + var2 + " when input is null");
      }

   }

   @Test
   public void testEmpty() {
      try {
         Set var1 = Analyzer.allWords(new LinkedList());
         if (var1 == null) {
            Assert.fail("allWords should return empty Set when input is empty");
         }

         Assert.assertTrue("allWords should return empty Set when input is empty", var1.isEmpty());
      } catch (Exception var2) {
         Assert.fail("allWords throws " + var2 + " when input is empty");
      }

   }

   @Test
   public void testAllWordsDistinct() {
      Sentence var1 = new Sentence(0, "word dog ");
      Sentence var2 = new Sentence(0, "cat monkey ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when all words in List are distinct");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when all words in List are distinct");
         }

         Assert.assertEquals("allWords contains incorrect number of elements when all words are distinct", 4L, (long)var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(0);
         Word var6 = new Word("dog");
         var6.increaseTotal(0);
         Word var7 = new Word("cat");
         var7.increaseTotal(0);
         Word var8 = new Word("monkey");
         var8.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct", var4.contains(var7));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct", var4.contains(var8));
      } catch (Exception var9) {
         Assert.fail("allWords throws " + var9 + " when all words in List are distinct");
      }

   }

   @Test
   public void testIgnoreNullSentenceInList() {
      Sentence var1 = new Sentence(0, "word dog ");
      Sentence var2 = new Sentence(0, "cat monkey ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add((Object)null);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when a Sentence in List is null");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when a Sentence in List is null");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when a Sentence in List is null", 4 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(0);
         Word var6 = new Word("dog");
         var6.increaseTotal(0);
         Word var7 = new Word("cat");
         var7.increaseTotal(0);
         Word var8 = new Word("monkey");
         var8.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", var4.contains(var7));
         Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", var4.contains(var8));
      } catch (Exception var9) {
         Assert.fail("allWords throws " + var9 + " when a Sentence in List is null");
      }

   }

   @Test
   public void testCorrectTotalAllWordsDistinctScoresPositive() {
      Sentence var1 = new Sentence(1, "word dog ");
      Sentence var2 = new Sentence(2, "cat monkey ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when all words are distinct");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when all words are distinct");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(1);
         Word var6 = new Word("dog");
         var6.increaseTotal(1);
         Word var7 = new Word("cat");
         var7.increaseTotal(2);
         Word var8 = new Word("monkey");
         var8.increaseTotal(2);
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", var4.contains(var7));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", var4.contains(var8));
      } catch (Exception var9) {
         Assert.fail("allWords throws " + var9 + " when all words are distinct");
      }

   }

   @Test
   public void testCorrectTotalAllWordsDistinctScoresNegative() {
      Sentence var1 = new Sentence(-1, "word dog ");
      Sentence var2 = new Sentence(-2, "cat monkey ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when all words are distinct");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when all words are distinct");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(-1);
         Word var6 = new Word("dog");
         var6.increaseTotal(-1);
         Word var7 = new Word("cat");
         var7.increaseTotal(-2);
         Word var8 = new Word("monkey");
         var8.increaseTotal(-2);
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", var4.contains(var7));
         Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", var4.contains(var8));
      } catch (Exception var9) {
         Assert.fail("allWords throws " + var9 + " when all words are distinct");
      }

   }

   @Test
   public void testSomeWordsAppearMoreThanOnce() {
      Sentence var1 = new Sentence(0, "word dog ");
      Sentence var2 = new Sentence(0, "cat dog ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when some words appear more than once");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words appear more than once");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(0);
         Word var6 = new Word("dog");
         var6.increaseTotal(0);
         Word var7 = new Word("cat");
         var7.increaseTotal(0);
         var6.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", var4.contains(var7));
      } catch (Exception var8) {
         Assert.fail("allWords throws " + var8 + " when some words appear more than once");
      }

   }

   @Test
   public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresPositive() {
      Sentence var1 = new Sentence(1, "word dog ");
      Sentence var2 = new Sentence(2, "cat dog ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when some words appear more than once");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words appear more than once");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(1);
         Word var6 = new Word("dog");
         var6.increaseTotal(1);
         Word var7 = new Word("cat");
         var7.increaseTotal(2);
         var6.increaseTotal(2);
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", var4.contains(var7));
      } catch (Exception var8) {
         Assert.fail("allWords throws " + var8 + " when some words appear more than once");
      }

   }

   @Test
   public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresNegative() {
      Sentence var1 = new Sentence(-1, "word dog ");
      Sentence var2 = new Sentence(-2, "cat dog ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when some words appear more than once");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words appear more than once");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(-1);
         Word var6 = new Word("dog");
         var6.increaseTotal(-1);
         Word var7 = new Word("cat");
         var7.increaseTotal(-2);
         var6.increaseTotal(-2);
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", var4.contains(var7));
      } catch (Exception var8) {
         Assert.fail("allWords throws " + var8 + " when some words appear more than once");
      }

   }

   @Test
   public void testIgnoreWordThatStartsWithCharacterThatIsNotALetter() {
      Sentence var1 = new Sentence(0, "word $dog ");
      LinkedList var2 = new LinkedList();
      var2.add(var1);

      try {
         Set var3 = Analyzer.allWords(var2);
         if (var3 == null) {
            Assert.fail("allWords returns null when some words start with character that is not a letter");
         } else if (var3.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words start with character that is not a letter");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words start with character that is not a letter", 1 == var3.size());
         Word var4 = new Word("word");
         var4.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when some words start with character that is not a letter", var3.contains(var4));
      } catch (Exception var5) {
         Assert.fail("allWords throws " + var5 + " when some words start with character that is not a letter");
      }

   }

   @Test
   public void testIgnoreWordThatIsSingleCharacterThatIsNotALetter() {
      Sentence var1 = new Sentence(0, "word dog ?");
      LinkedList var2 = new LinkedList();
      var2.add(var1);

      try {
         Set var3 = Analyzer.allWords(var2);
         if (var3 == null) {
            Assert.fail("allWords returns null when some words are single character that is not a letter");
         } else if (var3.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words are single character that is not a letter");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words are single character that is not a letter", 2 == var3.size());
         Word var4 = new Word("word");
         var4.increaseTotal(0);
         Word var5 = new Word("word");
         var5.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", var3.contains(var4));
         Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", var3.contains(var5));
      } catch (Exception var6) {
         Assert.fail("allWords throws " + var6 + " when some words are single character that is not a letter");
      }

   }

   @Test
   public void testCaseInsensitivity() {
      Sentence var1 = new Sentence(0, "word dog ");
      Sentence var2 = new Sentence(0, "cat DOG ");
      LinkedList var3 = new LinkedList();
      var3.add(var1);
      var3.add(var2);

      try {
         Set var4 = Analyzer.allWords(var3);
         if (var4 == null) {
            Assert.fail("allWords returns null when some words are same ignoring case");
         } else if (var4.isEmpty()) {
            Assert.fail("allWords returns empty Set when some words are same ignoring case");
         }

         Assert.assertTrue("allWords contains incorrect number of elements when some words are same ignoring case", 3 == var4.size());
         Word var5 = new Word("word");
         var5.increaseTotal(0);
         Word var6 = new Word("dog");
         var6.increaseTotal(0);
         Word var7 = new Word("cat");
         var7.increaseTotal(0);
         var6.increaseTotal(0);
         Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", var4.contains(var5));
         Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", var4.contains(var6));
         Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", var4.contains(var7));
      } catch (Exception var8) {
         Assert.fail("allWords throws " + var8 + " when some words are same ignoring case");
      }

   }
}
