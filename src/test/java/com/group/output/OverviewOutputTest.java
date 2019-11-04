package com.group.output;

import com.group.repository.MatchDetails;
import com.group.repository.Repository;
import com.group.repository.SqlMatchDetailRepository;
import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OverviewOutputTest {
    @Test
    public void test1 (){
        Repository repository = mock(SqlMatchDetailRepository.class);
        MatchDetails matchDetails = mock(MatchDetails.class);
        when(repository.getMatch("M000001")).thenReturn(matchDetails);
    }

}