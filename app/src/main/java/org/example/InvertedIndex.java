package org.example; 

//holds the inverted index data structure
//create the inverted index
//add words to the index and record their occurrences
//store the data in a HashMap<String, Set<Integer>>

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InvertedIndex
{
    private ProcessText processor;
    private Map<String, Set<Integer>> InvertedIndex;

    public InvertedIndex()
    {
        processor = new ProcessText();
        InvertedIndex = new HashMap<>();
    }

    public String readFile(String file) throws IOException
    {
        StringBuilder fileContent = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                fileContent.append(line).append("\n");
            }
        }
        return fileContent.toString();
    }

    public void buildInvertedIndex(String txt)
    {
        List<String> filteredWords = processor.filter(txt);
        for(int i = 0; i < filteredWords.size(); i++){
            String word = filteredWords.get(i);

            InvertedIndex.putIfAbsent(word, new HashSet<>());
            InvertedIndex.get(word).add(i);
        }
    }

    public void writeFile(String outputFile) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            List<Map.Entry<String, Set<Integer>>> entries = new ArrayList<>(InvertedIndex.entrySet());

            for(int i = 0; i < entries.size(); i++){
                Map.Entry<String, Set<Integer>> entry = entries.get(i);
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}