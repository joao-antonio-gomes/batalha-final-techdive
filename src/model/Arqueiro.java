package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Arqueiro extends Jogador {

    public Arqueiro(String nome, SexoEnum sexo, ArmasEnum arma) {
        super(18, 13, nome, sexo, arma);
    }
}
