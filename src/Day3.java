import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day1.getFileData("src/data");
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            sum += getNum(lines.get(i), i, lines);
        }

        System.out.println(sum);
    }

    public static int getNum(String str, int idx, ArrayList<String> lines) {
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            int idx2 = i + 1;
            int num = 0;
            for (int j = idx2; j < str.length(); j++) {
                boolean end = false;
                if (!Character.isDigit(str.charAt(j-1))) {
                    idx2 = j+1;
                    end = true;
                }
                if (!end) {
                    num = Integer.parseInt(str.substring(i, j));
                } else {
                    if (num != 0) {
                        int from = i;
                        if (i != 0) {
                            from -= 1;
                        }
                        if (idx != 0) {
                            String above = lines.get(i-1).substring(from, idx2);
                            if (checkValid(above)) {
                                System.out.println("above reached");
                                return num;
                            }
                        }
                        if (idx < lines.size()) {
                            String below = lines.get(i+1).substring(from, idx2);
                            if (checkValid(below)) {
                                System.out.println("below reached");
                                return num;
                            }
                        }
                        if (checkValid(lines.get(i).substring(idx2, idx2 + 1))) {
                            System.out.println("right checked");
                            return num;
                        }
                    }
                    num = 0;
                }
            }
        }
        return 0;
    }

    public static boolean checkValid(String str) {
        String[] special = {"*", "$", "#", "@", "/", "=", "+", "%", "-", "&"};
        for (String sp : special) {
            if (str.contains(sp)) {
                return true;
            }
        }
        return false;
    }
}
