package com.hackathought.wordcloud;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bazhunga on 11/7/2014.
 */
public class SentenceDB {
    private ArrayList<String> sdb;
    private String allSentences = "";

    public SentenceDB (){
        sdb = new ArrayList<String>();
    }
    public SentenceDB (String fullSentence){
        allSentences = fullSentence;
        ArrayList<String>sdb = new ArrayList<String>(){{
            add(allSentences);
        }};

    }

    public void append(String item){
        sdb.add(item);
    }
    public ArrayList<String> getSentenceList () {
        return sdb;
    }
    public String getKeySentence(){
        //First, put everything into one String
        allSentences = "";
        for (String s : sdb){
            allSentences = allSentences.concat(s + " ");
        }
        return allSentences;
        //Go through the array of sentences and
    }
    public ArrayList<String> getKeyWordArray() {
        ArrayList<String> splitArray;
        String [] wordArray = {};
        //try {
        wordArray = allSentences.split("\\s+");
        splitArray = new ArrayList<String>(Arrays.asList(wordArray));
        //} catch (PatternSyntaxException ex) {
            //
        //}
        return splitArray;

    }
}
