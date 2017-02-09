package exceptions.jogo;

public class ExceptionJogoScoreInvalido extends Exception{
	
	public ExceptionJogoScoreInvalido () {
		super("Score do jogo invalido. Nao pode ser menor que zero");
	}

}
