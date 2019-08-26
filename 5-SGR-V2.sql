CREATE TABLE SGR.disciplinas (
                ID_disciplina SERIAL,
                nome VARCHAR NOT NULL,
                tipo VARCHAR NOT NULL,
                CONSTRAINT disciplinas_pk PRIMARY KEY (ID_disciplina)
);
COMMENT ON COLUMN SGR.disciplinas.tipo IS 'obrigatória ou eletiva';

CREATE TABLE SGR.Endereco (
                ID_endereco SERIAL,
                logradouro VARCHAR(50) NOT NULL,
                tipo_Endereco VARCHAR(50) NOT NULL,
                tipo_Logradouro VARCHAR(50) NOT NULL,
                complemento VARCHAR(50) NOT NULL,
                estado VARCHAR(50) NOT NULL,
                bairro VARCHAR(50) NOT NULL,
                cidade VARCHAR(50) NOT NULL,
                numero VARCHAR(50) NOT NULL,
                cep VARCHAR(50) NOT NULL,
                pais VARCHAR(50) NOT NULL,
                CONSTRAINT endereco_pk PRIMARY KEY (ID_endereco)
);

CREATE TABLE SGR.Usuarios (
                ID_usuario SERIAL,
                ID_endereco INTEGER NOT NULL,
                cpf CHAR(11) NOT NULL,
                nome VARCHAR(200) NOT NULL,
                data_Nascimento DATE NOT NULL,
                senha VARCHAR(20) NOT NULL,
                email VARCHAR(100) NOT NULL,
                estado_Civil VARCHAR(20) NOT NULL,
                nacionalidade VARCHAR(20) NOT NULL,
                nome_Pai VARCHAR(200) NOT NULL,
                nome_Mae VARCHAR(200) NOT NULL,
                deficiencia VARCHAR(20) NOT NULL,
                sexo CHAR NOT NULL,
                data_Ingresso DATE DEFAULT current_date NOT NULL,
		telefone_celular VARCHAR(15),
		telefone_residencial VARCHAR(15),
                CONSTRAINT usuarios_pk PRIMARY KEY (ID_usuario)
);

CREATE TABLE SGR.Requerimentos (
                ID_requerimento SERIAL,
                descricao VARCHAR DEFAULT NULL,
                tipo_requerimento VARCHAR(50) NOT NULL
                ID_disciplina INTEGER DEFAULT 0 NOT NULL,
                ID_usuario INTEGER NOT NULL,
                numero_Requerimento VARCHAR NOT NULL,
                status VARCHAR NOT NULL DEFAULT 'TRIAGEM',
                area_Responsavel INTEGER DEFAULT 0 NOT NULL,
                data_Criacao DATE NOT NULL,
                data_Solucao DATE,
                resposta VARCHAR,
                anexo BYTEA DEFAULT NULL,
                CONSTRAINT requerimentos_pk PRIMARY KEY (ID_requerimento)
);

CREATE TABLE SGR.Aluno (
                ID_aluno SERIAL,
                matricula VARCHAR NOT NULL,
                periodo VARCHAR NOT NULL,
                esta_trancado BOOLEAN NOT NULL,
                qtde_trancamento SMALLINT DEFAULT 0 NOT NULL,
                ID_usuario INTEGER NOT NULL,
                CONSTRAINT aluno_pk PRIMARY KEY (ID_aluno)
);

CREATE TABLE SGR.aluno_disciplina (
                ID_aluno INTEGER NOT NULL,
                ID_disciplina INTEGER NOT NULL,
                CONSTRAINT aluno_disciplina_pk PRIMARY KEY (ID_aluno, ID_disciplina)
);


CREATE TABLE SGR.tecnico (
                ID_tecnico SERIAL,
                SIAPE VARCHAR NOT NULL,
                ID_usuario INTEGER NOT NULL,
                CONSTRAINT tecnico_pk PRIMARY KEY (ID_tecnico)
);



CREATE TABLE SGR.Professor (
                ID_professor SERIAL,
                SIAPE VARCHAR NOT NULL,
                centro_Academico VARCHAR(50) NOT NULL,
                regime_Trabalho VARCHAR(50) NOT NULL,
                classe_Docente VARCHAR(50) NOT NULL,
                titulacao VARCHAR(50) NOT NULL,
                cargo VARCHAR(50) DEFAULT 'Docente',
                ID_usuario INTEGER NOT NULL,
                CONSTRAINT professor_pk PRIMARY KEY (ID_professor)
);


