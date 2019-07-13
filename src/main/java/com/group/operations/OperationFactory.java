package com.group.operations;

public class OperationFactory {
    public Operation getInstance(String operator){
        Operation operation1 = null;
        if("marks".equals(operator)){
            operation1 = new TotalMarksOperation();
        }else if("overs".equals(operator)){
            operation1 = new TotalOversOperation();
        }else if("wickets".equals(operator)){
            operation1 = new TotalWicketsOperation();
        }
        return operation1;
    }
}
