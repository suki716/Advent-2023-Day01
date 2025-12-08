import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            sum += part1(lines.get(i), i, lines);
        }
        System.out.println(sum);
    }

    public static int part1(String str, int idx, ArrayList<String> lines) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int idx2 = i + 1;
            int from = i;
            if (i != 0) {
                from -= 1;
            }
            if (idx != 0) {
                String above = lines.get(idx - 1).substring(from, idx2);
                sum += countRolls(above);
            }
            if (idx + 1 < lines.size()) {
                String below = lines.get(idx + 1).substring(from, idx2);
                sum += countRolls(below);
            }
            if (idx2 <= str.length() - 1) {
                sum += countRolls(str.substring(idx2, idx2 + 1));
            }
        }
        if (sum < 4) {
            return 1;
        }
        return 0;
    }

    public static int countRolls(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                count++;
            }
        }
        return count;
    }
}
