package com.xinnan.contentcalender.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinnan.contentcalender.model.Content;
import com.xinnan.contentcalender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository contentRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository contentRepository, ObjectMapper objectMapper) {
        this.contentRepository = contentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (contentRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
                contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {
                }));
            }
        }
    }
}
