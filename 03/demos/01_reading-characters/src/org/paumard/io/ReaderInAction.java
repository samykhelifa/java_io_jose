package org.paumard.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInAction {

	public static void main(String[] args) {

		Path path = Paths.get("files/bat-weasels.txt");
		
		try (Stream<String> lines = Files.newBufferedReader(path).lines();) {
			
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
