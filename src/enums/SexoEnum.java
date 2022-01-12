package enums;

public enum SexoEnum {
    MASCULINO(1, "Masculino", "M"),
    FEMININO(2, "Feminino", "F");

    private int id;
    private String descricao;
    private String sigla;

    private SexoEnum(int id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }
}
