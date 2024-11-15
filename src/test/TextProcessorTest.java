package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextProcessorTest {

    TextProcessor textProcessor = new TextProcessor();

    // Existing Data Providers
    @DataProvider(name = "anagramDataProvider")
    public Object[][] anagramDataProvider() {
        return new Object[][] {
            { "listen", "silent", true },
            { "triangle", "integral", true },
            { "apple", "pale", false }
        };
    }

    @DataProvider(name = "reverseWordsDataProvider")
    public Object[][] reverseWordsDataProvider() {
        return new Object[][] {
            { "hello world", "world hello" },
            { "open source projects", "projects source open" },
            { "TestNG is awesome", "awesome is TestNG" }
        };
    }

    // Updated method name to match the XML
    @Test(dataProvider = "anagramDataProvider", groups = "text")
    public void testAreAnagrams(String str1, String str2, boolean expected) {
        Assert.assertEquals(textProcessor.areAnagrams(str1, str2), expected);
    }

    // Updated method name to match the XML
    @Test(dataProvider = "reverseWordsDataProvider", groups = "text")
    public void testReverseWords(String sentence, String expected) {
        Assert.assertEquals(textProcessor.reverseWords(sentence), expected);
    }

    // Parameterized Test for areAnagrams using XML parameters
    @Test(groups = "parameterized")
    @Parameters({ "anagramStr1", "anagramStr2" })
    public void testAreAnagramsParameterized(String str1, String str2) {
        boolean expected = true; // Adjust expected based on XML input if needed
        Assert.assertEquals(textProcessor.areAnagrams(str1, str2), expected);
    }

    // Parameterized Test for reverseWords using XML parameters
    @Test(groups = "parameterized")
    @Parameters({ "sentence" })
    public void testReverseWordsParameterized(String sentence) {
        String expected = new StringBuilder(sentence).reverse().toString(); // Reverse words logic
        Assert.assertEquals(textProcessor.reverseWords(sentence), expected);
    }
}
