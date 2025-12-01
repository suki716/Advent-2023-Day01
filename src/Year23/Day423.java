import java.util.ArrayList;

public class Day423 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            sum += (int) Math.pow(2, getVal(lines.get(i)) - 1);
        }
        System.out.println(sum);
    }

    public static int getVal(String str) {
        int sum = 0;
        int idx = str.indexOf(": ");
        int idx2 = str.indexOf("|");
        String[] winning = str.substring(idx, idx2).split(" ");

        for (String str5: winning) {
            System.out.println(str5);
        }

        String[] given = str.substring(idx2+1).split(" ");
        for (String str2 : given) {
            for (String str3 : winning) {
                if (Integer.parseInt(str3) == Integer.parseInt(str2)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
