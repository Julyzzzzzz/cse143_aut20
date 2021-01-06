// July Zhou
// Section: AH
// This Term.java file includes a Term class which represents an autocomplete term
// includes a string query and an integer weight. The terms can be compared to another
// term in different ways.

public class Term implements Comparable<Term>{
    private String query;
    private int weight;

    // Constructs a term with two inputs as a string query and a integer weight 
    public Term(String query, int weight) {
        this.query = query;
        this.weight = weight;
    }

    // Compares to another term in lexicographic order and return a compareTo value
    // case ignored
    public int compareTo(Term other) {
        String copy = query.toLowerCase();
        int cmp = copy.compareTo(other.query.toLowerCase());
        return cmp;
    }

    // Compares to another term in descending order by weight and return a compareTo value
    // the compareto value needs to time (-1) to indicate the reverse weight comparison
    public int compareToByReverseWeight(Term other) {
        int cmp = Integer.compare(this.weight, other.weight);
        return cmp*(-1);
    }

    // Returns the term's query
    public String query() {
        return query;
    }

    // Returns the term's weight
    public int weight() {
        return weight;
    }

    // Returns the result of the query() method which is the term's query
    public String toString() {
        return query();
    }

    // main method to construct new terms and call methods
    public static void main(String[] args) {
        Term t1 = new Term("Shanghai, China", 0);
        Term t2 = new Term("Buenos Aries, Argentina", 1);
        int cmp = t1.compareTo(t2);
        System.out.println(cmp);
    }
}
