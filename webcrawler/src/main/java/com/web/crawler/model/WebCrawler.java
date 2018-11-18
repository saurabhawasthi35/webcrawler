package com.web.crawler.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WebCrawler")
public class WebCrawler {

	private String url;

	private Set<String> webCrawlerList;

	private String errorMessage;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<String> getWebCrawlerList() {
		return webCrawlerList;
	}

	public void setWebCrawlerList(Set<String> webCrawlerList) {
		this.webCrawlerList = webCrawlerList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
