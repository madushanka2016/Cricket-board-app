package com.group.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TotalOversOperationTest {
    @Test
    public void testOvers_case1(){
        Operation operation=new TotalOversOperation();
        int totalOvers=operation.performe("M000001","SL");
        assertThat(totalOvers,is(33));
    }
    @Test
    public void testOvers_case2(){
        Operation operation=new TotalOversOperation();
        int totalOvers=operation.performe("M000001","AF");
        assertThat(totalOvers,is(37));
    }
}