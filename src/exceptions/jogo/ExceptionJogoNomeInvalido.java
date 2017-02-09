package exceptions.jogo;

public class ExceptionJogoNomeInvalido extends Exception{
	public ExceptionJogoNomeInvalido (){
		super("Nome do Jogo invalido. Nao pode ser nulo ou vazio.");
	}

}
