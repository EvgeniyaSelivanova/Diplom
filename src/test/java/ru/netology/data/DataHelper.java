package ru.netology.data;

import lombok.Value;
import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardData {
        private String numberCard;
        private String month;
        private String year;
        private String name;
        private String CVV;
    }

    public static CardData getValidCardData() {
        return new CardData("4444444444444441",
                "12", "22", "Ivanov", "111");
    }

    public static CardData getValidCardDataDeclined() {
        return new CardData("4444444444444442",
                "12", "22", "Ivanov", "111");
    }

    public static CardData getValidCardDataNotFromList() {
        return new CardData("4444444444444443",
                "12", "22", "Ivanov", "111");
    }

    public static CardData getInvalidCardDataTextAndNumber() {
        return new CardData("аааааааааааааааа",
                "aa", "aa", "1111111", "aaa");
    }

    public static CardData getInvalidCardDataEmpty() {
        return new CardData("",
                "", "", "", "");
    }

    public static CardData getInvalidCardDataPartialData() {
        return new CardData("4444 4444 4444 4441",
                "12", "", "", "");
    }

    public static CardData getValidCardDataBigName() {
        return new CardData("4444444444444441",
                "12", "22", "IVANOV", "111");
    }

    public static CardData getValidCardDataSmallName() {
        return new CardData("4444444444444441",
                "12", "22", "ivanov", "111");
    }

    public static CardData getValidCardDataHyphenName() {
        return new CardData("4444444444444441",
                "12", "22", "Ivanov-ivanov", "111");
    }

    public static CardData getInValidCardDataSpecialSymbols() {
        return new CardData("$$$$$$$$$$$$$$$$",
                "$$", "$$", "$$$$$$$$$", "$$$");
    }

    public static CardData getInValidCardDataMaxLength() {
        return new CardData("11111111111111111111",
                "111", "2222",
                "IvanovIvanovIvanovIvanovIvanovIvanovIvanovIvanovIvanovIvanovIvano", "2222");
    }

    public static CardData getInValidCardDataPreviousMonth() {
        return new CardData("4444444444444441",
                "01", "21","Ivanov", "111");
    }

    public static CardData getInValidCardDataIncorrectYear() {
        return new CardData("4444444444444441",
                "12", "20","Ivanov", "111");
    }

    public static CardData getInValidCardDataIncorrectMonth() {
        return new CardData("4444444444444441",
                "22", "21","Ivanov", "111");
    }

    public static int getOrderEntity() {
        int countOrder = 0;
        try {
            val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
            val createdState = conn.createStatement();
            val rs = createdState.executeQuery("SELECT count(*) FROM order_entity");

            while (rs.next()) {
                countOrder = rs.getInt(1);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return countOrder;
    }


    public static String getStatusAddedPaymentEntity() {
        val selectStatus = "SELECT status FROM payment_entity";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val createdState = conn.createStatement();
        ) {
            try (val rs = createdState.executeQuery(selectStatus)) {
                if (rs.next()) {
                    return rs.getString(1);
                }
                return null;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getStatusAddedCreditRequestEntity() {
        val selectStatus = "SELECT status FROM credit_request_entity";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val createdState = conn.createStatement();
        ) {
            try (val rs = createdState.executeQuery(selectStatus)) {
                if (rs.next()) {
                    return rs.getString(1);
                }
                return null;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void clearAllInAuthCodes() {
        val order = "DELETE FROM order_entity";
        val credit = "DELETE FROM credit_request_entity";
        val payment = "DELETE FROM payment_entity";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val stateOrder = conn.prepareStatement(order);
                val stateCredit = conn.prepareStatement(credit);
                val statePayment = conn.prepareStatement(payment);
        ) {
            stateOrder.executeUpdate(order);
            stateCredit.executeUpdate(credit);
            statePayment.executeUpdate(payment);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
