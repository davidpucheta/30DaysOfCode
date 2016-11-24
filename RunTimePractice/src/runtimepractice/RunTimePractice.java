/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimepractice;

import java.util.HashMap;

/**
 *
 * @author davidreyespucheta
 */
public class RunTimePractice {
    
    
    public static int findNumsOfRepetitions(String s, char c){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                sum++;
            }
        }
        return sum;
    }

    public static int[] findNumsOfRepetitionsv1(String s, char[] c){
        int[] sums = new int[c.length];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < c.length; j++) {
                if (s.charAt(i) == c[j]) {
                    sums[j] = sums[j] + 1;
                }
            }
        }
        return sums;
    }
    
    public static int[] findNumsOfRepetitionsv2(String s, char[] c){
        //O(n)
        int[] sums = new int[c.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int sum = map.get(s.charAt(i));
                map.put(s.charAt(i), sum+1);
            }
        }
        
        for (int i = 0; i < c.length; i++) {
            int sum;
            if (!map.containsKey(c[i])) {
                sums[i] = 0;
            } else {
                sums[i] = map.get(c[i]);
            }
        }
        
        return sums;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long startTime = System.currentTimeMillis();
        //Execute code
            System.out.println(findNumsOfRepetitions("abca", 'a'));
        //
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Test 0: " + duration + "ms");
        
        
        ///
        char[] a = { 'a', 'b', 'c', 'd' };
        String s = "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";
        startTime = System.currentTimeMillis();
        //Execute code
            System.out.println(findNumsOfRepetitionsv1(s, a));
        //
         endTime = System.currentTimeMillis();
         duration = endTime - startTime;
        System.out.println("Test v1: " + duration + "ms");
        
        
         startTime = System.currentTimeMillis();
        //Execute code
            System.out.println(findNumsOfRepetitionsv2(s, a));
        //
         endTime = System.currentTimeMillis();
         duration = endTime - startTime;
        System.out.println("Test v2: " + duration + "ms");
        
        
    }
    
