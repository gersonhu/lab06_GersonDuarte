package exceptions.jogo;

public class ExceptionJogoPrecoInvalido extends Exception{
	
	public ExceptionJogoPrecoInvalido(){
		super("Preco do jogo invalido. Nao pode ser menor que zero");
	}

}
