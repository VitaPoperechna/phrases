package com.femcoders.phrases.repositories;

import com.femcoders.phrases.models.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
