CREATE TABLE Factura (
	id_factura INT NOT NULL AUTO_INCREMENT,
	cliente varchar(150) NOT NULL,
	item varchar(150) NOT NULL,
	cantidad INT NOT NULL,
	valor_unitario DECIMAL NOT NULL,
	valor_total_producto DECIMAL NOT NULL,
	PRIMARY KEY(id_factura)
);