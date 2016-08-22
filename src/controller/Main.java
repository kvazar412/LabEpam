package controller;

import splitters.SentenceSplit;
import splitters.WordSplit;
import utils.FileOperator;

public class Main {

	public static void main(String[] args) {
		try {
			String sourceFileName = "data/sourceData.txt";
			String resultFileName = "data/resultData.txt";
			String sourceText;
			String resultText;

			sourceText = FileOperator.readFile(sourceFileName);
			System.out.println("Source text: \n" + sourceText);

			SentenceSplit sentenceOb = new SentenceSplit();
			WordSplit wordOb = new WordSplit();

			String[] sentence = sentenceOb.split(sourceText);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sentence.length; i++) {
				String[] word = wordOb.split(sentence[i]);
				for (int j = 0; j < word.length; j++) {
					sb.append(word[j]).append(" ");
				}
			}

			resultText = sb.toString();
			System.out.println("\nFormatted text: \n" + resultText);
			FileOperator.writeFile(resultFileName, resultText);
		} catch (Throwable e) {
			System.out.println("Error of main method " + e);
		}
	}
}
