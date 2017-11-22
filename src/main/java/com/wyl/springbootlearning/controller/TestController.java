package com.wyl.springbootlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("say/{id}")
    public String say(@PathVariable("id") int id) {
        return "index";
    }

    @GetMapping("say2")
    public String say2(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        model.addAttribute("id", id);
        return "index";
    }

    @GetMapping("/page1")
    public ModelAndView page1() {
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("content", "hello");
        return mav;
    }
}
