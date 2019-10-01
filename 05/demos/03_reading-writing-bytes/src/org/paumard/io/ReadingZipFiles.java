package org.paumard.io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipFiles {

	public static void main(String[] args) {

		String fileName = "files/archive.zip";
		
		try (InputStream is = new FileInputStream(new File(fileName));
			 ZipInputStream zis = new ZipInputStream(is);
			 DataInputStream dis = new DataInputStream(zis);) {
			
			ZipEntry entry = zis.getNextEntry();
			while (entry != null) {
				
				if (entry.isDirectory()) {
					System.out.println("Reading directory " + entry);
				} else {
					if (entry.getName().endsWith(".bin")) {
						System.out.println("Reading file " + entry);
						List<Integer> ints = new ArrayList<>();
						try {
							while (true) {
								ints.add(dis.readInt());
							}
						} catch (EOFException e) {
						}
						System.out.println("ints: " + ints.size());
					} else if (entry.getName().endsWith(".txt")) {
						System.out.println("Reading file " + entry);
						String content = dis.readUTF();
						System.out.println("Content = " + content);
					}
				}
				
				entry = zis.getNextEntry();
			}
			
		} catch (IOException e) {
		}
		
	}
}
