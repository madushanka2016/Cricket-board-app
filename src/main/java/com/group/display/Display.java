package com.group.display;

import com.group.CricketBoardApp;

import javax.swing.*;
import java.awt.*;

public class Display{
    private JPanel panelOoutput;

    public void show() {
        JFrame frame = new JFrame("Score board");
        JPanel panelMain = new JPanel();
        JPanel panel2 = new JPanel();


        JTextField textUserInput = new JTextField();
        JButton buttonSearch = new JButton("Search");
        textUserInput.setPreferredSize(new Dimension(100,30));
        buttonSearch.setPreferredSize(new Dimension(100,30));
        String[] country={"Overview","1st Inning","2nd Inning"};
        JComboBox comboBoxViewType = new JComboBox(country);
        panel2.add(textUserInput);
        panel2.add(comboBoxViewType);
        panel2.add(buttonSearch);

        buttonSearch.addActionListener(name->{

                String userInput = textUserInput.getText();
                String userSelection = comboBoxViewType.getSelectedItem().toString();

                CricketBoardApp cricketBoardApp = new CricketBoardApp();
                panelOoutput = cricketBoardApp.start(userInput,userSelection);

                show();
                textUserInput.setText("ds");
                frame.setVisible(false);
                panelOoutput.setVisible(true);
                textUserInput.setText(userInput);
        });
        frame.setPreferredSize(new Dimension(1000,400));
        panelMain.add(panel2);
        panelMain.add(panelOoutput);
        frame.add(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
