

insert into address (street, zipcode, city)
values ('lillbrostigen 1', 18463, 'åkersberga'),
       ('sidgatan 3', 85241, 'Sundsvall'),
       ('brovägen 53', 62428, ' Täby'),
       ('kallax stig 22', 57623, 'Växjö'),
       ('storhagsvägen 27', 95824, 'Malmö');

insert into members (first_name, last_name, date_of_birth, address, email)
values ('sebastian', 'fyr', '1990-09-26', 1, 'sebbe.fyhr@hotmail.com'),
       ('Dempa', 'demp', '1947-12-23', 2, 'demps@nerd.com'),
       ('susanne', 'reuter', '1899-04-30', 3, 's.reuter@strix.se'),
       ('Ludwig', 'torneus', '2002-12-12', 4, 'ludde.kudde@rolig.se'),
       ('Tanja', 'soneus', '1986-02-08', 5, 'tanja.coolio@spray.com'),
       ('Cecilia', 'demp', '1952-11-27', 2, 'cecilss@nerd.com');



insert into users
values
    ('tiger', '{bcrypt}$2a$10$edf0TQaGjCBcg2iw6artd.8KuyOcyjm2sJdFJGp0WZjjtjfcTMM0O', 1), /*paWpatrol*/
    ('jerry', '{bcrypt}$2a$10$tmXFogQehkhoe0E9oE1lBea8Yr3/2PRH2Ffo.TRUELPuW2mrhM19C', 1), /*dogsAndC4t5*/
    ('tiffany', '{bcrypt}$2a$10$wB5N7BZ8oyqxuSLgSi2yKemjoY6LxU6HnYQ.xnrmppuptrPU45U9K', 1),/*tass*/
    ('sebbe', '{bcrypt}$2a$10$Ea2eAJPxItJKh.RZxe6vaOr/IlMur7DIZwgl.F3xjjGjn1WneeeXW', 1); /*tassen*/


insert into authorities
values
    ('tiger', 'ROLE_USER'),
    ('jerry', 'ROLE_USER'),
    ('tiffany', 'ROLE_ADMIN'),
    ('sebbe', 'ROLE_ADMIN');

