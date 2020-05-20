package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of assumptions in test - Noasit
     * Number of assumptions used in test class. (Junit 5.0 feature)
     */

public class NoasitMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOASIT_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> noasit = c -> c.findAll(MethodCallExpr.class).stream()
                .filter(m -> m.toString().contains("assum"))
                .mapToInt(i -> 1)
                .sum();

        return getMetricForClass(noasit, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
