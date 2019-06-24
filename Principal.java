import java.util.*;

public class Principal {
	public static void main(String[] args) {
		String phi = new String("((d.e)+(c)')'");

		Leitor l = new Leitor(phi);

		// String[] teta = phi.split("");
		
		// Conectivo r = (Conectivo)l.lerFormula();

		// int a = -1;
		// Atomica[] at = l.obterAtomicas();

		// for (Atomica c : at) System.out.println(c+" "+(++a));

		// System.out.println();

		Tabela tb2 = new Tabela(( Conectivo)l.lerFormula() , l.obterAtomicas(), l.stringFormula());
		
		System.out.println();
		tb2.gerarTabela();

	}
}