package com.tjcloud.platform.utils;

import com.tjcloud.platform.model.dictionary.ValueDictionary;
import com.tjcloud.platform.service.ValuesService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomValues {

    @Autowired
    private ValuesService valuesService;

    private static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] charAndNumbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'z', 'b', 'd', 'e', 'r', 't', 'o', 'p', 's', 'd'};

    private static char[][] chars = {{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, {'3', '1', '4', '2', '6', '0', '5', '9', '8', '7'},
            {'9', '3', '1', '7', '5', '2', '0', '4', '8', '6'}, {'0', '2', '1', '3', '4', '8', '5', '6', '8', '7'},
            {'3', '6', '8', '9', '4', '2', '1', '5', '7', '0'}, {'3', '6', '7', '9', '2', '8', '1', '0', '3', '4'},
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, {'3', '7', '8', '9', '4', '0', '1', '5', '7', '2'}};

    public String genRandomValidateCode(DateTime dateTime) {

        String today = dateTime.toString("yyyy-MM");
        ValueDictionary validateData = valuesService.findValueByKey(today);

        if (validateData == null) {
            validateData = new ValueDictionary();
            validateData.setKey(today);
            validateData.setValue("0");

        }

        Integer queue = Integer.valueOf(validateData.getValue());
        String code = "";
        for (Integer i = 10000000, j = 0; i >= 1 || j < 7; i /= 10, j++) {

            char w = chars[j][queue / i];
            code = code.concat(String.valueOf(w));
            queue %= 10;

        }

        validateData.setValue((++queue).toString());
        valuesService.save(validateData);

        return code;

    }

    /**
     * 生成随即密码
     *
     * @param pwd_len 生成的密码的总长度
     * @return 密码的字符串
     */
    public static String genRandomNum(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 300;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            // 生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < numbers.length) {
                pwd.append(numbers[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    public static String genRandomPassword(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 300;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            // 生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < charAndNumbers.length) {
                pwd.append(charAndNumbers[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    public static String randomHeaderImg() {
        Random random = new Random();
        int i = random.nextInt(23);

        char c = (char) ('a' + i);
        return String.valueOf(c).concat(".png");

    }

    public static void main(String[] args) {
        Integer queue = Integer.valueOf(1);
        String code = "";
        for (Integer i = 10000000, j = 0; i >= 1 || j < 7; i /= 10, j++) {

            char w = chars[j][queue / i];
            code = code.concat(String.valueOf(w));
            queue %= 10;

        }

        System.out.println(code);

    }

}
