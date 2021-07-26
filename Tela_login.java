import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;
import java.awt.event.*;

public class Tela_login extends JDialog implements ActionListener
{
    
    private int Result;	
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();
        switch( btn.getText().charAt(0))
	{
		case 'A': Result = 1; break;
		case 'V': Result = 2; break;
        case 'S': Result = 3; break;
        default : Result = 0; break; 
	}
        setVisible(false);
    }

    public Tela_login()
    {
        initComponents();
    }  
    private JPanel pnlBotoes;
    private JButton criarBotao(String Texto)
    {
	JButton btn = new JButton(Texto); 
        pnlBotoes.add(btn);
        btn.setPreferredSize(new Dimension(150,30));
        btn.addActionListener(this);
	return btn;
    }
    private void initComponents()
    {
           
 	 setTitle("Login");
         setSize(400,250);
         
         Image im = Toolkit.getDefaultToolkit().getImage("visit.png");
         setIconImage(im);
         
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         setLocationRelativeTo(null);

         setModal(true);

	 setLayout(new FlowLayout());	
         
         pnlBotoes = new JPanel();    
         pnlBotoes.setPreferredSize(new Dimension(200,200));
	 add(pnlBotoes);	
 
	 criarBotao("Administrador");
	 criarBotao("Visistante");
	 criarBotao("Sair");
    }  

    private static Tela_login tela;
    public static int Executar()
    {
        if ( tela == null)
          tela = new Tela_login();
        tela.Result = 3;
        tela.setVisible(true);
        return tela.Result;
    }
    
    public static void main(String s[])
    {
	int op;
        while (  (op=Executar())!=3)
	       JOptionPane.showMessageDialog(null,"Escolheu:"+op);	

	System.exit(0);
    }
}