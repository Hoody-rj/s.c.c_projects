package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class ModeOperator implements ICalculators {

    private double[] inputDatas;

    public ModeOperator(double[] inputDatas) {
        this.inputDatas = inputDatas;
    }

    public ResultData operate() {
        ResultData resultData = new ResultData();
        double result = inputDatas[0];
        try {
            for (int i = 1; i < inputDatas.length; i++) {
                result %= inputDatas[i];
            }
            resultData.outputData = result;
            resultData.strException = "나머지";
            resultData.resultData = true;
        }catch (ArithmeticException e){
            resultData.strException = e.getMessage();
            resultData.resultData = false;
        }

        return resultData;
    }
}
