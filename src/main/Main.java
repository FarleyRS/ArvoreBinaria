package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arvore ab = new Arvore();
		
		ab.adicionar(6);
        ab.adicionar(4);
        ab.adicionar(8);
        ab.adicionar(3);
        ab.adicionar(5);
        ab.adicionar(7);
        ab.adicionar(9);
        
      System.out.println(ab.numFolhas());
	}

}