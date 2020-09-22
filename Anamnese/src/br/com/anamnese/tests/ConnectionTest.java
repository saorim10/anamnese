/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anamnese.tests;

import br.com.anamnese.jdbc.ConnectionFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Saorim
 */
public class ConnectionTest {
    public static void main(String[] args){
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
