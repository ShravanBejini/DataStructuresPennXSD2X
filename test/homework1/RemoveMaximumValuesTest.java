package homework1;
import org.junit.Test;

import org.junit.Assert;
import java.util.LinkedList;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class RemoveMaximumValuesTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNull() {
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)null, 2);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when input LinkedList is null");
        }
    }
    
    @Test
    public void testNegativeSize() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("doge");
        list.add("cat");
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)list, -1);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when number of elements to remove is negative");
        }
        if (list.size() < 2) {
            Assert.fail("removeMaximumValues removes elements from LinkedList when number of elenents to remove is negative");
        }
        if (list.size() > 2) {
            Assert.fail("removeMaximumValues adds elements to LinkedList when number of elenents to remove is negative");
        }
    }
    
    @Test
    public void testInsertEmpty() {
        final LinkedList<String> list = new LinkedList<String>();
        try {
            LinkedListUtils.removeMaximumValues(list, 1);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when input LinkedList is empty");
        }
        Assert.assertTrue("removeMaximumValues adds elements to list when input LinkedList is empty", list.isEmpty());
    }
    
    @Test
    public void testRemoveGreaterThanSize() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("doge");
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)list, 2);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when number of elements to remove is greater than size of input LinkedList");
        }
        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove is greater than size of input LinkedList", list.isEmpty());
    }
    
    @Test
    public void testRemoveEqualsSize() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("doge");
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)list, 1);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when number of elements to remove equals size of input LinkedList");
        }
        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove equals size of input LinkedList", list.isEmpty());
    }
    
    @Test
    public void testEachMaxAppearsOnce() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("doge");
        list.add("cat");
        list.add("kangaroo");
        list.add("koala");
        list.add("bear");
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)list, 2);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when number of elements to remove is less than size of input");
        }
        if (list.size() < 3) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input");
        }
        if (list.size() > 3) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input");
        }
        if (list.contains("kangaroo") || list.contains("koala")) {
            Assert.fail("removeMaximumValues does not remove correct elements from LinkedList when number of elements to remove is less than size of input");
        }
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", list.get(0).equals("doge"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", list.get(1).equals("cat"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", list.get(2).equals("bear"));
    }
    
    @Test
    public void testMaxValuesAppearMoreThanOnce() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("doge");
        list.add("kangaroo");
        list.add("cat");
        list.add("kangaroo");
        list.add("koala");
        list.add("bear");
        list.add("doge");
        list.add("koala");
        list.add("kangaroo");
        try {
            LinkedListUtils.removeMaximumValues((LinkedList<String>)list, 2);
        }
        catch (Exception obj) {
            Assert.fail("removeMaximumValues throws " + obj + " when number of elements to remove is less than size of input and maximum elements appear more than once");
        }
        if (list.size() < 4) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }
        if (list.contains("kangaroo") || list.contains("koala")) {
            Assert.fail("removeMaximumValues does not remove all instances of max elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }
        if (list.size() > 4) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
        }
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", list.get(0).equals("doge"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", list.get(1).equals("cat"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", list.get(2).equals("bear"));
        Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", list.get(3).equals("doge"));
    }
}
