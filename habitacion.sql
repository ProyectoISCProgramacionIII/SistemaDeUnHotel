-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2021 a las 21:46:17
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `numero` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `servcuarto` tinyint(1) NOT NULL,
  `servbar` tinyint(1) NOT NULL,
  `servspa` tinyint(1) NOT NULL,
  `servninera` tinyint(1) NOT NULL,
  `servtintoreria` tinyint(1) NOT NULL,
  `servantro` tinyint(1) NOT NULL,
  `servcarro` tinyint(1) NOT NULL,
  `tipo` int(11) NOT NULL,
  `costo` double NOT NULL,
  `totpersonas` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `cdorigen` varchar(40) NOT NULL,
  `fechaingreso` date NOT NULL,
  `fechasalida` date NOT NULL,
  `pos` int(11) NOT NULL,
  `totDias` int(11) NOT NULL,
  `personasExtr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`numero`, `estado`, `servcuarto`, `servbar`, `servspa`, `servninera`, `servtintoreria`, `servantro`, `servcarro`, `tipo`, `costo`, `totpersonas`, `piso`, `nombre`, `cdorigen`, `fechaingreso`, `fechasalida`, `pos`, `totDias`, `personasExtr`) VALUES
(102, 1, 1, 1, 0, 0, 0, 1, 1, 1, 500, 3, 1, 'Juan Carlos Alonso', 'Ciudad De México', '2021-06-27', '2021-06-30', 2, 3, 2),
(104, 1, 1, 0, 1, 0, 0, 1, 0, 1, 500, 1, 1, 'Cristobal rivera', 'Aguascalientes', '2021-06-04', '2021-06-19', 4, 15, 0),
(105, 1, 1, 0, 0, 1, 0, 1, 1, 1, 500, 2, 1, 'Alicia Huerta', 'AGS', '2021-06-22', '2021-06-24', 5, 2, 1),
(200, 1, 0, 0, 0, 0, 0, 1, 0, 1, 500, 2, 2, 'Alexander Marquez', 'Guadalajara', '2021-06-06', '2021-06-11', 15, 5, 1),
(201, 1, 1, 0, 0, 0, 0, 0, 1, 1, 500, 1, 2, 'Flor Hernandez', 'Aguascalientes', '2021-06-04', '2021-06-14', 16, 10, 0),
(203, 1, 1, 0, 0, 1, 0, 0, 1, 1, 500, 1, 2, 'Arturo Vazques', 'Guanajuato', '2021-06-05', '2021-06-09', 18, 4, 0),
(205, 1, 0, 1, 0, 0, 0, 1, 1, 1, 500, 3, 2, 'Abel Diaz Moreno', 'Zacatecas', '2021-06-01', '2021-06-02', 20, 1, 2),
(207, 1, 1, 0, 0, 0, 0, 0, 1, 2, 1000, 2, 2, 'Julian Vasquez', 'San Luis Potosi', '2021-06-05', '2021-06-20', 22, 15, 0),
(208, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1000, 2, 2, 'Heriberto Martinez', 'Puebla', '2021-06-18', '2021-06-19', 23, 1, 0),
(209, 1, 1, 0, 0, 0, 0, 0, 0, 3, 1500, 1, 2, 'Maria Clara Duarte Herrera', 'Mazatlan', '2021-05-06', '2021-05-21', 24, 15, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
