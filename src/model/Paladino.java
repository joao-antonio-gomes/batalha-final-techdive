package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Paladino extends Jogador {
    public Paladino(String nome, SexoEnum sexo, ArmasEnum arma) {
        super(13, 18, nome, sexo, arma);
    }
}
