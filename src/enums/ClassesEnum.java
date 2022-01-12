package enums;

public enum ClassesEnum {
    GUERREIRO(1, "Guerreiro"),
    PALADINO(2, "Paladino"),
    ARQUEIRO(3, "Arqueiro"),
    MAGO(4, "Mago");

    private int id;
    private String descricao;

    ClassesEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static ClassesEnum getClasse(int classe) {
        for (ClassesEnum c : ClassesEnum.values()) {
            if (c.getId() == classe) {
                return c;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
