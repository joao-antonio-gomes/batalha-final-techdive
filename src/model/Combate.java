package model;

import utils.Dado;

import java.util.Scanner;

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
        System.out.println();
        System.out.println("INICIO DO COMBATE");
        System.out.println((jogadorComecaPrimeiro ? "Jogador" : "Inimigo") + " começa primeiro");
        System.out.println();
        pressioneEnterParaContinuar();
        do {
            if (jogadorComecaPrimeiro) {
                System.out.println();
                System.out.println("Seu turno!");
                System.out.println();
                acoesJogadorCombate();
                System.out.println();
                System.out.println("O inimigo vai atacar agora!");
                System.out.println();
                acoesInimigoCombate();
            } else {
                System.out.println();
                System.out.println("O inimigo vai atacar agora!");
                System.out.println();
                acoesInimigoCombate();
                System.out.println();
                System.out.println("Seu turno!");
                System.out.println();
                acoesJogadorCombate();
            }
        } while (jogador.getPontosDeVida() > 0 && inimigo.getPontosDeVida() > 0);
    }

    private void pressioneEnterParaContinuar() {
        System.out.println("Pressione ENTER para continuar");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private boolean jogadorComecaPrimeiro() {
        int iniciativaJogador = Dado.rolarDado(20);
        int iniciativaAtacante = Dado.rolarDado(20);
        return iniciativaJogador > iniciativaAtacante;
    }

    public void acoesJogadorCombate() {
        System.out.println("Escolha uma ação: ");
        System.out.println("1 - Atacar");
        System.out.println("2 - Fugir");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            jogador.atacar(inimigo);
        } else {
            jogador.fugir();
        }
    }

    public void acoesInimigoCombate() {
        inimigo.atacar(jogador);
    }
}
