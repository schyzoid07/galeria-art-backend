INSERT INTO genre (nombre) VALUES ('Pintura');
INSERT INTO genre (nombre) VALUES ('Escultura');
INSERT INTO genre (nombre) VALUES ('Orfebrería');

INSERT INTO security_question (pregunta) VALUES ('¿Nombre de tu primera mascota?');
INSERT INTO security_question (pregunta) VALUES ('¿Ciudad de nacimiento de tu madre?');

INSERT INTO artist (nombre, biografia, nacionalidad, fecha_nacimiento, porcentaje_ganancia) VALUES ('Vincent van Gogh', 'Pintor postimpresionista.', 'Neerlandés', '1853-03-30', 8.50);

INSERT INTO users (login, password, nombre, apellido, email, telefono, activo) VALUES ('admin', 'admin123', 'Admin', 'Principal', 'admin@museo.com', '123456', TRUE);

INSERT INTO admin (id_usuario, cargo) VALUES (1, 'Gerente');

INSERT INTO art (nombre, precio_base, fecha_creacion, estatus, imagen_url, id_artista, id_genero) VALUES ('La Noche Estrellada', 1500.00, '1889-06-01', 'Disponible', 'https://link-a-imagen.com/noche.jpg', 1, 1);

INSERT INTO painting (id_obra, tecnica, estilo) VALUES (1, 'Óleo', 'Postimpresionismo');