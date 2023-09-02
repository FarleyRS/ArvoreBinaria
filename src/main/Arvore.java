package main;

public class Arvore {
	No raiz;

	private No addRecursivo(No atual, int valor) {

		if (atual == null) {
			return new No(valor);
		}

		if (valor < atual.valor) {
			atual.esquerdo = addRecursivo(atual.esquerdo, valor);
		} else if (valor > atual.valor) {
			atual.direito = addRecursivo(atual.direito, valor);
		} else {
			return atual; // o valor já existe
		}

		return atual;
	}

	public void adicionar(int valor) {
		raiz = addRecursivo(raiz, valor);
	}

	// verifica se a árvore contém o valor

	private int contemRecursivo(No no, int valor) {
		if (no == null) {
			return 0;
		} else if (valor < no.valor) {
			return contemRecursivo(no.esquerdo, valor);
		} else if (valor > no.valor) {
			return contemRecursivo(no.direito, valor);
		} else
			return no.valor;
	}

	public boolean contem(int dado) {
		if (dado == contemRecursivo(raiz, dado)) {
			return true;
		} else
			return false;
	}

	// retornar o menor valor
	private No minimoRecursivo(No no) {
		if (no != null) {
			if (no.esquerdo == null) {
				return no;
			}
			return minimoRecursivo(no.esquerdo);
		}
		return null;
	}

	public int minimo() {
		return minimoRecursivo(raiz).valor;
	}

	// retorna o maior valor da arvore
	private No maximoRecursivo(No no) {
		if (no != null) {
			if (no.direito == null) {
				return no;
			}
			return maximoRecursivo(no.direito);
		}
		return null;
	}

	public int maximo() {
		return maximoRecursivo(raiz).valor;
	}

	// Retorna o maior somatório de um caminho
	private int maxSomaRecursiva(No no) {
		if (no == null)
			return 0;

		int somaEsquerda = maxSomaRecursiva(no.esquerdo);
		int somaDireita = maxSomaRecursiva(no.direito);

		if (somaDireita < somaEsquerda)
			return no.valor += somaEsquerda;
		else
			return no.valor += somaDireita;
	}

	public int maxSoma() {
		return maxSomaRecursiva(raiz);
	}

	
	// Devolve o caminho para chegar a um dado nó
	private String caminho = "";
	private String caminhoRecursivo(No no, int valor) {
		if (no != null) {
			caminho += no.valor +" ";

			if (valor < no.valor) {
				caminhoRecursivo(no.esquerdo, valor);
			} else if (valor > no.valor) {
				caminhoRecursivo(no.direito, valor);
			}
		}
		return caminho;
	}

	public String pathTo(int valor) {
		return caminhoRecursivo(raiz, valor);
	}
	
	// Retorna o número de nós
	private int numNos;
	private int numNoRecursivo(No no) {
		if(no != null) {
			numNos++;
			numNoRecursivo(no.esquerdo);
			numNoRecursivo(no.direito);
		}
		return numNos;
	}
	public int numNo() {
		return numNoRecursivo(raiz);
	}
	
	// Retorna o número de nós que são folhas
	private int noFolhas;
	private int numFolhasRecursivo(No no) {
		if(no != null) {
			if(no.esquerdo == null && no.direito == null) {
				noFolhas++;
			}else {
				numFolhasRecursivo(no.esquerdo);
				numFolhasRecursivo(no.direito);
			}
				
		}
		return noFolhas;
	}
	public int numFolhas() {
		return numFolhasRecursivo(raiz);
	}
}
