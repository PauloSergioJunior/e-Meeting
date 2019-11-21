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
public class UsuarioComum extends Usuario{

    public UsuarioComum() {
        TipoUsuario();
    }

    public UsuarioComum(int id, String nome, long cpf, String senha, String email, String endereco) {
        super(id, nome, cpf, senha, email, endereco);
    }
    
    public Reuniao criarReuniao(ArrayList<Usuario> usuarios, String local, String dataRe, String ata) {

        Reuniao r = new Reuniao();
        r.setAta(ata);
        r.setDataReuniao(dataRe);
        r.setLocal(local);
        r.setParticipantes(usuarios);
        return r;
    }

    public Reuniao editarAta(Reuniao r, String ata) {

        r.setAta(ata);
        return r;

    }

    @Override
    public void TipoUsuario() {
        setTipo("Usuario Comum");
    }

    
    
}
