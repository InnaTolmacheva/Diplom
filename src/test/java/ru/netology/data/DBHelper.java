package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    static String url = System.getProperty("db.url");
    static String user = System.getProperty("db.user");
    static String pass = System.getProperty("db.password");

    @SneakyThrows
    public static String getPaymentStatus() {
        var usersSQL = "SELECT status FROM payment_entity;";
        var runner = new QueryRunner();
        try (
                Connection connection = DriverManager.getConnection(
                        url, user, pass
                );
        ) {
            String paymentStatus = runner.query(connection, usersSQL, new ScalarHandler<>());
            return paymentStatus;
        }
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var creditStatus = "SELECT status FROM credit_request_entity";
        var runner = new QueryRunner();

        try (
                Connection connection = DriverManager.getConnection(
                        url, user, pass
                );
        ) {
            String status = runner.query(connection, creditStatus, new ScalarHandler<>());
            return status;
        }
    }

    @SneakyThrows
    public static void cleanDataBases() {
        var runner = new QueryRunner();
        String cleanOrderEntity = "DELETE FROM order_entity;";
        String cleanPaymentEntity = "DELETE FROM payment_entity;";
        String cleanCreditRequestEntity = "DELETE FROM credit_request_entity;";


        try (
                Connection connection = DriverManager.getConnection(
                        url, user, pass
                );
        ) {

            runner.update(connection, cleanOrderEntity);
            runner.update(connection, cleanPaymentEntity);
            runner.update(connection, cleanCreditRequestEntity);
        }
    }
}
