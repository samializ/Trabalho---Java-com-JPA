package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    @OneToMany
    private List<Produto> produtos;

    public Pedido() {}
    public Pedido(String cliente) {
        this.cliente = cliente;
    }
}
