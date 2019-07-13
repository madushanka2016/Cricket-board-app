package com.group.repository;

import java.util.List;

public interface Repository {
    List<BattingDetail> getBatting(String matchId, String countryId);
    List<BowlingDetails> getBowling(String matchId, String countryId);
    MatchDetails getMatch(String matchId);
    String getPlayer(String playerId);
    String getCountry(String countryId);

}
