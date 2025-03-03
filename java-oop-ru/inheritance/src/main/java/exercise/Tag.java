package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    private String tag;
    private Map<String, String> attributes;

    Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public String mapToString() {
        String result = " ";
        for (String key : attributes.keySet()) {
            result += String.format("%s=\"%s\"", key, attributes.get(key)) + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}
// END
