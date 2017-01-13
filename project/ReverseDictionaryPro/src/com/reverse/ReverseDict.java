package com.reverse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Dict;

/**
 * Servlet implementation class ReverseDict
 */
@WebServlet("/ReverseDict")
public class ReverseDict extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReverseDict() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pharse = request.getParameter("pharse");
		Dict db = new Dict();
		List<String> reverseWords = new ArrayList<>();
		reverseWords = db.getReverseWords(pharse);
	
		System.out.println(pharse);
		// remove stopwords !

		String[] stopwords = { "a", "about", "above", "above", "across",
				"after", "afterwards", "again", "against", "all", "almost",
				"alone", "along", "already", "also", "although", "always",
				"am", "among", "amongst", "amoungst", "amount", "an", "and",
				"another", "any", "anyhow", "anyone", "anything", "anyway",
				"anywhere", "are", "around", "as", "at", "back", "be",
				"became", "because", "become", "becomes", "becoming", "been",
				"before", "beforehand", "behind", "being", "below", "beside",
				"besides", "between", "beyond", "bill", "both", "bottom",
				"but", "by", "call", "can", "cannot", "cant", "co", "con",
				"could", "couldnt", "cry", "de", "describe", "detail", "do",
				"done", "down", "due", "during", "each", "eg", "eight",
				"either", "eleven", "else", "elsewhere", "empty", "enough",
				"etc", "even", "ever", "every", "everyone", "everything",
				"everywhere", "except", "few", "fifteen", "fify", "fill",
				"find", "fire", "first", "five", "for", "former", "formerly",
				"forty", "found", "four", "from", "front", "full", "further",
				"get", "give", "go", "had", "has", "hasnt", "santhosh", "have",
				"he", "hence", "her", "here", "hereafter", "hereby", "herein",
				"hereupon", "hers", "herself", "him", "himself", "his", "how",
				"however", "hundred", "ie", "if", "in", "inc", "indeed",
				"interest", "into", "is", "it", "its", "itself", "keep",
				"last", "latter", "latterly", "least", "less", "ltd", "made",
				"many", "may", "me", "meanwhile", "might", "mill", "mine",
				"more", "moreover", "most", "mostly", "move", "much", "must",
				"my", "myself", "name", "namely", "neither", "never",
				"nevertheless", "next", "nine", "no", "nobody", "none",
				"noone", "nor", "not", "nothing", "now", "nowhere", "of",
				"off", "often", "on", "once", "one", "only", "onto", "or",
				"other", "others", "otherwise", "our", "ours", "ourselves",
				"out", "over", "own", "part", "per", "perhaps", "please",
				"put", "rather", "re", "same", "see", "seem", "seemed",
				"seeming", "seems", "serious", "several", "she", "should",
				"show", "side", "since", "sincere", "six", "sixty", "so",
				"some", "somehow", "someone", "something", "sometime",
				"sometimes", "somewhere", "still", "such", "system", "take",
				"ten", "than", "that", "the", "their", "them", "themselves",
				"then", "thence", "there", "thereafter", "thereby",
				"therefore", "therein", "thereupon", "these", "they", "thickv",
				"thin", "third", "this", "those", "though", "three", "through",
				"throughout", "thru", "thus", "to", "together", "too", "top",
				"toward", "towards", "twelve", "twenty", "two", "un", "under",
				"until", "up", "upon", "us", "very", "via", "was", "we",
				"well", "were", "what", "whatever", "when", "whence",
				"whenever", "where", "whereafter", "whereas", "whereby",
				"wherein", "whereupon", "wherever", "whether", "which",
				"while", "whither", "who", "whoever", "whole", "whom", "whose",
				"why", "will", "with", "within", "without", "would", "yet",
				"you", "your", "yours", "yourself", "yourselves", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "1.", "2.", "3.",
				"4.", "5.", "6.", "11", "7.", "8.", "9.", "12", "13", "14",
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z", "terms", "CONDITIONS", "conditions", "values",
				"interested.", "care", "sure", ".", "!", "@", "#", "$", "%",
				"^", "&", "*", "(", ")", "{", "}", "[", "]", ":", ";", ",",
				"<", ".", ">", "/", "?", "_", "-", "+", "=", "a", "b", "c",
				"d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
				"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"contact", "grounds", "buyers", "tried", "said,", "plan",
				"value", "principle.", "forces", "sent:", "is,", "was", "like",
				"discussion", "tmus", "diffrent.", "layout", "area.", "thanks",
				"thankyou", "hello", "bye", "rise", "fell", "fall", "psqft.",
				"http://", "km", "miles", "brought" };

		ArrayList<String> holdWords = new ArrayList<String>();// word in db
		ArrayList<String> wordsDb = new ArrayList<String>();// word in db
		String splitWord[] = pharse.split(" ");
		List<String> output = new ArrayList<String>();
		List<String> inputWordNet = new ArrayList<String>();


		for (int i = 0; i < splitWord.length; i++) {
			holdWords.add(splitWord[i]);
		}

		for (int k = 0; k < stopwords.length; k++) {

			wordsDb.add(stopwords[k]);
		}
		for (int j = 0; j < holdWords.size(); j++) {
			if (wordsDb.contains(holdWords.get(j))) {
				System.out.println("Equals >>" + holdWords.get(j));
			} else {
				output.add(holdWords.get(j));
				System.out.println("Not Equals >>" + holdWords.get(j));
			}
		}
		// print keywords ...
		String keyword = "";
		for (int g = 0; g < output.size(); g++) {
			keyword += output.get(g) + " ";
		}
		System.out.println("**********KEYWORDS***********");
		System.out.println(keyword);
		System.out.println("*****************************");
		
		//send to NLP parser to find noun and verb!
		ParserDemo1 demo =  new ParserDemo1();
		List<String> nouns = new ArrayList<>();
		nouns=demo.stripWords(keyword);
		System.out.println("*********NOUN*********");
		System.out.println(nouns);
		wordNet wordReverse = new wordNet();
		//send keywords to WordNet !
		String outputResponce="";
			for(int t=0;t<nouns.size();t++){
			outputResponce+=	wordReverse.getReverse(nouns.get(t).toString());
			}
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(outputResponce);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			// get only first few words from arrayList 
			List<String> subList = null;
			String tableCreation="<table>";
				System.out.println(reverseWords.isEmpty());
				System.out.println(reverseWords.toString());
			if(reverseWords.size()==0 || reverseWords.size()<15){
				System.out.println("im in if sublist");
				tableCreation+="<tr><td>No data Found</td></tr>";
				response.getWriter().write(tableCreation);
			}
			else{
				System.out.println("im in elseif sublist");
				 subList = reverseWords.subList(0, 15);
				System.out.println(subList.size());

			System.out.println("**********************");
			System.out.println("Size :"+subList.size());
			for(int i=0;i<subList.size();i++){
				tableCreation+="<tr><td>"+subList.get(i)+"</td></tr>";
			}
			
			System.out.println("**********************");

			System.out.println(subList.toString());
			List<String> removedSpace = new ArrayList<>();
			Iterator iter = subList.iterator();
			while (iter.hasNext()) {
				String object = (String) iter.next();
				if(!object.equals(" ")){
			//	System.out.println("ss = "+object);
				}
				if(object!=" "){
			//		System.out.println("ss = "+object);

				}
			}
			System.out.println("**********************"+outputResponce);

			
			
		response.getWriter().write(tableCreation);
			
			}}
	
	

}
