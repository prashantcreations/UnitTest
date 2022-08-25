package com.example.juint2;

import org.springframework.boot.test.context.SpringBootTest;


// test class package name and controller packge name is not same then have to mention package name externally
@SpringBootTest(classes = com.example.juint.UnitTestApplication.class )
public class SecondTest {

}
