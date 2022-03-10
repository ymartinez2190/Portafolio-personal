create database dbo_vaccine;
use dbo_vaccine;
create table tbl_vaccine(idvaccine int not null auto_increment,vaccinename varchar(50)not null,efficacy int not null, dosequantity int not null, weeksperdose int not null, primary key(idvaccine));
insert into tbl_vaccine(vaccinename, efficacy,dosequantity,weeksperdose)values("Pfizer",95,2,4),("AstraZeneca",76,2,8),("Moderna",94,2,4),("Johnson & Johnson",72,0,0);
create table tbl_client(idclient varchar(50) not null, firstname varchar(50) not null, lastname varchar(50) not null, phone varchar(50) not null, primary key(idclient));
create table tbl_vaccinationinfo(idinfo int not null auto_increment, idclient varchar(50)not null, idvaccine int not null, firstdose date not null, lastdose date not null, primary key(idinfo), foreign key(idclient) references tbl_client(idclient));

