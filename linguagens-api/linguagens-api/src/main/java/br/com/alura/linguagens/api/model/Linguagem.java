package br.com.alura.linguagens.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "principaisLinguagens")
public class Linguagem {

    @Id
    private String id;

    private String title;
    private String image;
    private int ranking;

}
