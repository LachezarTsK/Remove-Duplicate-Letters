
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int SIZE_ALPHABET = 26;
    private static final int ASCII_SMALL_CASE_A = 97;
    private int sizeInput;

    public String removeDuplicateLetters(String input) {

        sizeInput = input.length();
        boolean[] inludedInStringToCompose = new boolean[SIZE_ALPHABET];
        int[] lastIndexInInput = new int[SIZE_ALPHABET];
        fillArray_indexOfLastOccurenceInInput(lastIndexInInput, input);
        Deque<Character> stack = new ArrayDeque<>();        

        for (int i = 0; i < sizeInput; i++) {
            final char ch = input.charAt(i);
            if (inludedInStringToCompose[ch - ASCII_SMALL_CASE_A]) {
                continue;
            }
            while (!stack.isEmpty() && ch < stack.peek() && i < lastIndexInInput[stack.peek() - ASCII_SMALL_CASE_A]) {
                inludedInStringToCompose[stack.pop() - ASCII_SMALL_CASE_A] = false;
            }
            inludedInStringToCompose[ch - ASCII_SMALL_CASE_A] = true;
            stack.push(ch);
        }
        return assembleNewString(stack);
    }

    private void fillArray_indexOfLastOccurenceInInput(int[] lastIndexInInput, String input) {
        for (int i = 0; i < sizeInput; i++) {
            lastIndexInInput[input.charAt(i) - ASCII_SMALL_CASE_A] = i;
        }
    }

    private String assembleNewString(Deque<Character> stack) {
        StringBuilder noDuplicatesAscendingOrder = new StringBuilder();
        while (!stack.isEmpty()) {
            noDuplicatesAscendingOrder.append(stack.removeLast());
        }
        return noDuplicatesAscendingOrder.toString();
    }
}
