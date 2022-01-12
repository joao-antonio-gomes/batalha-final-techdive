package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

public class Paladino extends Jogador {
    public Paladino(String nome, SexoEnum sexo, MotivacoesEnum motivacao, ArmasEnum arma) {
        super(arma.getDano(), 18, nome, sexo, motivacao, arma);
    }
}
