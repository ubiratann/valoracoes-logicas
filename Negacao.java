class Negacao extends Conectivo {
	Negacao (Formula esq, String sinal) {
		super(esq,sinal);
	}

	boolean obterValor() {
		return !obterFilho(0).obterValor(); 
	}

	@Override
	String obterExpressao() {
		return "("+esquerdo+")"+sinal;
	}
	
	public String toString() {
		return "("+esquerdo+")"+sinal;
	}
}