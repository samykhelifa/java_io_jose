package org.paumard.io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ReadingBytes {

	public static void main(String[] args) {

		String fileName = "files/ints.bin.gz";
		
		try {
			Path path = Paths.get(fileName);
			long size = Files.size(path);
			System.out.println(path + " size: " + size);
		} catch (IOException e) {
		}
		
		try (InputStream is = new FileInputStream(new File(fileName));
			 GZIPInputStream gzis = new GZIPInputStream(is);
			 DataInputStream dis = new DataInputStream(gzis);) {
			
			List<Integer> ints = new ArrayList<>();
			try {
				while (true) {
					ints.add(dis.readInt());
				}
			} catch (EOFException e) {
			}
			System.out.println("ints: " + ints.size());
			
		} catch (IOException e) {
		}
	}
}
