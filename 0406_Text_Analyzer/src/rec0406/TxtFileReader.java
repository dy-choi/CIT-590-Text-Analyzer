package rec0406;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * This class is responsible for reading the provided .txt file. File
 * input/output should be covered in lecture next week. For now, we are
 * providing you with all the code needed to generate an ArrayList of Strings
 * that contains all the lines of the file.
 * 
 * @author eva
 *
 */
public class TxtFileReader {

	private String filename;

	public TxtFileReader(String filename) {
		this.filename = filename;
	}

	public ArrayList<String> getAllLines() {

		// initialize an arraylist to hold the lines of text
		ArrayList<String> lines = new ArrayList<String>();

		try {

			// create an BufferedReader to handle reading the file line by line
			BufferedReader file = new BufferedReader(new FileReader(filename));

			// get the first line of the file
			// will be null if no content in the file
			String line = file.readLine();

			// while there is more content
			while (line != null) {

				// trim the line
				line = line.trim();

				// make sure line wasn't just white space
				if (!line.isEmpty()) {
					// add the current line to the arraylist
					lines.add(line);
				}

				// get the next line in the file
				// will be null if no more lines in the file
				line = file.readLine();
			}

			// close the file resource
			file.close();

		} catch (FileNotFoundException e) {

			// print out what went wrong
			e.printStackTrace();

		} catch (IOException e) {

			// print out what went wrong
			e.printStackTrace();

		}

		// return the arraylist of lines of text
		return lines;
	}

}
