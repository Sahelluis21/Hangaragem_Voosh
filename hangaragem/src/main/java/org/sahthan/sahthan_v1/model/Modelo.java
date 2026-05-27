package org.sahthan.sahthan_v1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String fabricante;
    private double comprimento;
    private double largura;
    private double pesoMedio;
    private double altura;

    public Modelo() {
    }

    public Modelo(String nome, String fabricante, double comprimento, double largura, double pesoMedio, double altura) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.comprimento = comprimento;
        this.largura = largura;
        this.pesoMedio = pesoMedio;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

