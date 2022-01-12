package model;

import enums.ArmasEnum;

public class Lider extends Inimigo {
    private static final int pontosDeVida = 200;

    public Lider() {
        super(15, 15, ArmasEnum.MACHADO_DUPLO);
    }
}
