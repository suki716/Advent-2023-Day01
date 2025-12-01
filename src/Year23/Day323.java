import java.util.ArrayList;

public class Day323 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(getNum(lines.get(i), i, lines));
            sum += getNum(lines.get(i), i, lines);
        }

        System.out.println(sum);
    }

    public static int getNum(String str, int idx, ArrayList<String> lines) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int idx2 = i + 1;
            int num = 0;
            boolean end = false;
            for (int j = idx2; j < str.length(); j++) {
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
                            String above = lines.get(idx-1).substring(from, idx2);
                            if (checkValid(above)) {
                                sum += num;
                            }
                        }
                        if (idx < lines.size()) {
                            String below = lines.get(i+1).substring(from, idx2);
                            if (checkValid(below)) {
                                sum += num;
                            }
                        }
                        if (idx2 < str.length()) {
                            if (checkValid(str.substring(idx2, idx2 + 1))) {
                                sum += num;
                            }
                        }
                        end = false;
                        num = 0;
                    }
                }
            }
        }
        return sum;
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
