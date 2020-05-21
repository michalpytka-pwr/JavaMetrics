package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MemberValuePair;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

/**
 * NOEET - Number of expected exception tests
 */

public class NoeetMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOEET";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nooet = c ->
                c.findAll(MethodDeclaration.class).stream()
                        .mapToInt(fd -> (int) fd.getAnnotations()
                                .stream()
                                .filter(a -> "Test".equals(a.getName().toString())
                                        && a.findAll(MemberValuePair.class).stream().anyMatch(m -> "expected".equals(m.getName().toString()))).count())
                        .sum();

        return getMetricForClass(nooet, compilationUnit);
    }
    @Override
    public String getName() {
        return METRIC_NAME;
    }
}