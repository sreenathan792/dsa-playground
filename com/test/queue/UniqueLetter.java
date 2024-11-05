package com.test.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".
 * <p>
 * Here's a scenario:
 * <p>
 * A student says "a". It's the first letter. You write "a".
 * Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
 * A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
 * A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
 * A student says "c". "c" is unique. You add "c". The final is "aab#c".
 * Your task? Given the sequence the students call out A, determine the string on the board.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string after processing the stream of lowercase alphabets A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "abadbc"
 * Input 2:
 * <p>
 * A = "abcabc"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * "aabbdd"
 * Output 2:
 * <p>
 * "aaabc#"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "aba"    -   first non repeating character 'b'
 * "abad"   -   first non repeating character 'b'
 * "abadb"  -   first non repeating character 'd'
 * "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "abc"    -   first non repeating character 'a'
 * "abca"   -   first non repeating character 'b'
 * "abcab"  -   first non repeating character 'c'
 * "abcabc" -   no non repeating character so '#'
 */
public class UniqueLetter {

    public String solve(String A) {

        char[] chArr = A.toCharArray();
        HashMap<Character, Integer> cMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : chArr) {

            if(cMap.get(c) == null) {
                cMap.put(c,1);
            } else {
                cMap.put(c, cMap.get(c) + 1);
            }
            queue.offer(c);

            while(!queue.isEmpty() && cMap.get(queue.peek()) >1) {
                queue.poll();
            }

            if(queue.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(queue.peek());
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        UniqueLetter uniq = new UniqueLetter();
        System.out.println("Unique Letter Result -> " + uniq.solve("abcabc"));
    }

}
