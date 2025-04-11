package org.example; 

//will handle punctuation, whitespace, case sensitivity, etc
//will skip over "stop words"

import java.util.HashSet; 
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ProcessText
{
    private Set<String> skipWords;

    public ProcessText()
    {
        skipWords = new HashSet<>();
        commonWords();
    }

    private void commonWords() 
    {
        skipWords.add("a");
        skipWords.add("the");
        skipWords.add("and");
        skipWords.add("also");
        skipWords.add("who");
        skipWords.add("what");
        skipWords.add("when");
        skipWords.add("where");
        skipWords.add("why");
        skipWords.add("how");
        skipWords.add("which");
        skipWords.add("to");
        skipWords.add("for");
        skipWords.add("they");
        skipWords.add("them");
        skipWords.add("she");
        skipWords.add("her");
        skipWords.add("he");
        skipWords.add("him");
        skipWords.add("on");
        skipWords.add("of");
        skipWords.add("if");
        skipWords.add("from");
        skipWords.add("i");
        skipWords.add("me");
        skipWords.add("my");
        skipWords.add("myself");
        skipWords.add("we");
        skipWords.add("our");
        skipWords.add("ours");
        skipWords.add("ourselves");
        skipWords.add("you");
        skipWords.add("your");
        skipWords.add("yours");
        skipWords.add("his");
        skipWords.add("hers");
        skipWords.add("it");
        skipWords.add("its");
        skipWords.add("itself");
        skipWords.add("their");
        skipWords.add("theirs");
        skipWords.add("this");
        skipWords.add("that");
        skipWords.add("these");
        skipWords.add("those");
        skipWords.add("is");
        skipWords.add("was");
        skipWords.add("were");
        skipWords.add("be");
        skipWords.add("have");
        skipWords.add("has");
        skipWords.add("been");
        skipWords.add("had");
        skipWords.add("do");
        skipWords.add("does");
        skipWords.add("did");
        skipWords.add("doing");
        skipWords.add("an");
        skipWords.add("but");
        skipWords.add("because");
        skipWords.add("at");
        skipWords.add("with");
        skipWords.add("in");
        skipWords.add("like");
    }

    public List<String> filter(String txt)
    {
        txt = cleanText(txt);
        String[] words = txt.split("\\s+");
        List<String> filteredWords = filterSkipWords(words);

        return filteredWords;
    }

    private String cleanText(String txt)
    {
        txt = txt.toLowerCase();
        txt = txt.replaceAll("[^a-zA-Z]", " ");
        txt = txt.replaceAll("\\s+", " ").trim();

        return txt;
    }

    private List<String> filterSkipWords(String[] words)
    {
        List<String> filteredWords = new ArrayList<>();

        for(String word : words){
            if(!skipWords.contains(word)){
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}