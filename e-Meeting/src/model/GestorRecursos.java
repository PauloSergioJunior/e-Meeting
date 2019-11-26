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
public class GestorRecursos extends Usuario {

    public GestorRecursos(String nome, String cpf, String senha, String email, String endereco, String tipo, ArrayList<Reuniao> reunioes) {
        super(nome, cpf, senha, email, endereco, tipo, reunioes);
    }

    public GestorRecursos() {
    }

    @Override
    public void tipoUsuario() {
        setTipo("Gestor de Recursos");
    }

    public Sala criarSala(String nome) {

        Sala s = new Sala();
        s.setNome(nome);
        return s;

    }

}
