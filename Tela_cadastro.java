import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_cadastro extends JDialog implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
     JButton btn = (JButton)e.getSource();
     Confirmou = btn.getText().equals("Ok");
     setVisible(false);
   }
   private JPanel pnlDados;
   private JPanel pnlBotoes;
   private JTextField tbxId;
   private JTextField tbxNome_pais;
   private JTextField tbxouro;
   private JTextField tbxprata;
   private JTextField tbxbronze;
   private boolean Confirmou=false;

   private JButton criarBotao(String nome)
   {
	JButton btn = new JButton(nome);  
	btn.setPreferredSize(new Dimension(110,25));
	pnlBotoes.add(btn);
        btn.addActionListener(this);
	return btn;
   }

   int L = 0;
   private JTextField criarEntrada(String nome, int Tamanho)
   {
	JLabel lbl = new JLabel(nome);  
	pnlDados.add(lbl);
	lbl.setBounds(20,20+L*30,60,20);
	JTextField tbx = new JTextField(Tamanho);
	tbx.setBounds(80,20+L*30,Tamanho*10,20);
	pnlDados.add(tbx);
        L++;
	return tbx;
   }
	
   public Tela_cadastro()
   {
       setTitle("Inserção de Dados");
       setSize(520,250);
       setMinimumSize(new Dimension(520,250));
       
       Image im = Toolkit.getDefaultToolkit().getImage("icone_med.png");
       setIconImage(im);

       setLocationRelativeTo(null);

       setModal(true);

       pnlBotoes = new JPanel();
       pnlDados = new JPanel();
       pnlDados.setLayout(null);	

       add(pnlBotoes, BorderLayout.SOUTH);
       add(pnlDados,  BorderLayout.CENTER);

       criarBotao("Ok");
       criarBotao("Cancelar");

       tbxId = criarEntrada("Id",3);	
       tbxNome_pais = criarEntrada("Pais",10);
       tbxouro= criarEntrada("ouro",3);	
       tbxprata = criarEntrada("prata",3);	
       tbxbronze = criarEntrada("bronze",3);

   }
   
   private void atualizarTela(Cadastro a) 
   {
      tbxId.setText(a.getId());
      tbxNome_pais.setText(a.getNome_pais());
      tbxouro.setText(""+a.getouro());
      tbxprata.setText(""+a.getprata());
      tbxbronze.setText(""+a.getbronze());
   }

   private void atualizarObjeto(Cadastro a) 
   {
      a.setId(tbxId.getText());
      a.setNome_pais(tbxNome_pais.getText());
      a.setouro(Integer.parseInt(tbxouro.getText()));
      a.setprata(Integer.parseInt(tbxprata.getText()));
      a.setbronze(Integer.parseInt(tbxbronze.getText()));
   }

   private static Tela_cadastro Instancia;   
   public static boolean Executar(Cadastro a) 	
   {
    	if (Instancia==null)
	  Instancia = new Tela_cadastro();
        Instancia.Confirmou=false;
        Instancia.atualizarTela(a);
        Instancia.setVisible(true);
        if (Instancia.Confirmou)
           Instancia.atualizarObjeto(a);
	return Instancia.Confirmou;
   }
}