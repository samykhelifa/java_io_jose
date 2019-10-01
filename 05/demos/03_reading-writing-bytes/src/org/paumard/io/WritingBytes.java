package org.paumard.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

public class WritingBytes {
	
	public static void main(String[] args) {
		
		String pathname = "files/ints.bin.gz";
		File file = new File(pathname);
		
		try (OutputStream os = new FileOutputStream(file);
			 GZIPOutputStream gzos = new GZIPOutputStream(os);
			 DataOutputStream dos = new DataOutputStream(gzos);
				) {
			
			IntStream.range(0, 1000)
			.forEach(
					i -> { try { dos.writeInt(i); } catch (IOException e) {} }
			);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Path path = Paths.get(pathname);
			long size = Files.size(path);
			System.out.println(path + " size: " + size);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
