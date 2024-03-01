package com.example.pacbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pacbackend.Ordine.Ordine;
import com.example.pacbackend.Ordine.OrdineRepository;
import com.example.pacbackend.Ordine.OrdineService;

@SpringBootTest
public class OrdineServiceTest {

  @Autowired
  OrdineRepository ordineRepository;
  @Autowired
  OrdineService ordineService;

  @Test
  public void getOrdineTest(){
    int expectedId = 1;
    //Effettuo una ricerca per Id sugli ordini inseriti
    Optional<Ordine> actualOptOrdine = ordineService.getOrdine(expectedId);
    //Controllo che abbia restituito un ordine
    assertTrue(actualOptOrdine.isPresent());
    Ordine actualOrdine = actualOptOrdine.get();
    //Controllo che l'ordine corrisponda a quella cercato
    assertEquals(expectedId, actualOrdine.getId());
  }
  
}
