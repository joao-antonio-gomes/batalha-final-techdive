package enums;

public enum MotivacoesEnum {
    VINGANCA(1, "Vingança"),
    GLORIA(2, "Gloria");

    private int id;
    private String nome;

    private MotivacoesEnum(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static MotivacoesEnum getMotivacao(int motivacao) {
        for (MotivacoesEnum motivacaoEnum : MotivacoesEnum.values()) {
            if (motivacaoEnum.getId() == motivacao) {
                return motivacaoEnum;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
