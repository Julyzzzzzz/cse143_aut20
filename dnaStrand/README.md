# DNA Strand
*Implementing a DNA data type for scientific computing.*

Computational biology is an interdisciplinary area of computer science focused on programming computers to understand biological data, such as DNA, the carrier of genetic information in living things. Each **DNA strand** is made up of smaller units called nucleotides. There are four different nucleotides present in DNA: A, C, G, and T. Every human cell has billions of nucleotides, some of which are the same (or at least very similar) across almost all humans while other portions vary across the population. Computer programs can be used to analyze DNA for criminal justice and to simulate biological processes for scientific research.

#### DNA profiling

The process of determining an individual’s genetic fingerprint for use in criminal justice. One place where DNA tends to have high genetic diversity is in **Short Tandem Repeats** (STRs). An STR is a short sequence of nucleotides that tends to repeat consecutively numerous times at specific locations inside human DNA. The number of times any particular STR repeats varies a lot among individuals. In the DNA samples below, for example, Alice has the STR AGAT repeated four times in her DNA, while Bob has the same STR repeated five times.2

##### Alice

CT**AGATAGATAGATAGAT**GACTA

##### Bob

CT**AGATAGATAGATAGATAGAT**T

### Specification

Implement a `DNAStrand` data type that represents DNA with linked `Nucleotide` nodes.

`DNAStrand(String dna)`

Constructs a new `DNAStrand` with the given `dna` string representing nucleotide bases.

`int maxConsecutiveRepeats(DNAStrand substrand)`

Returns the maximum number of consecutive repetitions of the nucleotides in `substrand` found within this strand. Throws an `IllegalArgumentException` if the `substrand` is null or empty. Assume the `substrand` is strictly shorter than `this`. Make sure to consider every node as a potential starting position for the maximum consecutive repeats.

There are a few additional requirements.

- Do not construct any arrays, lists, strings, or other data structures.

- Only the `DNAStrand` constructor may create new `Nucleotide(...)` instances.

[Original assessment specification on the Course Website](https://courses.cs.washington.edu/courses/cse143/20au/dna-strand/)
