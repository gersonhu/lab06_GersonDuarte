package jogo;

import java.util.HashSet;

import exceptions.jogo.ExceptionJogoJogabilidadeInvalida;
import exceptions.jogo.ExceptionJogoNomeInvalido;
import exceptions.jogo.ExceptionJogoPrecoInvalido;
import exceptions.jogo.ExceptionJogoScoreInvalido;

public abstract class Jogo {

	private String nome;
	private double preco;
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
		
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.xJogadas = 0;
		this.xZeramentos = 0;
		this.jogabilidades = jogabilidades;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novoNome) throws ExceptionJogoNomeInvalido{
		if (nome == null || nome.trim().isEmpty()) {
			throw new ExceptionJogoNomeInvalido();
		}
		this.nome = novoNome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double novoPreco) throws ExceptionJogoPrecoInvalido {
		if (preco < 0) {
			throw new ExceptionJogoPrecoInvalido();
		}
		this.preco = novoPreco;
	}

	public int getMaiorScore() {
		return this.maiorScore;
	}

	public void setMaiorScore(int novoScore) throws ExceptionJogoScoreInvalido{
		if (maiorScore < 0) {
			throw new ExceptionJogoScoreInvalido();
		}
		this.maiorScore = novoScore;
	}
	
	public abstract int registraJogada(int score, boolean zerou);
	
	public void incrementaXJogadas() {
		this.xJogadas++;
	}
	
	public void incrementaXZeramentos(){
		this.xZeramentos++;
	}
}
