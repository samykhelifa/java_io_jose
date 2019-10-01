package org.paumard.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.paumard.io.model.Person;

public class WritingDataObjects {

	public static void main(String[] args) {

		String fileName = "files/person-proxy.bin";
		File file = new File(fileName);
		
		Person p1 = new Person("Linda", 32);
		Person p2 = new Person("David", 27);
		
		try (OutputStream os = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(os);) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(fileName + ": " + Files.size(Paths.get(fileName)));
		} catch (IOException e) {}
	}
}

