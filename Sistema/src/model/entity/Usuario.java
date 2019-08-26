/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author RafaelSalazarStavale
 */
public class Usuario {

    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    private String senha;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private LocalDate dataNascimeto;
    @Getter
    @Setter
    private String nacionalidade;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String estadoCivil;
    @Getter
    @Setter
    private String sexo;
    @Getter
    @Setter
    private String nomeDaMae;
    @Getter
    @Setter
    private String nomeDoPai;
    @Getter
    @Setter
    private String deficiencia;
    @Getter
    @Setter
    private String tipoDeEndereco;
    @Getter
    @Setter
    private String tipoLogradouro;
    @Getter
    @Setter
    private String logradouro;
    @Getter
    @Setter
    private String complemento;
    @Getter
    @Setter
    private String estado;
    @Getter
    @Setter
    private String telefoneResidencial;
    @Getter
    @Setter
    private String bairro;
    @Getter
    @Setter
    private String cidade;
    @Getter
    @Setter
    private String telefoneCelular;
    @Getter
    @Setter
    private String numero;
    @Getter
    @Setter
    private String cep;
    @Getter
    @Setter
    private String pais;

    public Usuario() {
    }

    public Usuario(String cpf, String senha, String nome, LocalDate dataNascimeto, String nacionalidade, String email, String estadoCivil, String sexo, String nomeDaMae, String nomeDoPai, String deficiencia, String tipoDeEndereco, String tipoLogradouro, String logradouro, String complemento, String estado, String telefoneResidencial, String bairro, String cidade, String telefoneCelular, String numero, String cep, String pais) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.dataNascimeto = dataNascimeto;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
        this.deficiencia = deficiencia;
        this.tipoDeEndereco = tipoDeEndereco;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.estado = estado;
        this.telefoneResidencial = telefoneResidencial;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefoneCelular = telefoneCelular;
        this.numero = numero;
        this.cep = cep;
        this.pais = pais;
    }

}
