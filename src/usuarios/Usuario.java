package usuarios;

import java.util.ArrayList;

import exceptions.jogo.ExceptionJogoInvalido;
import exceptions.jogo.ExceptionJogoNomeInvalido;
import exceptions.jogo.ExceptionJogoScoreInvalido;
import exceptions.usuarios.ExceptionUsuarioJogosInvalidos;
import exceptions.usuarios.ExceptionUsuarioLoginInvalido;
import exceptions.usuarios.ExceptionUsuarioX2pInvalido;
import exceptions.usuarios.ExceptionUsuariosNomeInvalido;
import jogo.Jogo;

public abstract class Usuario {

	private String nomeDoUsuario;
	private String login;
	private int saldo;
	private ArrayList<Jogo> jogosComprados;
	private int x2p;

	public Usuario(String nome, String login) throws Exception {
		this.nomeDoUsuario = nome;
		this.login = login;
		saldo = 0;
		jogosComprados = new ArrayList<Jogo>();
	}

	public String getNomeDoUsuario() {
		return this.nomeDoUsuario;
	}

	public void setNomeDoUsuario(String novoNome) throws Exception {
		if (novoNome == null || novoNome.trim().isEmpty()) {
			throw new ExceptionUsuariosNomeInvalido();
		}
		this.nomeDoUsuario = novoNome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String novoLogin) throws Exception {
		if (novoLogin == null || novoLogin.trim().isEmpty()) {
			throw new ExceptionUsuarioLoginInvalido();
		}
		this.login = novoLogin;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public void setJogosComprados(ArrayList<Jogo> novosJogos) throws Exception {
		if (novosJogos == null) {
			throw new ExceptionUsuarioJogosInvalidos();
		}
		this.jogosComprados = novosJogos;
	}

	public int getX2p() {
		return this.x2p;
	}

	public void aumentaX2p(int x2p) throws Exception {
		if (x2p < 0) {
			throw new ExceptionUsuarioX2pInvalido();
		}
		this.x2p += x2p;
	}

	public abstract boolean comprarJogo(Jogo jogo) throws Exception;

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

	public int getQuantidadeJogosComprados() {
		return this.jogosComprados.size();
	}

	private Jogo getJogo(String nomeDoJogo) {
		for (int i = 0; i < jogosComprados.size(); i++) {
			if (jogosComprados.get(i).getNomeDoJogo().equals(nomeDoJogo)) {
				return jogosComprados.get(i);
			}
		}
		return null;
	}

	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception {
		if (nomeDoJogo == null || nomeDoJogo.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}

		if (score < 0) {
			throw new ExceptionJogoScoreInvalido();
		}

		Jogo jogo = getJogo(nomeDoJogo);
		if (jogo != null) {
			int x2p = jogo.registraJogada(score, zerou);
			aumentaX2p(x2p);
		}
	}
	
	public boolean addJogosComprados(Jogo jogo) throws Exception{
		if (jogo == null){
			throw new ExceptionJogoInvalido();
		}
		
		
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
