/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anamnese.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Marcelo Saorim
 */
public class ConnectionFactory {
    private Connection conexao = null;
    public String url = "jdbc:mysql://127.0.0.1/anamnese?useTimezone=true&serverTimezone=UTC";
    public String user = "root";
    public String pass = "root";
    
    public Connection getConnection(){
        try {
            conexao = DriverManager.getConnection(url, user, pass);
            return conexao;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
