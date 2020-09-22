package br.com.anamnese.dao;
import br.com.anamnese.jdbc.ConnectionFactory;
import br.com.anamnese.model.Pacientes;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Marcelo Saorim
 */
public class PacientesDAO {
    private Connection con;
    
    public PacientesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    // **** Cadastrar Paciente ********************************************************************
    public void cadastrar(Pacientes obj){
        try {
            String sql = "INSERT INTO tb_pacientes (cpf, nome, data_nascto, sexo, estado_civil, "
                       + "profissao, cep, endereco, numero, complemento, bairro, cidade, uf, "
                       + "celular, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDataNascto());
            stmt.setString(4, obj.getSexo());
            stmt.setString(5, obj.getEstadoCivil());
            stmt.setString(6, obj.getProfissao());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setString(14, obj.getCelular());
            stmt.setString(15, obj.getEmail());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso.");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    
    // **** LISTAR PACIENTES **********************************************************************
    public List<Pacientes> listarPacientes(){
        try {
            List<Pacientes> lista = new ArrayList();
            
            String sql = "SELECT * FROM tb_pacientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pacientes obj = new Pacientes();
                obj.setCpf(rs.getString("cpf"));
                obj.setNome(rs.getString("nome"));
                obj.setDataNascto(rs.getString("data_nascto"));
                obj.setSexo(rs.getString("sexo"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setProfissao(rs.getString("profissao"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                obj.setCelular(rs.getString("celular"));
                obj.setEmail(rs.getString("email"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }
}
