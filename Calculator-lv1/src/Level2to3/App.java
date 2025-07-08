package Level2to3;

import Level2to3.Models.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Level2to3.ControllerConfig.conData;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (conData.runExit) {
            // 모드 설정 문구 표시
            System.out.println("계산 모드를 선택해주세요. (번호 입력)");
            System.out.println("1, 구형 계산.");
            System.out.println("2. 일반 계산");
            System.out.println("3. 프로그램 종료");
            ResultData tempResult = new ResultData();
            Configinfo tempInfo = new Configinfo(2);


            Queue<String> resultCal = new LinkedList<>();
            if (CONSTANTS.tryparserint(sc.next(), conData.outSelected)) {


                switch (conData.outSelected[0]) {
                    case 1:
                        while (conData.circleCalExit) {


                            System.out.println("계산 모드를 선택해주세요.");
                            System.out.println("1, 둘레 계산.");
                            System.out.println("2. 너비 계산");
                            // 둘레 or 너비 값 선택으로 인터페이스 상속
                            tempInfo.setCalSign(sc.next().charAt(0));

                            System.out.println("반지름을 입력해주세요.");

                            if (CONSTANTS.tryparserdouble(sc.next(), conData.outVal)) {
                                System.out.println("입력한 반지름입니다 >>> " + conData.outVal[0]);
                                tempInfo.inputDatas[0] = conData.outVal[0];
                            } else {
                                System.out.println("숫자가 아닙니다.");
                                continue;
                            }

                            tempResult = tempInfo.calculate();

                            if (tempResult.resultData) {
                                System.out.printf("결과 >>> %.3f", tempResult.outputData);
                                System.out.println("연산자 사용 >>> " + tempResult.strException);
                                resultCal.add(tempResult.outputData + "");
                            }
                            //입력 기호가 전혀 다름
                            else {
                                System.out.println("결과 없음");
                                System.out.println("오류 내용 >>> " + tempResult.strException);
                            }

                            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제/pass 입력 시 넘기기)");
                            if (sc.next().equals("remove")) {
                                resultCal.remove();
                            }
                            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                            if (sc.next().equals("inquiry")) {
                                int sidx = 1;
                                for (String fesaved : resultCal) {
                                    System.out.println(sidx++ + " 번째 계산값 >>> " + fesaved);
                                }
                            }
                            System.out.println("더 계산하시겠습니까? (Y/exit)  (종료 시 exit 입력)");
                            if (sc.next().toLowerCase().equals("exit")) {
                                conData.circleCalExit = false;
                            }
                        }
                        break;
                    case 2:
                        while (conData.normalCalExit) {

                            //입력 문구 구분 필요 : 숫자 제외 모든 문자 오류 처리
                            //처리 내용 : 종료

                            // <editor-fold desc="데이터 입력 부">
                            for (int sLoop = 0; sLoop < 2; ) {
                                System.out.println(sLoop + 1 + " 번째 숫자를 입력하세요. (종료 시 exit 입력)");
                                String inputStr = sc.next();
                                // 문자 확인 구분 함수 : tryparserint
                                if (CONSTANTS.tryparserdouble(inputStr, conData.outVal)) {
                                    System.out.println("입력한 숫자입니다 >>> " + conData.outVal[0]);
                                    tempInfo.inputDatas[sLoop] = conData.outVal[0];
                                    sLoop++;
                                } else System.out.println("숫자가 아닙니다.");
                            }
                            // 기호 입력 시 연산 함수 인스턴스 진행
                            System.out.print("사칙연산 기호를 입력하세요: ex) + - % * / ");
                            tempInfo.setCalSign(sc.next().charAt(0));

                            // </editor-fold>

                            tempResult = tempInfo.calculate();

                            //입력 기호에 해당하는 연산 후 결과 반환


                            if (tempResult.resultData) {
                                System.out.printf("결과 >>> %.3f", tempResult.outputData);
                                System.out.println("연산자 사용 >>> " + tempResult.strException);
                                resultCal.add(tempResult.outputData + "");
                            }
                            //입력 기호가 전혀 다름
                            else {
                                System.out.println("결과 없음");
                                System.out.println("오류 내용 >>> " + tempResult.strException);
                            }

                            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제/pass 입력 시 넘기기)");
                            if (sc.next().equals("remove")) {
                                resultCal.remove();
                            }
                            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                            if (sc.next().equals("inquiry")) {
                                int sidx = 1;
                                for (String fesaved : resultCal) {
                                    System.out.println(sidx++ + " 번째 계산값 >>> " + fesaved);
                                }
                            }
                            System.out.println("더 계산하시겠습니까? (Y/exit)  (종료 시 exit 입력)");
                            if (sc.next().toLowerCase().equals("exit")) {
                                conData.normalCalExit = false;
                            }

                        }
                        break;

                    default:
                        conData.runExit = false;
                        System.out.println(CONSTANTS.nowDTTM() + " : 프로그램이 종료 됩니다.");
                        break;
                }
            }
            else{
                System.out.println("숫자가 아닙니다.");
            }
        }

    }



}
