import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        Month firstMonthofQuarter = currentMonth.firstMonthOfQuarter();


        QuarterOfYearQuery q = new QuarterOfYearQuery();
        // Direct
        Quarter quarter = q.queryFrom(LocalDate.now());
        System.out.println(quarter);
        // Indirect
        quarter = LocalDate.now().query(q);
        System.out.println(quarter);

        LocalDate now = LocalDate.now();
        Temporal fdoq = now.with(new FirstDayOfQuarter());
        System.out.println(fdoq);
    }
}
