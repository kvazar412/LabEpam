package splitters;

public class WordSplit extends AbstractSplit implements Constants {

	public WordSplit() {
	}

	@Override
	public String[] split(String sentence) {
		sentence = sentence.trim();
		String[] word = sentence.split(WORD_SPACE_PATTERN);
		for (int i = 0; i < word.length; i++) {
			word[i] = word[i].replaceAll(WORD_REPLACE_PATTERN, "");
		}
		return word;
	}
}
