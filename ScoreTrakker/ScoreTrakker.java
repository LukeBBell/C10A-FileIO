import java.io.*;
import java.util.*;


public class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<>();
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

    public void loadDataFile(String fileName) {
                System.out.println("Processing file: " + fileName);
            try (Scanner scanner = new Scanner(new File("scores.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue;
                    String name = line;
                    String scoreStr = scanner.nextLine().trim();
                    try {
                        int score = Integer.parseInt(scoreStr);
                        Student student = new Student(name, score);
                        students.add(student);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect format for " + name + " not a valid score: " + scoreStr);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Can't open file: " + fileName);
            }

    }
    public void printInOrder() {
    Collections.sort(students); // uses compareTo from Student
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void processFiles() {
        for (String fileName : files) {
            loadDataFile(fileName);
            printInOrder();
        }
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}

