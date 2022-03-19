
#include <array>
#include <string>
#include <queue>
using namespace std;

class Solution {
    
    inline static const int SIZE_ALPHABET = 26;
    inline static const int ASCII_SMALL_CASE_A = 97;
    size_t sizeInput;

public:

    string removeDuplicateLetters(string input) {

        sizeInput = input.length();
        array<bool, SIZE_ALPHABET > inludedInStringToCompose{};
        array<int, SIZE_ALPHABET> lastIndexInInput{};
        fillArray_indexOfLastOccurenceInInput(lastIndexInInput, input);
        deque<char> stack;

        for (int i = 0; i < sizeInput; i++) {
            const char ch = input[i];
            if (inludedInStringToCompose[ch - ASCII_SMALL_CASE_A]) {
                continue;
            }
            while (!stack.empty() && ch < stack.front() && i < lastIndexInInput[stack.front() - ASCII_SMALL_CASE_A]) {
                inludedInStringToCompose[stack.front() - ASCII_SMALL_CASE_A] = false;
                stack.pop_front();
            }
            inludedInStringToCompose[ch - ASCII_SMALL_CASE_A] = true;
            stack.push_front(ch);
        }
        return assembleNewString(stack);
    }

private:

    void fillArray_indexOfLastOccurenceInInput(array<int, SIZE_ALPHABET>& lastIndexInInput, const string& input) {
        for (int i = 0; i < sizeInput; i++) {
            lastIndexInInput[input[i] - ASCII_SMALL_CASE_A] = i;
        }
    }

    string assembleNewString(deque<char>& stack) {
        string noDuplicatesAscendingOrder;
        while (!stack.empty()) {
            noDuplicatesAscendingOrder.push_back(stack.back());
            stack.pop_back();
        }
        return noDuplicatesAscendingOrder;
    }
};
