//package ASTHCJ;
//import VisitorHCJ.AstVisitor;
//public abstract class CssValueNode extends CssNode {
//
//    protected CssValueNode(String nodeName, int lineNumber) {
//        super(nodeName, lineNumber);
//    }
//
//    @Override
//    public <T> T accept(AstVisitor<T> visitor) {
//        return null;
//    }
//}
//
//
//
//
//
//
//
//
//
package ASTHCJ;
import VisitorHCJ.AstVisitor;

public abstract class CssValueNode extends CssNode {

    protected CssValueNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    // نجعله abstract بدون جسم ليقوم كل ابن بتطبيقه بطريقته
    @Override
    public abstract <T> T accept(AstVisitor<T> visitor);
}