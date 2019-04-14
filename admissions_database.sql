-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 04, 2019 at 01:47 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `admissions_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `name` varchar(60) NOT NULL,
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `surname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `alevelsubs`
--

DROP TABLE IF EXISTS `alevelsubs`;
CREATE TABLE IF NOT EXISTS `alevelsubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(15) NOT NULL,
  `grade` int(10) NOT NULL,
  `subject` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `alevelsubs_ibfk_1` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alevelsubs`
--

INSERT INTO `alevelsubs` (`id`, `student_id`, `grade`, `subject`) VALUES
(20, '100', 5, 'Maths'),
(21, '100', 3, 'Biology'),
(22, '100', 4, 'Chemistry'),
(23, '101', 5, 'Maths'),
(24, '101', 5, 'Physics'),
(25, '101', 4, 'Chemistry'),
(26, '102', 5, 'Computers'),
(27, '102', 5, 'Chemistry'),
(28, '102', 4, 'Biology'),
(29, '103', 5, 'Maths'),
(30, '103', 3, 'Physics'),
(31, '103', 4, 'Chemistry'),
(32, '105', 5, 'Maths'),
(33, '105', 3, 'Geography'),
(34, '105', 4, 'Physics');

-- --------------------------------------------------------

--
-- Table structure for table `constants_table`
--

DROP TABLE IF EXISTS `constants_table`;
CREATE TABLE IF NOT EXISTS `constants_table` (
  `program` varchar(60) NOT NULL,
  `physics` float NOT NULL,
  `chemistry` float NOT NULL,
  `maths` float NOT NULL,
  `geography` float NOT NULL,
  `biology` float NOT NULL,
  `computers` float NOT NULL,
  `agriculture` float NOT NULL,
  `cutoff` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `constants_table`
--

INSERT INTO `constants_table` (`program`, `physics`, `chemistry`, `maths`, `geography`, `biology`, `computers`, `agriculture`, `cutoff`) VALUES
('CS', 0.4, 0.3, 0.4, 0.2, 0.2, 0.4, 0.1, 5),
('EE', 0.4, 0.3, 0.4, 0.2, 0.2, 0.4, 0.2, 7),
('BioTech', 0.4, 0.4, 0.4, 0.1, 0.4, 0.4, 0.4, 6),
('CPSE', 0.4, 0.4, 0.4, 0.3, 0.2, 0.2, 0.2, 11);

-- --------------------------------------------------------

--
-- Table structure for table `enrolls`
--

DROP TABLE IF EXISTS `enrolls`;
CREATE TABLE IF NOT EXISTS `enrolls` (
  `student_id` varchar(15) NOT NULL,
  `admin_id` varchar(20) NOT NULL,
  KEY `student_id` (`student_id`),
  KEY `admin_id` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `olevelsubs`
--

DROP TABLE IF EXISTS `olevelsubs`;
CREATE TABLE IF NOT EXISTS `olevelsubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) NOT NULL,
  `student_id` varchar(15) NOT NULL,
  `grade` int(10) NOT NULL,
  PRIMARY KEY (`id`,`subject`),
  KEY `olevelsubs_ibfk_2` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `olevelsubs`
--

INSERT INTO `olevelsubs` (`id`, `subject`, `student_id`, `grade`) VALUES
(10, 'maths', '100', 5),
(11, 'english', '100', 3),
(12, 'geo', '100', 5),
(13, 'agric', '100', 3),
(14, 'hist', '100', 4),
(15, 'maths', '101', 5),
(16, 'english', '101', 3),
(17, 'hist', '101', 4),
(18, 'fashion', '101', 4),
(19, 'biology', '101', 2),
(20, 'maths', '102', 5),
(21, 'hist', '102', 3),
(22, 'english', '102', 4),
(23, 'geo', '102', 4),
(24, 'biology', '102', 2),
(25, 'english', '103', 5),
(26, 'hist', '103', 3),
(27, 'bible', '103', 4),
(28, 'religion', '103', 4),
(29, 'shona', '103', 2),
(30, 'maths', '105', 5),
(31, 'english', '105', 3),
(32, 'geo', '105', 4),
(33, 'computers', '105', 4),
(34, 'shona', '105', 2);

-- --------------------------------------------------------

--
-- Table structure for table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
CREATE TABLE IF NOT EXISTS `preferences` (
  `f_choice` varchar(20) DEFAULT NULL,
  `sec_choice` varchar(60) NOT NULL,
  `third_choice` varchar(60) NOT NULL,
  `student_id` varchar(15) NOT NULL,
  `pref_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pref_id`),
  KEY `preferences_ibfk_1` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preferences`
--

INSERT INTO `preferences` (`f_choice`, `sec_choice`, `third_choice`, `student_id`, `pref_id`) VALUES
('BioTech', 'EE', 'CS', '102', 1),
('CPSE', 'CS', 'EE', '101', 2),
('CS', 'EE', 'BioTech', '100', 30),
('CS', 'BioTech', 'EE', '103', 31),
('CS', 'BioTech', 'EE', '105', 32);

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
CREATE TABLE IF NOT EXISTS `results` (
  `student_id` varchar(15) NOT NULL,
  `f_name` varchar(100) NOT NULL,
  `l_name` varchar(100) NOT NULL,
  `f_choice` varchar(20) NOT NULL,
  `points` int(20) NOT NULL,
  `rating` float NOT NULL,
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`student_id`, `f_name`, `l_name`, `f_choice`, `points`, `rating`) VALUES
('102', 'Glen ', 'Matsiwe', 'BioTech', 14, 5.6),
('101', 'tinashe', 'muny', 'CPSE', 14, 5.6),
('100', 'tatenda', 'kwaramba', 'CS', 12, 4.4),
('103', 'Taku', 'Mponda', 'CS', 12, 4.4),
('105', 'Kt', 'tafie', 'CS', 12, 4.2);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` varchar(15) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(20) NOT NULL,
  `selected_for` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `first_name`, `lastname`, `gender`, `adress`, `email`, `phone`, `selected_for`) VALUES
('100', 'tatenda', 'kwaramba', 'male', 'Budaz', 'gmail', 7, 'CS'),
('101', 'tinashe', 'muny', 'male', 'downtown', 'email', 18, 'CPSE'),
('102', 'Glen ', 'Matsiwe', 'male', 'HIT', 'email', 1, 'BioTech'),
('103', 'Taku', 'Mponda', 'male', 'mbuya', 'email', 2, 'CS'),
('105', 'Kt', 'tafie', 'male', 'render', 'email', 4, 'CS');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alevelsubs`
--
ALTER TABLE `alevelsubs`
  ADD CONSTRAINT `alevelsubs_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `enrolls`
--
ALTER TABLE `enrolls`
  ADD CONSTRAINT `enrolls_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `enrolls_ibfk_2` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`id`),
  ADD CONSTRAINT `enrolls_ibfk_3` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`id`);

--
-- Constraints for table `olevelsubs`
--
ALTER TABLE `olevelsubs`
  ADD CONSTRAINT `olevelsubs_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `olevelsubs_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `preferences`
--
ALTER TABLE `preferences`
  ADD CONSTRAINT `preferences_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `results`
--
ALTER TABLE `results`
  ADD CONSTRAINT `results_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
