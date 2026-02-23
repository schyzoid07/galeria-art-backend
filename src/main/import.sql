-- 1. Insertar Géneros
INSERT INTO genre (nombre) VALUES ('Pintura'), ('Escultura'), ('Orfebrería');

-- 2. Insertar Preguntas de Seguridad
INSERT INTO security_question (pregunta) VALUES ('¿Nombre de tu primera mascota?'), ('¿Ciudad de nacimiento de tu madre?'), ('¿Nombre de tu escuela primaria?');

-- 3. Insertar un Artista de prueba
INSERT INTO artist (nombre, biografia, porcentaje_ganancia) VALUES ('Vincent van Gogh', 'Pintor postimpresionista neerlandés.', 10.0);

-- 4. Insertar un Administrador (Password: admin123)
INSERT INTO users (login, password, email, nombre, dtype) VALUES ('admin', 'admin123', 'admin@galeria.com', 'Admin Principal', 'Admin');
INSERT INTO admin (id) SELECT id FROM users WHERE login = 'admin';

-- 5. Insertar una Pintura (Recuerda que usa 2 tablas por la estrategia JOINED)
INSERT INTO art (titulo, precio_base, estatus, id_artista, id_genero) VALUES ('La Noche Estrellada', 1500.0, 'Disponible', 1, 1);
INSERT INTO painting (id, tecnica, estilo) VALUES (1, 'Óleo', 'Postimpresionismo');