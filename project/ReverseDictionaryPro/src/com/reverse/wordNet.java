package com.reverse;
import rita.wordnet.RiWordnet;

public class wordNet {
	
	RiWordnet wordnet = new RiWordnet(null);


	/**
	 * @param args
	 */
	public static void main(String[] args) {

			// Would pass in a PApplet normally, but we don't need to here
			wordNet n = new wordNet();
			n.getReverse("lukewarm");
			
	}
	public String getReverse(String word){
		String reverse="";
		//word = "Moderate ";
		String[] poss = wordnet.getPos(word);
		for (int j = 0; j < poss.length; j++) {
			System.out.println("\n\nSynonyms for " + word + " (pos: " + poss[j] + ")");
			String[] synonyms = wordnet.getAllSynonyms(word,poss[j],10);
			for (int i = 0; i < synonyms.length; i++) {
				System.out.println(synonyms[i]);
				reverse+=synonyms[i]+",";
			}   
		}
		System.out.println(reverse);
		
		return reverse;

		
	}


	}