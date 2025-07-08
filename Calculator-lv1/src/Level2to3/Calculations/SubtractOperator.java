package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class SubtractOperator implements ICalculators {

    private double[] inputDatas;
    private double outputData;

    public double getOutputData() {
        return outputData;
    }

    public SubtractOperator(double[] inputDatas) {
        this.inputDatas = inputDatas;
    }

    public ResultData operate() {

        double resultData = inputDatas[0];
        ResultData resultReturn = new ResultData();

        try {
            for (int i = 1; i < inputDatas.length; i++) {
                resultData -= inputDatas[i];
            }

            resultReturn.outputData = resultData;
            resultReturn.strException = "빼기";
            resultReturn.resultData = true;
        } catch (Exception e) {
            resultReturn.strException = e.getMessage();
            resultReturn.resultData = false;
        }

        return resultReturn;

    }
}
