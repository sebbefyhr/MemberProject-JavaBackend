drop table if exists address, members, users,authorities;
create table address
(
    id      int         not null AUTO_INCREMENT primary key,
    street  varchar(70) not null default '',
    zipcode int         not null default '00000',
    city    varchar(40) not null default ''
);

create table members
(
    id            int         not null AUTO_INCREMENT primary key,
    first_name    varchar(40) not null,
    last_name     varchar(45) not null,
    date_of_birth date        not null,
    address       int         not null,
    email         varchar(70) not null unique,
    phone_number  varchar(20),
    foreign key (address) references address (id)
);



create table users(
    username varchar(45) primary key not null,
    password varchar(68) not null,
    enabled boolean not null
);

create table authorities
(
    username varchar(45) not null primary key,
    authority varchar(45) not null,
    constraint authorities_idx_1 unique (username, authority),
    constraint authorities_ibfk_1
    foreign key (username)
    references users (username));
