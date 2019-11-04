package com.group.output;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNull;

public class OutputFactoryTest {
    @Test
    public void ShouldReturnOverviewDisplay() {
        OutputFactory selectedDisplayFactory = new OutputFactory();
        Output selectedDisplay = selectedDisplayFactory.getInstance("Overview");
        assertThat(selectedDisplay,instanceOf(OverviewOutput.class));
    }
    @Test
    public void ShouldReturnIningOneDisplay() {
        OutputFactory selectedDisplayFactory = new OutputFactory();
        Output selectedDisplay = selectedDisplayFactory.getInstance("1st Inning");
        assertThat(selectedDisplay,instanceOf(InningOneOutput.class));
    }
    @Test
    public void ShouldReturnIningTwoDisplay() {
        OutputFactory selectedDisplayFactory = new OutputFactory();
        Output selectedDisplay = selectedDisplayFactory.getInstance("2nd Inning");
        assertThat(selectedDisplay,instanceOf(InningTwoOutput.class));
    }
    @Test
    public void ShouldReturnNull() {
        OutputFactory selectedDisplayFactory = new OutputFactory();
        Output selectedDisplay = selectedDisplayFactory.getInstance("mistake");
        assertThat(selectedDisplay,is(isNull()));
    }

}