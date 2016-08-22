package splitters;

public class SentenceSplit extends AbstractSplit implements Constants {

	public SentenceSplit() {
	}

	@Override
	public String[] split(String poem) {
		String[] sentence = poem.split(SENTENCE_PATTERN);
		return sentence;
	}
}
