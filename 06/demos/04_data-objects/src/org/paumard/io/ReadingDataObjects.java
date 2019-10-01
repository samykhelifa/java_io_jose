package org.paumard.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

import org.paumard.io.model.Person;

public class ReadingDataObjects {

	public static void main(String[] args) {

		String fileName = "files/person-proxy.bin";
		File file = new File(fileName);
		
		try (InputStream is = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(is);) {
			
//			@SuppressWarnings("unchecked")
//			List<Person> people = (List<Person>)ois.readObject();
//			people.forEach(System.out::println);
			
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p2);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
