package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class MultiplyOperator implements ICalculators {

    private double[] inputDatas;

    public MultiplyOperator(double[] inputDatas) {
        this.inputDatas = inputDatas;
    }

    public ResultData operate() {
        double result = inputDatas[0];
        ResultData resultData = new ResultData();
        try {
            for (int i = 1; i < inputDatas.length; i++) {
                result *= inputDatas[i];
            }
            resultData.outputData = result;
            resultData.strException = "곱하기";
            resultData.resultData = true;
        }catch (Exception e){
            resultData.resultData = false;
            resultData.strException = e.getMessage();
        }

        return resultData;
    }
}
