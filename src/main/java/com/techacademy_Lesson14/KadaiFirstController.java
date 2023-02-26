package com.techacademy_Lesson14;

import java.util.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class KadaiFirstController {

        // 仕様1：指定日の曜日を算定する
        @GetMapping("/dayofweek/{val1}")
        public String getDayOfTheWeek(@PathVariable int val1) {

            // 入力された指定日(値)をString型に変換の上、「年・月・日」に各々分解、再度int型に変換したうえで代入する
            String input = String.valueOf(val1);
            int year = Integer.parseInt(input.substring(0, 4));
            int month = Integer.parseInt(input.substring(4, 6)) -1;
            int date = Integer.parseInt(input.substring(6, 8));

            // java.util.Calendarクラスを利用し、日付から曜日を取得する
            Calendar cal = Calendar.getInstance();              // インスタンスの生成
            cal.set(year, month, date);                         // 日付の設定
            int DayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);   //　曜日の取得と代入
            String rs = null;                                   //　画面に表示する「曜日(値)」を代入する変数の宣言

            if(DayOfTheWeek == 1) {
                rs = "Sunday";              // DayOfTheWeekの値が「1」の場合は"Sunday"と表示させる;
            }else if(DayOfTheWeek == 2) {
                rs = "Monday";              // DayOfTheWeekの値が「2」の場合は"Monday"と表示させる;
            }else if(DayOfTheWeek == 3) {
                rs = "Tuesday";             // DayOfTheWeekの値が「3」の場合は"Tuesday"と表示させる;
            }else if(DayOfTheWeek == 4) {
                rs = "Wednesday";           // DayOfTheWeekの値が「4」の場合は"Wednesday"と表示させる;
            }else if(DayOfTheWeek == 5) {
                rs = "Thursday";            // DayOfTheWeekの値が「5」の場合は"Thursday"と表示させる;
            }else if(DayOfTheWeek == 6) {
                rs = "Friday";              // DayOfTheWeekの値が「6」の場合は"Friday"と表示させる;
            }else if(DayOfTheWeek == 0) {
                rs = "Saturday";            // DayOfTheWeekの値が「0」の場合は"Saturday"と表示させる;
            }
            return rs;
        }

        // 仕様2：四則演算を行なう
        @GetMapping("/plus/{val1}/{val2}")
        public String calcPlus(@PathVariable int val1, @PathVariable int val2){
            int res = 0;
            res = val1 + val2;
            return "計算結果：" + res;
        }

        @GetMapping("/minus/{val1}/{val2}")
        public String calcMinus(@PathVariable int val1, @PathVariable int val2){
            int res = 0;
            res = val1 - val2;
            return "計算結果：" + res;
        }

        @GetMapping("/times/{val1}/{val2}")
        public String calcTimes(@PathVariable int val1, @PathVariable int val2){
            int res = 0;
            res = val1 * val2;
            return "計算結果：" + res;
        }

        @GetMapping("/divide/{val1}/{val2}")
        public String calcDivide(@PathVariable int val1, @PathVariable int val2){
            int res = 0;
            res = val1 / val2;
            return "計算結果：" + res;
        }
    }
