import java.util.ArrayList;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> lines = Day123.getFileData("src/data");
        int position = 50;
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            String str = lines.get(i);
            if (str.charAt(0) == 'L') {
                position -= Integer.parseInt(str.substring(1));
                if (position < 0) {
                    position = 100 - Math.abs(position);
                }
            }
            if (str.charAt(0) == 'R') {
                position += Integer.parseInt(str.substring(1));
                if (position > 99)
            }
            if (position == 0) {
                count++;
            }
        }
    }
}
