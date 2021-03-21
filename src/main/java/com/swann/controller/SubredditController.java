package com.swann.controller;

import com.swann.dto.SubredditDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
    @PostMapping
    public void createSubreddit(@RequestBody SubredditDto subredditDto){

    }
}
