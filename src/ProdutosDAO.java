/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void salvar (ProdutosDTO produto){
        
        String comandoSQL = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)"; 
                        
        try {
            
            conectaDAO conexao = new conectaDAO();            
            PreparedStatement pStatement = conexao.connectDB().prepareStatement(comandoSQL);            
            
            pStatement.setString(1, produto.getNome());
            pStatement.setInt(2, produto.getValor());
            pStatement.setString(3, produto.getStatus());           
            
            pStatement.executeUpdate();
            
            System.out.println("cadastro foi realizado com sucesso!");
            
        } catch (SQLException ex) {
            
            System.out.println("Falha ao cadastrar produto " + ex.getMessage());       
            
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        String comandoSQL = "SELECT id, nome, valor, status FROM produtos";
        
        listagem.clear();
        
        try {
            
            conectaDAO conexao = new conectaDAO();
            
            PreparedStatement pStatement = conexao.connectDB().prepareStatement(comandoSQL);
            ResultSet resultSet = pStatement.executeQuery();
            
            while (resultSet.next()) {
                ProdutosDTO produtoDTO = new ProdutosDTO();
                
                produtoDTO.setId(resultSet.getInt("id"));
                produtoDTO.setNome(resultSet.getString("nome"));
                produtoDTO.setValor(resultSet.getInt("valor"));
                produtoDTO.setStatus(resultSet.getString("status"));                
                
                listagem.add(produtoDTO);
            }
            
            resultSet.close();
            pStatement.close();
            conexao.connectDB().close();
            
        } catch (SQLException ex) {
            
            System.out.println("Falha ao listar produtos!!! " + ex.getMessage());
            
        }
        
        return listagem;
        
    }
    
    public void venderProduto(int id) {
        
        String comandoSQL = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        
        try {
            
            conectaDAO conexao = new conectaDAO();
            
            PreparedStatement pStatement = conexao.connectDB().prepareStatement(comandoSQL);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
            
            System.out.println("Produto vendido com sucesso!!!");
            
        } catch(SQLException ex) {
            
            System.out.println("Falha ao vender produto!!! " + ex.getMessage());
            
        }
        
    }
    
}

