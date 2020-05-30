package homework2;


import org.junit.Test;

import org.junit.Assert;
import java.io.IOException;
import java.util.Stack;

// 
// Decompiled by Procyon v0.5.36
// 

public class HtmlValidatorTest
{
    private String pathToTestFiles;
    
    public HtmlValidatorTest() {
        this.pathToTestFiles = "./TestFiles/Homework2/";
    }
    
    private Stack<HtmlTag> validateTestFile(final String s) {
        try {
            return (Stack<HtmlTag>)HtmlValidator.isValidHtml(HtmlReader.getTagsFromHtmlFile(this.pathToTestFiles + s));
        }
        catch (IOException obj) {
            System.out.println("An exception (" + obj + ") occurred while trying to read " + s + ". Be sure it is in the root directory of your Eclipse project or in the directory where you ran Java.");
            return null;
        }
    }
    
    @Test
    public void testFile1() {
        try {
            final Stack<HtmlTag> validateTestFile = this.validateTestFile("test1.html");
            if (validateTestFile == null) {
                Assert.fail("isValidHtml returns null for a valid HTML file input.");
            }
            Assert.assertTrue("isValidHtml should return an empty stack for a valid HTML file input.", validateTestFile.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " for valid HTML file input");
        }
    }
    
    @Test
    public void testFile2() {
        try {
            final Stack<HtmlTag> validateTestFile = this.validateTestFile("test2.html");
            if (validateTestFile == null) {
                Assert.fail("isValidHtml returns null when file ends without closing tags");
            }
            final Stack<HtmlTag> stack = new Stack<HtmlTag>();
            stack.push(new HtmlTag("html", true));
            stack.push(new HtmlTag("b", true));
            Assert.assertTrue("isValidHtml should return Stack with unmatched elements when file ends without closing tags", stack.equals(validateTestFile));
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " when file ends without closing tags");
        }
    }
    
    @Test
    public void testFile3() {
        try {
            final Stack<HtmlTag> validateTestFile = this.validateTestFile("test3.html");
            if (validateTestFile == null) {
                Assert.fail("isValidHtml returns null when tags are closed in incorrect order");
            }
            final Stack<HtmlTag> stack = new Stack<HtmlTag>();
            stack.push(new HtmlTag("b", true));
            stack.push(new HtmlTag("i", true));
            Assert.assertTrue("isValidHtml should return Stack with unmatched elements when tags are closed in incorrect order", stack.equals(validateTestFile));
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " when tags are closed in incorrect order");
        }
    }
    
    @Test
    public void testFile4() {
        try {
            Assert.assertNull("isValidHtml should return null when encountering closing tag without matching opening tag", (Object)this.validateTestFile("test4.html"));
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " when encountering closing tag without matching opening tag");
        }
    }
    
    @Test
    public void testFile5() {
        try {
            final Stack<HtmlTag> validateTestFile = this.validateTestFile("test5.html");
            if (validateTestFile == null) {
                Assert.fail("isValidHtml returns null for a valid HTML file input.");
            }
            Assert.assertTrue("isValidHtml should return an empty stack for a valid HTML file input.", validateTestFile.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " for a valid HTML file input.");
        }
    }
    
    @Test
    public void testFile6() {
        try {
            final Stack<HtmlTag> validateTestFile = this.validateTestFile("test6.html");
            if (validateTestFile == null) {
                Assert.fail("isValidHtml returns null when some tags are not closed");
            }
            final Stack<HtmlTag> stack = new Stack<HtmlTag>();
            stack.push(new HtmlTag("html", true));
            stack.push(new HtmlTag("head", true));
            stack.push(new HtmlTag("title", true));
            stack.push(new HtmlTag("p", true));
            Assert.assertTrue("isValidHtml should return Stack with unmatched elements when some tags are not closed", stack.equals(validateTestFile));
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " when some tags are not closed");
        }
    }
    
    @Test
    public void testFile7() {
        try {
            Assert.assertNull("isValidHtml should return null for HTML file containing only closing tag", (Object)this.validateTestFile("test7.html"));
        }
        catch (Exception obj) {
            Assert.fail("isValidHtml throws " + obj + " for HTML file containing only closing tag");
        }
    }
}
