create database projetoOlimpiada;

use projetoOlimpiada;

create table pais (
	id_pais integer unsigned not null,
    nome varchar(100) not null,
    populacao bigint unsigned not null,
    area decimal(15,2) not null,
    constraint pk_pais primary key (id_pais)
)ENGINE = InnoDB;

create table modalidade (
	id_modalidade integer unsigned not null,
    nome varchar(100) not null,
    tipo enum('verao', 'inverno'),
    constraint pk_modalidade primary key (id_modalidade)
)ENGINE = InnoDB;

create table olimpiada (
	id_olimpiada integer unsigned not null,
	ano integer unsigned not null,
	tipo enum('verao', 'inverno'),
	id_pais integer unsigned not null,
	id_modalidade integer unsigned not null,
	constraint pk_olimpiada primary key (id_olimpiada),
	constraint fk_pais foreign key (id_pais) references pais(id_pais),
	constraint fk_modalidade foreign key (id_modalidade) references modalidade(id_modalidade)
)ENGINE = InnoDB;

