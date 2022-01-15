package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Mago extends Jogador {
    public Mago(String nome, SexoEnum sexo, ArmasEnum arma) {
        super(19, 11, nome, sexo, arma);
    }
}
