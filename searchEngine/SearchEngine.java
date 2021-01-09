// July Zhou
// Section: AH
// This SearchEngine.java file implements a basic web search engine
// by using a index map to help users find web pages related to the
// search term.

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class SearchEngine {
    private Map<String, Set<String>> indexMap;

    // constructs an empty SearchEngine instance by creating a TreeMap
    // for the index that maps the query term to a set of documents that
    // are associated with the term.
    public SearchEngine() {
        indexMap = new TreeMap<String, Set<String>>();   
    }

    // Takes a document string as an input and indexes the document by associates
    // each term in the document with the document itself. 
    // The split method provided is used to ignore the cases of letters and non-alphabetic
    // characters in the document.
    public void index(String document) {
        Set<String> terms = split(document);
        for (String term : terms) {
            if (!indexMap.containsKey(term)) {
                Set<String> docs = new HashSet<String>(); 
                docs.add(document);
                indexMap.put(term, docs);
            } else {
                Set<String> docs1 = indexMap.get(term);
                docs1.add(document);
                indexMap.put(term, docs1);
            }
        }
    }

    // Takes a query string as an input and returns a list of documents
    // that each document contains all the terms in the query.
    // The split method provided is used to ignore cases of letters and
    // non-alphabetic characters in the query string.
    // Terms that are not included in the index TreeMap are also ignored.
    public Set<String> search(String query) {
        Set<String> words = split(query);
        Set<String> startDoc = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        for (String word : words) {
            if (indexMap.containsKey(word) && result.isEmpty()) {
                result= indexMap.get(word);
            } else if (indexMap.containsKey(word)) {
                Set<String> newdoc = indexMap.get(word);
                Set<String> tempSet = new HashSet<String>();
                for (String doc : result) {
                    if (newdoc.contains(doc)) {
                        tempSet.add(doc);
                    }
                }
                result = tempSet;
                if (result.isEmpty()) {
                    return result;
                }
            }
        }
        return result;
    }

    // Return the set of normalized terms split from the given text
    private static Set<String> split(String text) {
        Set<String> result = new HashSet<>();
        for (String term : text.split("\\s+")) {
            term = normalize(term);
            if (!term.isEmpty()) {
                result.add(term);
            }
        }
        return result;
    }

    // Return a standardized lowercase representation of the given string
    private static String normalize(String s) {
        return s.toLowerCase().replaceAll("(^\\p{P}+\\s*)|(\\s*\\p{P}+$)", "");
    }

    public static void main(String[] args) throws IOException {
        SearchEngine engine = new SearchEngine();
        for (String path : args) {
            engine.index(new String(Files.readAllBytes(Paths.get(path))));
        }
        if (args.length == 0) {
            engine.index("File 1 Title\n\napple BALL carrot");
            engine.index("File 2 Title\n\nball !carrot! ,!Dog*&");
        }
        //System.out.println("1");
        //System.out.println(engine.m);
        //engine.search("b");
        //System.out.println("2");
        //System.out.println(engine.m);
        //engine.search("b z");
        //System.out.println("3");
        System.out.println(engine.indexMap);
        System.out.println(engine.search("carrot"));
        //System.out.println("4");
        //System.out.println(engine.m);
        //System.out.println(engine.search("b z"));
    }
}
