package DUCS_Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	
	public static void copyFile(String src, String dst) {
		FileInputStream fins = null;
		FileOutputStream fouts = null;
		try {
			File infile = new File(src);
			File outfile = new File(dst);
			fins = new FileInputStream(infile);
			fouts = new FileOutputStream(outfile);
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = fins.read(buffer)) > 0) {
				fouts.write(buffer, 0, length);
			} 
			fins.close();
			fouts.close();
			System.out.println("File copied successfully!!");
		} catch(FileNotFoundException e) {
			System.out.println("File does not exist.");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		String src = "src/DUCS_Assignment/sourceFile.txt";
		String dst = "src/DUCS_Assignment/destinationFile.txt";
		copyFile(src, dst);

	}

}
