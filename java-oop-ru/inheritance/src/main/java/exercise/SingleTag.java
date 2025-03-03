package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{

    SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", getTag(), mapToString());
    }
}
// END
