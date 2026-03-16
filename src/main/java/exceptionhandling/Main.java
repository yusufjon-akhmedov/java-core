package exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Current Working Directory (pwd) = " +
                new File("").getAbsolutePath());

        String fileName = "/files/testing.csv";

        File file = new File(new File("").getAbsolutePath(), fileName);
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("I can't run unless this files exists");
            return;
        }
        System.out.println("I'm good to go.");

        for (File f : File.listRoots()) {
            System.out.println(f);
        }
    }

    // try with catch block
    private static void testFile(String fileName) {

        FileReader reader = null;
        Path path = Paths.get(fileName);

        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as  a resource");
    }

    // try with resource one
    private static void testFile2(String filename) {

        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + "' does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data " + badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
