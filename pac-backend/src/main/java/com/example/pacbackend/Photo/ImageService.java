package com.example.pacbackend.Photo;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image findByFileName(String fileName) {
        Optional<Image> optionalImage = imageRepository.findByFileName(fileName);
        if(!optionalImage.isPresent())
            throw new IllegalStateException("Image not found");
        Image image = optionalImage.get();
        return image;
    }

    //Metodo per postare immagine fornita sottoforma di File
    public String postImage (MultipartFile file) throws Exception {
        //Scompongo il file nelle varie componenti per creare l'oggetto Image
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setMimeType(file.getContentType());
        image.setData(file.getBytes());
        image.setUriImage("http://localhost:8080/images/"+image.getFileName());
      

        imageRepository.save(image);
        return image.getUriImage();
    }

    //Metodo per postare immagine fornita sottoforma di Image
    public String postImage (Image image) throws Exception {
        imageRepository.save(image);
        return "http://localhost:8080/images/"+image.getFileName();
    }




}
