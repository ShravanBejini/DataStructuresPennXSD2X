package homework1;
import org.junit.Test;

import org.junit.Assert;
import java.util.LinkedList;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class InsertSortedTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testInsertMiddle() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.addLast(8);
        list.addLast(11);
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)list, 10);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when placing value in middle of list");
        }
        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value in middle of list", list.size() == 4);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", list.get(0) == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", list.get(1) == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", list.get(2) == 10);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", list.get(3) == 11);
    }
    
    @Test
    public void testInsertEnd() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.addLast(8);
        list.addLast(11);
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)list, 14);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when placing value at end of list");
        }
        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at end of list", list.size() == 4);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", list.get(0) == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", list.get(1) == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", list.get(2) == 11);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", list.get(3) == 14);
    }
    
    @Test
    public void testInsertFront() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.addLast(8);
        list.addLast(11);
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)list, 1);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when placing value at front of list");
        }
        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at front of list", list.size() == 4);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", list.get(0) == 1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", list.get(1) == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", list.get(2) == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", list.get(3) == 11);
    }
    
    @Test
    public void testInsertMiddleEqualToExistingElement() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.addLast(8);
        list.addLast(11);
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)list, 8);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when placing value that is equal to value already in list");
        }
        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value that is equal to value already in list", list.size() == 4);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", list.get(0) == 3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", list.get(1) == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", list.get(2) == 8);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", list.get(3) == 11);
    }
    
    @Test
    public void testNull() {
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)null, 0);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when input LinkedList is null");
        }
    }
    
    @Test
    public void testInsertEmpty() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        try {
            LinkedListUtils.insertSorted((LinkedList<Integer>)list, 10);
        }
        catch (Exception obj) {
            Assert.fail("insertSorted throws " + obj + " when inserting into empty list");
        }
        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when inserting into empty list", list.size() == 1);
        Assert.assertTrue("insertSorted does not correctly insert element into empty list", list.get(0) == 10);
    }
}
