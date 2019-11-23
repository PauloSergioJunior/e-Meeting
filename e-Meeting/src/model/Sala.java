/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class Sala {

    private int id;
    private String nome;
    private ArrayList<Reuniao> reunioesSala;
    private boolean disponibilidade;

    public Sala() {
        this.setDisponibilidade(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Reuniao> getReunioesSala() {
        return reunioesSala;
    }

    public void setReunioesSala(ArrayList<Reuniao> reunioesSala) {
        this.reunioesSala = reunioesSala;
    }

    public Reuniao listarReunioesSala() {

        for (Reuniao r : getReunioesSala()) {

            return r;

        }
        return null;

    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    

    @Override
    public String toString() {
        return "Sala{ Nome= " + nome + " }";
    }

}
