package com.horizon.to_do_app.Controllers;

import com.horizon.to_do_app.Services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
    @Autowired
    private ItemService itemService;
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("items", itemService.getItems());
        return modelAndView;
    }
}
