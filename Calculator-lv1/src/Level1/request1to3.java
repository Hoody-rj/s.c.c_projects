package Level1;

import Level1.Models.request_lib;
import Level1.Models.request_result;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class request1to3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] outVal = new int[1];
        Queue<String> resultCal = new LinkedList<>();
        System.out.println("첫 번째 숫자를 입력하세요. (종료 시 exit 입력)");
        while (sc.hasNext() || sc.next().equals("exit")) {
            request_result tempResult = new request_result(2);
            //입력 문구 구분 필요 : 숫자 제외 모든 문자 오류 처리
            //처리 내용 : 종료
            if (tryparserint(sc.next(), outVal))
            {
                System.out.println("입력한 숫자입니다 >>> " + outVal[0]);
                tempResult.inputDatas[0] = outVal[0];
                System.out.println("두 번째 숫자를 입력하세요.");
                //입력 문구 구분 필요 : 숫자 제외 모든 문자 오류 처리
                //처리 내용 : 종료
                if (tryparserint(sc.next(), outVal))
                {
                    System.out.println("입력한 숫자입니다 >>> " + outVal[0]);
                    tempResult.inputDatas[1] = outVal[0];
                    System.out.print("사칙연산 기호를 입력하세요: ex) + - % * /");
                    tempResult.calSign = sc.next().charAt(0);

                    var calResult = resultInput(tempResult);
                    if (calResult.resultBool)
                        {
                            System.out.println("결과 >>> " + calResult.resultInt);
                            System.out.println("연산자 사용 >>> " + calResult.strException);

                        }
                    else {
                        System.out.println("결과 없음");
                        System.out.println("오류 내용 >>> " + calResult.strException);
                    }
                } else {
                    System.out.println("입력 오류 입니다 >>> ");
                    System.out.println("오류로 인한 종료");
                    break;
                }
            } else {
                System.out.println("입력 오류 입니다 >>> ");
                System.out.println("오류로 인한 종료");
                break;
            }

            System.out.println("첫 번째 숫자를 입력하세요. (종료 시 exit 입력)");
        }

    }

    public static boolean tryparserint(String brStr, int[] brParser){

        try {
            brParser[0] = Integer.parseInt(brStr);
            return true;
        }
        catch (Exception e){

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
                resultInt = brResult.inputDatas[0] + brResult.inputDatas[1];
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
