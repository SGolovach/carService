package by.htp.carservice.main;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws ParseException {

        String date1 = "2019-01-11T10:00";

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date1.replace("T"," "),formater);
//
//        date+=":00";
//
//        System.out.println(date.replace("T"," "));
//
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        LocalDateTime fff = timestamp.toLocalDateTime();
        System.out.println(timestamp);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date = dateFormat.parse(date1);
//        System.out.println(date);
//        Timestamp timestamp = new Timestamp(date.getTime());
//        System.out.println(timestamp);

    }
}
