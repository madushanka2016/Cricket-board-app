package com.group.output;



public class OutputFactory {

    public Output getInstance(String userSelection){
        Output output = null;
        if("Overview".equals(userSelection)){
            output = new OverviewOutput();
        }else if("1st Inning".equals(userSelection)){
            output = new InningOneOutput();
        }else if("2nd Inning".equals(userSelection)){
            output = new InningTwoOutput();
        }
        return output;
    }
}
