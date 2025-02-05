package csc223.vn;

public class DNA {
    public static String countNucleotides(String dna) {
        int countA = 0, countC = 0, countG = 0, countT = 0;
        for(int i = 0; i<dna.length();i++){
            if(dna.charAt(i) == 'A') {
                countA+= 1;
            }
            if(dna.charAt(i) == 'C') {
                countC+= 1;
            }
             if(dna.charAt(i) == 'G') {
                countG+= 1;
             }
             if(dna.charAt(i) == 'T') {
                countT+= 1;
             }
        }
        return countA + " " + countC+ " " + countG+ " " + countT;
    }
    public static String transcribe(String dna){
        String rna ="";
        for(int i = 0; i<dna.length();i++){
            if(dna.charAt(i) == 'T') {
                rna+= 'U';
    }else{
        rna+= dna.charAt(i);
    }
 }
    return rna;
    }
    public static String reverseComplement(String dna){
        String reverseComp = "";
        for(int i = dna.length() -1; i >= 0; i--) {
        char nucleotide = dna.charAt(i);
        if(nucleotide == 'A') {
            reverseComp += 'T';
        } else if(nucleotide == 'T') {
            reverseComp += 'A';
        } else if(nucleotide == 'C') {
            reverseComp += 'G';
        }else if(nucleotide == 'G') {
            reverseComp += 'C';
        }       
    }
    return reverseComp;
 }
 public static void main(String[] args) {
    String dna = "ATCGTA";
    System.out.println("Nucleotide counts: " + DNA.countNucleotides(dna));
    System.out.println("Transcribed RNA: " + DNA.transcribe(dna));
    System.out.println("Reverse complement: " + DNA.reverseComplement(dna));
 }
}