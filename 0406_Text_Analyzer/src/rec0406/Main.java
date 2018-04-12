package rec0406;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		TxtFileReader tfr = new TxtFileReader("war_and_peace.txt");
		
		ArrayList<String> lines = tfr.getAllLines();
		
		WordCounter wc = new WordCounter(lines);
		
		wc.printWordsOccuringMoreThan(500);

	}

}
