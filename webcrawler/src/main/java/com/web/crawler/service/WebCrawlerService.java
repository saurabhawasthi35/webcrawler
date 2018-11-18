package com.web.crawler.service;

import com.web.crawler.exception.WebCrawlerBusinessException;
import com.web.crawler.model.WebCrawler;



public interface WebCrawlerService {
	
	public WebCrawler  getWebCrawlerList(WebCrawler webCrawler) throws WebCrawlerBusinessException;
	//public WebCrawler getWebCrawlerList(String url) throws WebCrawlerBusinessException;
	

}
