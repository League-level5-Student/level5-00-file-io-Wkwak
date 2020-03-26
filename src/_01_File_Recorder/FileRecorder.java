package _01_File_Recorder;

import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String words = JOptionPane.showInputDialog(null, "write somethng");
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt", true);
			
			fw.write(words);
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
