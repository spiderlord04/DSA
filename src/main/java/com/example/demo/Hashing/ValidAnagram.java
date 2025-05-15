package com.example.demo.Hashing;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s,String s2){
        if (s.length() != s2.length()) {
            return false;
        }
        //freq
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //checking
        for(int i = 0;i<s.length();i++){
            
            char ch = s2.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }else if(map.get(ch) ==1){
                map.remove(ch);
            }
            else {
                map.put(ch,map.get(ch)-1);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String text = "race";
        String text2 = "care77";
        System.out.println(isAnagram(text, text2));
    }
}
