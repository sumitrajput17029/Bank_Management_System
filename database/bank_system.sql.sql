create database BankSystem;
use banksystem;

create table signup(from_no varchar(30), name varchar(30), father_name varchar(30), DOB varchar(30), gender varchar(30), email varchar(60), marital_status varchar(30), address varchar(60), city varchar(50), pincode varchar(30), state varchar(60));
select*from signup;

create table signuptwo(from_no varchar(30), religion varchar(30), category varchar(30), income varchar(30), education varchar(30), occuption varchar(60), PAN varchar(30), aadhar_card varchar(30), senior_ctizen varchar(30), Existing_account  varchar(30));
Select*from signuptwo;

create table signupthree(from_no varchar(30), account_type varchar(40), card_number varchar(30), pin varchar(30), facility varchar(200));
Select*from signupthree;

create table login(from_no varchar(30), card_number varchar(30), pin varchar(30));
Select*from login;

create table bank(pin varchar(10), date varchar(50),type varchar(20), amount varchar(20));
Select*from bank;
