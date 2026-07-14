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

    @GetMapping("/skills")
    public String Skills(){
        return """
                <h1> My Skills </h1>
                <ul>
                <li> Languages : C/C++, Java </li>
                <li> Web Technologies : HTMl , CSS , Tailwind CSS, ReactJS, NodeJS </li>
                <li> Tools/Platform : Git , GitHub , Visual Studio Code , Figma , Canva </li>
                <li> Soft Skills : Problem solving , Time management , Teamwork </li> 
                </ul>
                """;
    }

    @GetMapping("/education")
    public String Education(){
        return """
                <h1> Education </h1>
                <ul>
                    <li>
                        <h3>Lovely Professional University</h3>
                        <p>B.Tech - Computer Science and Engineering</p>
                        <p>Since Aug 2023</p>
                    </li>    
                    
                    <br>

                    <li>
                        <h3>MD Carmel School, Buxar</h3>
                        <p>Intermediate (PCM)</p>
                        <p>2021 - 2022</p>
                    </li>

                    <br>

                    <li>
                        <h3>MD Carmel School, Buxar</h3>
                        <p>Matriculation</p>
                        <p>2019 - 2020</p>
                    </li>                                                       
                </ul>
                """;
    }
//
//    @GetMapping("/project")
//    public String Project(){
//        return """
//                <h1>Project</h1>
//
//                """;
//    }


}
