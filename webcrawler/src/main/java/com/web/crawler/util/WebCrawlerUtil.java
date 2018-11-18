package com.web.crawler.util;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.web.crawler.exception.WebCrawlerBusinessException;

public class WebCrawlerUtil {

	public static Set<String> getWebCrawlerList(String url) {
		Set<String> urlElemntList = new HashSet<String>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();

			Elements links = doc.select("a[href]");
			Elements media = doc.select("[src]");
			Elements imports = doc.select("link[href]");

			media.forEach(src -> {
				if (src.tagName().equals("img"))
					urlElemntList.add(print(" * %s: <%s> %sx%s (%s)", src.tagName(), src.attr("abs:src"),
							src.attr("width"), src.attr("height"), trim(src.attr("alt"), 20)));
				else
					urlElemntList.add(print(" * %s: <%s>", src.tagName(), src.attr("abs:src")));
			});

			imports.forEach(link -> {
				urlElemntList.add(print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel")));
			});

			links.forEach(link -> {
				urlElemntList.add(print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel")));
			});
		} catch (Exception e) {
		   throw new WebCrawlerBusinessException(e.getMessage());
		}

		return urlElemntList;
	}

	public static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}

	private static String print(String msg, Object... args) {
		return String.format(msg, args);
	}
	
	

}
