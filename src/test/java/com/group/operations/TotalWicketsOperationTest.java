package com.group.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TotalWicketsOperationTest {
    @Test
    public void testWickets_case1(){
        Operation operation=new TotalWicketsOperation();
        int totalWickets=operation.performe("M000001","SL");
        assertThat(totalWickets,is(9));
    }
    @Test
    public void testWickets_case2(){
        Operation operation=new TotalWicketsOperation();
        int totalWickets=operation.performe("M000001","AF");
        assertThat(totalWickets,is(28));
    }
}