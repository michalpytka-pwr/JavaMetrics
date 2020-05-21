package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

/**
 * NOET - number of extended tests
 */

public class NoetMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOET";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> noct = c -> (int)
                c.findAll(SingleMemberAnnotationExpr.class)
                        .stream()
                        .filter(a -> "ExtendWith".equals(a.getNameAsString()))
                        .count();


        return getMetricForClass(noct, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
