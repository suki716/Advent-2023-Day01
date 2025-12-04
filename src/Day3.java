import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            sum += part1(lines.get(i));
        }
        System.out.println(sum);
    }

    public static int part1(String str) {
        int max = 0;
        int idx = -1;
        int second;
        for (int i = 0; i < str.length() - 1; i++) {
            int num = Integer.parseInt(str.substring(i, i+1));
            if (num > max) {
                max = num;
                idx = i;
            }
        }
        if (idx == str.length() - 1) {
            second = Integer.parseInt(str.substring(idx + 1, idx + 2));
        } else if (idx == 0) {
            second = str.charAt(1);
        } else {
            second = max;
            if (idx > 0) {
                max = Integer.parseInt(str.substring(idx - 1, idx));
            }
        }
        System.out.println( Integer.parseInt(max + Integer.toString(second)));
        return Integer.parseInt(max + Integer.toString(second));
    }
}
