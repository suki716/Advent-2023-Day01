import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        for (int i = 0; i < lines.size(); i++) {

        }
    }

    public static int part1(String str) {
        String[] ranges = str.split(",");
        int sum = 0;
        for (String str2 : ranges) {
            int idx = str2.indexOf("-");
            int firstID = Integer.parseInt(str2.substring(0, idx));
            int second = Integer.parseInt(str2.substring(idx));
            while (firstID < second) {
                for (int i = 0; i < String.valueOf(firstID).length(); i++) {
                    for (int j = i)
                }
                firstID++;
            }
        }
        return sum;
    }
}