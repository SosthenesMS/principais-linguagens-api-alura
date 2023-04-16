package br.com.alura.linguagens.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Linguagem {

    private String title;
    private String image;
    private int ranking;

}
