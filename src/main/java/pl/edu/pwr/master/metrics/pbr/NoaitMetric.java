package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;
import pl.edu.pwr.master.metrics.visitors.AssertVisitor;

import java.util.List;

    /**
     * Number of assertions in test - Noait
     * Number of assertions used in test class.
     */

public class NoaitMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOAIT_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> noait = c -> {
            AssertVisitor assertVisitor = new AssertVisitor();
            assertVisitor.visit(c, null);
            return assertVisitor.getCount();
        };

        return getMetricForClass(noait, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
