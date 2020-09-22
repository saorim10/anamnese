package br.com.anamnese.dao;

import br.com.anamnese.jdbc.ConnectionFactory;
import br.com.anamnese.model.Usuarios;
import br.com.anamnese.view.FrmLogin;
import br.com.anamnese.view.FrmMain;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Marcelo Saorim
 */
public class UsuariosDAO {
    private Connection con = null;
    
    public UsuariosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    // **** Cadastrar Usuário *********************************************************************
    public void cadastrar(Usuarios obj){
        try {
            // Criar comando sql
            String sql = "INSERT INTO tb_usuarios (cpf, nome, email, celular, nivel_acesso, senha) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getNivel_acesso());
            stmt.setString(6, obj.getSenha());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "usuário Cadastrado com sucesso.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    // **** Login *********************************************************************************
    public void logar(String email, String senha){
        try {
            String sql = "SELECT * FROM tb_usuarios WHERE email=? AND senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema!!!");
                FrmMain tela = new FrmMain();
                tela.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(null, "Usuário inexistente ou dados incorretos!!!");
            new FrmLogin().setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
