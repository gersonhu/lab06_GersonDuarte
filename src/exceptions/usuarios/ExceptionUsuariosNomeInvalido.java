package exceptions.usuarios;

public class ExceptionUsuariosNomeInvalido extends Exception{
	
	public ExceptionUsuariosNomeInvalido(){
		super("Nome do usuario invalido. Nao pode ser nulo ou vazio");
	}
}
