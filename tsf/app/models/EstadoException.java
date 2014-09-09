package models;

public class EstadoException extends Exception {
	
	String menssagem;
	public EstadoException(String msg) {
		menssagem = msg;
	}
	
	@Override
	public String toString(){
		return menssagem;
	}

}
