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
public class Tecnico extends Usuario {

    @Getter
    @Setter
    String siape;
    @Getter
    @Setter
    String centroAcademico;
    @Getter
    @Setter
    String lotacao;
    @Getter
    @Setter
    LocalDate dataIngresso;

    public Tecnico() {
    }

    public Tecnico(String siape, String centroAcademico, String lotacao, LocalDate dataIngresso, String cpf, String senha, String nome, LocalDate dataNascimeto, String nacionalidade, String email, String estadoCivil, String sexo, String nomeDaMae, String nomeDoPai, String deficiencia, String tipoDeEndereco, String tipoLogradouro, String logradouro, String complemento, String estado, String telefoneResidencial, String bairro, String cidade, String telefoneCelular, String numero, String cep, String pais) {
        super(cpf, senha, nome, dataNascimeto, nacionalidade, email, estadoCivil, sexo, nomeDaMae, nomeDoPai, deficiencia, tipoDeEndereco, tipoLogradouro, logradouro, complemento, estado, telefoneResidencial, bairro, cidade, telefoneCelular, numero, cep, pais);
        this.siape = siape;
        this.centroAcademico = centroAcademico;
        this.lotacao = lotacao;
        this.dataIngresso = dataIngresso;
    }

}
