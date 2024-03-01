package com.example.pacbackend.Photo;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;                               //Identificativo immagine

    @Column(name = "filename")
    private String fileName;                       //Nome dell'immagine

    @Column(name = "mimetype")
    private String mimeType;

    private byte[] data;                            //byte dell'immagine da salvare

    @Column(name = "uri")
    private String uriImage;                        //Indirizzo sul quale viene esposta l'immagine


    public String getUriImage() {
        return uriImage;
    }

    public void setUriImage(String uriImage) {
        this.uriImage = uriImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
}
