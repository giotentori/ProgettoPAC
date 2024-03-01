package com.example.pacbackend.Notebook;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pacbackend.Notebook.Technical_Features.Disk;
import com.example.pacbackend.Notebook.Technical_Features.OperatingSystem;
import com.example.pacbackend.Photo.Image;

/**
 * Classe utilizzata per realizzare l'interazione tra le API esposte
 * e il data model
 */

@Service
public class NotebookService {

    private final NotebookRepository notebookRepository;
    private static final String ERROR_SEARCH_MSG = "Il Notebook ricercato non è presente";

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    //Se esiste, restituisce il notebook con un certo nameModel
    public Optional<Notebook> findByNameModel(String nameModel) {
        Optional<Notebook> optional = notebookRepository.findByNameModel(nameModel);
        if(optional.isPresent())
            return optional;
        else
            throw new IllegalStateException(ERROR_SEARCH_MSG);
    }

    //Se esiste, restituisce il notebook con un certo Id
    public Optional<Notebook> findById(long id) {
        Optional<Notebook> optional = notebookRepository.findById(id);
        if(optional.isPresent())
            return optional;
        else
            throw new IllegalStateException(ERROR_SEARCH_MSG);
    }

     //Restituisce tutti i notebook presenti nell'applicazione
    public List<Notebook> getAllNotebook() {
        return notebookRepository.findAll();
    }

    //Restituisce tutti i notebook di una certa marca
    public List<Notebook> findByBrand(String brand) {
        return notebookRepository.findByBrand(brand);
    }

    //Restituisce tutti i notebook con un certo sistema operativo
    public List<Notebook> findByOperatingSystem(String stringOperatingSystem) {
        OperatingSystem operatingSystem = OperatingSystem.valueOf(stringOperatingSystem);
        return notebookRepository.findByOperatingSystem(operatingSystem);
    }

    //Restituisce tutti i notebook con lo schermo di una certa dimensione
    public List<Notebook> findByScreenSize(int screenSize) {
        return notebookRepository.findByScreenSize(screenSize);
    }

    //Restituisce tutti i notebook con una certa RAM
    List<Notebook> findByRam(int ram) {
        return notebookRepository.findByRam(ram);
    }

    //Restituisce tutti i notebook con una certo Storage
    List<Notebook> findByStorage(int storage) {
        return notebookRepository.findByStorage(storage);
    }

    //Restituisce tutti i notebook con una certa GPU
    List<Notebook> findByGpu(String gpu) {
        return notebookRepository.findByGpu(gpu);
    }

    //Restituisce tutti i notebook con una certa GPU
    List<Notebook> findByCpu(String cpu) {
        return notebookRepository.findByCpu(cpu);
    }

    //Restituisce tutti i notebook con un prezzo maggiore-uguale di quello specificato
    List<Notebook> findByPriceGreaterThanEqual(double price) {
        return notebookRepository.findByPriceGreaterThanEqual(price);
    }

    //Restituisce tutti i notebook con un prezzo minore-uguale di quello specificato
    List<Notebook> findByPriceLessThanEqual(double price) {
        return notebookRepository.findByPriceLessThanEqual(price);
    }

