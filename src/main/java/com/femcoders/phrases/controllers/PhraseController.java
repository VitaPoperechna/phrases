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
        List<Phrase> events = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(events, HttpStatus.OK);
    }

    @PostMapping("/phrases")
    public ResponseEntity<Phrase> addEvent(@RequestBody Phrase newEvent) {
        Phrase createdEvent = phraseService.addPhrase(newEvent);
        return new ResponseEntity<Phrase>(createdEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/phrases{id}")
    public ResponseEntity<HttpStatus> deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
