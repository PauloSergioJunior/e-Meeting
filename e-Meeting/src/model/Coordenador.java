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
public class Coordenador extends Usuario {

    public Coordenador(String nome, long cpf, String senha, String email, String endereco, String tipo, ArrayList<Reuniao> reunioes) {
        super(nome, cpf, senha, email, endereco, tipo, reunioes);
    }

    public Coordenador() {
        tipoUsuario();
    }

    @Override
    public void tipoUsuario() {
        setTipo("Coordenador");
    }

}