    //Restituisce tutti i notebook con un prezzo compreso tra i due specificati
    List<Notebook> findByPriceBetween(double minPrice, double maxPrice) {
        return notebookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    //Restituisce tutti i notebook con un certo tipo di disco
    List<Notebook> findByDisk(String stringDisk) {
        Disk disk = Disk.valueOf(stringDisk);
        return notebookRepository.findByDisk(disk);
    }

    //Ricerca sui campi OS, RAM e Storage
    List <Notebook> findByOperatingSystemAndRamAndStorage(String stringOperatingSystem,Integer ram,Integer storage) {
        OperatingSystem operatingSystem = OperatingSystem.valueOf(stringOperatingSystem);
        return notebookRepository.findByOperatingSystemAndRamAndStorage(operatingSystem, ram, storage);

    }

    //Inserisce un nuovo Notebook 
    public void insertNotebook (Notebook notebook) {
        /*TODO: Cambiare questa parte, ottenere una lista di notebook per name model e controllare che l'utente che lo 
            lo vuole inserire non sia lo stesso*/
        Optional<Notebook> optionalNotebook = notebookRepository.findByNameModel(notebook.getNameModel());
         if(optionalNotebook.isPresent())
            throw new IllegalStateException("Il notebook è già stato inserito");
        
        notebookRepository.save(notebook);
    }

    //Elimina un Notebook attraverso la ricerca sul campo nameModel
    public Notebook deleteNotebookByNameModel(String nameModel) {
        Optional<Notebook> optional = notebookRepository.findByNameModel(nameModel);
        if(!optional.isPresent())
            return null;
        Notebook deleteNotebook = optional.get();
        notebookRepository.delete(deleteNotebook);
        return deleteNotebook;
    }

    public List<Notebook> searchNotebook(Integer screenSize,String operatingSystem,String brand, Integer ram,
                                        Integer storage,String tod,String cpu, String gpu,Double minPrice, Double maxPrice) throws IllegalStateException {
        
        if(Objects.nonNull(operatingSystem)) {
            if(Objects.nonNull(screenSize) && Objects.nonNull(brand) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(minPrice) && Objects.nonNull(maxPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,marca,RAM,Storage,tipo di disco,CPU e intervallo di prezzo(Tutti i campi tecnici+ intervallo di prezzo)
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceBetween(screenSize, OperatingSystem.valueOf(operatingSystem), brand, ram, storage,Disk.valueOf(tod), cpu, gpu, minPrice, maxPrice);

            } else if(Objects.nonNull(screenSize) && Objects.nonNull(brand) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(minPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,marca,RAM,Storage,tipo di disco,CPU e prezzo minimo(Campi tecnici+ prezzo min)
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceGreaterThanEqual(screenSize, OperatingSystem.valueOf(operatingSystem), brand, ram, storage, Disk.valueOf(tod), cpu, gpu, minPrice);

            } else if(Objects.nonNull(screenSize) && Objects.nonNull(brand) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(maxPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,marca,RAM,Storage,tipo di disco,CPU e prezzo massimo(Campi tecnici+ prezzo max)
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpuAndPriceLessThanEqual(screenSize, OperatingSystem.valueOf(operatingSystem), brand, ram, storage, Disk.valueOf(tod), cpu, gpu, maxPrice);

            } else if(Objects.nonNull(screenSize) && Objects.nonNull(brand) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,marca,RAM,Storage,tipo di disco,CPU((Campi tecnici senza prezzo)
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndBrandAndRamAndStorageAndDiskAndCpuAndGpu(screenSize, OperatingSystem.valueOf(operatingSystem), brand, ram, storage, Disk.valueOf(tod), cpu, gpu);
                        
            } else if(Objects.nonNull(screenSize) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(minPrice) && Objects.nonNull(maxPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,RAM,Storage,tipo di disco,CPU e intervallo di prezzo
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceBetween(screenSize, OperatingSystem.valueOf(operatingSystem) , ram, storage, Disk.valueOf(tod), cpu, gpu, minPrice, maxPrice);

            } else if(Objects.nonNull(screenSize) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                     && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(minPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,RAM,Storage,tipo di disco,CPU e prezzo minimo
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceGreaterThanEqual(screenSize, OperatingSystem.valueOf(operatingSystem) , ram, storage, Disk.valueOf(tod), cpu, gpu, minPrice);

             } else if (Objects.nonNull(screenSize) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu) && Objects.nonNull(maxPrice)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,RAM,Storage,tipo di disco,CPU e prezzo massimo
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpuAndPriceLessThanEqual(screenSize, OperatingSystem.valueOf(operatingSystem) , ram, storage, Disk.valueOf(tod), cpu, gpu, maxPrice);

             } else if (Objects.nonNull(screenSize) && Objects.nonNull(ram) && Objects.nonNull(storage) 
                        && Objects.nonNull(tod) && Objects.nonNull(cpu) && Objects.nonNull(gpu)) {
                        //Chiamata al metodo per la ricerca tramite schermo,OS,RAM,Storage,tipo di disco,CPU
                        return notebookRepository.findByScreenSizeAndOperatingSystemAndRamAndStorageAndDiskAndCpuAndGpu(screenSize, OperatingSystem.valueOf(operatingSystem), ram, storage, Disk.valueOf(tod), cpu, gpu);
            } else if (Objects.nonNull(ram) && Objects.nonNull(storage)) {
                        //Chiamata al metodo per la ricerca tramite OS,RAM,Storage
                        return notebookRepository.findByOperatingSystemAndRamAndStorage(OperatingSystem.valueOf(operatingSystem),ram, storage);
}
        } 
    
        throw new IllegalStateException("Inserire una query valida ");
        

}


public void postImage(long id, MultipartFile file) throws Exception {
    Optional<Notebook> optionalNotebook = this.findById(id);
    if(!optionalNotebook.isPresent())
        throw new IllegalStateException("ERROR_SEARCH_MSG");
    
     Notebook notebook = optionalNotebook.get();

     Image image = new Image();
     image.setFileName(file.getOriginalFilename());
     image.setMimeType(file.getContentType());
     image.setData(file.getBytes());
     image.setUriImage("http://localhost:8080/images/"+image.getFileName());

     notebook.setImage(image);
     notebookRepository.save(notebook);

}


}
