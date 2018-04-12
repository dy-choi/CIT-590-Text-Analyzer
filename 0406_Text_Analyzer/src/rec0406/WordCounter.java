package rec0406;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	private ArrayList<String> lines;
	private Map<String, Integer> wordCount;

	public WordCounter(ArrayList<String> lines) {

		this.lines = lines;

		// initialize the map
		wordCount = new HashMap<String, Integer>();

		// generate the word count from the lines read
		generateWordCounts();
		removeTrivialWords(); // this is a challenege exercise

	}

	/**
	 * fills the map with words and counts
	 */
	protected void generateWordCounts() {

		// TODO

	}

	/**
	 * @return map of words to count totals
	 */
	protected Map<String, Integer> getWordCount() {
		return wordCount;
	}

	/**
	 * @param threshold
	 *            minimum word count to include in common words printed
	 */
	public void printWordsOccuringMoreThan(int threshold) {

		Map<String, Integer> commonWordCount = getWordsOccuringMoreThan(threshold);

		// TODO
	}

	/**
	 * @param threshold
	 *            minimum word count to include in returned map
	 * @return map of words to counts, with each count >= threshold
	 */
	public Map<String, Integer> getWordsOccuringMoreThan(int threshold) {

		// TODO

		return null;
	}

	/*
	 * NOTE: The following methods are challenge methods. They are meant for
	 * those who have finished the assignment before recitation is over. Notice
	 * that implementing and calling the below methods will cause our tests to
	 * fail, so you must write your own tests to test them.
	 */

	/**
	 * Define trivial words to be words that are either single- or
	 * double-characters long, such as "I", "a", "we", etc. Remove all such
	 * words from this.wordCount's key set.
	 */
	public void removeTrivialWords() {
		// TODO
	}

	/**
	 * Remove all punctuations from a word. Punctuations here are defined as
	 * anything that is not a letter or a digit. Do not use regex. If you do not
	 * know what it is, don't worry about it.
	 * 
	 * @param word
	 * @return
	 */
	private String removePunctuationsFromWord(String word) {
		String ans = "";
		// TODO: this is a challenge exercise.
		return ans;
	}

}
