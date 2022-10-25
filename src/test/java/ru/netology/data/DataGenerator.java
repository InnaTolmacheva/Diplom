package ru.netology.data;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class DataGenerator {
    private DataGenerator() {

    }

    public static String getMonth() {
        Random random = new Random();
        final String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int pos = random.nextInt(months.length);
        String newMonth = months[pos];
        return newMonth;
    }

    public static String getInvalidMonth() {
        Random random = new Random();
        final String[] months = {"00", "13"};
        int pos = random.nextInt(months.length);
        String newMonth = months[pos];
        return newMonth;
    }

    public static String getInvalidFormatMonth() {
        Random random = new Random();
        final String[] months = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int pos = random.nextInt(months.length);
        String newMonth = months[pos];
        return newMonth;
    }


    public static String getYear() {
        LocalDate newDate = LocalDate.now().plusYears(3); //сдвиг на 3 года вреред
        String newYear2 = String.valueOf(Integer.parseInt(String.valueOf(newDate.getYear()).substring(2, 4)));//
        return newYear2;
    }

    // вводим год предшествующий текущему
    public static String getInvalidYear() {
        LocalDate newDate = LocalDate.now().minusMonths(14); //сдвиг даты на 14 месяцев назад
        String newYear2 = String.valueOf(Integer.parseInt(String.valueOf(newDate.getYear()).substring(2, 4)));//
        return newYear2;
    }

    public static String getYearAboveFive() {
        LocalDate newDate = LocalDate.now().plusYears(6); //сдвиг даты на 6 лет
        String newYear2 = String.valueOf(Integer.parseInt(String.valueOf(newDate.getYear()).substring(2, 4)));//
        return newYear2;
    }

    public static String getName() {
        Faker faker = new Faker(new Locale("en"));
        String name = String.valueOf(faker.name().name());

        return name;
    }
    public static String getInvalidName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = String.valueOf(faker.name().name());

        return name;
    }

    public static String getCVV() {
        Faker faker = new Faker();
        String CVV = String.valueOf(faker.number().randomNumber(3, true));

        return CVV;
    }

    public static String getInvalidCVV() {
        Faker faker = new Faker();
        String CVV = String.valueOf(faker.number().randomNumber(2, true));

        return CVV;
    }

    static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static int getRequestStatusCode(Card card, String path) {
        int statusCode =
                given()
                        .spec(requestSpec)
                        .body(card)
                        .when()
                        .post(path)
                        .getStatusCode();
        System.out.println(statusCode);
        return statusCode;
    }

    public static int getCreditStatusCode(Card card, String path) {
        int statusCode =
                given()
                        .spec(requestSpec)
                        .body(card)
                        .when()
                        .post(path)
                        .getStatusCode();
        System.out.println(statusCode);
        return statusCode;
    }

    public static int getInvalidCode(Card card, String path) {
        int statusCode =
                given()
                        .spec(requestSpec)
                        .body(card)
                        .when()
                        .post(path)
                        .getStatusCode();
        System.out.println(statusCode);
        return statusCode;
    }

    public static Card getValidApprovedCard() {
        return new Card("4444 4444 4444 4441", "12", "24", "Client bank", "987");
    }

    public static Card getValidDeclinedCard() {
        return new Card("4444 4444 4444 4442", "12", "24", "Client bank", "987");
    }

    public static Card getInvalidCard() {
        return new Card("4444 4444 4444 4443", "12", "24", "Client bank", "987");
    }
}
