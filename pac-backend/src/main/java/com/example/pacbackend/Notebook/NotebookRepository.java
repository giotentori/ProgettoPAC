package com.example.pacbackend.Notebook;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pacbackend.Notebook.Technical_Features.Disk;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;

/**
 * Interfaccia responsabile dell'interazione con il database
 */

@Repository
public interface NotebookRepository extends JpaRepository<Notebook,Long> {

    Optional<Notebook> findByNameModel(String nameModel);

    List<Notebook> findByBrand(String brand);

    List<Notebook> findByOperatingSystem(OperatingSystem operatingSystem);

    List<Notebook> findByScreenSize(int screenSize);

    List<Notebook> findByRam(int ram);

    List<Notebook> findByStorage(int storage);

    List<Notebook> findByGpu(String gpu);

    List<Notebook> findByCpu(String gpu);

    List<Notebook> findByPriceGreaterThanEqual(double price);

    List<Notebook> findByPriceLessThanEqual(double price);

    List<Notebook> findByPriceBetween(double minPrice,double MaxPrice);

    List<Notebook> findByDisk(Disk disk);

    /*
     * Metodi per la ricerca completa
     */

     //Ricerca per OS,RAM e Storage
     List<Notebook> findByOperatingSystemAndRamAndStorage(OperatingSystem operatingSystem,Integer ram,Integer storage);

    //Ricerca per tutti i campi e intervallo di prezzo
    List<Notebook> findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceBetween(Integer screenSize,OperatingSystem operatingSystem,String brand, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double minPrice,Double maxPrice);
    
    //Ricerca per tutti i campi con prezzo minimo 
    List<Notebook> findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceGreaterThanEqual(Integer screenSize,OperatingSystem operatingSystem,String brand, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double minPrice);
    
    //Ricerca per tutti i campi con prezzo massimo 
    List<Notebook> findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceLessThanEqual(Integer screenSize,OperatingSystem operatingSystem,String brand, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double maxPrice);

    //Ricerca per tutti i campi senza vincoli di prezzo                
    List<Notebook> findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpu(Integer screenSize,OperatingSystem operatingSystem,String brand, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu);
    
    //Ricerca per tutti i campi tecnici (senza marca) con intervallo di prezzo
    List<Notebook> findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceBetween(Integer screenSize,OperatingSystem operatingSystem, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double minPrice,Double maxPrice);

    //Ricerca per tutti i campi tecnici (senza marca) con prezzo minimo
    List<Notebook> findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceGreaterThanEqual(Integer screenSize,OperatingSystem operatingSystem, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double minPrice);

    //Ricerca per tutti i campi tecnici (senza marca) con prezzo massimo
    List<Notebook> findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceLessThanEqual(Integer screenSize,OperatingSystem operatingSystem, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu,Double maxPrice);
                    
    //Ricerca per tutti i campi tecnici (senza marca)
    List<Notebook> findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpu(Integer screenSize,OperatingSystem operatingSystem, Integer ram,
                    Integer storage,Disk tod,String cpu, String gpu);

    

}
