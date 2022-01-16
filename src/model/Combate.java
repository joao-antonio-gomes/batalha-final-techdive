package model;

import utils.Dado;

public class Combate {
    private Jogador jogador;
    private Inimigo inimigo;
    private Personagem primeiroAtacante;

    public Combate(Jogador jogador, Inimigo inimigo){
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public Combate(Jogador jogador, Inimigo inimigo, Personagem primeiroAtacante){
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.primeiroAtacante = primeiroAtacante;
    }

    public void combate() {
        boolean jogadorComecaPrimeiro = jogadorComecaPrimeiro();
        jogadorComecaPrimeiro = this.primeiroAtacante instanceof Jogador;
        do {
            if (jogadorComecaPrimeiro) {
                acoesJogadorCombate();
                acoesInimigoCombate();
            } else {
                acoesInimigoCombate();
                acoesJogadorCombate();
            }
        } while (jogador.getPontosDeVida() > 0 && inimigo.getPontosDeVida() > 0);
    }

    private boolean jogadorComecaPrimeiro() {
        int iniciativaJogador = Dado.rolarDado(20);
        int iniciativaAtacante = Dado.rolarDado(20);
        return iniciativaJogador > iniciativaAtacante;
    }

    public void acoesJogadorCombate() {

    }

    public void acoesInimigoCombate() {

    }
}
