package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Guerreiro extends Jogador {
    public Guerreiro(String nome, SexoEnum sexo, MotivacoesEnum motivacao, ArmasEnum arma) {
        super(arma.getDano(), 15, nome, sexo, motivacao, arma);
    }
}
