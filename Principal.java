/*import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Atomica a = new Atomica("a", false);
		Atomica b = new Atomica("b", false);
		Atomica c = new Atomica("c", false);
		Atomica d = new Atomica("d", false);
		Atomica e = new Atomica("e", false);

		Conjuncao eLog = new Conjuncao(d, ".",e);
		Disjuncao ou = new Disjuncao(eLog, "+", c);
		Conjuncao eLog2 = new Conjuncao(ou, ".", b);
		Negacao aNegado = new Negacao(a,"'");

		Atomica[] atomicas = {a};

		Tabela tb = new Tabela(aNegado, atomicas);
		
		tb.gerarTabela();

	}
}*/