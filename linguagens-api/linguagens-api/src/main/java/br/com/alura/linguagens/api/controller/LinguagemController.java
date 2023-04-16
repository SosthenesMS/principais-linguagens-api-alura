package br.com.alura.linguagens.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.linguagens.api.model.Linguagem;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    List<Linguagem> linguagens = List.of(
            new Linguagem("java",
                    "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",
                    1),
            new Linguagem("php",
                    "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png",
                    2));

    @GetMapping
    public List<Linguagem> obterListaDeLinguagens() {
        return linguagens;
    }
}
