-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 10, 2020 at 09:12 AM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlsv`
--
CREATE DATABASE IF NOT EXISTS `qlsv` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `qlsv`;

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
CREATE TABLE IF NOT EXISTS `sinhvien` (
  `masv` char(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hoten` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` enum('Nam','Nữ') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Nam',
  `ngaysinh` date NOT NULL,
  `khoa` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lop` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdt` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`masv`),
  UNIQUE KEY `sdt` (`sdt`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`masv`, `hoten`, `gioitinh`, `ngaysinh`, `khoa`, `lop`, `email`, `sdt`, `diachi`) VALUES
('1688', 'Lưu Thị Kiều Oanh', 'Nữ', '2001-03-02', 'CNTT', 'CD19TT9', 'oanh@gmail.com', '0845453291', 'Cà Mau'),
('1795', 'Phan Hồng Bảo Ngọc', 'Nữ', '2001-06-15', 'CNTT', 'CD19TT9', 'ngoc@gmail.com', '0933018608', 'Đồng Nai'),
('4165', 'Nguyễn Lê Trọng Tiền', 'Nam', '2001-10-30', 'CNTT', 'CD19TT9', 'tien@gmail.com', '0774842930', 'Đồng Tháp'),
('1111', 'Huỳnh Dương Mỹ Uyên', 'Nữ', '2001-08-25', 'CNTT', 'CD19TT9', 'uyen@gmail.com', '0974606593', 'Thủ Đức'),
('4280', 'Vũ Minh Chuẩn', 'Nam', '1999-09-29', 'CNTT', 'CD19TT9', 'chuan@gmail.com', '0907366693', 'Vĩnh Long');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
