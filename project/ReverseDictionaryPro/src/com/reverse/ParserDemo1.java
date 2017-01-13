package com.reverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

public class ParserDemo1 {

	/** Usage: ParserDemo2 [[grammar] textFile] */
	public static void main(String[] args) throws IOException {

		ParserDemo1 demo = new ParserDemo1();
		//demo.stripWords();
		 String sent3 = "This is one last test run!";
		// lp.parse(sent3).pennPrint();
		 demo.stripWords(sent3);
	}

	public List<String> stripWords(String pharse) {
		List<String> nounparsed = new ArrayList<String>();
		String outputString = null;
		String grammar = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
		String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
		LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
		TreebankLanguagePack tlp = lp.getOp().langpack();
		GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();

		Iterable<List<? extends HasWord>> sentences;

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		/*try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(
									new File(
											"C:\\Users\\SanWin\\Desktop\\facebookSentiment1.txt"))));
			String tmp = null;

			while ((tmp = br.readLine()) != null) {
				sb.append(tmp + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
*/		String s = pharse;;
		System.out.println("The sentence is == " + s);
		String[] sent = new String[] { s };
		System.out.println("count == " + sent.length);
		/*
		 * List<HasWord> sentence = new ArrayList<HasWord>(); for (String word :
		 * sent) { System.out.println("word == "+word); sentence.add(new
		 * Word(word)); }
		 */

		// String sent2 = ("This is a slightly longer and more complex " +
		// "sentence requiring tokenization.");
		String sent2 = s;
		Tokenizer<? extends HasWord> toke = tlp.getTokenizerFactory()
				.getTokenizer(new StringReader(sent2));
		List<? extends HasWord> sentence2 = toke.tokenize();
		List<List<? extends HasWord>> tmp = new ArrayList<List<? extends HasWord>>();
		// tmp.add(sentence);
		tmp.add(sentence2);
		sentences = tmp;
		// }

		for (List<? extends HasWord> sentence1 : sentences) {
			Tree parse = lp.parse(sentence1);
			parse.pennPrint();// copy this to notepad....
			
			String toFile = parse.pennString();
			
			System.out.println();
			GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
			Collection<TypedDependency> tdl = gs.allTypedDependencies();
			Iterator<TypedDependency> iter = tdl.iterator();
			while (iter.hasNext()) {
				TypedDependency td = iter.next();
				// if(td.reln().toString().equals("conj")){
				System.out.println(td);
				/*
				 * String govString = td.gov().toString(); String first[] =
				 * govString.split("-"); int wordIndex =
				 * Integer.parseInt(first[1]);
				 * 
				 * String depString = td.dep().toString(); String second[] =
				 * depString.split("-"); }
				 */
			}
			// System.out.println("tdl == "+tdl);
			System.out.println();

			System.out.println("The words of the sentence:");
			for (Label lab : parse.yield()) {
				if (lab instanceof CoreLabel) {
					// System.out.println(((CoreLabel) lab).toString("{map}"));
					// System.out.println("core label...");
				} else {
					// System.out.println(lab);
					// System.out.println("not core label");
				}
			}
			System.out.println();
			// System.out.println("***** "+parse.taggedYield());
			List<TaggedWord> listTagged = parse.taggedYield();
			TaggedWord[] taggedWords = new TaggedWord[listTagged.size()];
			TaggedWord[] taggedWord = parse.taggedYield().toArray(taggedWords);

			int markWordIndex = 0;
			String reservedWords = "";
			for (int i = 0; i < taggedWord.length; i++) {
				TaggedWord tagWord = taggedWord[i];
				System.out.println(tagWord.tag() + "==" + tagWord.word());
				String tag = tagWord.tag();

				if (tag.equals("VB") ||tag.equals("RB") || tag.equals("VBD")|| tag.equals("VBG")|| 
						tag.equals("VBN")|| tag.equals("VBP")|| tag.equals("VBZ")|| tag.equals("JJ")|| tag.equals("JJR")|| tag.equals("JJS")) {
					markWordIndex = i;
					nounparsed.add(tagWord.word());

					//break;
				}
				reservedWords += tagWord.word() + " ";
				System.out.println(""+reservedWords);
			}
			// System.out.println(markWordIndex);
			reservedWords = reservedWords.substring(0,
					reservedWords.length() - 1);
			// System.out.println(reservedWords);
			int index = reservedWords.lastIndexOf(" ");
			System.out.println(index);
			String newTemp = "";
			if (index != -1) {
				newTemp = reservedWords.substring(0, index);
			}System.out.println("*");
			 System.out.println(newTemp);
			String nextSen = "";
			String remaining = "";
			for (int i = 0; i < taggedWord.length; i++) {
				TaggedWord tagWord = taggedWord[i];
				if (i > markWordIndex) {
					nextSen += tagWord.word() + " ";
				}
				if (i > markWordIndex + 1) {
					remaining += tagWord.word() + " ";
				}

			}
		/*	System.out.println(newTemp + " " + nextSen);
			System.out.println(reservedWords + " " + remaining);
			// listTagged.remove(markWordIndex);
			
			  System.out.println("********************************");
			  System.out.println(newTemp); 
			  System.out.println(nextSen);
			  System.out.println(reservedWords); 
			  System.out.println(remaining);
			  
			  System.out.println("********************************");
		*/	 outputString = reservedWords;

		}
		
		  System.err.println("NOUN");
		  System.err.println(nounparsed);
		 return nounparsed;

	}

}