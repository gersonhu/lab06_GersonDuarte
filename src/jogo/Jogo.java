package jogo;

import java.util.HashSet;

import exceptions.jogo.ExceptionJogoJogabilidadeInvalida;
import exceptions.jogo.ExceptionJogoNomeInvalido;
import exceptions.jogo.ExceptionJogoPrecoInvalido;
import exceptions.jogo.ExceptionJogoScoreInvalido;

public abstract class Jogo {

	private String nomeDoJogo;
	private double precoPrecoDoJogo;
	private int maiorScore;
	private int xJogadas;
	private int xZeramentos;
	private HashSet<Jogabilidade> jogabilidades;

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}

		if (preco < 0) {
			throw new ExceptionJogoPrecoInvalido();
		}

		if (jogabilidades == null) {
			throw new ExceptionJogoJogabilidadeInvalida();
		}

		this.nomeDoJogo = nome;
		this.precoPrecoDoJogo = preco;
		this.maiorScore = 0;
		this.xJogadas = 0;
		this.xZeramentos = 0;
		this.jogabilidades = jogabilidades;
	}

	public String getNomeDoJogo() {
		return this.nomeDoJogo;
	}

	public void setNomeDoJogo(String novoNome) throws ExceptionJogoNomeInvalido {
		if (nomeDoJogo == null || nomeDoJogo.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}
		this.nomeDoJogo = novoNome;
	}

	public double getPrecoDoJogo() {
		return this.precoPrecoDoJogo;
	}

	public void setPrecoDoJogo(double novoPreco) throws ExceptionJogoPrecoInvalido {
		if (precoPrecoDoJogo < 0) {
			throw new ExceptionJogoPrecoInvalido();
		}
		this.precoPrecoDoJogo = novoPreco;
	}

	public int getMaiorScore() {
		return this.maiorScore;
	}

	public void setMaiorScore(int novoScore) throws ExceptionJogoScoreInvalido {
		if (maiorScore < 0) {
			throw new ExceptionJogoScoreInvalido();
		}
		this.maiorScore = novoScore;
	}

	public void incrementaXJogadas() {
		this.xJogadas++;
	}

	public void incrementaXZeramentos() {
		this.xZeramentos++;
	}

	public abstract int registraJogada(int score, boolean zerou);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidades == null) ? 0 : jogabilidades.hashCode());
		result = prime * result + ((nomeDoJogo == null) ? 0 : nomeDoJogo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoPrecoDoJogo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidades == null) {
			if (other.jogabilidades != null)
				return false;
		} else if (!jogabilidades.equals(other.jogabilidades))
			return false;
		if (nomeDoJogo == null) {
			if (other.nomeDoJogo != null)
				return false;
		} else if (!nomeDoJogo.equals(other.nomeDoJogo))
			return false;
		if (Double.doubleToLongBits(precoPrecoDoJogo) != Double.doubleToLongBits(other.precoPrecoDoJogo))
			return false;
		return true;
	}
}
