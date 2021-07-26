import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_logando extends JDialog implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
     JButton btn = (JButton)e.getSource();
     Confirmou = btn.getText().equals("Ok");
     setVisible(false);
   }
   private JPanel pnlDados;
   private JPanel pnlBotoes;
   private JTextField tbxNome_login;
   private JTextField tbxsenha;
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
	
   public Tela_logando()
   {
       setTitle("Login");
       setSize(520,250);
       setMinimumSize(new Dimension(520,250));
       
       Image im = Toolkit.getDefaultToolkit().getImage("adm.png");
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
       tbxNome_login = criarEntrada("Login",15);
       tbxsenha = criarEntrada("Senha",10);
   }
   
   private void atualizarTela(Login a) 
   {
      tbxNome_login.setText(a.getNome_login());
      tbxsenha.setText(""+a.getsenha());
   }

   private void atualizarObjeto(Login a) 
   {
	  a.setNome_login(tbxNome_login.getText());
      a.setsenha(tbxsenha.getText());
   }

   private static Tela_logando Instancia;   
   public static boolean Executar(Login a) 	
   {
    	if (Instancia==null)
	  Instancia = new Tela_logando();
        Instancia.Confirmou=false;
        Instancia.atualizarTela(a);
        Instancia.setVisible(true);
        if (Instancia.Confirmou)
           Instancia.atualizarObjeto(a);
	return Instancia.Confirmou;
   }
   
}