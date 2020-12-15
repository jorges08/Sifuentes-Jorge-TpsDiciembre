-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-12-2020 a las 23:10:22
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
  `idalumnos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `materia` varchar(25) NOT NULL,
  `nota1` int(11) NOT NULL,
  `nota2` int(11) NOT NULL,
  `nota3` int(11) NOT NULL,
  `promedio` int(11) NOT NULL,
  `estatus` varchar(15) NOT NULL,
  PRIMARY KEY (`idalumnos`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=ascii;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idalumnos`, `nombre`, `apellido`, `materia`, `nota1`, `nota2`, `nota3`, `promedio`, `estatus`) VALUES
(7, 'Alexis', 'Ford', 'Quimica', 4, 2, 3, 3, 'Desaprobado'),
(8, 'Ruth', 'Ventura', 'Ingles', 5, 10, 9, 8, 'Aprobado'),
(6, 'Yasmin', 'Noya', 'Matematicas', 2, 10, 6, 6, 'Aprobado'),
(9, 'Juan', 'Perez', 'Literatura', 8, 2, 2, 4, 'Desaprobado'),
(10, 'Lucas', 'Dietrich', 'Ingles', 5, 6, 7, 6, 'Aprobado');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
