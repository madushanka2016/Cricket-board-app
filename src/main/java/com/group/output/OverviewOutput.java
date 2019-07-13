package com.group.output;

import com.group.operations.Operation;
import com.group.operations.OperationFactory;
import com.group.repository.MatchDetails;
import com.group.repository.Repository;

import javax.swing.*;
import java.awt.*;

public class OverviewOutput implements Output {
    public JPanel show(String userInput,Repository repository){

        MatchDetails matchDetails =  repository.getMatch(userInput);
        OperationFactory operationFactory = new OperationFactory();

        String countryOneCode = matchDetails.getCountryOne();
        String countryTwoCode = matchDetails.getCountryTwo();
        String countryOneName = repository.getCountry(countryOneCode);
        String countryTwoName = repository.getCountry(countryTwoCode);
        String countryWinCode = matchDetails.getWinningCountry();
        String countryWinName = repository.getCountry(countryWinCode);

        Operation marksOperation = operationFactory.getInstance("marks");
        Operation wicketOperation = operationFactory.getInstance("wickets");
        Operation oversOperation = operationFactory.getInstance("overs");
        Integer countryOneMarks = marksOperation.performe(userInput,countryOneCode);
        Integer countryTwoMarks = marksOperation.performe(userInput,countryTwoCode);
        Integer countryOneWickets = wicketOperation.performe(userInput,countryOneCode);
        Integer countryTwoWickets = wicketOperation.performe(userInput,countryTwoCode);
        Integer countryOneOvers = oversOperation.performe(userInput,countryOneCode);
        Integer countryTwoOvers = oversOperation.performe(userInput,countryTwoCode);

        JPanel main = new JPanel();
        main.setPreferredSize(new Dimension(1000,400));

        JPanel p1 = new JPanel();
        JLabel labelDate = new JLabel("date  :  "+matchDetails.getDate());
        p1.add(labelDate);

        JPanel p2 = new JPanel();
        JLabel labelCountry = new JLabel(countryOneName+"     VS     "+countryTwoName);
        p2.add(labelCountry);

        JPanel p3 = new JPanel();
        JLabel labelFirstTeam = new JLabel(countryOneName+"   "+countryOneMarks+"  / "+countryOneWickets+"  ( "+countryOneOvers+"  ) ");
        p3.add(labelFirstTeam);

        JPanel p4 = new JPanel();
        JLabel labelSecondTeam = new JLabel(countryTwoName+"   "+countryTwoMarks+"  / "+countryTwoWickets+"  ( "+countryTwoOvers+"  ) ");
        p4.add(labelSecondTeam);

        JPanel p5 = new JPanel();
        JLabel labelWonStatus = new JLabel(" Won by     "+countryWinName);
        p5.add(labelWonStatus);

        JPanel p6 = new JPanel();
        JLabel labelManOfTheMatch = new JLabel("Man of the match  :     "+repository.getPlayer(matchDetails.getManOfTheMatch()));
        p6.add(labelManOfTheMatch);

        main.setLayout(new GridLayout(10,1));
        main.add(p1 );
        main.add(p2 );
        main.add(p3 );
        main.add(p4 );
        main.add(p5 );
        main.add(p6 );
        return main;
    }
}
