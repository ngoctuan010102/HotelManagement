USE master
GO
IF EXISTS(SELECT 'True' FROM master.dbo.SysDatabases WHERE NAME='QLKS')
DROP DATABASE QLKS
GO
CREATE DATABASE QLKS
GO
USE QLKS
GO
CREATE TABLE TaiKhoan
(
	TenDN char(30) PRIMARY KEY,
	MatKhau char(30),
	QuyenKS char(10)
)
GO
CREATE TABLE NhanVien
(
	MaNV char(5) PRIMARY KEY,
	TenNV nvarchar(30),
	GioiTinh bit,
	DiaChi nvarchar(50),
	SoDT char(10),
	ChucVu char(10),
	Luong money,
	TenDN char(30),
	constraint fk_tk FOREIGN KEY(TenDN) REFERENCES TaiKhoan(TenDN) on update cascade on delete cascade
)
GO
CREATE TABLE Phong 
(
	SoPhong int PRIMARY KEY,
	Status char(10),
	LoaiPhong nvarchar(20),
	GiaTien float
)
CREATE TABLE KhachHang
(
	MaKH char(5) PRIMARY KEY,
	TenKH nvarchar(30),
	CCCD char(20),
	GioiTinh bit,
	SoDT char(10)
)
CREATE TABLE DatPhong
(
	MaDP char(10) PRIMARY KEY,
	MaNV char(5),
	MaKH char(5),
	SoPhong int,
	GioDat datetime,
	constraint fk_nv FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV) on update cascade on delete cascade,
	constraint fk_kh FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH) on update cascade on delete cascade,
	constraint fk_phong FOREIGN KEY(SoPhong) REFERENCES Phong(SoPhong) on update cascade on delete cascade
)
CREATE TABLE ThanhToan
(
	MaTT char(10) PRIMARY KEY,
	MaKH char(5) FOREIGN KEY(MaKH) REFERENCES KhachHang(MaKH) on update cascade on delete cascade,
	SoPhong int FOREIGN KEY(SoPhong) REFERENCES Phong(SoPhong) on update cascade on delete cascade,
	GioTra datetime
)
GO
CREATE TRIGGER insert_HD ON DatPhong AFTER INSERT AS
BEGIN
	UPDATE Phong 
	SET Status = 'Busy' FROM Phong JOIN inserted ON Phong.SoPhong = inserted.SoPhong 
END
GO
CREATE TRIGGER insert_TT ON ThanhToan AFTER INSERT AS
BEGIN
	UPDATE Phong 
	SET Status = 'Active' FROM Phong JOIN inserted ON Phong.SoPhong = inserted.SoPhong 
END
GO
CREATE FUNCTION xuat_hd (@madp char(10), @matt char(10))
RETURNS @tbl_hd TABLE (
					MaHD char(10),
					MaKH char(10),
					SoPhong int,
					GioDat datetime,
					GioTra datetime,
					TienTT Float
					)
AS
BEGIN
	DECLARE @mahd char(10)
	SET @mahd = @madp

	DECLARE @makh char(10)
	SELECT @makh =  MaKH FROM ThanhToan WHERE MaTT LIKE @matt

	DECLARE @sophong int 
	SELECT @sophong = SoPhong FROM ThanhToan WHERE MaTT LIKE @matt

	DECLARE @giodat datetime
	SELECT @giodat = GioDat FROM DatPhong WHERE MaDP LIKE @madp

	DECLARE @giotra datetime
	SELECT @giotra = GioTra FROM ThanhToan Where MaTT LIKE @matt

	DECLARE @thoigian float
	SET @thoigian = DATEDIFF(MINUTE, @giodat, @giotra) / 60.0 
	DECLARE @sotien float
	IF (@thoigian > 8)
		BEGIN
			IF (@thoigian < 24)
				SET @sotien = 200000.0
			ELSE
				SET @sotien = (@thoigian/24) * 200000.0 + 50000.0
		END
	ELSE
		BEGIN
			SET @sotien = @thoigian * 80000.0
		END
	INSERT INTO @tbl_hd VALUES (@mahd, @makh, @sophong, @giodat, @giotra, @sotien)
	RETURN
END
GO
--SAMPLE
INSERT INTO TaiKhoan VALUES ('anhpn','12345678','staff'),
							('anhtn','12345678','staff'),
							('tuanhn','12345678','admin'),
							('xuanht','12345678','staff')
GO
INSERT INTO NhanVien VALUES ('NV01','Pham Ngoc Anh',0,'Ha Noi','0495459495','NV',2000,'anhpn'),
							('NV02','Truong Ngoc Anh',0,'Ha Nam','0344459495','NV',2500,'anhtn'),
							('NV03','Ho Ngoc Tuan',1,'Ha Noi','0924723434','QL',10000,'tuanhn'),
							('NV04','Hoang Thi Xuan',0,'Ha Noi','032942394','NV',2000,'xuanht')
GO
INSERT INTO Phong VALUES (1,'Active','Standard',1000),
						 (2,'Active','Standard',1000),
						 (3,'Active','Standard',1000),
						 (4,'Active','Standard',1000),
						 (5,'Active','Superior',2000),
						 (6,'Active','Superior',2000),
						 (7,'Active','Superior',2000),
						 (8,'Active','Superior',2000),
						 (9,'Active','Suite',4000),
						 (10,'Active','Suite',4000)
GO
INSERT INTO KhachHang VALUES ('KH01','Pham Anh','231321323',0,'094384733'),
							 ('KH02','Truong Anh','454545444',0,'067676767'),
							 ('KH03','Tuan Ngoc','676324234',1,'0982763455'),
							 ('KH04','Xuan Hoang','453232222',0,'097738733')
GO
INSERT INTO DatPhong VALUES	('HD01','NV01','KH04',6,'2023-5-24 23:30'),
							('HD02','NV01','KH03',1,'2023-5-24 21:30'),
							('HD03','NV02','KH01',9,'2023-5-24 17:30'),
							('HD04','NV04','KH02',7,'2023-5-24 15:30')

GO
SELECT * FROM DatPhong
SELECT * FROM NhanVien
SELECT * FROM TaiKhoan
SELECT * FROM Phong
GO
INSERT INTO ThanhToan VALUES	('TT01','KH04',6,'2023-5-29 23:30')
INSERT INTO ThanhToan VALUES	('TT02','KH03',1,'2023-5-26 23:30')
SELECT * FROM Phong
SELECT * FROM xuat_hd('HD01','TT01')
SELECT * FROM xuat_hd('HD02','TT02')
GO
