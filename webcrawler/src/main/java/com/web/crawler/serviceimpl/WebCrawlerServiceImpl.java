package com.web.crawler.serviceimpl;

import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.common.util.StringUtils;

import com.web.crawler.exception.WebCrawlerBusinessException;
import com.web.crawler.model.WebCrawler;
import com.web.crawler.service.WebCrawlerService;
import com.web.crawler.util.WebCrawlerUtil;


@Path("/webcrawlerservice/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebCrawlerServiceImpl implements WebCrawlerService {

	@POST
	@Path("/getWebCrawlerList/")
	public WebCrawler getWebCrawlerList(WebCrawler webCrawler) {
		System.out.println("@POST Method");
		try {
			if (StringUtils.isEmpty(webCrawler.getUrl())) {
				webCrawler.setErrorMessage("Provide the URL info");
				throw new WebCrawlerBusinessException("Provide the URL info");
			}
			isValidUrl(webCrawler);
			webCrawler.setWebCrawlerList(WebCrawlerUtil.getWebCrawlerList(webCrawler.getUrl()));
		} catch (WebCrawlerBusinessException e) {
			if (StringUtils.isEmpty(webCrawler.getErrorMessage())) {
				webCrawler.setErrorMessage("ERROR occured During process , Please contact your administrator");
			}

		}
		return webCrawler;
	}

	public void isValidUrl(WebCrawler webCrawler) {
		try {
			new URL(webCrawler.getUrl()).toURI();
		} catch (Exception e) {
			webCrawler.setErrorMessage("Incorrect Url format");
			throw new WebCrawlerBusinessException("Provide the URL info");
		}
	}

}
