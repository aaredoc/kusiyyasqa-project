INSERT INTO zona(nombre) VALUES ('Los Jazmines');
INSERT INTO zona(nombre) VALUES ('La Perla');

INSERT INTO sector(nombre, zona_id) VALUES ('Trujillo', 1);
INSERT INTO sector(nombre, zona_id) VALUES ('Esperanza', 2);

INSERT INTO nacionalidad(nombre) VALUES ('Peru');
INSERT INTO nacionalidad(nombre) VALUES ('Argentina');

INSERT INTO seguro(tipo) VALUES('completo');

INSERT INTO administrador(apellido_materno, apellido_paterno, celular, email, identificacion, nombres, telefono, direccion, fecha_nacimiento, codigo, password, username, nacionalidad_id, sector_id, seguro_id, enabled) VALUES('Cabosmalon', 'Aredo', '912992934', 'aaredo@gmail.com', '70941729', 'Alexander', '044667023', 'Los Jazmines Mz P Lt 11', NOW(), '020317', 'password', 'aaredo', 1, 1, 1, true);


