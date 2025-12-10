import java.util.ArrayList;

public class Day4 {
    private static ArrayList<String> lines;

    public static void main(String[] args) {
        lines = Day123.getFileData("src/data");
        int sum = 0;
        int val = -1;
        while (val != 0) {
            val = 0;
            for (int i = 0; i < lines.size(); i++) {
                val += part1(lines.get(i), i);
            }
            sum += val;
            clean();
//            for (int i = 0; i < lines.size(); i++) {
//                System.out.println(lines.get(i));
//            }
//            System.out.println("---------------");
        }
        System.out.println(sum);
    }

    public static void clean() {
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.getFirst().length(); j++) {
                String str = lines.get(i);
                if (str.charAt(j) == 'x') {
                    lines.remove(i);
                    lines.add(i, str.substring(0, j) + "." + str.substring(j+1));
                }
            }
        }
    }

    public static int part1(String str, int idx) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                int count = 0;
                int idx2 = i + 1;
                if (i != str.length() - 1) {
                    idx2++;
                }
                int from = i;
                if (i != 0) {
                    from -= 1;
                }
                if (idx != 0) {
                    String above = lines.get(idx - 1).substring(from, idx2);
                    count += countRolls(above);
                }
                if (idx + 1 < lines.size()) {
                    String below = lines.get(idx + 1).substring(from, idx2);
                    count += countRolls(below);
                }
                if (idx2 <= str.length()) {
                    count += countRolls(str.substring(from, idx2)) - 1;
                }
                if (count < 4) {
                    sum++;
                    String str2 = lines.remove(idx);
                    lines.add(idx, str2.substring(0, i) + "x" + str2.substring(i+1));
                }
            }
        }
        return sum;
    }

    public static int countRolls(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@' || str.charAt(i) == 'x') {
                count++;
            }
        }
        return count;
    }
}
