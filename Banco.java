import java.sql.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.image.*;

public class Banco
{
   private final String _STR_CONEXAO_ = "jdbc:sqlite:Rio2016.db";
   private  Connection conexao;

   public Banco()  
   {
       try{
        Class.forName("org.sqlite.JDBC");
       }catch(Exception e)
       {
	   JOptionPane.showMessageDialog(null,"Nao foi possivel carregar o drive jdbc do SQLite");
           System.exit(0);
       }

       File f = new File("Rio2016.db");
       if (!f.exists())
          CriarBanco();

   }

   private void AbrirConexao()
   {
      try{
         conexao = DriverManager.getConnection(_STR_CONEXAO_);
      }catch(Exception e)
       {
    	  JOptionPane.showMessageDialog(null,"Nao foi possivel conectar com o banco de dados");
           System.exit(0);
       }
   }

   private void FecharConexao()
   {
      try{
        
	conexao.close();
      }catch(Exception e)
       {
    	  JOptionPane.showMessageDialog(null,"Nao foi possivel fechar a conexa com o banco de dados");
       }
   }
    

   private void CriarBanco()
   {
      AbrirConexao();
      try{
      
       
        Statement stm = conexao.createStatement();

        stm.executeUpdate("create table Cadastro (id varchar(30), nome_pais varchar(30), ouro int, prata int, bronze int)");
        stm.executeUpdate("create table Usuario (matricula varchar(30),Nome_login varchar(30), senha varchar(30))");


     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
     }
   }

   
  /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     +                                                                                                         +
     +                                       Area do Login                                                     + 
     +                                                                                                         +
     +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
   //------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
   
   public void inserir_login(Login a)
   {
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("insert into Usuario (matricula,Nome_login,senha) values (?,?,?)" );
        stm.setString(1,a.getmatricula());
        stm.setString(2,a.getNome_login());
        stm.setString(3,a.getsenha());
        stm.executeUpdate();

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
     }
   } 
   
   public void remover_login(String matricula)
   {
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("delete from Usuario where matricula=?" );
        stm.setString(1,matricula);
        stm.executeUpdate();

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
     }
   }
  
 //------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
   
/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   +                                                                                                         +
   +                                       Area do Cadastro                                                  + 
   +                                                                                                         +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
 //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   public void inserir(Cadastro a)
   {
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("insert into Cadastro (id,nome_pais,ouro,prata,bronze) values (?,?,?,?,?)" );
        stm.setString(1,a.getId());
        stm.setString(2,a.getNome_pais());
        stm.setInt(3,a.getouro());
        stm.setInt(4,a.getprata());
        stm.setInt(5,a.getbronze());
        stm.executeUpdate();

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
     }
   }        
 
   public void remover(String Id)
   {
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("delete from Cadastro where id=?" );
        stm.setString(1,Id);
        stm.executeUpdate();

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
     }
   }  
  
   public Cadastro obterCadastro(String Id)
   {
      Cadastro a = null;
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("select id,nome_pais,ouro,prata,bronze from Cadastro where id=?" );
        stm.setString(1,Id);
        ResultSet r = stm.executeQuery();

        if (r.next())
        {
           a = new Cadastro();
           a.setId(r.getString(1));
           a.setNome_pais(r.getString(2));
           a.setouro(r.getInt(3));
           a.setprata(r.getInt(4));
           a.setbronze(r.getInt(5));
        }

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
        return a;
     }
   }

   public Iterable<Cadastro> obterCadastro()
   {
      LinkedList<Cadastro> listaop = new LinkedList<Cadastro>(); 
      AbrirConexao();
      try{
      
        PreparedStatement stm = conexao.prepareStatement("select id,nome_pais,ouro,prata,bronze from Cadastro order by ouro DESC" );
        ResultSet r = stm.executeQuery();

        while (r.next())
        {
        	Cadastro a = new Cadastro();
            a.setId(r.getString(1));
            a.setNome_pais(r.getString(2));
            a.setouro(r.getInt(3));
            a.setprata(r.getInt(4));
            a.setbronze(r.getInt(5));
           listaop.add(a);
        }

     }catch(Exception e)
     {
        e.printStackTrace();
     }
     finally
     {
        FecharConexao();
        return listaop;
     }
   }  
   //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   public static void main(String s[])
   {

	   Banco bd = new Banco();

	     Cadastro x = new Cadastro();    
	     x.ler();
	     bd.inserir(x);
	     for(Cadastro a : bd.obterCadastro());
   }
   }