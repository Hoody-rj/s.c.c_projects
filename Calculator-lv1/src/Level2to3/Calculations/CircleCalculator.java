package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class CircleCalculator implements ICalculators {

    public static final double Pi = 3.14159;
    private double[] inputData;

    public CircleCalculator(double[] inputData) {
        this.inputData = inputData;
    }

    public ResultData operate(){
        ResultData resultData = new ResultData();
        double result = 0;
        try {
            resultData.outputData =inputData[0]*2*Pi;
            resultData.strException = "지름 계산";
            resultData.resultData = true;
        } catch (Exception e) {
            resultData.strException = e.getMessage();
            resultData.resultData = false;
        }
        return resultData;
    }
}
