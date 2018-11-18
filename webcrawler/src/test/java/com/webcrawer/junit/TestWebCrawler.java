package com.webcrawer.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.web.crawler.model.WebCrawler;
import com.web.crawler.util.WebCrawlerUtil;

public class TestWebCrawler {
	
	WebCrawler webCrawler = null;
	Document doc = null;

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - Testing is started");
	}

	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@@AfterClass - Testing is ended");
	}

	@Before
	public void runBeforeTestMethod() {
		System.out.println("@Before - Object in initilizing");
		webCrawler = new WebCrawler();
		webCrawler.setUrl("http://www.wipro.com");
		try {
			doc = Jsoup.connect(webCrawler.getUrl()).get();
		} catch (IOException e) {
			System.err.println("URl is not valid");
		}
	}

	@After
	public void runAfterTestMethod() {
		System.out.println("@After - Object in destroying");
		webCrawler =null;
	}

	@Test
	public void validateUrl() {
		System.out.println("Url Validating.....");
		try {
			new URL(webCrawler.getUrl()).toURI();
			assertTrue(true);
		} catch (MalformedURLException | URISyntaxException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	@Test
	public void getWebCrawler() {
		Set<String> listOfWebcrawler = WebCrawlerUtil.getWebCrawlerList(webCrawler.getUrl());
		System.out.println("get Web crawler list" +listOfWebcrawler.size());
		if(listOfWebcrawler!=null & listOfWebcrawler.size()>0) {
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
	
	@Test
	public void getWebCrawlerMedia() {
		System.out.println("Validating Image contain in URL");
		Elements media = doc.select("[src]");
		assertNotNull(media);
		
	}
	
	@Test
	public void getWebCrawlerLinks() {
		System.out.println("Validating link contain in URL");
		Elements links = doc.select("a[href]");
		assertNotNull(links);
		
	}
	
	
	@Test
	public void getWebCrawImports() {
		System.out.println("Validating imports contain in URL");
		Elements imports = doc.select("link[href]");
		assertNotNull(imports);
		
	}
}
