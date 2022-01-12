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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
