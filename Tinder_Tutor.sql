-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 30, 2019 at 05:29 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Tinder_Tutor`
--

-- --------------------------------------------------------

--
-- Table structure for table `Messages`
--

CREATE TABLE `Messages` (
  `Message_ID` int(11) NOT NULL,
  `Message_Content` longtext NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `Tutor_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Messages`
--

INSERT INTO `Messages` (`Message_ID`, `Message_Content`, `Student_ID`, `Tutor_ID`) VALUES
(1, 'well peter', 2, 9),
(2, 'hi there peter any chance of a grind', 2, 9),
(3, 'well peter any chance of a grind', 2, 9);

-- --------------------------------------------------------

--
-- Table structure for table `Student_Users`
--

CREATE TABLE `Student_Users` (
  `StudentID` int(11) NOT NULL,
  `S_Name` varchar(50) DEFAULT NULL,
  `User_Name` varchar(20) DEFAULT NULL,
  `Students_Password` varchar(20) DEFAULT NULL,
  `College_Year` varchar(20) DEFAULT NULL,
  `College_ModuleCode` varchar(20) DEFAULT NULL,
  `Student_Location` float DEFAULT NULL,
  `Grind_Type` varchar(20) DEFAULT NULL,
  `Student_Price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Student_Users`
--

INSERT INTO `Student_Users` (`StudentID`, `S_Name`, `User_Name`, `Students_Password`, `College_Year`, `College_ModuleCode`, `Student_Location`, `Grind_Type`, `Student_Price`) VALUES
(2, 'Adam O Ceallaigh', 'adamoc', '1234', '2', 'IS2205', 4.7, 'Single', 20),
(3, 'Olivia Roche', 'livrochee', '1234', '2', 'IS2215', 2.59, 'Single', 20),
(4, 'Sophie Walker', 'swalker', '1234', '2', 'IS2207', 1.27, 'Single', 20),
(5, 'Sean O Sullivan', 'seanos', '1234', '2', 'IS2208', 3.63, 'Single', 20),
(6, 'Emma Looney', 'looneytunezzz', '1234', '2', 'IS2207', 2.24, 'Single', 20),
(7, 'Ryan Walters', 'rwalters', '1234', '2', 'IS2203', 2.52, 'Single', 30),
(8, 'Oscar Phillips', 'ophilly', '1234', '2', 'IS2201', 1.29, 'Single', 30),
(9, 'Luke Skywalker', 'lukeeSW', '1234', '2', 'IS2303', 3.71, 'Single', 30);

-- --------------------------------------------------------

--
-- Table structure for table `Tutor_Users`
--

CREATE TABLE `Tutor_Users` (
  `TutorID` int(11) NOT NULL,
  `T_Name` varchar(20) DEFAULT NULL,
  `User_Name` varchar(20) DEFAULT NULL,
  `Tutors_Password` varchar(20) DEFAULT NULL,
  `Subject_Area` varchar(250) DEFAULT NULL,
  `Qualifications` varchar(250) DEFAULT NULL,
  `Tutor_Location` float DEFAULT NULL,
  `Grind_Type` varchar(20) DEFAULT NULL,
  `Tutor_Price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Tutor_Users`
--

INSERT INTO `Tutor_Users` (`TutorID`, `T_Name`, `User_Name`, `Tutors_Password`, `Subject_Area`, `Qualifications`, `Tutor_Location`, `Grind_Type`, `Tutor_Price`) VALUES
(1, 'Peter Casey', 'pcasey', '1234', 'Data Analysis', 'Data Analyst , Data Planner', 3.53, 'Single', 20),
(2, 'John Briggs', 'jbriggs', '1234', 'Accounting', 'BSC. Accounting', 2.61, 'Single', 20),
(3, 'Robert Taggart', 'robbieT', '1234', 'Economics', 'Bsc. Economics, Phd. Economics', 1.67, 'Single', 20),
(4, 'Jane Finch', 'jfinchie', '1234', 'Accounting', 'BSc. Accounting , MSc.Accounting , PHd. Accounting', 4.59, 'Single', 20),
(5, 'Eileen Dover', 'eileenD', '1234', 'Cyber Security', 'BSc.Computer Science', 2.45, 'Single', 20),
(6, 'Sean Wells', 'sWells', '1234', 'Business', 'BSc.Business', 1.68, 'Single', 20),
(7, 'Adam Looney', 'ALooney', '1234', 'Science', 'Bsc Science', 3.23, 'Single', 30),
(8, 'Isaac Bore', 'iboree', '1234', 'Maths', 'BSc.Maths', 3.32, 'Single', 30),
(9, 'Peter Walsh', 'pwalshiee', '1234', 'Electronics', 'BSs.Electrical Engineering', 1.58, 'Single', 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Messages`
--
ALTER TABLE `Messages`
  ADD PRIMARY KEY (`Message_ID`);

--
-- Indexes for table `Student_Users`
--
ALTER TABLE `Student_Users`
  ADD PRIMARY KEY (`StudentID`);

--
-- Indexes for table `Tutor_Users`
--
ALTER TABLE `Tutor_Users`
  ADD PRIMARY KEY (`TutorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Messages`
--
ALTER TABLE `Messages`
  MODIFY `Message_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Student_Users`
--
ALTER TABLE `Student_Users`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Tutor_Users`
--
ALTER TABLE `Tutor_Users`
  MODIFY `TutorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
