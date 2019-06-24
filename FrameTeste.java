
import java.util.ArrayList;
import java.io.*;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ubiratan
 */
public class FrameTeste extends javax.swing.JFrame {
	String stringPhi;
	Formula phi;
	Atomica[] atomica;
        
   	FrameTeste (Formula form, Atomica[] at, String nome) {
		initComponents();
                phi = form;
		atomica = at;
		stringPhi = nome;
                this.setLocationRelativeTo(this);
                this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		inicializar();
                gerarTabela();
                
	} 
	
	void inicializar() {
		if (atomica != null) for (int i = 0; i < atomica.length; i++) atomica[i].escolherBitPos(i); // a posicao da prop at no array corresponde a sua pos no num bin
	}

	void mostrarCabecalho() {
		if (atomica != null)
		{
       
			for (int i = atomica.length-1; i >= 0; i--) areaTxt.setText( areaTxt.getText()+atomica[i]+"\t"); // 0 corresponde ao LBS (menos sig); atomica.length-1 ao MBS (mais sig)
			areaTxt.setText(areaTxt.getText() + stringPhi + "\n");
		}
	}
	// mostra os val verd das prop atomicas e da formula 
	void mostrarLinha() {
          
		if (atomica != null)
		{
			for (int i = atomica.length-1; i >= 0; i--) areaTxt.setText(areaTxt.getText()+ atomica[i].obterValor()+"\t");
			areaTxt.setText(areaTxt.getText() +phi.obterValor()+ "\n");
		}
	}

	void incrementarValoresAt() {
		if (atomica != null) for (Atomica prop : atomica) prop.incrementar(); // incrementa o contador das prop at, uma por uma
	}

	void verificarValoresAt() {
		if (atomica != null)
			for (Atomica prop : atomica)
			{
				if (prop.obterContador() == prop.obterContMax()) // troca os valores das prop at cujo esteja com o contador no limite
				{
					prop.zerarCont();
					prop.trocarValor();
				}
			}
	}

	void gerarTabela() {
		int linha, qtdTotalLinhas;
			
		linha = 1;
		qtdTotalLinhas = 2 * atomica[ atomica.length-1 ].obterContMax(); // o total de linhas da tab verd corresponde a 2 elevado a pos do MSB;
		
		mostrarCabecalho();

		while (linha <= qtdTotalLinhas)
		{
			mostrarLinha();
			
			incrementarValoresAt();
			
			verificarValoresAt();
			
			linha++;
		}
	} 
    
    
    
    
    
    /** TABELA ANTIGA
     * 
     * 
     * Formula phi;
	ArrayList <Atomica> atomica = new ArrayList();

    
     * Creates new form FrameTeste
     */
        /**
    public FrameTeste(Formula form, ArrayList<Atomica> at) {
        initComponents();
        this.phi = form;
        this.atomica = at;
        inicializar();
        gerarTabela();
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
	
	void inicializar() {
		for (int i = 0; i < atomica.size(); i++) atomica.get(i).escolherBitPos(i); // a posicao da prop at no array corresponde a sua pos no num bin
	}

	void mostrarCabecalho() {
		for (int i = atomica.size()-1; i >= 0; i--) areaTxt.setText(areaTxt.getText() +atomica.get(i)+ "\t"  );
                    //System.out.print( atomica.get(i)+"\t"); // 0 corresponde ao LBS (menos sig); atomica.length-1 ao MBS (mais sig)
                    areaTxt.setText(areaTxt.getText() + phi +"\n");
                    //System.out.println(phi);
	}
	// mostra os val verd das prop atomicas e da formula 
	void mostrarLinha() {
		for (int i = atomica.size()-1; i >= 0; i--) areaTxt.setText(areaTxt.getText()+atomica.get(i).obterValor()+" \t");
                    // System.out.print( atomica.get(i).obterValor()+"\t");
                    areaTxt.setText(areaTxt.getText() +phi.obterValor()+"\n");
                    //System.out.println(phi.obterValor());
	}

	void incrementarValoresAt() {
		for (Atomica prop : atomica) prop.incrementar(); // incrementa o contador das prop at, uma por uma
	}

	void verificarValoresAt() {
		for (Atomica prop : atomica)
		{
			if (prop.obterContador() == prop.obterContMax()) // troca os valores das prop at cujo esteja com o contador no limite
			{
				prop.zerarCont();
				prop.trocarValor();
			}
		}
	}

	void gerarTabela() {
		int linha, qtdTotalLinhas;
			
		linha = 1;
		qtdTotalLinhas = 2 * atomica.get(atomica.size()-1).obterContMax(); // o total de linhas da tab verd corresponde a 2 elevado a pos do MSB;
		
		mostrarCabecalho();

		while (linha <= qtdTotalLinhas)
		{
			mostrarLinha();
			
			incrementarValoresAt();
			
			verificarValoresAt();
			
			linha++;
		}
	}
    
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxt = new javax.swing.JTextArea();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTxt.setEditable(false);
        areaTxt.setColumns(20);
        areaTxt.setRows(5);
        areaTxt.setEnabled(false);
        areaTxt.setPreferredSize(new java.awt.Dimension(353, 230));
        jScrollPane1.setViewportView(areaTxt);

        save.setText("Salvar Tabela");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        File file = new File("./teste.txt");
        try{
            file.createNewFile();
        }
        catch(IOException io){
            io.printStackTrace();
        }
        
        try{
            FileWriter fw  = new FileWriter(file.getAbsoluteFile());
            BufferedWriter wr = new BufferedWriter(fw);
            String str[] = this.areaTxt.getText().split("\\n");
            for(String linha : str){
                wr.write(linha+"\n");
            }
            
            wr.close();
        }catch(IOException io){
            io.printStackTrace();
        }
        
    }//GEN-LAST:event_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}