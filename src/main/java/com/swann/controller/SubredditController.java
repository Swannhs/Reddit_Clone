package com.swann.controller;

import com.swann.dto.SubredditDto;
import com.swann.model.Subreddit;
import com.swann.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
    @Autowired
    private SubredditService subredditService;

    @PostMapping
    public ResponseEntity<SubredditDto> createSubreddit(@RequestBody SubredditDto subredditDto){
        SubredditDto dto = subredditService.save(subredditDto);
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<?> getSubreddits(){
        return new ResponseEntity<>(subredditService.getAll(), HttpStatus.ACCEPTED);
    }
}
