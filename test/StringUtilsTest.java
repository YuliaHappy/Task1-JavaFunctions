import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class StringUtilsTest {

    @Test
    public void getNumberEntrySymbolTestSymbolNotInLine() throws Exception {
        Assert.assertThat(0, is (StringUtils.getNumberEntrySymbol('0', "123456789")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineOnesOnBegin() throws Exception {
        Assert.assertThat(1, is (StringUtils.getNumberEntrySymbol('0', "0123456789")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineOnesOnLast() throws Exception {
        Assert.assertThat(1, is (StringUtils.getNumberEntrySymbol('0', "1234567890")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInLineRepeatedly() throws Exception {
        Assert.assertThat(3, is (StringUtils.getNumberEntrySymbol('0', "102345067890")));
    }

    @Test
    public void getNumberEntrySymbolTestSymbolInEmptyLine() throws Exception {
        Assert.assertThat(0, is (StringUtils.getNumberEntrySymbol('0', "")));
    }

    @Test
    public void getNumberEntrySymbolTestBlankSymbolInLine() throws Exception {
        Assert.assertThat(0, is (StringUtils.getNumberEntrySymbol(' ', "123456789")));  //TODO
    }

    @Test
    public void isSameElementsTestNotRepeatElementsInLine() throws Exception{
        Assert.assertThat(false, is (StringUtils.isSameElements(new String[]{"1", "2", "3", "4"})));
    }

    @Test
    public void isSameElementsTestRepeatEmptyElementsInLine() throws Exception{
        Assert.assertThat(true, is (StringUtils.isSameElements(new String[]{"", "2", "3", ""})));
    }

    @Test
    public void isSameElementsTestRepeatElementsInLine() throws Exception{
        Assert.assertThat(true, is (StringUtils.isSameElements(new String[]{"2", "2", "3", ""})));
    }

    @Test
    public void isSameElementsTestRepeatElementsInEmptyLine() throws Exception{
        Assert.assertThat(false, is (StringUtils.isSameElements(null)));
    }

    @Test
    public void isSameElementsTestRepeatElementsInLineWithOneElement() throws Exception{
        Assert.assertThat(false, is (StringUtils.isSameElements(new String[]{"s"})));
    }
}