package ASTHCJ;
import java.util.List;
public abstract class HtmlElement extends HtmlNode {

    protected final String tagName;
    protected final List<HtmlAttribute> attributes;

    public HtmlElement(String nodeName, int lineNumber, String tagName, List<HtmlAttribute> attributes) {
        super(nodeName, lineNumber);
        this.tagName = tagName;
        this.attributes = attributes;
    }



    public String getTagName() {
        return tagName;
    }

    public List<HtmlAttribute> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "tagName='" + tagName + '\'' +
                ", attributesCount=" + attributes.size() +
                '}';
    }
}