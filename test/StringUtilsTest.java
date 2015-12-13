import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class StringUtilsTest {

    @Test
    public void getNumberEntrySymbolTestSymbolNotInLine() throws Exception {
        Assert.assertThat(0, is (StringUtils.countEntrySymbol('0', "123456789")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineOnesOnBegin() throws Exception {
        Assert.assertThat(1, is (StringUtils.countEntrySymbol('0', "0123456789")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineOnesOnLast() throws Exception {
        Assert.assertThat(1, is (StringUtils.countEntrySymbol('0', "1234567890")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineRepeatedly() throws Exception {
        Assert.assertThat(3, is (StringUtils.countEntrySymbol('0', "102345067890")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInEmptyLine() throws Exception {
        Assert.assertThat(0, is (StringUtils.countEntrySymbol('0', "")));
    }

    @Test
    public void isEqualElementsTestNotRepeatElementsInLine() throws Exception{
        Assert.assertFalse(StringUtils.isEqualElements(new String[]{"1", "2", "3", "4"}));
    }

    @Test
    public void isEqualElementsTestRepeatEmptyElementsInLine() throws Exception{
        Assert.assertTrue(StringUtils.isEqualElements(new String[]{"", "2", "3", ""}));
    }

    @Test
    public void isEqualElementsTestRepeatElementsInLine() throws Exception{
        Assert.assertTrue(StringUtils.isEqualElements(new String[]{"2", "2", "3", ""}));
    }

    @Test
    public void isEqualElementsTestRepeatElementsInEmptyLine() throws Exception{
        Assert.assertFalse(StringUtils.isEqualElements(null));
    }

    @Test
    public void isEqualElementsTestRepeatElementsInLineWithOneElement() throws Exception{
        Assert.assertFalse(StringUtils.isEqualElements(new String[]{"s"}));
    }
    
    @Test
    public void isEqualElementsTestArrayIsNull() throws  Exception {
        Assert.assertFalse(StringUtils.isEqualElements(null));
    }
}