package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private ArrayList<Tag> children;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList<Tag> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Tag> children) {
        this.children = children;
    }

    PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> children) {
        super(tag, attributes);
        this.body = body;
        this.children = new ArrayList<>(children);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>%s%s</%s>", getTag(), mapToString(), body, listToString(), getTag());
    }

    public String listToString() {
        String result = "";
        for (Tag child : children) {
            result += child.toString();
        }
        return result;
    }
}
// END
