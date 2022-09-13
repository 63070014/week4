package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1+n2;
    }

    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1-num2;
    }

    @RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1/num2;
    }

    @RequestMapping(value = "/multi/{num1}/{num2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1*num2;
    }

    @RequestMapping(value = "/mod/{num1}/{num2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1%num2;
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public double myMax(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return (num1>num2? num1:num2);
    }

}