import java.util.ArrayList;

public class Day6 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;

        while (!getmathop(lines.get(lines.size() - 1)).equals("")) {
            ArrayList<Integer> ints = new ArrayList<>();
            int len = 0;
            for (int i = 0; i < lines.size() -1; i++) {
                String str = "";
                int idx = lines.get(i).indexOf(" ");
                if (idx == -1) {
                    str = lines.get(i);
                } else  {
                    str = lines.get(i).substring(0, idx);
                    if (idx == 0) {
                        String temp = lines.get(i);
                        for (int j = 0; j < temp.length(); j++) {
                            if (temp.charAt(j) != ' ') {
                                temp = temp.substring(j);
                                break;
                            }
                        }
                        if (temp.indexOf(" ") == -1) {
                            str = temp;
                        } else {
                            str = temp.substring(0, temp.indexOf(" "));
                        }

                    }
                    if (str.length() > len) {
                        len = str.length();
                    }
                }
                ints.add(Integer.valueOf(str));
            }
            String str = getmathop(lines.get(lines.size() - 1));
            int val = ints.getFirst();
            for (int i = 1; i < ints.size(); i++) {
                if (str.equals("mul")) {
                    val *= ints.get(i);
                } else {
                    val += ints.get(i);
                }
            }
            sum += val;

            for (int i = 0; i < lines.size(); i++) {
                String str2 = lines.remove(i);
                if (len != 1) {
                    lines.add(i, str2.substring(len+1));
                }
            }


            for (String str3 : lines) {
                System.out.println(str3);
            }
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
