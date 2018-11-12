package practice.demo.playground;

/**
 * Descriptions: 年份<p>
 *
 * @author SailHe
 * @date 2018/11/12 19:20
 */
class Year implements Say {
    String year;

    public Year(String year) {
        this.year = year;
    }

    @Override
    public Blessing say(String word) {
        System.out.printf(word);
        return new Blessing(year);
    }
}
