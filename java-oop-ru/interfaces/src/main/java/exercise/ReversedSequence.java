package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String text;

    ReversedSequence(String line) {
        String result = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            result += line.charAt(i);
        }
        this.text = result;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.substring(start, end);
    }

    public String toString() {
        return text;
    }
}
// END
