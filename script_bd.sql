-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2026 a las 19:05:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `script bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ALU_CODIGO` int(11) NOT NULL,
  `ALU_NOMBRE` varchar(100) NOT NULL,
  `ALU_DIRECCION` varchar(100) DEFAULT NULL,
  `ALU_STATUS` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion_cursos_alumnos`
--

CREATE TABLE `asignacion_cursos_alumnos` (
  `car_codigo` int(11) NOT NULL,
  `cur_codigo` int(11) NOT NULL,
  `ALU_CODIGO` int(11) NOT NULL,
  `mae_codigo` int(11) NOT NULL,
  `jornada_codigo` int(11) NOT NULL,
  `ACA_Nota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `car_codigo` int(11) NOT NULL,
  `car_nombre` varchar(50) NOT NULL,
  `car_status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`car_codigo`, `car_nombre`, `car_status`) VALUES
(8, 'Ingenieria Nuclear', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `cur_codigo` int(11) NOT NULL,
  `cur_nombre` varchar(40) NOT NULL,
  `cur_status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornadas`
--

CREATE TABLE `jornadas` (
  `jor_codigo` int(11) NOT NULL,
  `jor_nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `mae_codigo` int(11) NOT NULL,
  `mae_nombre` varchar(100) NOT NULL,
  `mae_direccion` varchar(150) DEFAULT NULL,
  `mae_estatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ALU_CODIGO`);

--
-- Indices de la tabla `asignacion_cursos_alumnos`
--
ALTER TABLE `asignacion_cursos_alumnos`
  ADD PRIMARY KEY (`car_codigo`,`cur_codigo`,`mae_codigo`,`ALU_CODIGO`,`jornada_codigo`),
  ADD KEY `cur_codigo` (`cur_codigo`),
  ADD KEY `mae_codigo` (`mae_codigo`),
  ADD KEY `ALU_CODIGO` (`ALU_CODIGO`),
  ADD KEY `jornada_codigo` (`jornada_codigo`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`car_codigo`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`cur_codigo`);

--
-- Indices de la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`jor_codigo`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`mae_codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `ALU_CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `car_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `cur_codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `maestros`
--
ALTER TABLE `maestros`
  MODIFY `mae_codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacion_cursos_alumnos`
--
ALTER TABLE `asignacion_cursos_alumnos`
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_1` FOREIGN KEY (`car_codigo`) REFERENCES `carreras` (`car_codigo`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_2` FOREIGN KEY (`cur_codigo`) REFERENCES `cursos` (`cur_codigo`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_3` FOREIGN KEY (`mae_codigo`) REFERENCES `maestros` (`mae_codigo`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_4` FOREIGN KEY (`ALU_CODIGO`) REFERENCES `alumnos` (`ALU_CODIGO`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_5` FOREIGN KEY (`jornada_codigo`) REFERENCES `jornadas` (`jor_codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
