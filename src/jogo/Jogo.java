package jogo;


public abstract class Jogo {
	
	private String nome;
	private double preco;
	private int maiorScore;
	private int xVezes;
	private int xZeramentos;
	
	public Jogo (String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.xVezes = 0;
		this.xZeramentos = 0;
	}

	public void registraJogada(int score, boolean zerou) {
		return;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public void setPreco(double novoPreco){
		this.preco = novoPreco;
	}
	
	public int getMaiorScore(){
		return this.maiorScore;
	}
	
	public void setMaiorScore(int novoScore){
		this.maiorScore = novoScore;
	}
}
