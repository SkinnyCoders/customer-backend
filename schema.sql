CREATE DATABASE test_salt;

USE test_salt;

CREATE TABLE konsument(
	id				int auto_increment primary key,
    nama        	VARCHAR(100) NOT NULL,
    alamat			TEXT,
    kota        	CHAR(100),
    provinsi		CHAR(100),
    tgl_registrasi	DATETIME,
    status			CHAR(100)
) ENGINE InnoDB;