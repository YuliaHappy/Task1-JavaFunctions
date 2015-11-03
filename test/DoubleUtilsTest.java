import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class DoubleUtilsTest {

    @Test
    public void isEquallyTestEqualsPositive() {
        Assert.assertThat(true, is (DoubleUtils.isEqually(1.6, 1.6 + 2.120446049250313e-016)));
    }

    @Test
    public void isEquallyTestEqualsNegative() {
        Assert.assertThat(true, is (DoubleUtils.isEqually(-1.6, -1.6 + 2.120446049250313e-016)));
    }

    @Test
    public void isEquallyTestNotEqualsPositiveAndNegative() {
        Assert.assertThat(false, is (DoubleUtils.isEqually(1.6, -1.6 + 2.120446049250313e-016)));
    }

    @Test
    public void isEquallyTestNotEquals() {
        Assert.assertThat(false, is (DoubleUtils.isEqually(1.6, 1.0)));
    }

    @Test
    public void isEquallyArrayTestEqualsInOrder() {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1.6, 1.7}, new double[]{1.6 + 2.120446049250313e-016, 1.7})));
    }

    @Test
    public void isEquallyArrayTestEqualsInNotOrder() {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1.6, 1.7}, new double[]{1.7, 1.6 + 2.120446049250313e-016})));
    }

    @Test
    public void isEquallyArrayTestEqualsElementsArrayRepeatedly() {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1.6, 1.6, 1.7}, new double[]{1.6, 1.7, 1.6})));
    }

    @Test
    public void isEquallyArrayTestEqualsEmptyArray() {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{}, new double[]{})));
    }

    @Test
    public void isEquallyArrayTestNotEquals() {
        Assert.assertThat(false, is (DoubleUtils.isEquallyArray(new double[]{1.6, 1.7}, new double[]{1.0, 2})));
    }

    @Test
    public void intersectionArrayTestInIntersectionBetterOneElements() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1.4, 1.7},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{1.4, 1.7}))));
    }

    @Test
    public void intersectionArrayTestInIntersectionOneElement() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1.7},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{1.9, 1.7}))));
    }

    @Test
    public void intersectionArrayTestOneArrayIsEmpty() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{}))));
    }

    @Test
    public void intersectionArrayTestArraysIsEmpty() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{},
                DoubleUtils.intersectionArray(new double[]{}, new double[]{}))));
    }

    @Test
    public void intersectionArrayTestOneArrayWithRepeatElement() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1},
                DoubleUtils.intersectionArray(new double[]{1, 1, 2}, new double[]{1}))));
    }

    @Test
    public void intersectionArrayTestArrayWithRepeatElement() throws Exception {
        Assert.assertThat(true, is (DoubleUtils.isEquallyArray(new double[]{1},
                DoubleUtils.intersectionArray(new double[]{1, 1, 2}, new double[]{1, 1}))));
    }
}