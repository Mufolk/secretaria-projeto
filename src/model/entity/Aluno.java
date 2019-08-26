/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author RafaelSalazarStavale
 */
public class Aluno extends Usuario {

    
    private String matricula;
    
    private String periodo;

    
    private LocalDate dataIngresso;

    
    private ArrayList<String> disciplina;

    
    private boolean estaTrancado;

    
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public ArrayList<String> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(ArrayList<String> disciplina) {
		this.disciplina = disciplina;
	}

	public boolean isEstaTrancado() {
		return estaTrancado;
	}

	public void setEstaTrancado(boolean estaTrancado) {
		this.estaTrancado = estaTrancado;
	}

	public int getQtdeTrancamento() {
		return qtdeTrancamento;
	}

	public void setQtdeTrancamento(int qtdeTrancamento) {
		this.qtdeTrancamento = qtdeTrancamento;
	}
    
    

}
