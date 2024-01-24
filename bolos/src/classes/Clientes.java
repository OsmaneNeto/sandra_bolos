package classes;

public class Clientes {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    protected String nome;
    protected String telefone;

    public Clientes(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

}
