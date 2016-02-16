import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMatrix {
    private final Matrix m1;
    private final Matrix m2;
    private final Matrix res;
    private final int countThread;


    private final static Object[][] TEST = new Object[][]{
            {new double[][]{{0.0}}, new double[][]{{0.0}}, new double[][]{{0.0}}, 1},
            {new double[][]{{1.0, 1.0}, {2.0, 2.0}}, new double[][]{{2.0, 2.0}, {1.0, 1.0}}, new double[][]{{3.0, 3.0}, {6.0, 6.0}}, 1},
            {new double[][]{{1.0, 1.0}, {2.0, 2.0}}, new double[][]{{2.0, 2.0}, {1.0, 1.0}}, new double[][]{{3.0, 3.0}, {6.0, 6.0}}, 2},
            {new double[][]{{1.0, 1.0, 1.0}, {2.0, 2.0, 2.0}}, new double[][]{{2.0, 2.0}, {1.0, 1.0}, {3.0, 3.0}}, new double[][]{{6.0, 6.0}, {12.0, 12.0}}, 2},
            {new double[][]{{1.0, 1.0, 1.0}, {2.0, 2.0, 2.0}}, new double[][]{{2.0, 2.0}, {1.0, 1.0}, {3.0, 3.0}}, new double[][]{{6.0, 6.0}, {12.0, 12.0}}, 3}
    };

    public TestMatrix(double[][] m1, double[][] m2, double[][] res, int countThread) {
        this.m1 = new Matrix(m1);
        this.m2 = new Matrix(m2);
        this.res = new Matrix(res);
        this.countThread = countThread;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() throws Exception {
        return Arrays.asList(TEST);
    }

    @Test
    public void test() {
        try {
            Matrix result = new MatrixMultiplication(m1, m2, countThread).multiply();
            Assert.assertTrue(compare(res, result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean compare(final Matrix m1, final Matrix m2) {
        if (m1.getLine() != m2.getLine() && m1.getColumns() != m2.getColumns())
            return false;
        for (int i = 0; i < m1.getLine(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                if (!m1.getElement(i, j).equals(m2.getElement(i, j)))
                    return false;
            }
        }
        return true;
    }
}
