package com.terry.demo.controller;

import com.terry.demo.core.util.KpPropertyUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CeoIndexController {

    /**
     * ADMIN INDEX
     * @param res
     * @throws Exception
     */

    @GetMapping(value = "/")
    public void ceoIndex(HttpServletResponse res) throws Exception {
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        res.getWriter().print("CEO-" + KpPropertyUtil.getProperty("spring.profiles.active"));
    }
}
