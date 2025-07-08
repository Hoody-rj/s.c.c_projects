package Level2to3.Models;

import Level2to3.Calculations.*;

public class Configinfo {

    public double[] inputDatas;
    public char calSign;
    private ICalculators calculators;


    public Configinfo(int brLen)
    {
        inputDatas = new double[brLen];
    }

    public char getCalSign() {
        return calSign;
    }

    public void setCalSign(char calSign) {
        this.calSign = calSign;

        switch (calSign) {
            case '+' -> calculators = new AddOperator(inputDatas);
            case '-' ->  calculators = new SubtractOperator(inputDatas);
            case '*' ->  calculators = new MultiplyOperator(inputDatas);
            case '/' ->  calculators = new DivideOperator(inputDatas);
            case '%' ->  calculators = new ModeOperator(inputDatas);
            case '1' ->  calculators = new CircleCalculator(inputDatas);
            case '2' ->  calculators = new ArithmeticCalculator(inputDatas);
            default ->  calculators = new AddOperator(inputDatas);
        };
    }

    public ResultData calculate()
    {
        return calculators.operate();
    }


}
