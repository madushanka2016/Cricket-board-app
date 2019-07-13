package com.group.operations;

import com.group.repository.BattingDetail;
import com.group.repository.Repository;
import com.group.repository.SqlMatchDetailRepository;

import java.util.List;

public class TotalMarksOperation implements Operation{
    public int performe(String matchId, String countryId){
        int total=0;
        Repository repository=new SqlMatchDetailRepository();
        List<BattingDetail> battingDetails = repository.getBatting(matchId,countryId);
        for (int i = 0; i <battingDetails.size() ; i++) {
            total+=battingDetails.get(i).getRuns();
        }
        return total;
    }
}
