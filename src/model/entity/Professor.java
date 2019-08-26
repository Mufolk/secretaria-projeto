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
public class Professor extends Usuario {

    
    ArrayList<String> grade = new ArrayList<>();
    
    String siape;
    String centroAcademico = "CCET";
    LocalDate dataIngresso;
    String regimeTrabalho;
    String lotacao = "Escola de Informática Aplicada";
    String classeDocente;
    String titulacao;
    String cargo;

    public Professor() {
    }

    public Professor(String siape, LocalDate dataIngresso, String regimeTrabalho, String classeDocente, String titulacao, String cargo, String cpf, String senha, String nome, LocalDate dataNascimeto, String nacionalidade, String email, String estadoCivil, String sexo, String nomeDaMae, String nomeDoPai, String deficiencia, String tipoDeEndereco, String tipoLogradouro, String logradouro, String complemento, String estado, String telefoneResidencial, String bairro, String cidade, String telefoneCelular, String numero, String cep, String pais) {
        super(cpf, senha, nome, dataNascimeto, nacionalidade, email, estadoCivil, sexo, nomeDaMae, nomeDoPai, deficiencia, tipoDeEndereco, tipoLogradouro, logradouro, complemento, estado, telefoneResidencial, bairro, cidade, telefoneCelular, numero, cep, pais);
        this.siape = siape;
        this.dataIngresso = dataIngresso;
        this.regimeTrabalho = regimeTrabalho;
        this.classeDocente = classeDocente;
        this.titulacao = titulacao;
        this.cargo = cargo;
    }

	public ArrayList<String> getGrade() {
		return grade;
	}

	public void setGrade(ArrayList<String> grade) {
		this.grade = grade;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getCentroAcademico() {
		return centroAcademico;
	}

	public void setCentroAcademico(String centroAcademico) {
		this.centroAcademico = centroAcademico;
	}

	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public String getRegimeTrabalho() {
		return regimeTrabalho;
	}

	public void setRegimeTrabalho(String regimeTrabalho) {
		this.regimeTrabalho = regimeTrabalho;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getClasseDocente() {
		return classeDocente;
	}

	public void setClasseDocente(String classeDocente) {
		this.classeDocente = classeDocente;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    
    

}
