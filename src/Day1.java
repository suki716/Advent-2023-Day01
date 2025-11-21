import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<String> lines = getFileData("src/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < lines.size(); i++) {
            //partOneAnswer += getPartOneNumber(lines.get(i));
            partTwoAnswer += getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(String line) {
        // do part 1
        // find the first digit and last digit of the String
        // return the number put together
        String firstNum = "";
        String lastNum = "";
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                if (firstNum.equals("")) {
                    firstNum = String.valueOf(line.charAt(i));
                } else {
                    lastNum = String.valueOf(line.charAt(i));
                }
            }
        }
        if (lastNum.equals("")) {
            lastNum = firstNum;
        }
        return Integer.parseInt(firstNum + lastNum);
    }

    public static int getPartTwoNumber(String line) {
        String firstNum = "";
        String lastNum = "";
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                if (firstNum.equals("")) {
                    firstNum = String.valueOf(line.charAt(i));
                } else {
                    lastNum = String.valueOf(line.charAt(i));
                }
            } else {
                for (int j = i + 3; j < line.length() + 1; j++) {
                    if (getNumFromWord(line.substring(i, j)) != 0) {
                        if (firstNum.equals("")) {
                            firstNum = String.valueOf(getNumFromWord(line.substring(i, j)));
                        } else {
                            lastNum = String.valueOf(getNumFromWord(line.substring(i, j)));
                        }
                        break;
                    }
                    if (line.substring(i, j).length() > 6) {
                        break;
                    }
                }
            }
        }
        if (lastNum.equals("")) {
            lastNum = firstNum;
        }
        return Integer.parseInt(firstNum + lastNum);
    }

    public static int getNumFromWord(String word) {
        if (word.equals("one")) {
            return 1;
        }
        if (word.equals("two")) {
            return 2;
        }
        if (word.equals("three")) {
            return 3;
        }
        if (word.equals("four")) {
            return 4;
        }
        if (word.equals("five")) {
            return 5;
        }
        if (word.equals("six")) {
            return 6;
        }
        if (word.equals("seven")) {
            return 7;
        }
        if (word.equals("eight")) {
            return 8;
        }
        if (word.equals("nine")) {
            return 9;
        }
        return 0;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}