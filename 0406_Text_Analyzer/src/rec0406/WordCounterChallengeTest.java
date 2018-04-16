package rec0406;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class WordCounterChallengeTest {

	@Test
	public void testWordCounterSimple() {

		ArrayList<String> lines = new ArrayList<String>();

		lines.add("here's a line of text");
		lines.add("here's another line");
		lines.add("and one more line of text");

		WordCounter wc = new WordCounter(lines);

		Map<String, Integer> wordCount = wc.getWordCount();

		assertTrue(wordCount.size() == 7);
		assertTrue(wordCount.containsKey("heres"));
		assertTrue(wordCount.get("heres") == 2);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 3);
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
		
		assertTrue(wordCount.size() == 4);
		assertTrue(wordCount.containsKey("heres"));
		assertTrue(wordCount.get("heres") == 2);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 2);
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
		
		assertTrue(wordCount.size() == 4);
		assertTrue(wordCount.containsKey("heres"));
		assertTrue(wordCount.get("heres") == 2);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 3);
		assertTrue(wordCount.containsKey("text"));
		assertTrue(wordCount.get("text") == 1);
		assertTrue(wordCount.containsKey("another"));
		assertTrue(wordCount.get("another") == 2);
		
	}
	
	@Test
	public void testWordCounterLinesWithPunctuationAlone() {
		
		ArrayList<String> lines = new ArrayList<String>();

		lines.add("here's a line of text");
		lines.add("another  ,  ;  [  line");
		lines.add("here's another line");

		WordCounter wc = new WordCounter(lines);
		
		Map<String, Integer> wordCount = wc.getWordCount();
		
		assertTrue(wordCount.size() == 4);
		assertTrue(wordCount.containsKey("heres"));
		assertTrue(wordCount.get("heres") == 2);
		assertTrue(wordCount.containsKey("line"));
		assertTrue(wordCount.get("line") == 3);
		assertTrue(wordCount.containsKey("text"));
		assertTrue(wordCount.get("text") == 1);
		assertTrue(wordCount.containsKey("another"));
		assertTrue(wordCount.get("another") == 2);
		
	}
	

}
