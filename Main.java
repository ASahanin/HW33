package hw33;

import cw_exceptions.MyExeption;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("answers33.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String replace = scanner.nextLine().replace(" ", "");
            System.out.println(replace);
            FileWriter fileWriter = new FileWriter("replaced.txt");
            fileWriter.write(replace);
            fileWriter.close();
        }
        fileReader.close();

        File file = new File("answers33.txt");


        File file1 = new File("ddd.txt");

        try {
            fileIsOver100b(file);
        }
        catch (Exception ex){
            System.out.println("Код слишком большой!");
        }
        finally {
            fileExistence(file1);
        }

    }
    public static void fileIsOver100b(File file) {
        if (file.length() >= 100) {
            throw new IllegalStateException();
        }
    }

    public static void fileExistence(File file){
        if(file.exists()){
            System.out.println("Файл существует!");
        }
        else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}


