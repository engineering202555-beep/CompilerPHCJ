package VisitorHCJ;
import ASTHCJ.*;
public class VisitorHJC implements AstVisitor<Void>{


        private int depth = 0;

        private void indent() {
            for (int i = 0; i < depth; i++) {
                System.out.print("│   ");
            }
        }

        private void printNode(AstNode node) {
            indent();
            System.out.println(
                    node.getClass().getSimpleName()
                            + " (line " + node.getLineNumber() + ")"
            );
        }

       

        @Override
        public Void visitHtmlDocument(HtmlDocument document) {
            printNode(document);
            depth++;

            if (document.getDoctype() != null) {
                document.getDoctype().accept(this);
            }

            for (HtmlNode node : document.getNodes()) {
                node.accept(this);
            }

            depth--;
            return null;
        }

        @Override
        public Void visitDoctype(DoctypeNode node) {
            printNode(node);
            return null;
        }

      

        @Override
        public Void visitPairedTag(PairedTag node) {
            printNode(node);
            depth++;

            for (HtmlAttribute attr : node.getAttributes()) {
                attr.accept(this);
            }

            for (AstNode child : node.getChildren()) {
                if (child != null) {
                    child.accept(this);
                }
            }

            depth--;
            return null;
        }

//    @Override
//    public Void visitHtmlAttribute(HtmlAttribute node) {
//        return null;
//    }

    @Override
        public Void visitSelfClosingTag(SelfClosingTag node) {
            printNode(node);
            depth++;

            for (HtmlAttribute attr : node.getAttributes()) {
                attr.accept(this);
            }

            depth--;
            return null;
        }

    

        @Override
        public Void visitTextContent(TextContent node) {
            printNode(node);
            return null;
        }

    @Override
    public Void visitStyleContent(StyleContent node) {
        printNode(node);
        depth++;

        if (node.getCss() != null) {
            node.getCss().accept(this);
        }

        depth--;
        return null;
    }

     

        @Override
        public Void visitBooleanAttribute(BooleanAttribute attribute) {
            printNode(attribute);
            return null;
        }

        @Override
        public Void visitAttributeWithValue(AttributeWithValue attribute) {
            printNode(attribute);
            depth++;
            attribute.getValue().accept(this);
            depth--;
            return null;
        }

      

        @Override
        public Void visitStringValue(StringValue value) {
            printNode(value);
            return null;
        }

    @Override
    public Void visitCssStyleSheet(CssStyleSheetNode node) {
        printNode(node);
        depth++;

        for (CssRuleNode rule : node.getRules()) {
            rule.accept(this);
        }

        depth--;
        return null;
    }

    @Override
    public Void visitCssRule(CssRuleNode node) {
        printNode(node);
        depth++;

        node.getSelector().accept(this);

        for (CssDeclarationNode decl : node.getDeclarations()) {
            decl.accept(this);
        }

        depth--;
        return null;
    }

    @Override
    public Void visitCssSelector(CssSelectorNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssDeclaration(CssDeclarationNode node) {
        printNode(node);
        depth++;

        node.getValue().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitCssCompositeValue(CssCompositeValueNode node) {
        printNode(node);
        depth++;

        for (CssValueNode part : node.getParts()) {
            part.accept(this);
        }

        depth--;
        return null;
    }

    public Void visitCssNumberValue(CssNumberValueNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssUnitValue(CssUnitValueNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssIdentifierValue(CssIdentifierValueNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssKeywordValue(CssKeywordValueNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssColorValue(CssColorValueNode node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitCssFunctionValue(CssFunctionValueNode node) {
        printNode(node);
        depth++;

        for (CssValuePartNode arg : node.getArguments()) {
            arg.accept(this);
        }

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaIdentifier(J_JinjaIdentifier node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitJinjaStringLiteral(J_JinjaStringLiteral node) {
        printNode(node);
        return null;
    }


    @Override
    public Void visitJinjaNumberLiteral(J_JinjaNumberLiteral node) {
        printNode(node);
        return null;
    }

    @Override
    public Void visitJinjaDotAccess(J_JinjaDotAccess node) {
        printNode(node);
        depth++;

        node.getBase().accept(this);
        node.getProperty().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaKeywordArgument(J_JinjaKeywordArgument node) {
        printNode(node);
        depth++;

        node.getName().accept(this);
        node.getValue().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitCompositeAttributeValue(J_CompositeAttributeValue node) {
        printNode(node);
        depth++;

        for (AstNode part : node.getParts()) {
            part.accept(this); 
        }

        depth--;
        return null;
    }

//    @Override
//    public Void visitCssStyleSheetNode(CssStyleSheetNode node) {
//        return null;
//    }

//    @Override
//    public Void visitCssRuleNode(CssRuleNode node) {
//        return null;
//    }

//    @Override
//    public Void visitCssSelectorNode(CssSelectorNode node) {
//        return null;
//    }

//    @Override
//    public Void visitCssDeclarationNode(CssDeclarationNode node) {
//        return null;
//    }

    @Override
    public Void visitJinjaFunctionCall(J_JinjaFunctionCall node) {
        printNode(node);
        depth++;
        node.getFunctionName().accept(this);
        for (J_JinjaExpression arg : node.getArguments()) {
            arg.accept(this);
        }

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaForNode(J_JinjaForNode node) {
        printNode(node);
        depth++;

       
        for (J_JinjaLoopVariable var : node.getVariable()) {
            var.accept(this);
        }

   
        node.getIterable().accept(this);

   
        for (AstNode html : node.getBody()) {
            html.accept(this);
        }

        depth--;
        return null;
    }

   

    @Override
    public Void visitJinjaVariable(J_JinjaVariableNode node) {
        printNode(node);
        depth++;

        node.getExpression().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaIndexAccessNode(J_JinjaIndexAccessNode node) {
        printNode(node);
        depth++;

        // base
        node.getTarget().accept(this);

        // index
        node.getIndex().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaFilterNode(J_JinjaFilterNode node) {
        printNode(node);
        depth++;

        // expression being filtered
        node.getExpression().accept(this);

        depth--;
        return null;
    }

    @Override
    public Void visitJinjaLoopVariable(J_JinjaLoopVariable node) {
        printNode(node);  // طباعة العقدة نفسها
        indent();  // المسافة الإضافية لتوضيح العمق
        System.out.println("Loop Variable: " + node.getName() + " (line " + node.getLineNumber() + ")");
        return null;
    }


}






