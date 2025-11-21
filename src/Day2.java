import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day1.getFileData("src/data");
        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            sum += getID(lines.get(i));
        }
    }

    public static int getID(String word) {
        int ID = Integer.parseInt(word.substring(5, word.indexOf(":")));
        System.out.println("ID: " + ID);
        String[] val = word.substring(word.indexOf(":") + 2).split(";");
        for (String str : val) {
            String[] val2 = str.split(", ");
            for (String str2 : val2) {
                System.out.println(str2);
            }
        }
        return ID;
    }
}
