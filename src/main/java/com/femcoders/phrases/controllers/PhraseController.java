package com.femcoders.phrases.controllers;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public ResponseEntity<List<Phrase>> getAllPhrases() {
        List<Phrase> phrases = phraseService.getAllPhrases();
        return new ResponseEntity<>(phrases, HttpStatus.OK);
    }

    @PostMapping("/phrases")
    public ResponseEntity<Phrase> addPhrase(@RequestBody Phrase newPhrase) {
        Phrase createdPhrase = phraseService.addPhrase(newPhrase);
        return new ResponseEntity<>(createdPhrase, HttpStatus.CREATED);
    }

    @DeleteMapping("/phrases/{id}")
    public ResponseEntity<HttpStatus> deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/phrases/{id}")
    public ResponseEntity<Phrase> getPhrase(@PathVariable Long id) {
        Phrase phrases = phraseService.findById(id);
        return new ResponseEntity<>(phrases, HttpStatus.OK);
    }

    @PutMapping("/phrases/{id}")
    public ResponseEntity<Phrase> updatePhrase(@PathVariable Long id, @RequestBody Phrase updatedPhrase){
        Phrase updatePhrase = phraseService.updatePhrase(id, updatedPhrase);
        return new ResponseEntity<>(updatePhrase, HttpStatus.OK);
    }
}
