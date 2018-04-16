package rec0406;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {

	private ArrayList<String> lines;
	private Map<String, Integer> wordCount;

	public WordCounter(ArrayList<String> lines) {

		this.lines = lines;

		// initialize the map
		wordCount = new HashMap<String, Integer>();

		// generate the word count from the lines read
		generateWordCounts();
		removeTrivialWords();
	}

	/**
	 * @return map of words to count totals
	 */
	public void generateWordCounts() {

		// iterate through all the lines
		for (String line : lines) {

			// split the line at empty spaces
			String[] words = line.split(" ");

			// iterate through the words
			for (String word : words) {

				// check if the word is empty
				if (!word.isEmpty()) {
					// CHALLENGE EXERCISE: removePunctuationsFromWord
					word = removePunctuationsFromWord(word);

					// check if the map already has this word
					if (wordCount.containsKey(word)) {

						// get the current count
						int currentCount = wordCount.get(word);

						// change the count to be 1 more
						wordCount.put(word, currentCount + 1);

					} else {

						// add new word with count of 1
						wordCount.put(word, 1);
					}
				}
			}
		}

	}

	public Map<String, Integer> getWordCount() {
		return wordCount;
	}

	/**
	 * @param threshold
	 *            minimum word count to include in common words printed
	 */
	public void printWordsOccuringMoreThan(int threshold) {

		// get map of words that occur more than threshold
		Map<String, Integer> commonWordCount = getWordsOccuringMoreThan(threshold);

		// iterate through key set of map
		for (String word : commonWordCount.keySet()) {

			// format the output for each word: "count: word"
			// "\t" is a tab character
			String output = commonWordCount.get(word) + ":\t" + word;

			// print the formatted output
			System.out.println(output);

		}

	}

	/**
	 * @param threshold
	 *            minimum word count to include in returned map
	 * @return map of words to counts, with each count >= threshold
	 */
	public Map<String, Integer> getWordsOccuringMoreThan(int threshold) {

		// create a new map with all the values of the original, full word count
		// map
		Map<String, Integer> commonWordCount = new HashMap<String, Integer>(wordCount);

		// get an iterator for the collection of entries in the map
		Iterator<Entry<String, Integer>> iter = commonWordCount.entrySet().iterator();

		// keeping going while there are still entries to analyze
		while (iter.hasNext()) {

			// get the Entry object from the iterator
			Map.Entry<String, Integer> currentEntry = iter.next();

			// get the count for this entry
			Integer count = (Integer) currentEntry.getValue();

			// if the count is below the threshold, remove it from the map
			if (count < threshold) {
				iter.remove();
			}

		}
		// return the updated map
		return commonWordCount;

	}

	/*
	 * NOTE: The following methods are challenge methods. They are meant for
	 * those who have finished the assignment before recitation is over. Notice
	 * that implementing and calling the below methods will cause our tests to
	 * fail, so you must write your own tests to test them.
	 */

	/**
	 * Define trivial words to be words that are of length three or less, such
	 * as "I", "a", "we", "the", "and", etc. Remove all such words from
	 * this.wordCount's key set.
	 */
	private void removeTrivialWords() {
		Iterator<String> iter = this.wordCount.keySet().iterator();
		// iterate through each element in the key set
		while (iter.hasNext()) {
			// remove if iter points to String with length less than three
			if (iter.next().length() < 4) {
				iter.remove();
			}
		}
	}

	/**
	 * Remove all punctuations from a word. Punctuations here are defined as
	 * anything that is not a letter or a digit.
	 * 
	 * @param word
	 * @return
	 */
	private String removePunctuationsFromWord(String word) {
		String ans = "";
		// loop through all characters in a char[] of the word
		for (Character c : word.toCharArray()) {
			if (Character.isLetterOrDigit(c))
				ans += c;
		}
		return ans;
	}

}