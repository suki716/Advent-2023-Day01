import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Day5 {
    private static ArrayList<String> valid = new ArrayList<>();
    private static ArrayList<Long> part2 = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        boolean reached = false;
        int count = 0;
//        for (int i = 0; i < lines.size(); i++) {
//            if (!reached) {
//                valid.add(lines.get(i));
//            } else {
//                count += part1(Long.valueOf(lines.get(i)));
//            }
//            if (lines.get(i).equals("x")) {
//                reached = true;
//            }
//        }
        for (int i = 0; i < lines.size(); i++) {
            part2(lines.get(i));
        }
        System.out.println(part2.size());
    }

    public static void part2(String str) {
        int idx = str.indexOf("-");
        long from = Long.parseLong(str.substring(0, idx));
        long to = Long.parseLong(str.substring(idx+1));
        for (long i = from; i <= to; i++) {
            part2.add(i);
            part2 = removeDuplicates(part2);
        }
    }

    /**
     * Method to remove duplicate integers from an ArrayList.
     *
     * @param list The ArrayList that may contain duplicates.
     * @return A new ArrayList with all duplicates removed.
     */
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        // Create a LinkedHashSet from the ArrayList to automatically remove duplicates.
        // LinkedHashSet maintains the original insertion order of elements [2, 3].
        Set<T> setWithoutDuplicates = new LinkedHashSet<>(list);

        // Convert the Set back to an ArrayList.
        return new ArrayList<>(setWithoutDuplicates);
    }

    public static int part1(long num) {
        for (int i = 0; i < valid.size() - 1; i++) {
            String str = valid.get(i);
            int idx = str.indexOf("-");
            long from = Long.parseLong(str.substring(0, idx));
            long to = Long.parseLong(str.substring(idx+1));
            if (num >= from && num <= to) {
                return 1;
            }
        }
        return 0;
    }

}