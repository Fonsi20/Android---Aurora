-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2019 at 01:05 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `psidb`
--

-- --------------------------------------------------------

--
-- Table structure for table `actividades`
--

CREATE TABLE `actividades` (
  `id` int(2) NOT NULL,
  `nombreA` varchar(50) NOT NULL,
  `descripcionA` varchar(900) NOT NULL,
  `tipoA` enum('escribir','leer','video') DEFAULT NULL,
  `respuesta` varchar(300) NOT NULL,
  `fechayhora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `actividades`
--

INSERT INTO `actividades` (`id`, `nombreA`, `descripcionA`, `tipoA`, `respuesta`, `fechayhora`) VALUES
(1, 'Cual es tu recuerdo mas bonito de tu infancia?', 'Todos tenemos recuerdos de cuando eramos pequenos, y todos ellos cuentan con la alegria con la que los vivimos, cuentanos el que mas feliz te haga!', 'escribir', '', '0000-00-00 00:00:00'),
(2, 'Como llamarias a tu siguiente mascota?', 'De pequeno mi primer perrito se llamaba Lupo, como el musico de Bremen de los 4 musicos. Tienes algun nombre pensado para tu proxima mascota?', 'escribir', '', '0000-00-00 00:00:00'),
(3, 'Entre los libros se esconden los suenos.', '“He oído lo que los poetas escriben sobre las mujeres. Componen rimas y rapsodias, y mienten. He visto a marineros en la orilla contemplando en silencio la lenta ondulación del mar. He visto a viejos soldados con el corazón de cuero que derramaban lágrimas al ver los colores de su rey ondeando al viento.Creedme: esos hombres no saben nada del amor.No lo encontraréis en las palabras de los poetas ni en la mirada anhelante de los marineros. Si queréis saber algo del amor, miradle las manos a un músico de troupe cuando toca un instrumento. Los músicos de troupe si saben” - El Nombre del Viento - Patrick Rothfuss', 'leer', '', '0000-00-00 00:00:00'),
(4, 'Hay que levantarse!', 'https://www.youtube.com/watch?v=cFUnXOLEj7k', 'video', '', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `sentimientos`
--

CREATE TABLE `sentimientos` (
  `fecha` date NOT NULL,
  `sensacion` enum('feliz','neutro','triste') DEFAULT NULL,
  `respuesta` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sentimientos`
--

INSERT INTO `sentimientos` (`fecha`, `sensacion`, `respuesta`) VALUES
('2019-04-16', 'feliz', 2.42);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombreA` (`nombreA`);

--
-- Indexes for table `sentimientos`
--
ALTER TABLE `sentimientos`
  ADD PRIMARY KEY (`fecha`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actividades`
--
ALTER TABLE `actividades`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
