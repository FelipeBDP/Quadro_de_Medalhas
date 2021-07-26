import javax.swing.JOptionPane;

public class Login implements java.io.Serializable
{
   private String Nome_login,senha,matricula;   

   public Login()
   {
      Nome_login="";
      senha="";
      matricula="";
   }   
   
   public String getmatricula() { return matricula; }  
   public String getNome_login() { return Nome_login; }    
   public String getsenha() { return senha; } 
   
   public void setmatricula(String valor) { matricula = valor; }   
   public void setNome_login(String valor) { Nome_login = valor; }    
   public void setsenha(String valor) { senha = valor; } 
   
   public void ler()
   {
    Nome_login = JOptionPane.showInputDialog("Entre com o seu Login:");
    senha = JOptionPane.showInputDialog("Entre com sua senha:");
   }
}