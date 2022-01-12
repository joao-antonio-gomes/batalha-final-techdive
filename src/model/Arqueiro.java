package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Arqueiro extends Jogador {

    public Arqueiro(String nome, SexoEnum sexo, MotivacoesEnum motivacao, ArmasEnum arma) {
        super(arma.getDano(), 13, nome, sexo, motivacao, arma);
    }
}
