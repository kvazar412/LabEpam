package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperator {

	public static String readFile(String sourceFileName) {
		String sourceText = null;
		String fileString;

		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = null;

			try {
				br = new BufferedReader(new FileReader(new File(sourceFileName)));
				while ((fileString = br.readLine()) != null) {
					sb.append(fileString);
					sb.append("\n");
				}
				sourceText = sb.toString();
			} catch (IOException e) {
				System.out.println("Reading error " + e);
			} finally {
				br.close();
			}

		} catch (IOException e) {
			System.out.println("Reading error " + e);
		}
		return sourceText;
	}

	public static void writeFile(String resultFileName, String resultText) {
		PrintWriter pw = null;
		try {
			File resultFile = new File(resultFileName);
			if (!resultFile.exists()) {
				resultFile.createNewFile();
			}
			pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile)));
			pw.print(resultText);
			System.out.println("\nFormatted text was successfully writed to " + resultFile.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Writing error " + e);
		} finally {
			pw.close();
		}
	}
}
