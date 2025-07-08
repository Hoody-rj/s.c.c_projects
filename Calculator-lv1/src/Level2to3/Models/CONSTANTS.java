package Level2to3.Models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CONSTANTS {
    private CONSTANTS(){};

    public static String nowDTTM(){
        LocalDateTime now = LocalDateTime.now();
        String tempNow = now.format
                (DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        return tempNow;
    }
    public static String nowDate(){
        LocalDateTime now = LocalDateTime.now();
        String sDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        return sDate;
    }
    public static String LogDate(){
        LocalDateTime now = LocalDateTime.now();
        String sDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return sDate;
    }
    public static String nowTime(){
        LocalDateTime now = LocalDateTime.now();
        String sTime = now.format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"));
        return sTime;
    }

    public static void LogonTxt(String brMsg){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LogDate() +".txt", true))) {
            // true: 기존 파일에 이어서 쓰기, false(생략): 새로 쓰기
            bw.write("["+LogDate()+"] =>" + brMsg);
            bw.newLine(); // 줄바꿈
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
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
    public static boolean tryparserdouble(String brStr, double[] brParser) {

        try {
            brParser[0] = Double.parseDouble(brStr);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
