package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; //to create restful API
import java.util.*;


@Service

public class NewsService {

    private final RestTemplate restTemplate;

    @Value("${newsapi.key}")
    private String API_KEY;

    public NewsService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Article> fetchNews(String keyword){

        //Change here with your own API keys

        String url = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + API_KEY;
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        System.out.println("Fetched Articles:");
        response.getArticles().forEach(a -> System.out.println(a.getTitle()));


        return response != null ? response.getArticles() : new ArrayList<Article>(); //can change to Collection.emptyList()
    }
}
