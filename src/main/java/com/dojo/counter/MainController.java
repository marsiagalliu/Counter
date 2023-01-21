package com.dojo.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(HttpSession session) {

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        else {
            int count = (int) session.getAttribute("count");
            count++;
            session.setAttribute("count", count);
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String showCount(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow", currentCount);
        return "showCount.jsp";

    }
}
