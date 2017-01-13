package com.database;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Dict {
	public static void main(String[] args) {
				try
				{
					String datatoSearch = "Happening quickly";

					Dict g = new Dict();
					g.getReverseWords(datatoSearch);
				}catch(Exception e){
					System.out.println(e);
				}
			}

	public List<String> getReverseWords(String pharse) {
		List<String> myReverseWords = new ArrayList<String>();
		String url1 = "";
		String url = "http://www.onelook.com/?w=*&loc=revfp2&clue=";
		String datatoSearch = "Happening quickly";
		try {
			Document doc = Jsoup.connect(url + pharse).timeout(0).get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				url1 += link.ownText() + "\n";

			}
			int indexStart = url1
					.indexOf("<< Return to the reverse dictionary page");
			System.out.println(indexStart);
			String title = StringUtils.substringBetween(url1,
					"<< Return to the reverse dictionary page",
					"<< Return to the reverse dictionary page");
			System.out.println(myReverseWords.size());

			String[] tile = title.split("\n");
			System.out.println("*********");
			String tableCreation="<table>";
			for (int i = 0; i < tile.length; i++) {
				if(tile[i]!= " "){
				myReverseWords.add(tile[i]);
				tableCreation+="<tr><td>"+tile[i]+"</td></tr>";
				}
				tableCreation+="</table>";

			}
			System.out.println(myReverseWords.size());
			myReverseWords.remove("nouns");
			myReverseWords.remove("Next page >>");
			myReverseWords.remove("More info on wildcards");

			myReverseWords.remove("Home");
			myReverseWords.remove("Reverse Dictionary");
			myReverseWords.remove("Customize");
			myReverseWords.remove("Browse Dictionaries");
			myReverseWords.remove("Privacy");
			myReverseWords.remove("Blog");
			myReverseWords.remove("Help");
			myReverseWords.remove("Blog");
			myReverseWords.remove("Link to us");
			myReverseWords.remove("Word of the Day");
			myReverseWords.remove("adjectives");

			myReverseWords.remove("verbs");
			myReverseWords.remove("adverbs");
			myReverseWords.remove("adjectives");
			myReverseWords.remove(" ");
			System.out.println(myReverseWords.size());
			System.out.println("************");
		//	System.out.println(myReverseWords.toString());
			System.out.println(tableCreation);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myReverseWords;

	}
	/*
	 * try {
			List<String> myReverseWords = new ArrayList<String>();
			String url1 = "";
			String url = "http://www.onelook.com/?w=*&loc=revfp2&clue=";
			String datatoSearch = "Happening quickly";
			Document doc = Jsoup.connect(url + datatoSearch).get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				url1 += link.ownText() + "\n";

			}
			int indexStart = url1
					.indexOf("<< Return to the reverse dictionary page");
			System.out.println(indexStart);
			String title = StringUtils.substringBetween(url1,
					"<< Return to the reverse dictionary page",
					"<< Return to the reverse dictionary page");
			System.out.println(myReverseWords.size());

			String[] tile = title.split("\n");
			// System.out.println(title);
			System.out.println("*********");
			for (int i = 0; i < tile.length; i++) {
				myReverseWords.add(tile[i]);
				// System.out.println(tile[i]);

			}
			System.out.println(myReverseWords.size());
			myReverseWords.remove("nouns");
			myReverseWords.remove("Next page >>");
			myReverseWords.remove("More info on wildcards");

			myReverseWords.remove("Home");
			myReverseWords.remove("Reverse Dictionary");
			myReverseWords.remove("Customize");
			myReverseWords.remove("Browse Dictionaries");
			myReverseWords.remove("Privacy");
			myReverseWords.remove("Blog");
			myReverseWords.remove("Help");
			myReverseWords.remove("Blog");
			myReverseWords.remove("Link to us");
			myReverseWords.remove("Word of the Day");
			myReverseWords.remove("adjectives");

			myReverseWords.remove("verbs");
			myReverseWords.remove("adverbs");
			myReverseWords.remove("adjectives");

			System.out.println(myReverseWords.size());
			System.out.println("************");
			System.out.println(myReverseWords.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	 */

}