CREATE TABLE SGR.professor_disciplina (
                ID_professor INTEGER NOT NULL,
                ID_disciplina INTEGER NOT NULL,
                CONSTRAINT professor_disciplina_pk PRIMARY KEY (ID_professor, ID_disciplina)
);


ALTER TABLE SGR.aluno_disciplina ADD CONSTRAINT disciplinas_aluno_disciplina_fk
FOREIGN KEY (ID_disciplina)
REFERENCES SGR.disciplinas (ID_disciplina)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.professor_disciplina ADD CONSTRAINT disciplinas_professor_disciplina_fk
FOREIGN KEY (ID_disciplina)
REFERENCES SGR.disciplinas (ID_disciplina)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Requerimentos ADD CONSTRAINT disciplinas_requerimentos_fk
FOREIGN KEY (ID_disciplina)
REFERENCES SGR.disciplinas (ID_disciplina)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Requerimentos ADD CONSTRAINT area_responsavel_fk
FOREIGN KEY (area_responsavel)
REFERENCES SGR.usuarios (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Usuarios ADD CONSTRAINT endereco_usuarios_fk
FOREIGN KEY (ID_endereco)
REFERENCES SGR.Endereco (ID_endereco)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Professor ADD CONSTRAINT usuarios_professor_fk
FOREIGN KEY (ID_usuario)
REFERENCES SGR.Usuarios (ID_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.tecnico ADD CONSTRAINT usuarios_tecnico_fk
FOREIGN KEY (ID_usuario)
REFERENCES SGR.Usuarios (ID_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Aluno ADD CONSTRAINT usuarios_aluno_fk
FOREIGN KEY (ID_usuario)
REFERENCES SGR.Usuarios (ID_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.Requerimentos ADD CONSTRAINT faz
FOREIGN KEY (ID_usuario)
REFERENCES SGR.Usuarios (ID_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.aluno_disciplina ADD CONSTRAINT aluno_aluno_disciplina_fk
FOREIGN KEY (ID_aluno)
REFERENCES SGR.Aluno (ID_aluno)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE SGR.professor_disciplina ADD CONSTRAINT professor_professor_disciplina_fk
FOREIGN KEY (ID_professor)
REFERENCES SGR.Professor (ID_professor)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE OR REPLACE FUNCTION SGR.validaCPF(CPF char) RETURNS BOOLEAN AS $$
DECLARE 
        num1 integer := substring(cpf, 1, 1);
    num2 integer := substring(cpf, 2, 1);
    num3 integer := substring(cpf, 3, 1);
    num4 integer := substring(cpf, 4, 1);
    num5 integer := substring(cpf, 5, 1);
    num6 integer := substring(cpf, 6, 1);
    num7 integer := substring(cpf, 7, 1);
    num8 integer := substring(cpf, 8, 1);
    num9 integer := substring(cpf, 9, 1);
    num10 integer := substring(cpf, 10, 1);
    num11 integer := substring(cpf, 11, 1);
    soma1 integer;
    soma2 integer;
    resto1 integer;
    resto2 integer;
BEGIN
        IF(CHAR_LENGTH(CPF) != 11) THEN
            RETURN FALSE;
    END IF;
    
    IF((num1 = num2) AND (num2 = num3) AND (num3 = num4) AND (num4 = num5) AND (num5 = num6) AND (num6 = num7) AND (num7 = num8) AND (num8 = num9) AND (num9 = num10) AND (num10 = num11)) THEN
            RETURN FALSE;
    END IF;
  
    soma1 := num1 * 10 + num2 * 9 + num3 * 8 + num4 * 7 + num5 * 6 + num6 * 5 + num7 * 4 + num8 * 3 + num9 * 2;
    resto1 := (soma1 * 10) % 11;
    
    IF(resto1 = 10) THEN
            resto1 := 0;
    END IF;
    
    soma2 := num1 * 11 + num2 * 10 + num3 * 9 + num4 * 8 + num5 * 7 + num6 * 6 + num7 * 5 + num8 * 4 + num9 * 3 + num10 * 2;
         resto2 := (soma2 * 10) % 11;
    
    IF(resto2 = 10) THEN
            resto2 := 0;
    END IF;
    
    IF((resto1 = num10) AND (resto2 = num11)) THEN
            RETURN TRUE;
    ELSE
            RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;