import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateFormatUtil {
    static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
