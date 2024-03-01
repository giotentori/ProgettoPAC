package com.example.pacbackend.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ImageRepository extends JpaRepository<Image,Long> {

    public Optional<Image> findByFileName(String fileName);
    
}
