package exceptions.usuarios;

public class ExceptionUsuarioX2pInvalido extends Exception{
	
	public ExceptionUsuarioX2pInvalido () {
		super("X2p nao pode ser menor que zero");
	}

}
