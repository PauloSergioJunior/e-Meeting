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
public class UsuarioComum extends Usuario {

    public UsuarioComum() {
        tipoUsuario();
    }

    public UsuarioComum(String nome, long cpf, String senha, String email, String endereco, String tipo, ArrayList<Reuniao> reunioes) {
        super(nome, cpf, senha, email, endereco, tipo, reunioes);
    }

    public Reuniao criarReuniao(ArrayList<Usuario> usuarios, String local, String dataRe, String descricao) {

        Reuniao r = new Reuniao();
        r.setDescricao(descricao);
        r.setDataReuniao(dataRe);
        r.setLocal(local);
        r.setParticipantes(usuarios);
        return r;
    }

    public Reuniao editarAta(Reuniao r, String descricao) {

        r.setDescricao(descricao);
        return r;

    }

    @Override
    public void tipoUsuario() {
        setTipo("Usuario Comum");
    }

}
