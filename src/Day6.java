import java.util.ArrayList;

public class Day6 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;

        while (!getmathop(lines.get(lines.size() - 1)).equals("")) {
            ArrayList<Integer> ints = new ArrayList<>();
            int len = 0;
            for (int i = 0; i < lines.size() -1; i++) {
                len = 0;
                int idx = lines.get(i).indexOf(" ");
                String str = lines.get(i).substring(0, idx);
                if (str.length() > len) {
                    len = str.length();
                }
                ints.add(Integer.valueOf(str));
            }
            String str = getmathop(lines.get(lines.size() - 1));
        }
        System.out.println(sum);
    }

    public static String getmathop(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (str.charAt(i) == '*') {
                    return "mul";
                } else {
                    return "add";
                }
            }
        }
        return "";
    }
}
