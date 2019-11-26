package model;

import java.util.ArrayList;

public abstract class Usuario implements GerenciaUsuarios {

    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String endereco;
    private String tipo;
    private ArrayList<Reuniao> reunioes;

    public Usuario(String nome, String cpf, String senha, String email, String endereco, String tipo, ArrayList<Reuniao> reunioes) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.tipo = tipo;
        this.reunioes = reunioes;
    }

    
    public Usuario() {

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Reuniao> getReunioes() {
        return reunioes;
    }

    public void setReunioes(ArrayList<Reuniao> reunioes) {
        this.reunioes = reunioes;
    }
    
    public Reuniao listarReunioesConfirmadas(){
    
        for (Reuniao r : getReunioes()) {
            
            return r;
            
        }
        return null;
        
    }
    
    @Override
    public String toString() {
        return "Usuario [ id= " + id + ", nome= " + nome + ", cpf= " + cpf + ", senha= " + senha
                + ", email= " + email + ", endereco= " + endereco + " Tipo= " + tipo + " ]";
    }

}
