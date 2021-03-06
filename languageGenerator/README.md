# Language Generator

*Generating sentences with recursion and randomness.*

In syntactocentric linguistics, **recursive syntax** (embedding phrases within phrases) has been hypothesized to be the critical feature of human language capacity. Although this claim has been challenged in recent decades, generating understandable human language remains a key challenge for computer programming given the infinite expressiveness of human language. Can we define a program to generate all possible English sentences?

Most (if not all) human languages involve combining words in certain ways that correspond to valid sentences. The rules that determine valid and invalid sentences are part of the language’s grammar.

**Formal language**. A set of words and symbols along with a set of production rules defining how those symbols may be used together. For example, “A boy threw the ball.” is a valid sentence, but “A threw boy ball the” makes no sense, because the words were put together in an invalid manner.

**Grammar**. A way of describing the syntax and symbols of a formal language. When constructing sentences, words are put together in grammatically-correct ways using structures such as sentences, noun phrases, and objects. Grammars consist of two types of **symbols** that represent either individual words (**terminal**) or combinations of words such as phrases and sentences (**non-terminal**).

**Generative grammar** is a linguistic theory that supposes a system of rules can be followed to generate every possible grammatical expression in a formal language. For example, consider this formal language with the following terminals and non-terminals.

**Terminals**. the, a, boy, girl, runs, walks

**Non-terminals**

- A sentence consists of an article followed by an object followed by a verb.

- An article consists of either “the” or “a”.

- An object consists of either “boy” or “girl”.

- A verb consists of either “runs” or walks”.

This language contains the following valid sentences.

- the boy runs

- the boy walks

- a boy runs

- a boy walks

- the girl runs

- the girl walks

- a girl runs

- a girl walks

### Specification

Implement a `LanguageGenerator` class that generates valid strings according to the production rules defined by the given `Grammar`. A `Grammar` consists of a `Supplier` field with a `get()` method that returns a `Map<String, String[]>` representing the production rules.

`LanguageGenerator(Grammar grammar)`

Constructs a new `LanguageGenerator` for the given grammar.

`LanguageGenerator(Grammar grammar, Random random)`

Constructs a new `LanguageGenerator` for the given grammar and source of randomness.

`String generate(String target)`

Returns a string generated by following the production rule for the given `target`. The resulting string should be compact: there should be exactly one space between each terminal and no leading or trailing spaces. Choose between potential production rules for the given `target` by calling `random.nextInt` so that each possibility is equally likely to be chosen.

The base case occurs when the `target` is a terminal symbol. Otherwise, in the recursive case (a non-terminal symbol):

1. Choose a random production rule for the given non-terminal `target`.

2. For each symbol in the production rule, recursively `generate` an occurrence of that symbol.

Split a production rule on one or more whitespace characters by calling `split("\\s+")`.

```
String text = "lots of spaces";
String[] terms = text.split("\\s+");
// ["lots", "of", "spaces"]
```

Call the `trim` method to remove leading and trailing whitespace from the final result.

```
String text = "   lots   of  spaces    ";
String trimmed = text.trim();
// "lots   of  spaces"
```

[Original assessment specification on the Course Website](https://courses.cs.washington.edu/courses/cse143/20au/language-generator/)
