import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MatrixUtilsTest {
    @Test
    public void isEquallyTestNotEqualsCountRow() throws  Exception {
        Assert.assertThat(false, is
                (MatrixUtils.isEqually(new int[][]{new int[]{1,2}, new int[]{1,1}}, new int[][]{new int[]{1,2}})));
    }

    @Test
    public void isEquallyTestNotEqualsCountColumn() throws  Exception {
        Assert.assertThat(false, is
                (MatrixUtils.isEqually(new int[][]{new int[]{1,2}, new int[]{1,1}}, new int[][]{new int[]{1,2,3}, new int[]{1,1,1}})));
    }

    @Test
    public void isEquallyTestNotEquals() throws  Exception {
        Assert.assertThat(false, is
                (MatrixUtils.isEqually(new int[][]{new int[]{1,2}, new int[]{1,1}}, new int[][]{new int[]{1,2}, new int[]{1,2}})));
    }

    @Test
    public void isEquallyTestEqualsEmptyMatrix() throws  Exception {
        Assert.assertThat(true, is (MatrixUtils.isEqually(new int[][]{}, new int[][]{})));
    }

    @Test
    public void isEquallyTestEquals() throws  Exception {
        Assert.assertThat(true, is
                (MatrixUtils.isEqually(new int[][]{new int[]{1, 2}, new int[]{1, 1}}, new int[][]{new int[]{1, 2}, new int[]{1, 1}})));
    }

    @Test
    public void multiplicationMatrixTestOrdinary() throws Exception {
        Assert.assertThat(true, is(MatrixUtils.isEqually(new int[][]{new int[]{3, 6}, new int[]{3, 6}, new int[]{3, 6}},
                MatrixUtils.multiplicationMatrix(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}}, new int[][]{new int[]{1, 2}, new int[]{1, 2}}))));
    }

    @Test
    public void multiplicationMatrixTestMatrixIsEmpty() throws Exception {
        Assert.assertThat(true, is (MatrixUtils.isEqually(new int[][]{}, MatrixUtils.multiplicationMatrix(new int[][]{}, new int[][]{}))));
    }

    @Test
    public void multiplicationMatrixTestDimensionMatrixNotValid() throws Exception {
        Assert.assertThat(true, is (MatrixUtils.isEqually(new int[][]{},
                MatrixUtils.multiplicationMatrix(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}}, new int[][]{new int[]{1, 2}}))));
    }
}