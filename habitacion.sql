-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2021 a las 05:55:24
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
  `fechaactual` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`numero`, `estado`, `servcuarto`, `servbar`, `servspa`, `servninera`, `servtintoreria`, `servantro`, `servcarro`, `tipo`, `costo`, `totpersonas`, `piso`, `nombre`, `cdorigen`, `fechaingreso`, `fechasalida`, `fechaactual`) VALUES
(105, 1, 1, 0, 0, 1, 0, 1, 1, 1, 500, 2, 1, 'Alicia Huerta', 'AGS', '2021-06-22', '2021-06-24', '2021-06-04'),
(205, 1, 1, 0, 0, 0, 0, 0, 1, 1, 500, 1, 2, 'Abel Diaz Moreno', 'Zacatecas', '2021-06-01', '2021-06-08', '2021-06-04');

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
