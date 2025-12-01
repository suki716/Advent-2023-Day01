import java.util.ArrayList;

public class Day223 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < lines.size(); i++) {
            sum += getID(lines.get(i));
            sum2 += getPower(lines.get(i));
        }
        System.out.println("Part 1: " + sum);
        System.out.println("Part 1: " + sum2);
    }

    public static int getID(String word) {
        int ID = Integer.parseInt(word.substring(5, word.indexOf(":")));
        String[] val = word.substring(word.indexOf(":") + 2).split("; ");
        for (String str : val) {
            String[] val2 = str.split(", ");
            for (String str2 : val2) {
                int s = str2.indexOf(" ");
                if (str2.contains("red")) {
                    if (Integer.parseInt(str2.substring(0, s)) > 12) {
                        return 0;
                    }
                }
                if (str2.contains("green")) {
                    if (Integer.parseInt(str2.substring(0, s)) > 13) {
                        return 0;
                    }
                }
                if (str2.contains("blue")) {
                    if (Integer.parseInt(str2.substring(0, s)) > 14) {
                        return 0;
                    }
                }
            }
        }
        return ID;
    }

    public static int getPower(String word) {
        int ID = Integer.parseInt(word.substring(5, word.indexOf(":")));
        String[] val = word.substring(word.indexOf(":") + 2).split("; ");
        int red = 0;
        int green = 0;
        int blue = 0;
        for (String str : val) {
            String[] val2 = str.split(", ");
            for (String str2 : val2) {
                int s = str2.indexOf(" ");
                if (str2.contains("red")) {
                    if (Integer.parseInt(str2.substring(0, s)) > red) {
                        red = Integer.parseInt(str2.substring(0, s));
                    }
                }
                if (str2.contains("green")) {
                    if (Integer.parseInt(str2.substring(0, s)) > green) {
                        green = Integer.parseInt(str2.substring(0, s));
                    }
                }
                if (str2.contains("blue")) {
                    if (Integer.parseInt(str2.substring(0, s)) > blue) {
                        blue = Integer.parseInt(str2.substring(0, s));
                    }
                }
            }
        }
        return red * green * blue;
    }
}
