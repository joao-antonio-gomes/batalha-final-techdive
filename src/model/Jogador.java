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
            System.out.println("ERRRRRRRRROU!!!");
            List<String> frasesErro = List.of(
                    "Não foi dessa vez",
                    "Você errou seu ataque por muito!",
                    "Seu inimigo pareceu o Neo ao se desviar, bullet time!"
            );
            System.out.println(frasesErro.get((int) (Math.random() * frasesErro.size())));
            return;
        }

        if (danoDado == 20) {
            System.out.println("Um ataque crítico!");
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

        List<ArmasEnum> armasCurtas = List.of(ArmasEnum.ESPADA, ArmasEnum.MACHADO, ArmasEnum.MARTELO, ArmasEnum.CLAVA);
        List<ArmasEnum> armasLongas = List.of(ArmasEnum.BESTA, ArmasEnum.ARCO);
        String frase;
        if (armasCurtas.contains(arma)) {
            frase = "Você atacou com sua " + arma.getNome();
        } else if (armasLongas.contains(arma)) {
            if (arma == ArmasEnum.ARCO) {
                frase = "Você atacou com seu arco e flecha";
            } else {
                frase = "Você atacou com sua besta e virote";
            }
        } else if (arma == ArmasEnum.CAJADO) {
            frase = "Você atacou com seu cajado, lançando uma bola de fogo";
        } else {
            frase = "Você absorveu a energia do seu livro mágico com uma de suas mãos e soltou pela outra";
        }

        frase += " e causou " + danoTotal + " de dano!";
        System.out.println(frase);

        if (defensorEstaVivo) {
            System.out.println("O inimigo ainda está vivo!");
            return;
        }

        System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
    }

    public int getPontosDeVidaMaximo() {
        return pontosDeVidaMaximo;
    }

    public void setMotivacao(MotivacoesEnum motivacao) {
        this.motivacao = motivacao;
    }

    public void fugir() {
        System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
        System.exit(0);
    }

    public MotivacoesEnum getMotivacao() {
        return motivacao;
    }

    public SexoEnum getSexo() {
        return sexo;
    }
}
