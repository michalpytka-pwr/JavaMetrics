package pl.edu.pwr.master.metrics.pbr;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import pl.edu.pwr.master.core.ClassMetric;
import pl.edu.pwr.master.core.ClassMetricStrategy;
import pl.edu.pwr.master.core.model.Metric;
import java.util.List;

/**
 * TFU - Test Framework usage
 */

public class TfuMetric extends ClassMetricStrategy<Boolean> {

    private static final String METRIC_NAME = "TFU";
    private static final String frameworks = "[\\s|.]hamcrest[.|*]|[\\s|.]fest[.|*]|[\\s|.]assertj[.|*]|[\\s|.]atrium[.|*]|[\\s|.]strikt[.|*]";

    @Override
    public List<Metric<Boolean>> compute(CompilationUnit compilationUnit) {
        ClassMetric<Boolean> tfu = c -> c.getParentNode().get().findAll(ImportDeclaration.class)
                .stream()
                .anyMatch(a -> a.getNameAsString().split(frameworks).length > 1);

        return getMetricForClass(tfu, compilationUnit);
    }

    @Override
    public String getName() {
        return METRIC_NAME;
    }
}