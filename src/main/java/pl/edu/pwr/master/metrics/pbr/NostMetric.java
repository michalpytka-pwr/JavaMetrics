package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

/**
 * NONT - number of nested tests
 */

public class NostMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NONT";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> noct = c ->
                c.findAll(ClassOrInterfaceDeclaration.class).stream()
                        .mapToInt(fd -> (int) fd.getAnnotations().stream().filter(a -> "Nested".equals(a.getName().toString())).count())
                        .sum();

        return getMetricForClass(noct, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
