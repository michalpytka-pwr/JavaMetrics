package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

/**
 * NORT - number of repeated tests
 */

public class NortMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NORT";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> noct = c ->
                c.findAll(MethodDeclaration.class).stream()
                        .mapToInt(fd -> (int) fd.getAnnotations().stream().filter(a -> "RepeatedTest".equals(a.getName().toString())).count())
                        .sum();

        return getMetricForClass(noct, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
