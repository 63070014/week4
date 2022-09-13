package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{number}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("number") int number) {
        Change c1 = new Change();
        while (number>0) {
            if (number >= 1000) {
                c1.setB1000(c1.getB1000()+1);
                number -= 1000;
            }
            else if (number >= 500 && number < 1000) {
                c1.setB500(c1.getB500()+1);
                number -= 500;
            }
            else if (number >= 100 && number < 500) {
                c1.setB100(c1.getB100()+1);
                number -= 100;
            }
            else if (number >= 20 && number < 100) {
                c1.setB20(c1.getB20()+1);
                number -= 20;
            }
            else if (number >= 10 && number < 20) {
                c1.setB10(c1.getB10()+1);;
                number -= 10;
            }
            else if (number >= 5 && number < 10) {
                c1.setB5(c1.getB5()+1);
                number -= 5;
            }
            else if (number >= 1 && number < 5) {
                c1.setB1(c1.getB1()+1);
                number -= 1;
            }
        }
        return c1;
    }
}
