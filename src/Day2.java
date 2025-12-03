import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        long sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            //sum += part1(lines.get(i));
            sum += part2(lines.get(i));
        }
        System.out.println(sum);
    }

    public static long part2(String str) {
        String[] ranges = str.split(",");
        long sum = 0;
        for (String str2 : ranges) {
            int idx = str2.indexOf("-");
            long firstID = Long.parseLong(str2.substring(0, idx));
            long second = Long.parseLong(str2.substring(idx+1));
            while (firstID <= second) {
                String check = Long.toString(firstID);
                for (int i = 1; i < check.length(); i++) {
                    String num = check.substring(0, i);
                    boolean add = true;
                    for (int j = i; j < check.length(); j+= num.length()) {
                        if (j + num.length() > check.length()) {
                            add = false;
                            break;
                        }
                        if (!check.startsWith(num, j)) {
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        System.out.println("added: " + firstID);
                        sum += firstID;
                    }
                }
                firstID++;
            }
        }
        return sum;
    }

    public static long part1(String str) {
        String[] ranges = str.split(",");
        long sum = 0;
        for (String str2 : ranges) {
            int idx = str2.indexOf("-");
            long firstID = Long.parseLong(str2.substring(0, idx));
            long second = Long.parseLong(str2.substring(idx+1));
            while (firstID <= second) {
                    String check = Long.toString(firstID);
                for (int i = 1; i < check.length(); i++) {
                    String num = check.substring(0, i);
                    if (check.substring(i).equals(num)) {
                        sum += firstID;
                        break;
                    }
                }
                firstID++;
            }
        }
        return sum;
    }
}