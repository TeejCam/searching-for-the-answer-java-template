/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.util.List;
import java.io.IOException;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        InvertedIndex index = new InvertedIndex();

        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try{
            String fileContents = index.readFile(inputFile);

            index.buildInvertedIndex(fileContents);
            index.writeFile(outputFile);

            System.out.println("Inverted index created and written to: " + outputFile);
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
