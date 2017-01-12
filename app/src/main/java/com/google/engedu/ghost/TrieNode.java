package com.google.engedu.ghost;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;


public class TrieNode {
    private HashMap<String, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void add(String s) {
        TrieNode currentNode = this;
        String key;

        for (int i = 0; i < s.length(); i++)
        {
            key = "" + s.charAt(i);
            if(!currentNode.children.containsKey(key)){
                currentNode.children.put(key, new TrieNode());
            }

            currentNode = currentNode.children.get(key);
        }

        currentNode.isWord = true;
    }

    public boolean isWord(String s) {

      TrieNode currentNode = this;
        String key;
        boolean isFound =false;
        for (int i=0;i<=s.length();i++){
            key = ""+s.charAt(i);
            if(currentNode.children.containsKey(key)){
                currentNode=currentNode.children.get(key);

            }
            else{
                isFound= true;
                return isFound;
            }
        }
        if(currentNode.isWord){
            isFound = true;
        }

        return isFound;
    }

    public String getAnyWordStartingWith(String s) {
        TrieNode currentNode = this;

         Set keyList;
        String key;
        String word = "";

        if (!s.isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                key = "" + s.charAt(i);
                word += key;
                if (currentNode.children.containsKey(key)) {
                    currentNode = currentNode.children.get(key);
                } else {
                    return null;

                }
            }
        }

        while (!currentNode.isWord){
            keyList = currentNode.children.keySet();
            key =  keyList.toArray()[new Random().nextInt(keyList.size())].toString();
            word+=key;
            currentNode= currentNode.children.get(key);
        }
        return word;

    }
    public String getGoodWordStartingWith(String s) {
        return null;
    }
}
