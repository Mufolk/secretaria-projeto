/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.entity.Aluno;
import model.entity.Professor;
import model.entity.Tecnico;
import model.entity.Usuario;
import model.requerimento.Requerimento;

/**
 *
 * @author RafaelSalazarStavale
 */
public class ConexaoBancoDeDados {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static void openConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {

        con = null;

        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(url, user, password);

    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "ERROR to close database");
            }
        }
    }

    public static Professor obterProfessorCPFSenha(String cpf, String senha) {
        Professor professor = new Professor();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.USUARIOS U, SGR.professor P, SGR.ENDERECO E "
                    + "WHERE U.CPF = ? AND U.SENHA = ? and U.id_endereco = E.id_endereco;"
            );
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            if (rs.next()) {
                professor.setCpf(rs.getString("cpf"));
                professor.setSiape(rs.getString("siape"));
                professor.setCentroAcademico(rs.getString("centro_academico"));
                professor.setNome(rs.getString("nome"));
                professor.setDataNascimeto(rs.getDate("data_nascimento").toLocalDate());
                professor.setSenha(rs.getString("senha"));
                professor.setEmail(rs.getString("email"));
                professor.setEstadoCivil(rs.getString("estado_civil"));
                professor.setNacionalidade(rs.getString("nacionalidade"));
                professor.setNomeDoPai(rs.getString("nome_pai"));
                professor.setNomeDaMae(rs.getString("nome_mae"));
                professor.setDeficiencia(rs.getString("deficiencia"));
                professor.setSexo(rs.getString("sexo"));
                professor.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                professor.setTelefoneCelular(rs.getString("telefone_celular"));
                professor.setTelefoneResidencial(rs.getString("telefone_residencial"));
                professor.setRegimeTrabalho(rs.getString("regime_trabalho"));
                professor.setClasseDocente(rs.getString("classe_docente"));
                professor.setTitulacao(rs.getString("titulacao"));
                professor.setCargo(rs.getString("cargo"));
                professor.setLogradouro(rs.getString("logradouro"));
                professor.setTipoDeEndereco(rs.getString("tipo_endereco"));
                professor.setTipoLogradouro(rs.getString("tipo_logradouro"));
                professor.setComplemento(rs.getString("complemento"));
                professor.setEstado(rs.getString("estado"));
                professor.setBairro(rs.getString("bairro"));
                professor.setCidade(rs.getString("cidade"));
                professor.setCep(rs.getString("cep"));
                professor.setPais(rs.getString("pais"));
                professor.setNumero(rs.getString("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;

    }

    public static Aluno obterAluno(String cpf, String senha) {
        Aluno aluno = new Aluno();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.USUARIOS U, SGR.ALUNO A, SGR.ENDERECO E "
                    + "WHERE U.CPF = ? AND SENHA = ? and U.id_endereco = E.id_endereco;"
            );
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            if (rs.next()) {
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setPeriodo(rs.getString("periodo"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNascimeto(rs.getDate("data_nascimento").toLocalDate());
                aluno.setSenha(rs.getString("senha"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setNacionalidade(rs.getString("nacionalidade"));
                aluno.setNomeDoPai(rs.getString("nome_pai"));
                aluno.setNomeDaMae(rs.getString("nome_mae"));
                aluno.setDeficiencia(rs.getString("deficiencia"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                aluno.setTelefoneCelular(rs.getString("telefone_celular"));
                aluno.setTelefoneResidencial(rs.getString("telefone_residencial"));
                aluno.setEstaTrancado(rs.getBoolean("esta_trancado"));
                aluno.setQtdeTrancamento(rs.getInt("qtde_trancamento"));
                aluno.setLogradouro(rs.getString("logradouro"));
                aluno.setTipoDeEndereco(rs.getString("tipo_endereco"));
                aluno.setTipoLogradouro(rs.getString("tipo_logradouro"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setEstado(rs.getString("estado"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setCep(rs.getString("cep"));
                aluno.setPais(rs.getString("pais"));
                aluno.setNumero(rs.getString("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;

    }

    public static ArrayList<Requerimento> obterRequerimentosPorCPF(String cpf) {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        Usuario usuarioRequerente = new Usuario();
        Usuario usuarioRequerido = new Usuario();

        try {
            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.id_usuario = "
                    + "(SELECT id_usuario from SGR.USUARIOS U WHERE U.CPF = ?);"
            );
            query.setString(1, cpf);
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(usuarioRequerente);
                requerimento.setAreaResponsavel(usuarioRequerido);
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    }

    public static void criarNovoRequerimentoAluno(Requerimento requerimento) {
        try {
            PreparedStatement query = con.prepareStatement(""
                    + "INSERT INTO sgr.requerimentos("
                    + "id_usuario, numero_requerimento,"
                    + "status, data_criacao,descricao,tipo_requerimento,tipo_requerente)"
                    + "VALUES "
                    + "((SELECT id_usuario from SGR.USUARIOS WHERE CPF = ?),"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,?);");
            query.setString(1, requerimento.requerente.getCpf());
            query.setString(2, requerimento.getNumeroRequerimento());
            query.setString(3, requerimento.getStatus());
            query.setDate(4, Date.valueOf((requerimento.getDataCriacao())));
            query.setString(5, requerimento.getDescricao());
            query.setString(6, requerimento.getTipoRequerimento());
            query.setString(7, "Aluno");
            rs = query.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void atualizarRequerimento(Requerimento requerimento, String novoStatus) {
         try {
            PreparedStatement query = con.prepareStatement(
            "UPDATE sgr.Requerimentos SET status = ? WHERE numero_requerimento = ?;"
            );
            
            query.setString(1, requerimento.getNumeroRequerimento());
            query.setString(2, novoStatus);
            rs = query.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static Aluno obterUsuarioPorID(int ID) {
        Aluno aluno = new Aluno();
        ResultSet resultSet = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "select * from sgr.usuarios U, SGR.ALUNO A, sgr.endereco E"
                    + " WHERE A.ID_USUARIO = U.ID_USUARIO AND U.ID_USUARIO = ? AND U.ID_ENDERECO = E.ID_ENDERECO");
            stmt.setInt(1, ID);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                aluno.setCpf(resultSet.getString("cpf"));
                aluno.setMatricula(resultSet.getString("matricula"));
                aluno.setPeriodo(resultSet.getString("periodo"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setDataNascimeto(resultSet.getDate("data_nascimento").toLocalDate());
                aluno.setSenha(resultSet.getString("senha"));
                aluno.setEmail(resultSet.getString("email"));
                aluno.setEstadoCivil(resultSet.getString("estado_civil"));
                aluno.setNacionalidade(resultSet.getString("nacionalidade"));
                aluno.setNomeDoPai(resultSet.getString("nome_pai"));
                aluno.setNomeDaMae(resultSet.getString("nome_mae"));
                aluno.setDeficiencia(resultSet.getString("deficiencia"));
                aluno.setSexo(resultSet.getString("sexo"));
                aluno.setDataIngresso(resultSet.getDate("data_ingresso").toLocalDate());
                aluno.setTelefoneCelular(resultSet.getString("telefone_celular"));
                aluno.setTelefoneResidencial(resultSet.getString("telefone_residencial"));
                aluno.setEstaTrancado(resultSet.getBoolean("esta_trancado"));
                aluno.setQtdeTrancamento(resultSet.getInt("qtde_trancamento"));
                aluno.setLogradouro(resultSet.getString("logradouro"));
                aluno.setTipoDeEndereco(resultSet.getString("tipo_endereco"));
                aluno.setTipoLogradouro(resultSet.getString("tipo_logradouro"));
                aluno.setComplemento(resultSet.getString("complemento"));
                aluno.setEstado(resultSet.getString("estado"));
                aluno.setBairro(resultSet.getString("bairro"));
                aluno.setCidade(resultSet.getString("cidade"));
                aluno.setCep(resultSet.getString("cep"));
                aluno.setPais(resultSet.getString("pais"));
                aluno.setNumero(resultSet.getString("numero"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }

    public static ArrayList<Requerimento> obterRequerimentoAreaResponsavelProfessorDesignadoPendente(String cpf) {
      ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();

        try {
            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.AREA_RESPONSAVEL = 0;"
            );

            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    }

    public static ArrayList<Requerimento> obterRequerimentoAreaResponsavelProfessorDesignado(String cpf) {
    ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();

        try {
            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.AREA_RESPONSAVEL = 0;"
            );

            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    
    }

    public static ArrayList<Requerimento> obterRequerimentoAreaResponsavelTecnico() {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();

        try {
            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.AREA_RESPONSAVEL = 0;"
            );

            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;

    }

    public static ArrayList<Requerimento> obterRequerimentoAreaResponsavelProfessor() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return null;
    }

    public static ArrayList<Requerimento> obterRequerimentoRequerenteProfessor() {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE r.tipo_requerente = ? ;"
            );
            query.setString(1, "Professor");
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }
            ;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    }

    public static ArrayList<Requerimento> obterRequerimentoRequerenteAluno() {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE r.tipo_requerente = ? ;"
            );
            query.setString(1, "Aluno");
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }
            ;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;

    }

    public static ArrayList<Requerimento> obterRequerimentoFinalizado() {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.status = ? OR R.status = ? ;"
            );
            query.setString(1, "REJEITADO");
            query.setString(2, "CONCLUIDO");
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }
            ;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
        
    }

    public static ArrayList<Requerimento> obterRequerimentoAreaResponsavelProfessorFinalizado(String cpf) {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();

        try {
            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.AREA_RESPONSAVEL = 0;"
            );

            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    }

    public static ArrayList<Requerimento> obterRequerimentosTriagem() {
        ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.status = ?;"
            );
            query.setString(1, "TRIAGEM");
            
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
        
    }

    public static ArrayList<Requerimento> obterRequerimentoProtocolo(String numeroProtocolo) {
    ArrayList<Requerimento> listaRequerimento = new ArrayList<>();
        Requerimento requerimento = new Requerimento();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.REQUERIMENTOS R WHERE R.numero_requerimento = ?;"
            );
            query.setString(1, numeroProtocolo);
            
            rs = query.executeQuery();
            while (rs.next()) {

                requerimento.setRequerente(obterUsuarioPorID(rs.getInt("id_usuario")));
                requerimento.setDataCriacao(rs.getString("data_criacao"));
                requerimento.setDataSolucao(rs.getString("data_solucao"));
                requerimento.setDescricao(rs.getString("descricao"));
                requerimento.setNumeroRequerimento(rs.getString("numero_requerimento"));
                requerimento.setResposta(rs.getString("resposta"));
                requerimento.setStatus(rs.getString("status"));
                requerimento.setTipoRequerimento(rs.getString("tipo_requerimento"));
                listaRequerimento.add(requerimento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRequerimento;
    }

    public Tecnico obterTecnico(String cpf, String senha) {
        Tecnico tecnico = new Tecnico();
        try {

            PreparedStatement query = con.prepareStatement(
                    "SELECT * FROM SGR.USUARIOS U, SGR.TECNICO T, SGR.ENDERECO E "
                    + "WHERE U.CPF = ? AND U.SENHA = ? and U.id_endereco = E.id_endereco;"
            );
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            if (rs.next()) {
                tecnico.setCpf(rs.getString("cpf"));
                tecnico.setNome(rs.getString("nome"));
                tecnico.setDataNascimeto(rs.getDate("data_nascimento").toLocalDate());
                tecnico.setSenha(rs.getString("senha"));
                tecnico.setEmail(rs.getString("email"));
                tecnico.setEstadoCivil(rs.getString("estado_civil"));
                tecnico.setNacionalidade(rs.getString("nacionalidade"));
                tecnico.setNomeDoPai(rs.getString("nome_pai"));
                tecnico.setNomeDaMae(rs.getString("nome_mae"));
                tecnico.setDeficiencia(rs.getString("deficiencia"));
                tecnico.setSexo(rs.getString("sexo"));
                tecnico.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                tecnico.setTelefoneCelular(rs.getString("telefone_celular"));
                tecnico.setTelefoneResidencial(rs.getString("telefone_residencial"));
                tecnico.setSiape(rs.getString("siape"));
                tecnico.setLogradouro(rs.getString("logradouro"));
                tecnico.setTipoDeEndereco(rs.getString("tipo_endereco"));
                tecnico.setTipoLogradouro(rs.getString("tipo_logradouro"));
                tecnico.setComplemento(rs.getString("complemento"));
                tecnico.setEstado(rs.getString("estado"));
                tecnico.setBairro(rs.getString("bairro"));
                tecnico.setCidade(rs.getString("cidade"));
                tecnico.setCep(rs.getString("cep"));
                tecnico.setPais(rs.getString("pais"));
                tecnico.setNumero(rs.getString("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tecnico;

    }
}
