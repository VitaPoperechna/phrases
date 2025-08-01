package com.femcoders.phrases.services;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }

    public Phrase addPhrase(Phrase newPhrase){
        return phraseRepository.save(newPhrase);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }

    public Phrase updatePhrase(Long id, Phrase updatedPhrase) {
        Phrase existingPhrase = findById(id);
        existingPhrase.setPhrase(updatedPhrase.getPhrase());
        existingPhrase.setAuthor(updatedPhrase.getAuthor());
        return phraseRepository.save(existingPhrase);
    }

    public Phrase findById(Long id) {
        return phraseRepository.findById(id).orElse(null);
    }
}
