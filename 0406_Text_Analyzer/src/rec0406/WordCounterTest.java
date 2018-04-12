package rec0406;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testWordCounterSimple() {

		ArrayList<String> lines = new ArrayList<String>();

		lines.add("here's a line of text");
		lines.add("here's another line");
		lines.add("and one more line of text");

		WordCounter wc = new WordCounter(lines);

		Map<String, Integer> wordCount = wc.getWordCount();

		assertTrue(wordCount.size() == 9);
		assertTrue(wordCount.containsKey("here's"));
		assertTrue(wordCount.get("here's") == 2);
		assertTrue(wordCount.containsKey("a"));
		assertTrue(wordCount.get("a") == 1);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 3);
		assertTrue(wordCount.containsKey("of"));
		assertTrue(wordCount.get("of") == 2);
		assertTrue(wordCount.containsKey("text"));
		assertTrue(wordCount.get("text") == 2);
		assertTrue(wordCount.containsKey("another"));
		assertTrue(wordCount.get("another") == 1);
		assertTrue(wordCount.containsKey("and"));
		assertTrue(wordCount.get("and") == 1);
		assertTrue(wordCount.containsKey("one"));
		assertTrue(wordCount.get("one") == 1);
		assertTrue(wordCount.containsKey("more"));
		assertTrue(wordCount.get("more") == 1);

	}

	@Test
	public void testWordCounterEmptyLine() {

		ArrayList<String> lines = new ArrayList<String>();

		lines.add("here's a line of text");
		lines.add("        ");
		lines.add("here's another line");

		WordCounter wc = new WordCounter(lines);
		
		Map<String, Integer> wordCount = wc.getWordCount();
		
		assertTrue(wordCount.size() == 6);
		assertTrue(wordCount.containsKey("here's"));
		assertTrue(wordCount.get("here's") == 2);
		assertTrue(wordCount.containsKey("a"));
		assertTrue(wordCount.get("a") == 1);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 2);
		assertTrue(wordCount.containsKey("of"));
		assertTrue(wordCount.get("of") == 1);
		assertTrue(wordCount.containsKey("text"));
		assertTrue(wordCount.get("text") == 1);
		assertTrue(wordCount.containsKey("another"));
		assertTrue(wordCount.get("another") == 1);
	}
	
	
	@Test
	public void testWordCounterLinesWithEmptySpace() {
		
		ArrayList<String> lines = new ArrayList<String>();

		lines.add("here's a line of text");
		lines.add("another        line");
		lines.add("here's another line");

		WordCounter wc = new WordCounter(lines);
		
		Map<String, Integer> wordCount = wc.getWordCount();
		
		assertTrue(wordCount.size() == 6);
		assertTrue(wordCount.containsKey("here's"));
		assertTrue(wordCount.get("here's") == 2);
		assertTrue(wordCount.containsKey("a"));
		assertTrue(wordCount.get("a") == 1);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 3);
		assertTrue(wordCount.containsKey("of"));
		assertTrue(wordCount.get("of") == 1);
		assertTrue(wordCount.containsKey("text"));
		assertTrue(wordCount.get("text") == 1);
		assertTrue(wordCount.containsKey("another"));
		assertTrue(wordCount.get("another") == 2);
		
	}
	
	@Test
	public void testGetWordsOccuringMoreThan() {
		
		ArrayList<String> lines = new ArrayList<String>();

		for (int i = 0; i < 100; i++) {
			lines.add("eva's amazing text!");
			if (i % 2 == 0) {
				lines.add("wow, that's amazing text!");
			}
		}

		WordCounter wc = new WordCounter(lines);
		
		Map<String, Integer> wordCount = wc.getWordCount();
		
		assertTrue(wordCount.size() == 5);
		assertTrue(wordCount.containsKey("eva's"));
		assertTrue(wordCount.get("eva's") == 100);
		assertTrue(wordCount.containsKey("amazing"));
		assertTrue(wordCount.get("amazing") == 150);
		assertTrue(wordCount.containsKey("text!"));
		assertTrue(wordCount.get("text!") == 150);
		assertTrue(wordCount.containsKey("wow,"));
		assertTrue(wordCount.get("wow,") == 50);
		assertTrue(wordCount.containsKey("that's"));
		assertTrue(wordCount.get("that's") == 50);
		
		Map<String, Integer> commonWordCount = wc.getWordsOccuringMoreThan(120);
		
		assertTrue(commonWordCount.size() == 2);
		assertTrue(commonWordCount.containsKey("amazing"));
		assertTrue(commonWordCount.get("amazing") == 150);
		assertTrue(commonWordCount.containsKey("text!"));
		assertTrue(commonWordCount.get("text!") == 150);
		
	}

}
