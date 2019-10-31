package model;

public class Usuario {

	private int id;
	private String nome;
	private long cpf;
	private String login;
	private String senha;
	private String email;
	private String endereco;

        public Usuario(int id, String nome, long cpf, String login, String senha, String email, String endereco) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.login = login;
            this.senha = senha;
            this.email = email;
            this.endereco = endereco;
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

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha
				+ ", email=" + email + ", endereco=" + endereco + "]";
	}
	
	
	
	
}
