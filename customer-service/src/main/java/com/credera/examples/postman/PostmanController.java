package com.credera.examples.postman;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/postman")
public class PostmanController {

    @PostMapping
    public boolean httpHeaderTest(HttpServletRequest request) {
        printHeaders(request);
        return true;
    }

    private void printHeaders(HttpServletRequest request) {
        var headerIterator = request.getHeaderNames().asIterator();

        while (headerIterator.hasNext()) {
            var headerName = headerIterator.next();
            System.out.println(headerName + " : " + request.getHeader(headerName));
        }
    }
}
