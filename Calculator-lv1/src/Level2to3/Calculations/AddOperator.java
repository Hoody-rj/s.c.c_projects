package Level2to3.Calculations;

import Level2to3.Models.ResultData;

public class AddOperator implements ICalculators {

    private double[] inputData;

    public AddOperator(double[] result) {
        this.inputData = result;
    }

    public ResultData operate() {
        double result =0;
        ResultData resultData = new ResultData();
        try {
            for (double feelement : inputData) {
                result += feelement;
            }
            resultData.outputData = result;
            resultData.strException = "더하기";
            resultData.resultData = true;

        }catch (Exception e){
            resultData.strException = e.getMessage();
            resultData.resultData = false;
        }


        return resultData;


    }
}
