package br.com.alura.linguagens.api.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.alura.linguagens.api.model.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

    List<Linguagem> findByTitle(String title);

    List<Linguagem> findByRanking(int ranking);

    void deleteByTitle(String title);

    void deleteByRanking(int ranking);

}
