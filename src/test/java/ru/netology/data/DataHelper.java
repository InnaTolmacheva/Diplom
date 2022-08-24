package ru.netology.data;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataHelper {
    public DataHelper() {
    }

    ;

    @Value
    public static class CardInfo {
        private String number;
        private String status;
    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo("4444 4444 4444 4441", "APPROVED");
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("4444 4444 4444 4442", "DECLINED");
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var usersSQL = "SELECT status FROM payment_entity;";
        var runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
        ) {
            String paymentStatus = runner.query(conn, usersSQL, new ScalarHandler<>());
            return paymentStatus;
        }
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var creditStatus = "SELECT status FROM credit_request_entity";
        var runner = new QueryRunner();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")
        ) {
            String status = runner.query(connection, creditStatus, new ScalarHandler<>());
            return status;
        }
    }


}