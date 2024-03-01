package com.example.pacbackend.Notebook;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Classe utilizzata per esporre gli endpoint al fine di gestire i notebook dell'applicazione
 */

@RestController
@RequestMapping(path = "notebook")
@CrossOrigin
public class NotebookController {

    private final NotebookService notebookService;
    private static final String OK_MSG = "Notebook correttamente inserito";

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    //Restituisco il notebook con un certo id
    @GetMapping("/byId")
    public Optional<Notebook> findById(@RequestParam long id) {
        return notebookService.findById(id);
    }

    //Se esiste restituisce il Notebook con un certo nome del modello
     @GetMapping("/byNameModel")
     public Optional<Notebook> findByNameModel(@RequestParam String nameModel) {
        return notebookService.findByNameModel(nameModel);
    }

    //Restituisce tutti i notebook presenti nell'applicazione
    @GetMapping("/getAll")
    public List<Notebook> getAllNotebook() {
        return notebookService.getAllNotebook();
    }

    //Restituisce tutti i notebook di una certa marca
    @GetMapping("/byBrand")
    public List<Notebook> findByBrand(@RequestParam String brand) {
        return notebookService.findByBrand(brand);
    }

    //Restituisce tutti i notebook di un certo OS
    @GetMapping("/byOS")
    public List<Notebook> findByOperatingSystem(@RequestParam(name = "OS") String operatingSystem) {
        return notebookService.findByOperatingSystem(operatingSystem);
    }
    
    //Restituisce tutti i notebook con lo schermo di una certa grandezza
    @GetMapping("/byScreen")
    public List<Notebook> findByScreenSize(@RequestParam(name = "screen") int screenSize) {
        return notebookService.findByScreenSize(screenSize);
    }

    //Restituisce tutti i notebook con una certa RAM
    @GetMapping("/byRam")
    List<Notebook> findByRam(@RequestParam int ram) {
        return notebookService.findByRam(ram);
    }

     //Restituisce tutti i notebook con un certo Storage
    @GetMapping("/byStorage")
    List<Notebook> findByStorage(@RequestParam int storage) {
        return notebookService.findByStorage(storage);
    }

    //Restituisce tutti i notebook con una certa GPU
    @GetMapping("/byGpu")
    List<Notebook> findByGpu(@RequestParam String gpu) {
        return notebookService.findByGpu(gpu);
    }

    //Restituisce tutti i notebook con una certa CPU
    @GetMapping("/byCpu")
    List<Notebook> findByCpu(@RequestParam String cpu) {
        return notebookService.findByCpu(cpu);
    }

    //Restituisce tutti i notebook con un prezzo maggiore-uguale di quello specificato
    @GetMapping("/byMinPrice")
     List<Notebook> findByPriceGreaterThanEqual(@RequestParam double price) {
        return notebookService.findByPriceGreaterThanEqual(price);
    }

    //Restituisce tutti i notebook con un prezzo minore-uguale di quello specificato
    @GetMapping("/byMaxPrice")
    List<Notebook> findByPriceLessThanEqual(@RequestParam double price) {
        return notebookService.findByPriceLessThanEqual(price);
    }

    @GetMapping("/byPriceBetween")
    List<Notebook> findByPriceBetween(@RequestParam(name = "p1") double minPrice,@RequestParam(name = "p2") double maxPrice) {
        return notebookService.findByPriceBetween(minPrice, maxPrice);
    }
    
    //Restituisce tutti i notebook con un certo tipo di disco
    @GetMapping("/byDisk")
    List<Notebook> findByDisk(@RequestParam String disk) {
        return notebookService.findByDisk(disk);
    }

    //Ricerca sui campi OS, RAM e Storage
    @GetMapping("byOS&ram&storage")
    List<Notebook> findByOperatingSystemAndRamAndStorage(@RequestParam(name = "OS") String OperatingSystem,@RequestParam Integer ram,
                                                        @RequestParam Integer storage){
        return notebookService.findByOperatingSystemAndRamAndStorage(OperatingSystem, ram, storage);

    }

    //Inserisce un nuovo notebook nell'applicazione
    @PostMapping("/insert")
    public String insertNotebook(@RequestBody Notebook notebook) {
        notebookService.insertNotebook(notebook);
        return OK_MSG;
    }

    //Elimina notebook con un certo name model e restituisce l'oggetto eliminato
    @DeleteMapping("/delete")
    public Notebook deleteNotebookByNameModel(@RequestParam(name = "name") String nameModel) {
       return notebookService.deleteNotebookByNameModel(nameModel);
    }

    //Ricerca per caratteristiche tecniche e prezzo
    @GetMapping("/search")
    public List<Notebook> searchNotebook(@RequestParam(name = "screen", required = false) Integer screenSize,
                                         @RequestParam(name = "OS", required = false) String operatingSystem,
                                         @RequestParam(required = false) String brand,
                                         @RequestParam(required = false) Integer ram,
                                         @RequestParam(required = false) Integer storage,
                                         @RequestParam(required = false, name ="disk") String tod,
                                         @RequestParam(required = false) String cpu,
                                         @RequestParam(required = false) String gpu,
                                         @RequestParam(required = false) Double minPrice,
                                         @RequestParam(required = false) Double maxPrice) 
    {
        return notebookService.searchNotebook(screenSize, operatingSystem, brand, ram, storage, tod, cpu, gpu, minPrice, maxPrice);                                         
    }


    @PostMapping("postImage")
    public void postImage(@RequestParam long id, @RequestPart MultipartFile file) throws Exception {
        notebookService.postImage(id, file);
    }

        
    
    
}
