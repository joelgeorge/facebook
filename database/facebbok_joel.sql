-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 01, 2016 at 07:18 AM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `facebbok_joel`
--

-- --------------------------------------------------------

--
-- Table structure for table `facebook_signup`
--

CREATE TABLE IF NOT EXISTS `facebook_signup` (
  `username` varchar(100) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `facebook_signup`
--

INSERT INTO `facebook_signup` (`username`, `firstname`, `lastname`, `gender`, `email`, `password`, `userid`) VALUES
('joel george', 'JOEL', 'GEORGE', 'MALE', 'paul@gmail', 'JOELGEORGE', 1),
('DINEESH A.D', 'DINEESH', 'A.D', 'MALE', 'DINESH@GMAIL.COM', 'DINESH', 2),
('$username', '$firstname', '$lastname', '$gender', '$email', '$password', 3),
('joel', 'joel', 'george', 'male', 'uuu', 'pass1', 4),
('ssssssssss', 'ssss', 'ssssss', 'male', 'sssss', 'eeeee', 5),
('t1t1', 't1', 't1', 'male', 't1', '123', 6),
('joyaljo', 'joyal', 'jo', 'male', 'jo@gmail.com', 'jo', 7),
('rajraj', 'raj', 'raj', 'male', 'raj@gmail.com', 'raj', 8);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
