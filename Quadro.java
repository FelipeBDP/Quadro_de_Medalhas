import javax.swing.*;
import java.util.*;

public class Quadro
{
   Banco bnc;
 
   public Quadro()
   {
	   bnc = new Banco();
   }

   public void inserir(Cadastro a)
   {
	   bnc.inserir(a);
   }
   public void inserir_login(Login a)
   {
	   bnc.inserir_login(a);
   }
   public Cadastro getCadastro(String Id)
   {
     return bnc.obterCadastro(Id);
   }

   public Iterable<Cadastro> getCadastro()
   {
     return bnc.obterCadastro();
   }
   
   public void remover(String Id)
   {
      bnc.remover(Id);
   }
   public void remover_login(String matricula)
   {
      bnc.remover_login(matricula);
   }
   public void lista()
   {
      String Result="";
      for(Cadastro a : bnc.obterCadastro())	  
    	  Result +=a.getNome_pais()+" " +a.getouro()+" "+a.getprata()+" "+a.getbronze()+" \n";
      JOptionPane.showMessageDialog(null,Result); 
   }
   public void listarop()
   {
      String Result="";
      for(Cadastro a : bnc.obterCadastro())	  
    	  Result +=a.getId()+" "+a.getNome_pais()+" " +a.getouro()+" "+a.getprata()+" "+a.getbronze()+" \n";
      JOptionPane.showMessageDialog(null,Result); 
   }

   public Iterable<Cadastro> getCadastros(String parte)
   {
      String Result="";
      List<Cadastro> vet = new LinkedList<Cadastro>();
      parte = parte.toLowerCase();
      for(Cadastro a : bnc.obterCadastro())
        if (a.getNome_pais().toLowerCase().contains(parte) || a.getId().toLowerCase().contains(parte))
           vet.add(a);
      return vet;
   }

}