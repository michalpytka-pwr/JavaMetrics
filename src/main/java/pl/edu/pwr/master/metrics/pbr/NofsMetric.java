package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.ForStmt;
import pl.edu.pwr.master.core.*;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of for statements - Nofs
     * Number of for statements in a class
     */

public class NofsMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOFS_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nofs = c -> c.findAll(ForStmt.class).stream()
                .mapToInt(i -> 1).sum();

        return getMetricForClass(nofs, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
