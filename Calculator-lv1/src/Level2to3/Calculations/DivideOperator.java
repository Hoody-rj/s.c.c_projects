package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class DivideOperator implements ICalculators {

    private double[] inputDatas;

    public DivideOperator(double[] inputDatas) {
        this.inputDatas = inputDatas;
    }

    public ResultData operate() {
        double result = inputDatas[0];
        ResultData resultData = new ResultData();
        try {
            for (int i = 1; i < inputDatas.length; i++) {
                result /= inputDatas[i];
            }
            resultData.outputData = result;
            resultData.strException = "나누기";
            resultData.resultData = true;
        }catch (ArithmeticException e){
            resultData.strException = e.getMessage();
            resultData.resultData = false;
        }

        return resultData;

    }
}
