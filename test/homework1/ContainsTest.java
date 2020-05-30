package homework1;
import org.junit.Test;

import org.junit.Assert;
import java.util.LinkedList;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class ContainsTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testContainsMiddle() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(8);
        list2.add(3);
        list2.add(12);
        try {
            Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second in middle of list", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains second in middle of list");
        }
    }
    
    @Test
    public void testContainsFront() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(4);
        list2.add(8);
        list2.add(3);
        try {
            Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at front of list", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains second at front of list");
        }
    }
    
    @Test
    public void testContainsRear() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(3);
        list2.add(12);
        list2.add(6);
        try {
            Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at rear of list", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains second at rear of list");
        }
    }
    
    @Test
    public void testNoOverlap() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(5);
        list2.add(9);
        list2.add(2);
        try {
            Assert.assertFalse("containsSubsequence returns true when lists have no overlapping elements", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when lists have no overlapping elements");
        }
    }
    
    @Test
    public void testSomeOverlap() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(8);
        list2.add(3);
        list2.add(9);
        try {
            Assert.assertFalse("containsSubsequence returns true when lists have some overlapping elements but first does not contain all elements of second", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when lists have some overlapping elements but first does not contain all elements of second");
        }
    }
    
    @Test
    public void testOverlapWrongOrder() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(12);
        list2.add(8);
        list2.add(6);
        try {
            Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but not in same order", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains all elements of second but not in same order");
        }
    }
    
    @Test
    public void testOverlapOtherElementsInSequenceInOne() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(8);
        list2.add(3);
        list2.add(6);
        try {
            Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but with other elements in sequence", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains all elements of second but with other elements in sequence");
        }
    }
    
    @Test
    public void testOverlapOtherElementsInSequenceInTwo() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(8);
        list2.add(3);
        list2.add(9);
        list2.add(12);
        try {
            Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but with other elements in sequence", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first LinkedList contains all elements of second but with other elements in sequence");
        }
    }
    
    @Test
    public void testOverlapAtEndOfOne() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(12);
        list2.add(6);
        list2.add(7);
        try {
            Assert.assertFalse("containsSubsequence returns true when lists overlap at end of first LinkedList but it does not contain all elements of second", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when lists overlap at end of first LinkedList but it does not contain all elements of second");
        }
    }
    
    @Test
    public void testFirstNull() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(12);
        list2.add(6);
        list2.add(7);
        try {
            Assert.assertFalse("containsSubsequence returns true when first input is null", LinkedListUtils.containsSubsequence((LinkedList<Integer>)null, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first input is null");
        }
    }
    
    @Test
    public void testSecondNull() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(12);
        list2.add(6);
        list2.add(7);
        try {
            Assert.assertFalse("containsSubsequence returns true when second input is null", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, (LinkedList<Integer>)null));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws  " + obj + " when second input is null");
        }
    }
    
    @Test
    public void testBothNull() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        list2.add(12);
        list2.add(6);
        list2.add(7);
        try {
            Assert.assertFalse("containsSubsequence returns true when second input is null", LinkedListUtils.containsSubsequence((LinkedList<Integer>)null, (LinkedList<Integer>)null));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws  " + obj + " when second input is null");
        }
    }
    
    @Test
    public void testFirstEmpty() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(12);
        list2.add(6);
        list2.add(7);
        try {
            Assert.assertFalse("containsSubsequence returns true when first input is empty", LinkedListUtils.containsSubsequence(list, (LinkedList<Integer>)list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when first input is empty");
        }
    }
    
    @Test
    public void testSecondEmpty() {
        final LinkedList<Integer> list = new LinkedList<Integer>();
        final LinkedList<Integer> list2 = new LinkedList<Integer>();
        list.add(4);
        list.addLast(8);
        list.addLast(3);
        list.addLast(12);
        list.addLast(6);
        try {
            Assert.assertFalse("containsSubsequence returns true when second input is empty", LinkedListUtils.containsSubsequence((LinkedList<Integer>)list, list2));
        }
        catch (Exception obj) {
            Assert.fail("containsSubsequence throws " + obj + " when second input is empty");
        }
    }
}
