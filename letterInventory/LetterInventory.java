// July Zhou
// Section: AH
// This LetterInventory.java file includes a LetterInventory data type
// that represents an inventory of the 26 English letters. 

public class LetterInventory {
    private int[] inventory;
    private int size;

    public static final int ALPHABET_SIZE = 26;
    // Constructs an inventory of letters with capacity of 26 elements;
    // cases of letters and non-alphabetic characters are ignored;
    // total count of each letter/element in the given string will be stored.
    public LetterInventory(String data) {
        inventory = new int[ALPHABET_SIZE];
        data = data.replaceAll("[^a-zA-Z]", "").toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            int j = data.charAt(i) - 'a';
            inventory[j] ++;
            size ++;
        }
    }

    // Returns a count of how many times the given letter are in the inventory;
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    // throws an IllegalArgumentException when a nonalphabetic letter is passed.
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        } else {
            return inventory[Character.toLowerCase(letter) - 'a'];
        }
    }

    // Sets the count of the given letter to the given count value;
    // ignoring the case of letters and ignoring any non-alphabetic characters.
    // throws an IllegalArgumentException when the input letter is nonalphabetic
    // letter or the input value if negative.
    public void set(char letter, int value) {
        if (!Character.isLetter(letter) | value < 0) {
            throw new IllegalArgumentException();
        } else {
            int n = Character.toLowerCase(letter) - 'a';
            size += value - inventory[n];
            inventory[n] = value;
        }
    }

    // Returns the total counts of letters in the inventory.
    public int size() {
        return size;
    }

    // Returns true if the inventory is empty, returns false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns a string represents the input string with all letters lowercased
    // and sorted and surrounded by square bracket.
    public String toString() {
        String result = "";
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < inventory[i]; j++) {
                result += (char)(i + 'a');
            }
        }
        return "[" + result + "]";
    }

    // Constructs and returns a new letterinventory object that represents the sum of
    // the original string and the new added string.
    public LetterInventory add(LetterInventory other) {
        LetterInventory addNew = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            addNew.inventory[i] = this.inventory[i] + other.inventory[i];
        }
        addNew.size = this.size + other.size;
        return addNew;
    }

    // Constructs and returns a new letterinventory object that represents the reminder
    // of the original string subtracting the input string; returns null if negative count.
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory subNew = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            subNew.inventory[i] = this.inventory[i] - other.inventory[i];
            if (subNew.inventory[i] < 0) {
                return null;
            }
        }
        subNew.size = this.size - other.size;
        return subNew;
    }

    // Main method to call all the methods
    public static void main(String[] args) {
        LetterInventory inventory = new LetterInventory("washington state");
        System.out.println(inventory.get('a'));
    }

    // Returns true if the other object stores the same character counts as this inventory.
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LetterInventory)) {
            return false;
        }
        LetterInventory other = (LetterInventory) o;
        LetterInventory diff = this.subtract(other);
        return diff != null && diff.isEmpty();
    }

    // Returns a hash code value for this letter inventory.
    public int hashCode() {
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            result += c * get(c);
        }
        return result;
    }

    // Returns the cosine similarity between this inventory and the other inventory.
    public double similarity(LetterInventory other) {
        long product = 0;
        double thisNorm = 0;
        double otherNorm = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int a = this.get(c);
            int b = other.get(c);
            product += a * (long) b;
            thisNorm += a * a;
            otherNorm += b * b;
        }
        if (thisNorm <= 0 || otherNorm <= 0) {
            return 0;
        }
        return product / (Math.sqrt(thisNorm) * Math.sqrt(otherNorm));
    }
}
