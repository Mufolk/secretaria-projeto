INSERT INTO sgr.requerimentos(
            id_usuario, numero_requerimento, 
            status, area_responsavel, data_criacao, 
            anexo)
    VALUES ((SELECT id_usuario from SGR.USUARIOS WHERE CPF = ?),
		?,
		?,
		?,
		?, ?,);


ALTER TABLE SGR.REQUERIMENTOS alter column area_responsavel set not null

ALTER TABLE SGR.REQUERIMENTOS 
   ADD CONSTRAINT fk_area_responsavel
   FOREIGN KEY (area_responsavel) 
   REFERENCES SGR.USUARIOS(id_usuario);


SELECT * FROM SGR.REQUERIMENTOS R WHERE R.id_usuario = (SELECT id_usuario from SGR.USUARIOS U WHERE U.CPF = '13352738750')






