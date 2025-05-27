package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/news")


public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {

        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<?> getNews(@RequestParam String keyword) {
        return ResponseEntity.ok(newsService.fetchNews(keyword));
    }
}

