package homework3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) throws IOException {

		/* IMPLEMENT THIS METHOD! */
		
		List<Sentence> result = new ArrayList<>();
		
		if (filename == null)
			return result;

		String temp = ""; 
		String[] validScores = {"0 ", "-1 ", "-2 ", "1 ", "2 "};
		File f = new File(filename);
		if (f.length() == 0)
			return result;
		
		BufferedReader br = new BufferedReader(new FileReader(f));
					
		while((temp = br.readLine())!=null)
			for(String item: validScores) 
				if (temp.startsWith(item)){
					Sentence s = new Sentence( Integer.parseInt(item.trim()), temp.substring(item.length()) );
					result.add(s);
				}					
					
		br.close();
				
		return result; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		Set<Word> result = new HashSet<>();
		
		if (sentences == null)
			return result;
		
		//Set<String> wordList = new HashSet<>();
		for (Sentence s: sentences) { 
			
			if (s == null)
				continue;
			
			String[] temp = s.text.split(" ");

			for(String item: temp) 
				if (Character.isAlphabetic(item.charAt(0))) {
					Word word = new Word(item.toLowerCase());
					result.add(word);
			}
			
		}
		
		for(Word w: result) {
			for (Sentence s: sentences) {

				if (s == null)
					continue;
				
				int tempCount = 0;
				String[] temp = s.text.split(" "); 
				
				for(String item: temp) 
					if (item.toLowerCase().equals(w.text)) 
						tempCount ++;
					
				if (tempCount==1)
					w.increaseTotal(s.score);
				else if ( tempCount > 1) {
					for(int i = 0; i< tempCount - 1; i++)
						w.increaseTotal(0);
					w.increaseTotal(s.score);
				}
			}	
		}		
		
		return result; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		Map<String, Double> result = new HashMap<>();
		
		if (words == null)
			return result;
		
		for(Word w: words) {
			if (w == null)
				continue;
			result.put(w.text, w.calculateScore());
		}
				
		return result; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		double score = 0, result = 0;
		if (wordScores == null || wordScores.isEmpty())
			return result;
		if(sentence == null || sentence.isEmpty())
			return result;
		String[] temp = sentence.split(" ");
		int count = 0;
		for (String s: temp)
			if(Character.isAlphabetic(s.charAt(0)))
				count++;
		if (count == 0)
			return 0;
		
		for (String item: temp)
			if (wordScores.containsKey(item.toLowerCase()))
				score += wordScores.get(item.toLowerCase());
						
		return (Double) (score/count); // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * if (args.length == 0) {
		 * System.out.println("Please specify the name of the input file");
		 * System.exit(0); }
		 */
		
		String filename = "./testinputfile";
		/*
		 * System.out.print("Please enter a sentence: "); Scanner in = new
		 * Scanner(System.in); String sentence = in.nextLine(); in.close();
		 */
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		/*
		 * Set<Word> words = Analyzer.allWords(sentences); Map<String, Double>
		 * wordScores = Analyzer.calculateScores(words); double score =
		 * Analyzer.calculateSentenceScore(wordScores, sentence);
		 * System.out.println("The sentiment score is " + score);
		 */
		
		for(Sentence s: sentences)
			System.out.println(s.score + " " + s.text);
		
		for (Word w: words)
			System.out.println(w.text + " " + w.count + " " + w.total);
		
	}
}
