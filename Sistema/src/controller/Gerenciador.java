package controller;

import dao.ConexaoBancoDeDados;
import dao.ManipuladorXML;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.Aluno;

import model.entity.Professor;
import model.entity.Tecnico;

import model.requerimento.Requerimento;

public class Gerenciador {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/SGR";
    private static final String USER = "postgres";
    private static final String PASS = "";
    private static final ConexaoBancoDeDados dbconnection = new ConexaoBancoDeDados();

    public static void analisaRequerimento(Requerimento requerimento) {

        switch (requerimento.getStatus()) {
            case "TRIAGEM":
                try {

                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ConexaoBancoDeDados.criarNovoRequerimentoAluno(requerimento);
                    ConexaoBancoDeDados.closeConnection();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "DESIGNADO": {
                try {
                    String novoStatus = "DESIGNADO";
                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ConexaoBancoDeDados.atualizarRequerimento(requerimento,novoStatus);
                    ConexaoBancoDeDados.closeConnection();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            }
            case "CONCLUIDO": {
                try {
                    String novoStatus = "CONCLUIDO";
                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ConexaoBancoDeDados.atualizarRequerimento(requerimento,novoStatus);
                    ConexaoBancoDeDados.closeConnection();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "REJEITADO": {
                try {
                    String novoStatus = "REJEITADO";
                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ConexaoBancoDeDados.atualizarRequerimento(requerimento,novoStatus);
                    ConexaoBancoDeDados.closeConnection();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "PENDENTE": {
                try {
                    String novoStatus = "PENDENTE";
                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ConexaoBancoDeDados.atualizarRequerimento(requerimento, novoStatus);
                    ConexaoBancoDeDados.closeConnection();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }

    public static Aluno obterAluno(String cpf, String senha) throws ClassNotFoundException, SQLException {

        ConexaoBancoDeDados.openConnection(URL, USER, PASS);
        Aluno alunoObtido = ConexaoBancoDeDados.obterAluno(cpf, senha);
        ConexaoBancoDeDados.closeConnection();
        if (alunoObtido.getCpf() == null) {
            return null;
        } else {
            return alunoObtido;
        }
    }

    public static Tecnico obterTecnico(String cpf, String senha) throws ClassNotFoundException, SQLException {

        ConexaoBancoDeDados.openConnection(URL, USER, PASS);
        Tecnico tecnico = dbconnection.obterTecnico(cpf, senha);
        ConexaoBancoDeDados.closeConnection();
        if (tecnico.getCpf() == null) {
            return null;
        } else {
            return tecnico;
        }

    }

    public static Professor obterProfessorDisciplina(String disciplina) {
        ArrayList<Professor> lista;
        Professor professorObtido;
        professorObtido = null;

//        for (int i = 0; i < lista.size(); i++) {
////            System.out.println(lista.get(i).getGrade().get(i));
////
//            if ((lista.get(i).getGrade().contains(disciplina))) {
//
//                professorObtido = lista.get(i);
//                return professorObtido;
//            }
//        }
        return professorObtido;
    }

    public static Professor obterProfessorCargo(String cargo) {

        ArrayList<Professor> lista;
        Professor professorObtido;
        professorObtido = null;

        return professorObtido;
    }

    public static Tecnico criarTecnicoGenerico() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Tecnico Generico");
        tecnico.setCpf("0000");
        return tecnico;
    }

    public static Professor obterProfessorCPFSenha(String cpf, String senha) throws SQLException, ClassNotFoundException {

        ConexaoBancoDeDados.openConnection(URL, USER, PASS);
        Professor professorObtido = ConexaoBancoDeDados.obterProfessorCPFSenha(cpf, senha);
        ConexaoBancoDeDados.closeConnection();
        if (professorObtido.getCpf() == null) {
            return null;
        } else {
            return professorObtido;
        }
    }

    public static ArrayList<Requerimento> buscarRequerimentosTriagem() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentosTriagem();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoProtocolo(String numeroProtocolo) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoProtocolo(numeroProtocolo);
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    
        
    }

    public static ArrayList<Requerimento> buscarRequerimentoCPF(String cpf) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentosPorCPF(cpf);
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoRequerenteAluno() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoRequerenteAluno();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoRequerenteProfessor() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoRequerenteProfessor();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessor() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoAreaResponsavelProfessor();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelTecnico() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoAreaResponsavelTecnico();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoFinalizado() {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoFinalizado();
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignado(String cpf) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoAreaResponsavelProfessorDesignado(cpf);
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignadoPendente(String cpf) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoAreaResponsavelProfessorDesignadoPendente(cpf);
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorFinalizado(String cpf) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentoAreaResponsavelProfessorFinalizado(cpf);
            ConexaoBancoDeDados.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaRetorno;
    }

}
