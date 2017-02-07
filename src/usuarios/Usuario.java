package usuarios;

import java.util.ArrayList;

import jogo.Jogo;

public abstract class Usuario {
	
	private String nome;
	private String login;
	private int saldo;
	private ArrayList<Jogo> jogosComprados;
	
	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		saldo = 0;
		jogosComprados = new ArrayList<Jogo>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String novoLogin){
		this.login = novoLogin;
	}
	
	public int getSaldo(){
		return this.saldo;
	}

}
