USE WebServiceDb;

INSERT INTO Users (Firstname, Lastname, Login, Password, Salt, Role)
VALUES ('Jean', 'Pal', 'jean.pal', 'motdepassesalé', 'salé    ', 'developer');
INSERT INTO Users (Firstname, Lastname, Login, Password, Salt, Role)
VALUES ('Michel', 'Blanc', 'michel.blanc', 'unautremotdepasseausel', 'ausel   ', 'developer');
INSERT INTO Users (Firstname, Lastname, Login, Password, Salt, Role)
VALUES ('Peter', 'Smith', 'peter.smith', 'passwordwithsalt', 'withsalt', 'developer');


INSERT INTO Projects (Label) VALUES ('projet 1');
INSERT INTO Projects (Label) VALUES ('projet 2');
INSERT INTO Projects (Label) VALUES ('projet 3');
INSERT INTO Projects (Label) VALUES ('projet X');