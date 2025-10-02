import java.io.*;
import java.util.*;
import Student.java;


public class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<>();

    public void loadDataFile(String fileName) {
        try (Scanner scanner = new Scanner(new File("scores.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                // Find the last space (to split name and score)
                int lastSpace = line.lastIndexOf(" ");
                if (lastSpace == -1) {
                    System.out.println("Incorrect format: " + line);
                    continue;
                }

                String name = line.substring(0, lastSpace).trim();
                String scoreStr = line.substring(lastSpace + 1).trim();

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

    public ArrayList<Student> getStudents() {
        return students;
    }
}

