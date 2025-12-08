import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;
        long sum2 = 0;
        for (int i = 0; i < lines.size(); i++) {
            //sum += part1(lines.get(i));
            sum2 += part2(lines.get(i));
        }
        System.out.println(sum2);
    }

    public static long part2(String str) {
        ArrayList<Integer> idxs = new ArrayList<>();
        while (idxs.size() != 12) {
            int max = 0;
            int idx = -1;
            for (int i = 0; i < str.length(); i++) {
                boolean in = false;
                for (int x : idxs) {
                    if (x == i) {
                        in = true;
                        break;
                    }
                }
                if (!in) {
                    if (Integer.parseInt(str.substring(i, i+1)) >= max) {
                        max = Integer.parseInt(str.substring(i, i+1));
                        idx = i;
                        if (idx < 3) {
                            i = idx + 1;
                        }
                    }
                }
            }
            idxs.add(idx);
        }
        Collections.sort(idxs);
        String val = "";
        for (int x : idxs) {
            val += str.charAt(x);
        }
        System.out.println(Long.parseLong(val));
        return Long.parseLong(val);
    }

    public static int part1(String str) {
        int max = 0;
        int idx = -1;
        int second = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(i, i+1));
            if (num > max) {
                max = num;
                idx = i;
            }
        }
        if (idx < str.length() - 1) {
            for (int i = idx + 1; i < str.length(); i++) {
                int num = Integer.parseInt(str.substring(i, i+1));
                if (num > second) {
                    second = num;
                }
            }
        } else {
            second = max;
            max = 0;
            for (int i = 0; i < idx; i++) {
                int num = Integer.parseInt(str.substring(i, i+1));
                if (num > max) {
                    max = num;
                }
            }
        }
        return Integer.parseInt(max + Integer.toString(second));
    }
}
