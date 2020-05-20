package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of dynamic tests - Nodt
     * Number of dynamic tests in a test class (Junit 5.0 feature)
     */

public class NodtMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NODT_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nodt = c -> c.findAll(MethodDeclaration.class).stream()
                .mapToInt(i -> (int) i.getAnnotations().stream()
                        .filter(a -> a.getName().toString().contains("TestFactory")).count())
                .sum();

        return getMetricForClass(nodt, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
