
/**
 * @param {string} input
 * @return {string}
 */
var removeDuplicateLetters = function (input) {
    this.SIZE_ALPHABET = 26;
    this.ASCII_SMALL_CASE_A = 97;
    this.sizeInput = input.length;

    const inludedInStringToCompose = new Array(SIZE_ALPHABET).fill(false);
    const lastIndexInInput = new Array(SIZE_ALPHABET).fill(-1);
    fillArray_indexOfLastOccurenceInInput(lastIndexInInput, input);
    const stack = [];

    for (let i = 0; i < sizeInput; i++) {
        const ch = input.charAt(i);
        if (inludedInStringToCompose[ascii_char(ch) - ASCII_SMALL_CASE_A]) {
            continue;
        }
        while (stack.length > 0
                && ch < stack[stack.length - 1]
                && i < lastIndexInInput[ascii_char(stack[stack.length - 1]) - ASCII_SMALL_CASE_A]) {

            inludedInStringToCompose[ascii_char(stack.pop()) - ASCII_SMALL_CASE_A] = false;
        }
        inludedInStringToCompose[ascii_char(ch) - ASCII_SMALL_CASE_A] = true;
        stack.push(ch);
    }
    return stack.join('');
};

/**
 * @param {number[]} lastIndexInInput
 * @param {string} input
 */
function fillArray_indexOfLastOccurenceInInput(lastIndexInInput, input) {
    for (let i = 0; i < this.sizeInput; i++) {
        lastIndexInInput[input.codePointAt(i) - this.ASCII_SMALL_CASE_A] = i;
    }
}

/**
 * @param {string} char
 * @return {number} 
 */
function ascii_char(char) {
    return char.codePointAt(0);
}
