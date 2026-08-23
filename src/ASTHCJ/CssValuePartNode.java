//package ASTHCJ;
//
//import VisitorHCJ.AstVisitor;
//
//public abstract class CssValuePartNode extends CssValueNode {
//
//    protected CssValuePartNode(String nodeName, int lineNumber) {
//        super(nodeName, lineNumber);
//    }
//
//    @Override
//    public <T> T accept(AstVisitor<T> visitor) {
//        return super.accept(visitor);
//    }
//}
package ASTHCJ;

import VisitorHCJ.AstVisitor;

public abstract class CssValuePartNode extends CssValueNode {

    protected CssValuePartNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public abstract  <T>T accept(AstVisitor<T> visitor);
}
