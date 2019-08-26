/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author RafaelSalazarStavale
 */
public class Aluno extends Usuario {

    @Getter
    @Setter
    private String matricula;
    @Getter
    @Setter
    private String periodo;

    @Getter
    @Setter
    private LocalDate dataIngresso;

    @Getter
    @Setter
    private ArrayList<String> disciplina;

    @Getter
    @Setter
    private boolean estaTrancado;

    @Getter
    @Setter
    private int qtdeTrancamento;

    public Aluno() {
    }

    public Aluno(String matricula, String periodo, LocalDate dataIngresso, ArrayList<String> disciplina, boolean estaTrancado, int qtdeTrancamento, String cpf, String senha, String nome, LocalDate dataNascimeto, String nacionalidade, String email, String estadoCivil, String sexo, String nomeDaMae, String nomeDoPai, String deficiencia, String tipoDeEndereco, String tipoLogradouro, String logradouro, String complemento, String estado, String telefoneResidencial, String bairro, String cidade, String telefoneCelular, String numero, String cep, String pais) {
        super(cpf, senha, nome, dataNascimeto, nacionalidade, email, estadoCivil, sexo, nomeDaMae, nomeDoPai, deficiencia, tipoDeEndereco, tipoLogradouro, logradouro, complemento, estado, telefoneResidencial, bairro, cidade, telefoneCelular, numero, cep, pais);
        this.matricula = matricula;
        this.periodo = periodo;
        this.dataIngresso = dataIngresso;
        this.disciplina = disciplina;
        this.estaTrancado = estaTrancado;
        this.qtdeTrancamento = qtdeTrancamento;
    }

}
