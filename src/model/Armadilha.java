package model;

import enums.ArmasEnum;
import utils.Dado;

public class Armadilha implements Atacante {
    private int pontosDeAtaque;
    private ArmasEnum arma;

    public Armadilha() {
        this.arma = ArmasEnum.ARMADILHA;
        this.pontosDeAtaque = 5;
    }

    @Override
    public void atacar(Personagem personagem) {
        int ataqueByDado = Dado.rolarDado(10);
        if (ataqueByDado == 1) {
            System.out.println("O ataque da armadilha pegou de raspão e você não sofreu dano");
            return;
        }

        int ataqueArma = arma.getDano();
        int ataqueTotal = ataqueByDado + ataqueArma + pontosDeAtaque;

        int pontosDeDefesaAlvo = personagem.getPontosDeDefesa();
        int dano = ataqueTotal - pontosDeDefesaAlvo;
        dano = Math.max(dano, 0);

        int pontosDeVidaAlvo = personagem.getPontosDeVida();
        int vidaRestante = pontosDeVidaAlvo - dano;
        personagem.setPontosDeVida(vidaRestante);

        System.out.println("Você sofreu " + dano + " de dano e agora possui " + vidaRestante + " pontos de vida");
    }
}
