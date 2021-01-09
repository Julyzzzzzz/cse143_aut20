# Search Engine

Web search engines are software systems that organize information on the internet so that users can discover web pages related to a search query. We can implement a basic web search engine by building an *inverted index* (also known as an *index*) that maps each term (word) to the set of web pages in which it appears. A search query, which is a sequence of one or more terms, can be answered by returning the web pages that contain all of the terms.

# Specification

Implement a `SearchEngine` class that represents an inverted index.

`SearchEngine()`

Constructs an empty `SearchEngine` instance.

`void index(String document)` 

Indexes the `document` by associating each term in the `document` with the `document` itself. This method will be called for each web page that the client wants to add to the search engine.

`Set<String> search(String query)`

Returns the set of documents where each document contains all of the terms in the given `query` ignoring any never-indexed terms. If none of the terms have been indexed or if the `query` is empty, then an empty set is returned. One way to implement this is to start with all of the documents associated with any one of the indexed terms in the `query` and then remove all of the documents not associated with each of the other indexed terms in the `query`.

Split strings using the provided `split` method that returns a `Set<String>` terms.

[Original assessment specification on the Course Website](https://courses.cs.washington.edu/courses/cse143/20au/search-engine/)
