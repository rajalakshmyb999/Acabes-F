package com.textfile.reading;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class TextFileController {
    @GetMapping
    public String getData() throws IOException {
        //Read the content of the text file
        ClassPathResource resource = new ClassPathResource("text.txt");
        byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String fileContent = new String(data, StandardCharsets.UTF_8);
        //You can parse the file content into your Data class or return it as a String
        return fileContent;
    }
}
