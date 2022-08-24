package ru.netology.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
public class DataGenerator {
    private DataGenerator(){

    }

    public static  String getMonth() {
        LocalDate newDate = LocalDate.now().plusMonths(14); //сдвиг даты а 14 месяцев
     //   String monthName = String.valueOf(newDate.getMonth());
        String newMonth = String.valueOf(newDate.getMonthValue());
        /*Random random = new Random();
        final String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int pos = random.nextInt(months.length);
        String month = months[pos];*/
        return newMonth;
    }

    public static String getYear() {
        LocalDate newDate = LocalDate.now().plusMonths(14); //сдвиг даты а 14 месяцев
        String newYear2 = String.valueOf(Integer.parseInt(String.valueOf(newDate.getYear()).substring(2,4)));//
        return newYear2;
    }
    public static  String getName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = String.valueOf(faker.name().name());

        return name;
}
    public static  String getCVV() {
        Faker faker = new Faker();
        String CVV = String.valueOf(faker.number().randomNumber(3,true));

        return CVV;
    }
}
