package uk.ac.ed.inf.heatmap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HeatMapIO {
	
	/**
	 * Reads file line by line.
	 * Splits each line by ", " to get each number as a String
	 * and parse them as Double.
	 * 
	 * @param filename name of the file to read
	 * @return 2D Double array with the corresponding prediction
	 * in each cell.
	 * @throws FileNotFoundException
	 */
	public Double[][] parseFile(String filename) throws FileNotFoundException {
		var file = new FileReader(filename);
		Scanner scanner = new Scanner(file);
    	int line_row = 0;
    	Double[][] double_array = new Double[10][10];
    	while (scanner.hasNextLine()) {
    		String[] row = scanner.nextLine().split(", ");
    		int column = 0;
    		for (String element : row) {
    			double_array[line_row][column] = Double.parseDouble(element);
    			column++;	
    		}
    		line_row++;
    	}
    	return double_array;
	}
	
	/** 
	 * Creates file and writes to it a given String
	 * 
	 * @param filename name of the file to create
	 * @param string_to_write String to be written on the file
	 */
	public void createFile(String filename, String string_to_write) {
	    try {
	    	var writer = new FileWriter(filename);
	    	System.out.println("File " + filename + " created successfully.");
			writer.append(string_to_write);
			writer.append('\n');
		    writer.close();
		    
		} catch (IOException e) {
			System.out.println("File could not be created");
			e.printStackTrace();
		}
	  
	}
}
