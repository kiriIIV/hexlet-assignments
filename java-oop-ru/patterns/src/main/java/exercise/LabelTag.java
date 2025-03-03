package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String value;
    private TagInterface someTag;

    LabelTag(String value, TagInterface someTag) {
        this.value = value;
        this.someTag = someTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", value, someTag.render());
    }
}
// END
