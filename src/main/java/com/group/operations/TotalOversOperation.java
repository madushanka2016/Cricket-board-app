package com.group.operations;

import com.group.repository.BowlingDetails;
import com.group.repository.Repository;
import com.group.repository.SqlMatchDetailRepository;

import java.util.List;

public class TotalOversOperation implements Operation{
    public int performe(String matchId, String countryId){
        int overs = 0;
        Repository repository=new SqlMatchDetailRepository();
        List<BowlingDetails> ballingDetails = repository.getBowling(matchId,countryId);
        for (int i = 0; i <ballingDetails.size() ; i++) {
            overs+=ballingDetails.get(i).getOvers();
        }
        return overs;
    }
}
