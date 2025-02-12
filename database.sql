CREATE TABLE departamento (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE vendedor (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  DataDeNascimento datetime NOT NULL,
  SalarioBase double NOT NULL,
  DepartamentoId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartamentoId) REFERENCES departamento (id)
);

INSERT INTO departamento (Nome) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');