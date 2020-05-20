package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.VariableDeclarator;
import pl.edu.pwr.master.core.*;
import pl.edu.pwr.master.core.model.Metric;

import java.util.List;

    /**
     * Number of defined variables - Nodv
     * Number of defined variables in a class
     */

public class NodvMetric extends ClassMetricStrategy<Integer> {

    private static final String METRIC_NAME = "NODV_C";

    @Override
    public List<Metric<Integer>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Integer> nodv = c -> c.findAll(VariableDeclarator.class).stream()
                .mapToInt(i -> 1).sum();

        return getMetricForClass(nodv, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}
