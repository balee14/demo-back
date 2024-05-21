package com.terry.demo.controller;


import com.terry.demo.core.util.KpPropertyUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BatchIndexController {

    /**
     * ADMIN INDEX
     * @param res
     * @throws Exception
     */

    @GetMapping(value = "/")
    public void batchIndex(HttpServletResponse res) throws Exception {
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        res.getWriter().print("BATCH-" + KpPropertyUtil.getProperty("spring.profiles.active"));
    }

}
