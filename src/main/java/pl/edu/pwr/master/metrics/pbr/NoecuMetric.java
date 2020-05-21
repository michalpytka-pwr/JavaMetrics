package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.VariableDeclarator;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

/**
 * number of ErrorCollector usages - NOECU
 * usage of ErrorCollector in class (JUnit 4.0 feature)
 */

public class NoecuMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOECU_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {

        ClassMetric<Integer> noecu = c -> c.findAll(VariableDeclarator.class).stream()
                .filter(v -> v.toString().contains("ErrorCollector"))
                .mapToInt(i -> 1)
                .sum();


        return getMetricForClass(noecu, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
