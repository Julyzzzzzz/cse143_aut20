# Autocomplete
*Implementing a comparable data type for efficient autocomplete*

Autocomplete is a feature of many modern applications that automatically helps the user complete an input query based on a list of predicted terms. We can implement predictive autocomplete in three steps: sorting the terms by query string; binary searching to find all query strings that start with a given prefix; and sorting the matching terms by relevance.

## Specification
Implement a Term class that represents an autocomplete term—a query string and an associated integer weight. Each instance of the Term class can be compared against other instances of the Term class in two different ways.

1. Compare query by lexicographic order so that terms appear in dictionary order.
2. Compare weight by descending order so that the most heavily-weighted terms appear first.

`Term(String query, int weight)`

Constructs a term with the given non-null `query` string and `weight`.

`int compareTo(Term other)`

Compares to another term in lexicographic order by query and ignoring case.

`int compareToByReverseWeight(Term other)`

Compares to another term in descending order by weight.

`String query()`

Returns this term’s query.

`int weight()`

Returns this term’s weight.

`String toString()`

Returns this term’s query.

## Web app

To launch the web app, Open Terminal `>_`, paste the following command, and press Enter.

`javac Server.java && java Server cities.tsv; rm *.class`

Then, open the Network dropdown and select host 0.0.0.0:8000.

When you’re done, return to the terminal and enter the key combination `Ctrl` `C` to close the server.

[Original assessment specification on the Course Website](https://courses.cs.washington.edu/courses/cse143/20au/autocomplete/#autocomplete)
