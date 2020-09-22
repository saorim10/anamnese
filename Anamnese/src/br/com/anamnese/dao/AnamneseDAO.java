package br.com.anamnese.dao;
import br.com.anamnese.jdbc.ConnectionFactory;
import br.com.anamnese.model.Anamnese;
import java.sql.*;
/**
 *
 * @author Marcelo Saorim
 */
public class AnamneseDAO {

    // **** Conexão *******************************************************************************
    private Connection con = null;

    public AnamneseDAO() {
        this.con = new ConnectionFactory().getConnection();
        // ********************************************************************************************
    }

    public void gravar(Anamnese obj) {
        // **** Gravar Anamnese ***********************************************************************
        // Comando SQL para gravar no mySQL ****
        String sql = "INSERT INTO tb_anamnese (cpf, queixa, bebida_alcoolica, sono, fumante, "
                + "agua, alimentacao, evacua, usa_remedio, remedios, atividade_fisica, atividades, "
                + "obs_vida, p_circulacao, p_renal, p_respiratorio, p_digestivo, p_endocrino, "
                + "p_gastro, p_ginecologico, p_pressao, p_cardiaco, p_hepatico, p_diabetes, "
                + "p_anemias, p_epilepsia, p_colesterol, p_hipotireoide, p_hipertireoide, p_cancer, "
                + "p_depressao, p_herpes, p_audicao, p_alergia, alergias, obs_saude, cirurgia, "
                + "cirurgias, plastica, plastica_local, obs_cirurgia, gravida, lentes, obturacoes, "
                + "aparelho, placas, marca_passo, diu, imagem_1, imagem_2, imagem_3, imagem_4) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Ajusta comando SQL com atributos do objeto ****
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCpf());
            stmt.setString(2, obj.getQueixa());
            stmt.setString(3, obj.getBebida_alcoolica());
            stmt.setString(4, obj.getSono());
            stmt.setString(5, obj.getFumante());
            stmt.setString(6, obj.getAgua());
            stmt.setString(7, obj.getAlimentacao());
            stmt.setString(8, obj.getEvacua());
            stmt.setString(9, obj.getUsa_remedio());
            stmt.setString(10, obj.getRemedios());
            stmt.setString(11, obj.getAtividade_fisica());
            stmt.setString(12, obj.getAtividades());
            stmt.setString(13, obj.getObs_vida());
            stmt.setString(14, String.valueOf(obj.isP_circulacao()));
            stmt.setString(15, String.valueOf(obj.isP_renal()));
            stmt.setString(16, String.valueOf(obj.isP_respiratorio()));
            stmt.setString(17, String.valueOf(obj.isP_digestivo()));
            stmt.setString(18, String.valueOf(obj.isP_endocrino()));
            stmt.setString(19, String.valueOf(obj.isP_gastro()));
            stmt.setString(20, String.valueOf(obj.isP_ginecologico()));
            stmt.setString(21, String.valueOf(obj.isP_pressao()));
            stmt.setString(22, String.valueOf(obj.isP_cardiaco()));
            stmt.setString(23, String.valueOf(obj.isP_hepatico()));
            stmt.setString(24, String.valueOf(obj.isP_diabetes()));
            stmt.setString(25, String.valueOf(obj.isP_anemias()));
            stmt.setString(26, String.valueOf(obj.isP_epilepsia()));
            stmt.setString(27, String.valueOf(obj.isP_colesterol()));
            stmt.setString(28, String.valueOf(obj.isP_hipotireoide()));
            stmt.setString(29, String.valueOf(obj.isP_hipertireoide()));
            stmt.setString(30, String.valueOf(obj.isP_cancer()));
            stmt.setString(31, String.valueOf(obj.isP_depressao()));
            stmt.setString(32, String.valueOf(obj.isP_herpes()));
            stmt.setString(33, String.valueOf(obj.isP_audicao()));
            stmt.setString(34, String.valueOf(obj.isP_alergia()));
            stmt.setString(35, obj.getAlergias());
            stmt.setString(36, obj.getObs_saude());
            stmt.setString(37, String.valueOf(obj.isCirurgia()));
            stmt.setString(38, obj.getCirurgias());
            stmt.setString(39, String.valueOf(obj.isPlastica()));
            stmt.setString(40, obj.getPlastica_local());
            stmt.setString(41, obj.getObs_cirurgia());
            stmt.setString(42, String.valueOf(obj.isGravida()));
            stmt.setString(43, String.valueOf(obj.isLentes()));
            stmt.setString(44, String.valueOf(obj.isObturacoes()));
            stmt.setString(45, String.valueOf(obj.isAparelho()));
            stmt.setString(46, String.valueOf(obj.isPlacas()));
            stmt.setString(47, String.valueOf(obj.isMarca_passo()));
            stmt.setString(48, String.valueOf(obj.isDiu()));
            stmt.setString(49, obj.getImagem_1());
            stmt.setString(50, obj.getImagem_2());
            stmt.setString(51, obj.getImagem_3());
            stmt.setString(52, obj.getImagem_4());

            // Executa SQL e fecha ****
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
    }
}
