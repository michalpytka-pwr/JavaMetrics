package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of new objects - Nono
     * Number of 'new' usages per class.
     */

public class NonoMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "Nono_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nono = c -> c.findAll(ObjectCreationExpr.class).stream()
                .mapToInt(i -> 1)
                .sum();

        return getMetricForClass(nono, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
