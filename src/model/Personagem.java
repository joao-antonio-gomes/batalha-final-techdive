package model;

abstract public class Personagem {
    private int pontosDeVida;
    private int pontosDeAtaque;
    private  int pontosDeDefesa;

    public Personagem(int pontosDeVida, int pontosDeAtaque, int pontosDeDefesa){
        this.pontosDeVida = pontosDeVida;
        this.pontosDeAtaque = pontosDeAtaque;
        this.pontosDeDefesa = pontosDeDefesa;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosDeAtaque() {
        return pontosDeAtaque;
    }

    public void setPontosDeAtaque(int pontosDeAtaque) {
        this.pontosDeAtaque = pontosDeAtaque;
    }

    public int getPontosDeDefesa() {
        return pontosDeDefesa;
    }

    public void setPontosDeDefesa(int pontosDeDefesa) {
        this.pontosDeDefesa = pontosDeDefesa;
    }
}
