import java.io.*;
import java.util.*;

public class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> errors = new ArrayList<>();
    private final String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

    public void loadDataFile(String fileName) {
        students.clear();
        errors.clear();
            try (Scanner scanner = new Scanner(new File(fileName))) {
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
                        errors.add("Incorrect format for " + name + " not a valid score: " + scoreStr);
                    }
                }
            } catch (FileNotFoundException e) {
                errors.add("Can't open file: " + fileName);
            }

    }
    public void printInOrder() {
    if (!students.isEmpty()) {
        System.out.println("Student Score List");
    }
    Collections.sort(students); // uses compareTo from Student
        for (Student student : students) {
            System.out.println(student);
        }
        if (!errors.isEmpty() && !students.isEmpty()) {
            System.out.println();
        }
        for (String error : errors) {
            System.out.println(error);
        }
            System.out.println();

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

