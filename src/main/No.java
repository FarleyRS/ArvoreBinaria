package main;

public class No{
	int valor;
	No esquerdo;
	No direito;
	
	No(int valor){
		this.valor = valor;
		direito = null;
		esquerdo = null;
	}
}