package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Removal {

	public static void main(String args[]) throws IOException {

		File file = new File("src/main/resources/new");
		File file2 = new File("src/main/resources/old");
		Set<String> words = new LinkedHashSet<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
			String cont = null;
			try {
				while ((cont = reader.readLine()) != null) {
					words.add(cont.trim());
				}
				for (String string : words) {
					writer.write(string);
					writer.write("\r\n");
				}
			}finally {
				reader.close();
				writer.close();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}