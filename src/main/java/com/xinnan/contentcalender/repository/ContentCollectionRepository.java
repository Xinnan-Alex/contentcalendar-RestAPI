package com.xinnan.contentcalender.repository;

import com.xinnan.contentcalender.model.Content;
import com.xinnan.contentcalender.model.Status;
import com.xinnan.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(content1 -> content1.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);

    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(content1 -> content1.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(content -> content.id().equals(id));
    }
}
