package exceptions.usuarios;

public class ExceptionUsuarioLoginInvalido extends Exception{
	
	public ExceptionUsuarioLoginInvalido(){
		super("Login do usuario invalido. Nao pode ser nulo ou vazio");
	}
}
