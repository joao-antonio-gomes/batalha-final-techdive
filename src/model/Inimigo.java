package model;

import enums.ArmasEnum;
import enums.MotivacoesEnum;
import enums.SexoEnum;
import utils.Dado;

import java.util.List;

abstract public class Inimigo extends Personagem implements Atacante {
    private ArmasEnum arma;
    private static final int pontosDeVida = 100;

    public Inimigo(int pontosDeVida, int pontosDeAtaque, int pontosDeDefesa, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa);
        this.arma = arma;
    }

    public Inimigo(int pontosDeAtaque, int pontosDeDefesa, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa);
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
            System.out.println("O inimigo errou o golpe, você não sofreu dano!");
            return;
        }

        int pontosDeVidaFinal;
        if (danoDado == 20) {
            System.out.println("O inimigo acertou um ataque crítico!");

            pontosDeVidaFinal = pontosDeVida - danoTotal;
            defensor.setPontosDeVida(pontosDeVidaFinal);
        } else {
            danoTotal = danoTotal - pontosDeDefesa;
            if (danoTotal < 0) {
                danoTotal = 0;
            }
            pontosDeVidaFinal = pontosDeVida - danoTotal;
            defensor.setPontosDeVida(pontosDeVidaFinal);
        }

        boolean defensorEstaVivo = defensor.getPontosDeVida() > 0;

        System.out.println("Seu inimigo causou " + danoTotal + " de dano! Você possui " + pontosDeVidaFinal + " pontos de vida!");

        if (defensorEstaVivo) {
            System.out.println("Você permanece de pé!");
            return;
        }

        System.out.println("Você não estava preparado para a força do inimigo.");
        MotivacoesEnum motivacao = ((Jogador) defensor).getMotivacao();
        if (motivacao == MotivacoesEnum.VINGANCA) {
            System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
        } else {
            SexoEnum sexo = ((Jogador) defensor).getSexo();
            if (sexo == SexoEnum.FEMININO) {
                System.out.println("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroína.");
            } else {
                System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
            }
        }
        System.exit(0);
    }
}
