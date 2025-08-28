package model;

import jakarta.persistence.Entity;

@Entity
public class ProdutoFisico extends Produto {
    private double peso;
    private double prateleira;

    public ProdutoFisico() {}

    public ProdutoFisico(String nome, double preco, String descricao, double peso, double prateleira) {
        super(nome, preco, descricao);
        this.peso = peso;
        this.prateleira = prateleira;
    }
}
