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
public class GerenciaUsuario {
    
    public Usuario criarUsuario(String nome,int CPF,String senha, String email,String endereco,String tipo){
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setCpf(CPF);
        u.setSenha(senha);
        u.setEmail(email);
        u.setEndereco(endereco);
        u.setTipo(tipo);
        return u;
        
    }
    
}
