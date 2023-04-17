package br.com.alura.linguagens.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.linguagens.api.model.Linguagem;
import br.com.alura.linguagens.api.repository.LinguagemRepository;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    @GetMapping
    public ResponseEntity<List<Linguagem>> obterListaDeLinguagens() {
        List<Linguagem> linguagens = linguagemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(linguagens);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Linguagem>> obterTodasAsLinguagens(@RequestParam("title") String title) {
        return ResponseEntity.status(HttpStatus.OK).body(linguagemRepository.findByTitle(title));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Linguagem>> obterLinguagemPeloNome(@PathVariable("title") String title) {
        return ResponseEntity.status(HttpStatus.OK).body(linguagemRepository.findByTitle(title));
    }

    @GetMapping("/ranking/{ranking}")
    public ResponseEntity<List<Linguagem>> obterLinguagemPeloRanking(@PathVariable("ranking") int ranking) {
        return ResponseEntity.status(HttpStatus.OK).body(linguagemRepository.findByRanking(ranking));
    }

    @PostMapping
    public ResponseEntity<Object> criarNovaLinguagem(@RequestBody Linguagem linguagem) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(linguagemRepository.save(linguagem));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao criar a linguagem de programação" + ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarLinguagem(@RequestBody Linguagem linguagem) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(linguagemRepository.save(linguagem));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao tentar atualizar a linguagem de programação" + ex.getMessage());
        }
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<String> deletarLinguagem(@PathVariable("title") String title) {
        linguagemRepository.deleteByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body("Linguagem deletada com sucesso!");
    }

    @DeleteMapping("/ranking/{ranking}")
    public ResponseEntity<String> deletarLinguagemPeloRanking(@PathVariable("ranking") int ranking) {
        linguagemRepository.deleteByRanking(ranking);
        return ResponseEntity.status(HttpStatus.OK).body("Linguagem deletada com sucesso!");
    }

    @Autowired
    private LinguagemRepository linguagemRepository;

}
