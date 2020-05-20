package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.IfStmt;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of if statements - Nois
     * Number of if statements in a class
     */


public class NoisMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NOIS_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nois = c -> c.findAll(IfStmt.class).stream()
                .mapToInt(i -> 1).sum();

        return getMetricForClass(nois, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
