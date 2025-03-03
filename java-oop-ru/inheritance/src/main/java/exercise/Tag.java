package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    private String tag;
    private Map<String, String> attributes;

    Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public abstract String toString();

    public String mapToString() {
        String result = " ";
        for (String key : attributes.keySet()) {
            result += String.format("%s=\"%s\"", key, attributes.get(key)) + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}
// END
