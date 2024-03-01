package com.example.pacbackend.Carrello;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacbackend.Notebook.Notebook;

@Repository
public interface CarrelloRepo extends JpaRepository<Notebook,Long> {

    Optional<Notebook> findNotebookById(long id);

}
