package com.group.repository;

import com.sun.media.jfxmedia.logging.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlMatchDetailRepository implements Repository {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public List<BattingDetail> getBatting(String matchId, String countryId) {
        List<BattingDetail> battingDetailsArray = new ArrayList();
        String query = "SELECT playerId ,runs , balls , fours , sixs FROM batting WHERE matchId=? AND playerId in (SELECT playerID from players WHERE countryId=?);";
        try {
            setConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, matchId);
            preparedStatement.setString(2, countryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BattingDetail battingDetail = new BattingDetail();
                battingDetail.setPlayerId(resultSet.getString(1));
                battingDetail.setRuns(resultSet.getInt(2));
                battingDetail.setBalls(resultSet.getInt(3));
                battingDetail.setFours(resultSet.getInt(4));
                battingDetail.setSixs(resultSet.getInt(5));
                battingDetailsArray.add(battingDetail);
            }
            connection.close();
        }catch (NullPointerException e){
            Logger.logMsg(1,"error nullpoint error");
        }
        catch (Exception e) {
            Logger.logMsg(1,"error retrieving data");
        }finally {
            closeConnections();
        }
        return battingDetailsArray;
    }
    @Override
    public List<BowlingDetails> getBowling(String matchId, String countryId) {
        List<BowlingDetails> bowlingDetailsArray = new ArrayList();
        String query="SELECT playerId ,overs , marks , wicket  FROM bowling WHERE matchId=? AND playerId in (SELECT playerID from players WHERE countryId=?);";
        try {
            setConnection();
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,matchId);
            preparedStatement.setString(2,countryId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BowlingDetails bowlingDetails = new BowlingDetails();
                bowlingDetails.setPlayerId(resultSet.getString(1));
                bowlingDetails.setOvers(resultSet.getFloat(2));
                bowlingDetails.setMarks(resultSet.getInt(3));
                bowlingDetails.setWicket(resultSet.getInt(4));
                bowlingDetailsArray.add(bowlingDetails);
            }
            closeConnections();
        }catch (Exception e) {
            Logger.logMsg(1,"error getting balling data");
        }finally {
            closeConnections();
        }

        return bowlingDetailsArray;
    }
    @Override
    public MatchDetails getMatch(String matchId){
        MatchDetails matchDetails = new MatchDetails();
        String query="SELECT date , country1 , country2 , winners , man_of_the_match FROM matchdetails WHERE matchId=?;";
        try {
            setConnection();
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,matchId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                matchDetails.setDate(resultSet.getString(1));
                matchDetails.setCountryOne(resultSet.getString(2));
                matchDetails.setCountryTwo(resultSet.getString(3));
                matchDetails.setWinningCountry(resultSet.getString(4));
                matchDetails.setManOfTheMatch(resultSet.getString(5));
            }
        } catch (Exception e) {
            Logger.logMsg(1,"Match data retrieving error");
        }
        finally {
            closeConnections();
        }
        return matchDetails;
    }
    @Override
    public String getPlayer(String playerId){
        String playerName = null;
        String query="SELECT playerName FROM players WHERE playerId=?;";
        try {
            setConnection();
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,playerId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                playerName = resultSet.getString(1);
            }
            connection.close();
        } catch (Exception e) {
            Logger.logMsg(1,"Database not connect player");
        }
        finally {
            closeConnections();
        }
        return playerName;
    }
    @Override
    public String getCountry(String countryId){
        String teamName = null;
        String query="SELECT countryName FROM country WHERE countryId=?;";
        try {
            setConnection();
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,countryId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                teamName = resultSet.getString(1);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            Logger.logMsg(1,"Error getting country");
        }
        finally {
            closeConnections();
        }
        return teamName;
    }
    public void closeConnections() {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (Exception e) {
            Logger.logMsg(1, "error closing result set");
        }
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            Logger.logMsg(1, "error closing prepared statement");
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            Logger.logMsg(1, "error closing connection");
        }

    }
    public void setConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "");
        } catch (ClassNotFoundException e) {
            Logger.logMsg(1,"error class not found");
        } catch (SQLException e) {
            Logger.logMsg(1,"error connection");
        }


    }
}