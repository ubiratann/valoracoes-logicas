public class Pilha {
	Formula[] pilha = new Formula[3];
	int topo = -1;

	boolean empty() {
		if ( topo == -1 ) return true;
		return false;
	}

	boolean flow() {
		if ( topo == 2 ) return true;
		return false;
	}
	
	void push(Formula f) {
		if (flow()) {
			System.out.println("Error: overflow");

		} else {
			++topo;
			
			pilha[topo] = f;
		}
	}

	Formula pop() {
		if (empty()){
			System.out.println("Error: underflow");
			return null;
		}

		Formula x = pilha[topo];

		pilha[topo] = null;

		--topo;

		return x;
	}

	void reduceStackUnary() {
		Conectivo conecUn = (Conectivo)pop();
		
		conecUn.add( (Atomica)pop() );
		
		push(conecUn);
	}
	
	void reduceStackBinary() {
		Atomica atDir = (Atomica)pop();

		Conectivo conecBin = (Conectivo)pop();
		
		conecBin.add( pop(), atDir );

		push(conecBin);
	}

	boolean readyUnary() {
		if ( pilha[topo] instanceof Negacao ) return true;
		return false;
	}
	
	boolean readyBinary() {
		if ( pilha[topo] instanceof Atomica && flow() ) return true;
		return false;
	}
}