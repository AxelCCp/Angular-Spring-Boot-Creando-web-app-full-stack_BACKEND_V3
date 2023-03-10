INSERT INTO regiones (id, nombre) VALUES (1, 'Sudam?rica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroam?rica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteam?rica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, '?frica');
INSERT INTO regiones (id, nombre) VALUES (6, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (7, 'Ocean?a');
INSERT INTO regiones (id, nombre) VALUES (8, 'Ant?rtida');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2,'ASJHAS','AKSJHD','HasASG@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3,'ZIZU','SDS','A@KDJFH.COM','2019-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1,'OWR','ZXC','ADS@KDJFH.COM','2015-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4,'ZXCX','WQE','DF@KDJFH.COM','2016-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (8,'MKO','RTY','XC@KDJFH.COM','2012-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7,'NMBFFS','QQW','WER@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5,'QUTW','ZXC','XCV@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3,'WMNWM','ERT','XCVj@KDJFH.COM','2021-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (6,'ZOCXIU','ZXC','XCAV@KDJFH.COM','2022-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4,'AHSKJ','TYU','HASDASG@KDJFH.COM','2010-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2,'MAASD','QW','QEEEW@KDJFH.COM','2011-01-01');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3,'ASJHAS','AKSJHD','1HasASG@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5,'ZIZU','SDS','1A@KDJFH.COM','2019-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (8,'OWR','ZXC','1ADS@KDJFH.COM','2015-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7,'ZXCX','WQE','1DF@KDJFH.COM','2016-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1,'MKO','RTY','1XC@KDJFH.COM','2012-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2,'NMBFFS','QQW','1WER@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1,'QUTW','ZXC','1XCV@KDJFH.COM','2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (6,'WMNWM','ERT','1XCVj@KDJFH.COM','2021-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5,'ZOCXIU','ZXC','1XCAV@KDJFH.COM','2022-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4,'AHSKJ','TYU','1HASDASG@KDJFH.COM','2010-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3,'MAASD','QW','1QEEEW@KDJFH.COM','2011-01-01');


INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres', '$2a$10$S01KtNl4n8m9UyyJxYgzxu.2TofOwQNFJi2XT/EXwAMjSqEBPC92O', 1, 'Andres', 'Guz', 'asdasd@kjhj.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$3w8NEpLSRY8WVtHEONvxzuOU0gx3dLeqT9iATh3dL3FPPavoviTSS', 1, 'Rey', 'Pilaf', 'xcvx@jkh.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);

INSERT INTO productos (nombre, precio, create_at) VALUES ('panasonic pantalla lcd', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('sony camara digital', 123456, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('apple iphone', 353453, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('sony notebook', 345398, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('msi katana', 55555, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('hewlett packard', 7777777, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('bicicleta xxx', 999999, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('mueble yyy', 111111, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('otra wea', 5656565, NOW());

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', 'hartas weas', 1, now());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (2,1,4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1,1,7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES ('Factura Bicicleta', 'alguna nota importante', 1, now());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3,2,6);



