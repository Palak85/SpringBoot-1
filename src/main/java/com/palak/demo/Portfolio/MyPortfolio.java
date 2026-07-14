package com.palak.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {
    @GetMapping("/myself")
    public String Myself(){
        return """
                <h1>Myself</h1>
                <p>Hi, I'm Palak Kumari!
                
                   💫 Aspiring Developer | Tech Enthusiast | Lifelong Learner
                
                   🌱 Passionate about coding, creativity, and continuous growth
                   💻 Love building projects and solving real-world problems
                   🚀 Working towards becoming a skilled software developer </p>
                <ul>
                    <li>Github Link : https://github.com/Palak85/li>
                    <li>Leetcode Link: https://leetcode.com/u/Palak_kumari8340/</li>  
                </ul>
                """;
    }

//    @GetMapping("/Skills")
//    public String skills(){
//        return """
//                <h1> My Skills </h1>
//                """;
//    }
}
