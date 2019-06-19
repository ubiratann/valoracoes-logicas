import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Atomica a = new Atomica("a");
		Atomica b = new Atomica("b");
		Atomica c = new Atomica("c");
		Atomica d = new Atomica("d");
		Atomica e = new Atomica("e");

		Conjuncao eLog = new Conjuncao(d, ".",e);
		Disjuncao ou = new Disjuncao(eLog, "+", c);
		Conjuncao eLog2 = new Conjuncao(ou, ".", b);
		Negacao aNegado = new Negacao(a,"'");
		
		Atomica[] atomicas = {d,e};

		Tabela tb = new Tabela(eLog, atomicas);
		tb.gerarTabela();

		String phi = new String("d.e");

		Leitor l = new Leitor(phi);

		String[] teta = phi.split("");
		
		//System.out.println( l.lerFormula(teta, 0, teta.length) );

		Tabela tb2 = new Tabela( l.lerFormula(teta, 0, teta.length), atomicas );

		tb2.gerarTabela();

	}
}