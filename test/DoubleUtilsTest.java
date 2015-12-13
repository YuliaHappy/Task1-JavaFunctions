import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class DoubleUtilsTest {

    @Test
    public void isEquallyTestEqualsPositive() {
        Assert.assertTrue(DoubleUtils.isEqually(1.6, 1.6 + DoubleUtils.EPSILON));
    }

    @Test
    public void isEquallyTestEqualsNegative() {
        Assert.assertTrue(DoubleUtils.isEqually(-1.6, -1.6 + DoubleUtils.EPSILON));
    }

    @Test
    public void isEquallyTestNotEqualsPositiveAndNegative() {
        Assert.assertFalse(DoubleUtils.isEqually(1.6, -1.6 + DoubleUtils.EPSILON));
    }

    @Test
    public void isEquallyTestNotEquals() {
        Assert.assertFalse(DoubleUtils.isEqually(1.6, 1.0));
    }

    @Test
    public void isEquallyArrayTestEqualsInOrder() {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1.6, 1.7}, new double[]{1.6 + DoubleUtils.EPSILON, 1.7}));
    }

    @Test
    public void isEquallyArrayTestEqualsInNotOrder() {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1.6, 1.7}, new double[]{1.7, 1.6 + DoubleUtils.EPSILON}));
    }

    @Test
    public void isEquallyArrayTestEqualsElementsArrayRepeatedly() {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1.6, 1.6, 1.7}, new double[]{1.6, 1.7, 1.6}));
    }

    @Test
    public void isEquallyArrayTestEqualsEmptyArray() {
        Assert.assertTrue(DoubleUtils.equal(new double[]{}, new double[]{}));
    }

    @Test
    public void isEquallyArrayTestNotEquals() {
        Assert.assertFalse(DoubleUtils.equal(new double[]{1.6, 1.7}, new double[]{1.0, 2}));
    }

    @Test
    public void intersectionArrayTestInIntersectionBetterOneElements() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1.4, 1.7},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{1.4, 1.7})));
    }

    @Test
    public void intersectionArrayTestInIntersectionOneElement() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1.7},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{1.9, 1.7})));
    }

    @Test
    public void intersectionArrayTestOneArrayIsEmpty() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{},
                DoubleUtils.intersectionArray(new double[]{1.1, 1.4, 1.7}, new double[]{})));
    }

    @Test
    public void intersectionArrayTestArraysIsEmpty() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{},
                DoubleUtils.intersectionArray(new double[]{}, new double[]{})));
    }

    @Test
    public void intersectionArrayTestOneArrayWithRepeatElement() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1},
                DoubleUtils.intersectionArray(new double[]{1, 1, 2}, new double[]{1})));
    }

    @Test
    public void intersectionArrayTestArrayWithRepeatElement() throws Exception {
        Assert.assertTrue(DoubleUtils.equal(new double[]{1},
                DoubleUtils.intersectionArray(new double[]{1, 1, 2}, new double[]{1, 1})));
    }
}