import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day1.getFileData("src/data");
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            sum += getNum(lines.get(i), i);
        }

        System.out.println(sum);
    }

    public static int getNum(String str, int idx) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {

            }
        }

        return 0;
    }
}
