/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Paulo
 */
public class Coordenador extends Usuario{

    public Coordenador(int id, String nome, long cpf, String senha, String email, String endereco) {
        super(id, nome, cpf, senha, email, endereco);
    }

    public Coordenador() {
        tipoUsuario();
    }

    
    
    @Override
    public void tipoUsuario() {
        setTipo("Coordenador");
    }
    
}
