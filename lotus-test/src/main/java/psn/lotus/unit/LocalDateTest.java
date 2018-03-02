package psn.lotus.unit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @project lotus
 * @time 2018/3/1 16:52
 */
public class LocalDateTest {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate begin = LocalDate.parse("2017-08-02", formatter);
        LocalDate end = LocalDate.parse("2017-08-02", formatter);
        LocalDate temp = begin;
        do {
            System.out.println("I am running...");
        } while ((temp = temp.plusDays(1L)).toEpochDay() <= end.toEpochDay());

        System.out.println("toEpochDay, result: " + begin.toEpochDay());
    }

}
