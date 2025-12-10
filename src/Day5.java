import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day5 {
    private static ArrayList<Long> valid = new ArrayList<>();
    private static ArrayList<Long> given = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        boolean reached = false;
        for (int i = 0; i < lines.size(); i++) {
            if (!reached) {
                getValid(lines.get(i));
            } else {
                given.add(Long.valueOf(lines.get(i)));
            }
            if (lines.get(i).isBlank()) {
                reached = true;
            }
        }

        ;

    }

    public static void getValid(String str) {
        int idx = str.indexOf("-");
        long from = Long.parseLong(str.substring(0, idx));
        long to = Long.parseLong(str.substring(idx+1));
        for (long i = to; i < from; i++) {
            valid.add(i);
        }
    }

}