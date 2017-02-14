package exceptions.usuarios;

public class ExceptionUsuarioJogosInvalidos extends Exception{
	
	public ExceptionUsuarioJogosInvalidos() {
		super("Lista de Jogos Invalida. Nao pode ser nula");
	}

}
