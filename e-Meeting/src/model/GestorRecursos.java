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
public class GestorRecursos extends Usuario{

    public GestorRecursos(int id, String nome, long cpf, String senha, String email, String endereco) {
        super(id, nome, cpf, senha, email, endereco);
    }

    public GestorRecursos() {
    }

    @Override
    public void tipoUsuario() {
        setTipo("Gestor de Recursos");
    }
    
    public Sala criarSala(String nome){
        
        Sala s = new Sala();
        s.setNome(nome);
        return s;
        
    }
    
}
