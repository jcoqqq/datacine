-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 14, 2023 at 12:42 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_cine`
--
DROP DATABASE IF EXISTS `data_cine`;
CREATE DATABASE IF NOT EXISTS `data_cine` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `data_cine`;

-- --------------------------------------------------------

--
-- Table structure for table `acteur`
--

DROP TABLE IF EXISTS `acteur`;
CREATE TABLE IF NOT EXISTS `acteur` (
  `id_acteur` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  PRIMARY KEY (`id_acteur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acteur`
--

INSERT INTO `acteur` (`id_acteur`, `prenom`, `nom`, `date_naissance`) VALUES
(1, 'jean', 'jeeaaan', '2023-04-04');

-- --------------------------------------------------------

--
-- Table structure for table `acteur_film_realisateur`
--

DROP TABLE IF EXISTS `acteur_film_realisateur`;
CREATE TABLE IF NOT EXISTS `acteur_film_realisateur` (
  `id_acteurFilm` int NOT NULL AUTO_INCREMENT,
  `id_acteur` int NOT NULL,
  `id_film` int NOT NULL,
  `id_realisateur` int NOT NULL,
  PRIMARY KEY (`id_acteurFilm`),
  KEY `acteur` (`id_acteur`),
  KEY `film` (`id_film`),
  KEY `realisateur` (`id_realisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acteur_film_realisateur`
--

INSERT INTO `acteur_film_realisateur` (`id_acteurFilm`, `id_acteur`, `id_film`, `id_realisateur`) VALUES
(1, 1, 2, 1),
(2, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `avisacteur`
--

DROP TABLE IF EXISTS `avisacteur`;
CREATE TABLE IF NOT EXISTS `avisacteur` (
  `id_avis_acteur` int NOT NULL AUTO_INCREMENT,
  `id_acteur` int NOT NULL,
  `avis` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `note` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_avis_acteur`),
  KEY `user` (`id_user`),
  KEY `acteurcontr` (`id_acteur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avisacteur`
--

INSERT INTO `avisacteur` (`id_avis_acteur`, `id_acteur`, `avis`, `note`, `id_user`) VALUES
(1, 1, 'est', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `avisfilm`
--

DROP TABLE IF EXISTS `avisfilm`;
CREATE TABLE IF NOT EXISTS `avisfilm` (
  `id_filmAvis` int NOT NULL AUTO_INCREMENT,
  `id_film` int NOT NULL,
  `avis` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `note` int NOT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_filmAvis`),
  KEY `user2` (`id_user`),
  KEY `filmcontrainte` (`id_film`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avisfilm`
--

INSERT INTO `avisfilm` (`id_filmAvis`, `id_film`, `avis`, `note`, `id_user`) VALUES
(2, 1, 'bien', 4, 2),
(4, 2, 'super', 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `avisrealisateur`
--

DROP TABLE IF EXISTS `avisrealisateur`;
CREATE TABLE IF NOT EXISTS `avisrealisateur` (
  `id_realisateurAvis` int NOT NULL AUTO_INCREMENT,
  `id_realisateur` int NOT NULL,
  `avis` text NOT NULL,
  `note` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_realisateurAvis`),
  KEY `user3` (`id_user`),
  KEY `realis2` (`id_realisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avisrealisateur`
--

INSERT INTO `avisrealisateur` (`id_realisateurAvis`, `id_realisateur`, `avis`, `note`, `id_user`) VALUES
(1, 1, 'rtyuiop', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `id_film` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(75) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_film`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id_film`, `nom`, `description`) VALUES
(1, 'sonic', 'sonic : film à regarder en famille'),
(2, 'avatar', 'avatar : film interessant'),
(3, 'uncharted', 'uncharted : film action');

-- --------------------------------------------------------

--
-- Table structure for table `realisateur`
--

DROP TABLE IF EXISTS `realisateur`;
CREATE TABLE IF NOT EXISTS `realisateur` (
  `id_realisateur` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date_naissance` date DEFAULT NULL,
  PRIMARY KEY (`id_realisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `realisateur`
--

INSERT INTO `realisateur` (`id_realisateur`, `prenom`, `nom`, `date_naissance`) VALUES
(1, 'xav', 'dol', '2023-04-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` text NOT NULL,
  `mail` text NOT NULL,
  `password` text NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user`, `mail`, `password`, `admin`) VALUES
(1, 'test', 'test@test', 'test', 1),
(2, 'a', 'a@test.fr', 'test', 0),
(7, 'rem', 'rem@rem.fr', 'test', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acteur_film_realisateur`
--
ALTER TABLE `acteur_film_realisateur`
  ADD CONSTRAINT `acteur` FOREIGN KEY (`id_acteur`) REFERENCES `acteur` (`id_acteur`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `film` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `realisateur` FOREIGN KEY (`id_realisateur`) REFERENCES `realisateur` (`id_realisateur`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `avisacteur`
--
ALTER TABLE `avisacteur`
  ADD CONSTRAINT `acteurcontr` FOREIGN KEY (`id_acteur`) REFERENCES `acteur` (`id_acteur`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `avisfilm`
--
ALTER TABLE `avisfilm`
  ADD CONSTRAINT `filmcontrainte` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `user2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `avisrealisateur`
--
ALTER TABLE `avisrealisateur`
  ADD CONSTRAINT `realis2` FOREIGN KEY (`id_realisateur`) REFERENCES `realisateur` (`id_realisateur`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `user3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
