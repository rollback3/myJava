package org.cg.GolarionScraper;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GolarionTalenti {

	private static String replaceSpaces(String stringGetted) {
		String newString = null;
		newString = stringGetted.replace(" ", "_");
		return newString;
	}

	public static String getTalento(String talento) throws IOException {
		String url = "https://golarion.altervista.org/wiki/" + talento;
		String result = null;

		Document doc = Jsoup.connect(url).get();
		ArrayList<String> talentoName = new ArrayList<String>();
		Elements tmp2 = doc.select("div.mw-parser-output");
		for (Element titolo : tmp2) {
			// System.out.println(titolo.getElementsByTag("h3").text());
			talentoName.add(titolo.getElementsByTag("h3").text());
		}
		ArrayList<String> talentoDescription = new ArrayList<String>();
		Elements tmp3 = doc.select("div.mw-parser-output");
		for (Element body : tmp3) {
			// System.out.println(body.getElementsByTag("b3").text());
			// System.out.println(body.getElementsByTag("p").text());
			talentoDescription.add(body.getElementsByTag("b3").text());
			talentoDescription.add(body.getElementsByTag("p").text());
		}
		result = talentoName.toString() + "\n" + talentoDescription.toString();
		replaceSpaces(result);
		return result;
	}
}
