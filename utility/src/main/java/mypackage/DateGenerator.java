package mypackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: 日期时间生成器类<p>
 * 构造器(String, Long, Date)
 * 转换器(String, Long, Date)<p>
 *
 * @author: SailHe
 * @date: 2018/4/3 14:47
 */
public class DateGenerator {
    // default format
    private SimpleDateFormat dateFormatBuffer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date buffer = null;

    /**
     * Descriptions: 改变该对象的格式<p>
     *
     * @author SailHe
     * @date 2018/4/3 16:42
     */
    public void setFormat(SimpleDateFormat dateFormat) {
        dateFormatBuffer = dateFormat;
    }

    public DateGenerator(String date) {
        try {
            buffer = dateFormatBuffer.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public DateGenerator(Date date) {
        buffer = date;
    }

    public DateGenerator(Long date) {
        buffer = new Date(date);
    }

    @Override
    public String toString() {
        return dateFormatBuffer.format(buffer);
    }

    public Date toDate() {
        return buffer;
    }

    public Long toLong() {
        return buffer.getTime();
    }

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("Date类直接输出: " + now);
        DateGenerator generator = new DateGenerator(now);
        System.out.println("Date类构造: " + generator);
        generator.setFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        System.out.println("格式变换后: " + generator);

        System.out.println("字符串构造: " + new DateGenerator(generator.toString()));
        System.out.println("字符串构造: " + new DateGenerator(generator.toDate()).toString());


        System.out.println("Long输出" + generator.toLong());
        System.out.println("Long构造: " + new DateGenerator(generator.toLong()));
    }
}
