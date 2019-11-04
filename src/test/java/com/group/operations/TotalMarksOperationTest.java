package com.group.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TotalMarksOperationTest {

    @Test
    public void testMarks_case1(){
        Operation operation=new TotalMarksOperation();
        int totalMarks=operation.performe("M000001","SL");
        assertThat(totalMarks,is(166));
    }
    @Test
    public void testMarks_case2(){
        Operation operation=new TotalMarksOperation();
        int totalMarks=operation.performe("M000001","AF");
        assertThat(totalMarks,is(133));
    }
}