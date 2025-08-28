package model;

import jakarta.persistence.Entity;

@Entity
public class ProdutoDigital extends Produto {
    private String urlDownload;

    public ProdutoDigital() {}

    public ProdutoDigital(String nome, double preco, String descricao, String urlDownload) {
        super(nome, preco, descricao);
        this.urlDownload = urlDownload;
    }
}
