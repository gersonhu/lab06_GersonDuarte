package usuarios;

import java.util.ArrayList;

import exceptions.usuarios.ExceptionUsuariosNomeInvalido;
import jogo.Jogo;

public abstract class Usuario {

	private String nome;
	private String login;
	private int saldo;
	private ArrayList<Jogo> jogosComprados;

	public Usuario(String nome, String login) throws Exception {
		this.nome = nome;
		this.login = login;
		saldo = 0;
		jogosComprados = new ArrayList<Jogo>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novoNome) throws Exception {
		if (novoNome == null || novoNome.trim().isEmpty()) {
			throw new ExceptionUsuariosNomeInvalido();
		}
		this.nome = novoNome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String novoLogin) throws Exception {
		if (novologin)
			this.login = novoLogin;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public abstract void comprarJogo(Jogo jogo);

	public void incrementaSaldo(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor nao pode ser menor que zero");
		}
		this.saldo += valor;
	}

	public void decrementaSaldo(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor nao pode ser menor que zero");
		}
		this.saldo -= valor;
	}
}
