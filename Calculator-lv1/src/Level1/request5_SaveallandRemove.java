package Level1;

import Level1.Models.request_lib;
import Level1.Models.request_result;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class request5_SaveallandRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] outVal = new int[1];
        Queue<String> resultCal = new LinkedList<>();
        while (true) {

            request_result tempResult = new request_result(2);
            //입력 문구 구분 필요 : 숫자 제외 모든 문자 오류 처리
            //처리 내용 : 종료

            for (int sLoop = 0; sLoop < 2;)
            {
                System.out.println(sLoop+1 + " 번째 숫자를 입력하세요. (종료 시 exit 입력)");
                String inputStr = sc.next();
                if (tryparserint(inputStr, outVal)) {
                    System.out.println("입력한 숫자입니다 >>> " + outVal[0]);
                    tempResult.inputDatas[sLoop] = outVal[0];
                    sLoop++;
                }
                else System.out.println("숫자가 아닙니다.");
            }

            System.out.print("사칙연산 기호를 입력하세요: ex) + - % * / ");
            tempResult.calSign = sc.next().charAt(0);

            var calResult = resultInput(tempResult);
            //입력 기호에 해당하는 연산 후 결과 반환
            if (calResult.resultBool) {
                System.out.println("결과 >>> " + calResult.resultInt);
                System.out.println("연산자 사용 >>> " + calResult.strException);
                resultCal.add(calResult.resultInt + "");
            }
            //입력 기호가 전혀 다름
            else {
                System.out.println("결과 없음");
                System.out.println("오류 내용 >>> " + calResult.strException);
            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if (sc.next().equals("remove")) {
                resultCal.remove();
            }
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if (sc.next().equals("inquiry")) {
                int sidx =1;
                for (String fesaved : resultCal) {
                    System.out.println(sidx++ +" 번째 계산값 >>> " + fesaved);
                }
            }
            System.out.println("더 계산하시겠습니까? (Y/N)  (종료 시 exit 입력)");
            if (sc.next().equals("n") && sc.next().equals("N")) {
                System.out.println("프로그램 종료");
                break;
            }
        }


    }

    public static boolean tryparserint(String brStr, int[] brParser) {

        try {
            brParser[0] = Integer.parseInt(brStr);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public static request_lib resultInput(request_result brResult) {
        return switch (brResult.calSign) {
            case '+' -> new request_lib() {{
                resultInt = brResult.inputDatas[0] + brResult.inputDatas[1];
                strException = "더하기";
            }};
            case '-' -> new request_lib() {{
                resultInt = brResult.inputDatas[0] + brResult.inputDatas[1];
                strException = "빼기";
            }};
            case '*' -> new request_lib() {{
                resultInt = brResult.inputDatas[0] + brResult.inputDatas[1];
                strException = "곱하기";
            }};
            case '/' -> new request_lib() {{
                resultInt = brResult.inputDatas[0] / brResult.inputDatas[1];
                strException = "나누기";
            }};
            case '%' -> new request_lib() {{
                resultInt = brResult.inputDatas[0] % brResult.inputDatas[1];
                strException = "나머지";
            }};
            default -> new request_lib() {{
                resultBool = false;
                strException = "해당 기호가 존재하지 않음 - " + brResult.calSign;
            }};
        };
    }

}
