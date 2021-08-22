package homework9;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String validPhoneNumber = "([0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\) [0-9]{3}-[0-9]{4})";

    public static void main(String[] args) throws IOException {
//        printAllValidNumbersToConsole();
//        jsonFromFile();
        wordsCount();
    }

    public static void printAllValidNumbersToConsole() throws FileNotFoundException {
        File file = new File("src/homework9/file.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));

        while(scanner.hasNextLine()){
            String number = scanner.nextLine();
            if(number.matches(validPhoneNumber)){
                System.out.println(number);
            }
        }

        scanner.close();
    }

    public static void jsonFromFile() throws IOException {
        File file = new File("src/homework9/file1.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
        FileWriter fileWriter = new FileWriter("src/homework9/user.json");
        String[] tableHead = scanner.nextLine().split(" ");
        fileWriter.append("[\n");

        while (scanner.hasNextLine()){
            String[] tableEntry = scanner.nextLine().split(" ");
            fileWriter.append("{\n");

            for(int i = 0; i < tableEntry.length; i++){
                fileWriter.append("\"" + tableHead[i] + "\": ");
                if(tableHead[i].equals("age")){
                    fileWriter.append(tableEntry[i]);
                } else {
                    fileWriter.append("\"" + tableEntry[i] + "\"");
                }
                if(i < tableEntry.length - 1)
                    fileWriter.append(",\n");
                else
                    fileWriter.append("\n");
            }

            if(scanner.hasNextLine())
                fileWriter.append("},\n");
            else
                fileWriter.append("}\n");
        }

        fileWriter.append("]");
        fileWriter.flush();
        fileWriter.close();
        scanner.close();
    }

    public static void wordsCount() throws FileNotFoundException {
        File file = new File("src/homework9/words.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
        Map<String,Integer> map = new HashMap<>();
        while(scanner.hasNextLine()){
            String[] words = scanner.nextLine().split(" ");
            for(int i = 0; i < words.length; i++){
                if(!words[i].equals(" ")){
                    if(map.containsKey(words[i])){
                        map.put(words[i],map.get(words[i]) + 1);
                    } else {
                        map.put(words[i],1);
                    }
                }
            }
        }
        scanner.close();
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                      .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
