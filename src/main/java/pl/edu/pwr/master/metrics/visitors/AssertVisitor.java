package pl.edu.pwr.master.metrics.visitors;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.AssertStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

    /**
     * Visitor used to count all assert statements and assert function calls from Junit
     */

public class AssertVisitor extends VoidVisitorAdapter<Void> {

    private int count = 0;

    @Override
    public void visit(AssertStmt n, Void arg) {
        super.visit(n, arg);
        count++;
    }

    @Override
    public void visit(MethodCallExpr n, Void arg) {
        if (!n.toString().contains("assert")) return;
        super.visit(n, arg);
        count++;
    }

    public int getCount() {
        return count;
    }
}
