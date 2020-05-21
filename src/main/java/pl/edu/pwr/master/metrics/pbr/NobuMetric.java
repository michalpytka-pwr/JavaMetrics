package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;
import java.util.List;

/**
 * number of before usages - NOBU
 * number of @Before annotations used in a test class
 */

public class NobuMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOBU";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> nobu = c ->
                c.findAll(MethodDeclaration.class).stream()
                        .mapToInt(fd -> (int) fd.getAnnotations().stream().filter(a -> "Before".equals(a.getName().toString())).count())
                        .sum();

        return getMetricForClass(nobu, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}