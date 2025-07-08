package Level1.Models;

public class request_result {
    public double[] inputDatas;
    public char calSign;
    private double outputDatas;


    public double getOutputDatas() {
        return outputDatas;
    }

    public request_result(int brLen)
    {
        inputDatas = new double[brLen];
    }



}
