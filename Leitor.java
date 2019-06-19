public class Leitor {
	String[] formula;
	
	Leitor(String form) {
		formula = form.split("");
	}

	Formula criarForm(String phi) {
		Formula aux;
	    
	    if (phi.toUpperCase().compareTo("A") == 0 || phi.toUpperCase().compareTo("B") == 0 || phi.toUpperCase().compareTo("C") == 0 || phi.toUpperCase().compareTo("D") == 0 || phi.toUpperCase().compareTo("E") == 0) 
		{
			aux = new Atomica(phi.toUpperCase());
		}
		else {
			switch(phi) {
				case ".":
		    		aux = new Conjuncao(null, phi, null);
		    		break;
		    	
		    	case "+":
		    		aux = new Disjuncao(null, phi, null);
		    		break;
		    	
		    	case "'":
		    		aux = new Negacao(null,phi);
		    		break;
		    	
		    	default:
		    		aux = null;
		    		break;
		    }
		}

	    return aux;
	}
	
	int fimSubForm(String[] phi, int ini) {
		int i, qtdParentesis = 0;

		for (i = ini; i < phi.length; ++i)
		{
			if ( phi[i].compareTo("(") == 0 )
			{
				++qtdParentesis;
			}
			
			if ( phi[i].compareTo(")") == 0 )
			{
				if ( qtdParentesis == 0 )
				{
					if ( i < phi.length && phi[i+1].compareTo("'") == 0 ) return i+1; // CONSIDERANDO QUE PODE HAVER O SIMBOLO DA NEGAÇÃO APÓS O PARENTESE
					return i;
				}

				--qtdParentesis;
			}
		}

		return -1; // FAZER O TRY CATCH
	}

	Formula lerFormula(String[] phi, int ini, int fim) {
		int i, f;
		Formula aux;
		Pilha p = new Pilha();
		
		for (i = ini; i < fim; ++i) 
		{
			if ( phi[i].compareTo("(") == 0 ) 
			{
				f = fimSubForm(phi, ++i);
				
				p.push(lerFormula(phi, ++i, f));

				i = f;
			} 
			else 
			{
				aux = criarForm( phi[i] );

				p.push(aux);
			}

	        if ( p.readyUnary() ) p.reduceStackUnary();
			
			if ( p.readyBinary() ) p.reduceStackBinary();
		}
		
		return p.pop();
	}
}