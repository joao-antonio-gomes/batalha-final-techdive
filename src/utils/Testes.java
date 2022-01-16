package utils;

import java.util.List;

public class Testes {
    public static void main(String[] args) {
        List<String> frasesErro = List.of(
                "Não foi dessa vez",
                "Você errou seu ataque por muito!",
                "Seu inimigo pareceu o Neo ao se desviar, bullet time!"
        );
        System.out.println(frasesErro.get((int) (Math.random() * frasesErro.size())));
    }
}
