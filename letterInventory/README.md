# Letter Inventory
*Implementing a character vector data type with arrays.*

Natural language processing (NLP) is an interdisciplinary area of computer science focused on programming computers to work with natural languages used by humans everyday. Since all data in computers are ultimately represented as numbers, a key challenge in NLP is **vectorization**: the process of turning a natural language text into a meaningful numeric representation.

A letter inventory is a data type that represents a character-by-character count vectorization for letters in the English alphabet. Each letter inventory keeps track of how many a’s, how many b’s, etc. are contained in a given string. For example, the letter inventory for the string “Washington State” corresponds to `[aaeghinnosstttw]`. The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.

## Specification

Implement a `LetterInventory` data type that represents an inventory of the 26 letters in the English alphabet. It should be represented with an array.

`LetterInventory(String data)`

Constructs an inventory of the letters in the given string, ignoring the case of letters and ignoring any non-alphabetic characters. Store the inventory (how many a’, how many b’s, …) as an array of 26 counters (one for each letter) along with any other necessary data fields.

`int get(char letter)`

Returns a count of how many of this letter are in the inventory. Letter might be lowercase or uppercase. If a nonalphabetic character is passed, throw an `IllegalArgumentException`.

`void set(char letter, int value)`

Sets the count for the given letter to the given value. The given letter might be lowercase or uppercase. If a nonalphabetic character is passed or if value is negative, throw an `IllegalArgumentException`.

`int size()`

Returns the sum of all of the counts in this inventory. This operation should be fast in that it should store the size rather than having to compute it each time this method is called.

`boolean isEmpty()`

Returns true if this inventory is empty (all counts are 0). This operation should be fast in that it should not need to examine each of the 26 counts when it is called.

`String toString()`

Returns a String representation of the inventory with the letters all in lowercase and in sorted order and surrounded by square brackets. The number of occurrences of each letter should match its count in the inventory. For example, an inventory of 4 a’s, 1 b, 1 l and 1 m would be represented as `[aaaablm]`.

`LetterInventory add(LetterInventory other)`

Constructs and returns a new `LetterInventory` object that represents the sum of this letter inventory and the other given `LetterInventory`. The counts for each letter should be added together. The two LetterInventory objects being added together (`this` and `other`) should not be changed by this method.

`LetterInventory washington = new LetterInventory("Washington");
LetterInventory state = new LetterInventory("State");
System.out.println(washington.add(state));`

`washington` corresponds to `[aghinnostw]`, `state` corresponds to `[aestt]`, and the result of adding them corresponds to `[aaeghinnosstttw]`.

`LetterInventory subtract(LetterInventory other)`

Constructs and returns a new `LetterInventory` object that represents the result of subtracting the other inventory from this inventory (i.e., subtracting the counts in the other inventory from this object’s counts). If any resulting count would be negative, return `null`. The two `LetterInventory` objects being subtracted (`this` and `other`) should not be changed by this method.

The values of type `char` have corresponding integer values. There is a character with value 0, a character with value 1, a character with value 2, and so on. Different values of type char can be compared using the less-than and greater-than operators.

`char c = 'w';
if (c >= 'a') {
    // Since 'w' >= 'a', we'll take this branch
    ...
}`

Use `char` arithmetic to determine array indices and offsets. char represents characters as numbers. The lowercase letters are all grouped together: ‘a’ then ‘b’ then ‘c’ and so on. Likewise, uppercase letters are also grouped together: ‘A’ then ‘B’ then ‘C’ and so on. This numbering system allows us to determine the distance between two letters using subtraction: `'c' - 'a'` is 2 since ‘c’ is 2 letters after ‘a’ in the alphabet. To programmatically compute the letter 8 alphabet positions after ‘a’, use addition and then cast the result to `char`. (The result is the letter ‘i’.)

`char result = (char) ('a' + 8);`

Getting the lowercase version of some text depends on whether the text is a `String` or a `char`. Since strings are objects in Java, we can call the `toLowerCase` instance method. But since `char` values are just numbers, Java provides the `Character.toLowerCase` static method instead.

`String s = "Washington State";
String l = s.toLowerCase();`

`char c = 'W';
char l = Character.toLowerCase(c);`

[Original assessment specification on the Course Website](https://courses.cs.washington.edu/courses/cse143/20au/letter-inventory/)
