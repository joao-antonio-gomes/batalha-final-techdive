package personagens;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;

abstract public class Jogador extends Personagem implements Atacante {
    private String nome;
    private SexoEnum sexo;
    private MotivacoesEnum motivacao;
    private ArmasEnum arma;
    private static final int pontosDeVida = 200;

    public Jogador(int pontosDeAtaque, int pontosDeDefesa, String nome, SexoEnum sexo, MotivacoesEnum motivacao, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa);
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
        this.sexo = sexo;
        this.motivacao = motivacao;
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem p) {

    }
}
