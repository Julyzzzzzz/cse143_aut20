// July Zhou
// Section: AH
// This DNAStrand.java file includes a DNASrand data type that represents
// DNA with nucleotide and functions to find the maximum repeat of
// consecutive substrands in the DNA.

public class DNAStrand {
    private Nucleotide front;
    private int dnaSize;
        
    // construts a new DNAStrand data type with the given dna String
    // representing nucleotide bases.
    public DNAStrand(String dna) {
        dnaSize = dna.length();
        if (dna.isEmpty()) {
            front = null;
        }  else {
            for (int i = dnaSize - 1; i >= 0; i--) {
                Nucleotide temp = new Nucleotide(dna.charAt(i));
                temp.next = front;
                front = temp;
            }
        }  
    }

    // returns the maximum number of consecutive repeated STRs/substrand
    // in the strand. The input is a string of substrand we will be look
    // for in the dna strand. When the substrand is null or empty,
    // throw an IllegalArgumentException.
    public int maxConsecutiveRepeats(DNAStrand substrand) {
        if (substrand == null || substrand.front == null) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        Nucleotide dnaFront = this.front;
        for (int i = 0; i <= this.dnaSize - substrand.dnaSize; i++) {
            int tmp = match(dnaFront, substrand.front);
            if (tmp > max) {
                max = tmp;
            }
            dnaFront = dnaFront.next;
        }
        return max;
    }

    // helper function
    private static int match(Nucleotide dna, Nucleotide substrand) {
        int repeats = 0;
        for ( ; ; ) {
            Nucleotide dnaTemp = dna;
            Nucleotide subTemp = substrand;
            for ( ; dnaTemp != null && subTemp != null; ) {
                if (dnaTemp.data != subTemp.data) {
                    return repeats;
                }
                subTemp = subTemp.next;
                dnaTemp = dnaTemp.next;
            }
            if (subTemp == null) {
                repeats++;
            }
            if (dnaTemp == null) {
                return repeats;
            }
            dna = dnaTemp;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Nucleotide current = front; current != null; current = current.next) {
            result.append(current.data);
        }
        return result.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DNAStrand)) {
            return false;
        }
        return this.toString().equals(o.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public static void main(String[] args) {
        DNAStrand dna = new DNAStrand("CTAGTAGTAGB");
        DNAStrand str = new DNAStrand("TAG");
        //System.out.println(str.toString());
        System.out.println(dna.maxConsecutiveRepeats(str));
    }

    private static class Nucleotide {
        public char data;
        public Nucleotide next;

        public Nucleotide(char data) {
            this.data = data;
            this.next = null;
        }
    }
}
