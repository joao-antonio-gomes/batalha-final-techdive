package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;
import utils.Dado;

import java.util.List;

abstract public class Jogador extends Personagem implements Atacante {
    private String nome;
    private SexoEnum sexo;
    private MotivacoesEnum motivacao;
    private ArmasEnum arma;
    private static final int pontosDeVidaMaximo = 200;

    public Jogador(int pontosDeAtaque, int pontosDeDefesa, String nome, SexoEnum sexo, ArmasEnum arma) {
        super(pontosDeVidaMaximo, pontosDeAtaque, pontosDeDefesa);
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
        this.sexo = sexo;
        this.motivacao = motivacao;
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem defensor) {
        int danoDado = Dado.rolarDado(20);
        int pontosDeAtaque = this.getPontosDeAtaque();
        int danoArma = this.arma.getDano();
        int danoTotal = pontosDeAtaque + danoArma + danoDado;

        int pontosDeDefesa = defensor.getPontosDeDefesa();
        int pontosDeVida = defensor.getPontosDeVida();

        if (danoDado == 1) {
            List<String> frasesErro = List.of(
                    "Não foi dessa vez",
                    "Você errou seu ataque por muito!",
                    "Seu inimigo pareceu o Neo ao se desviar, bullet time!"
            );
            System.out.println(frasesErro.get((int) (Math.random() * frasesErro.size())));
            return;
        }

        if (danoDado == 20) {
            List<String> frasesErro = List.of(
                    "Você sente uma força preencher você e consegue acertar um golpe super poderoso!",
                    "Você acertou um golpe muito forte e seu inimigo pareceu ficar confuso!"
            );
            System.out.println(frasesErro.get((int) (Math.random() * frasesErro.size())));
            int pontosDeVidaFinal = pontosDeVida - (danoTotal * 2);
            defensor.setPontosDeVida(pontosDeVidaFinal);
        } else {
            int danoFinal = danoTotal - pontosDeDefesa;
            int pontosDeVidaFinal = pontosDeVida - danoFinal;
            defensor.setPontosDeVida(pontosDeVidaFinal);
        }

        boolean defensorEstaVivo = defensor.getPontosDeVida() > 0;

        System.out.println("Seu ataque causou " + danoTotal + " de dano!");

        if (defensorEstaVivo) {
            System.out.println("O inimigo ainda está vivo!");
            return;
        }

        System.out.println("O inimigo morreu!");
    }

    public int getPontosDeVidaMaximo() {
        return pontosDeVidaMaximo;
    }

    public void setMotivacao(MotivacoesEnum motivacao) {
        this.motivacao = motivacao;
    }
}
