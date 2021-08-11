package com.credera.examples.cURL;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("curl")
public class CurlPracticeController {
    @PostMapping
    public CurlResponse curlRequestExample(@RequestBody String text, @RequestHeader("content-type") String contentType) {
        CurlResponse curlResponse = new CurlResponse();
        curlResponse.setGreeting(text);
        curlResponse.setContentType(contentType);

        return curlResponse;
    }
}
