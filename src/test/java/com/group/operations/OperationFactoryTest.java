package com.group.operations;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNull;

public class OperationFactoryTest {
    @Test
    public void shouldReturanTotalMarksOperation(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance("marks");
        assertThat(operation, instanceOf(TotalMarksOperation.class));
    }
    @Test
    public void shouldReturanTotalOversOperation(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance("overs");
        assertThat(operation, instanceOf(TotalOversOperation.class));
    }
    @Test
    public void shouldReturanTotalWicketsOperation(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance("wickets");
        assertThat(operation, instanceOf(TotalWicketsOperation.class));
    }
    @Test
    public void shouldReturanNull(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance("Something");
        assertThat(operation, is(isNull()));
    }

}