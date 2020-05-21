package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;
import java.util.List;

/**
 * number of after usages - NOAU
 * number of @After annotations used in a test class
 */

public class NoauMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOAU";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> noau = c ->
                c.findAll(MethodDeclaration.class).stream()
                        .mapToInt(fd -> (int) fd.getAnnotations().stream().filter(a -> "After".equals(a.getName().toString())).count())
                        .sum();

        return getMetricForClass(noau, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}