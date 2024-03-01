package com.example.pacbackend.Notebook;


import jakarta.persistence.*;
import lombok.Getter;

import com.example.pacbackend.Notebook.Technical_Features.Disk;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;
import com.example.pacbackend.Photo.Image;



/**
 * Questa classe rappresenta l'oggetto Notebook che potrà essere venduto
 * o acquistato all'interno dell'applicazione
 */

@Entity
@Table
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "modello")
    private String nameModel;
    @Column(name = "marca")
    private String brand;
    @Enumerated(EnumType.STRING)
    @Column(name = "OS")
    private OperatingSystem operatingSystem;
    @Column(name = "grandezza_schermo")
    private int screenSize;
    private int ram;
    @Enumerated(EnumType.STRING)
    @Column(name = "disco")
    private Disk disk;
    private int storage;
    @Column(name = "processore")
    private String cpu;
    @Column(name = "scheda_grafica")
    private String gpu;
    private String description;
    @Column(name = "prezzo")
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_image")
    private Image image;

    @Column(name = "uri_image")
    private String uriImage;



    public Notebook(String nameModel,int screenSize, OperatingSystem operatingSystem,
                    String brand, int ram, int storage,Disk tod,String cpu,String gpu,String description,double price) {
                        
        this.nameModel = nameModel;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.brand = brand;
        this.ram = ram;
        this.disk = tod;
        this. storage = storage;
        this.cpu = cpu;
        this.gpu = gpu;
        this.description = description;
        this.price = price;
    }


    public Notebook() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk tod) {
        this.disk = tod;
    }

    public Image getImage() {
        return image;
    }


    public void setImage(Image image) {
        this.image = image;
        this.uriImage = image.getUriImage();
    }

    public void setUriImage() {
        uriImage = this.image.getUriImage();
    }

    public String getUriImage() {
        return uriImage;
    }
    


}
