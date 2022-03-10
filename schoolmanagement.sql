-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 19 Δεκ 2020 στις 19:43:39
-- Έκδοση διακομιστή: 8.0.17
-- Έκδοση PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `schoolmanagement`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `assignments`
--

CREATE TABLE `assignments` (
  `AssignmentID` int(11) NOT NULL,
  `ATitle` varchar(45) DEFAULT NULL,
  `ADescription` varchar(45) DEFAULT NULL,
  `ASubDataTime` datetime DEFAULT NULL,
  `ACourseTitle` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `assignments`
--

INSERT INTO `assignments` (`AssignmentID`, `ATitle`, `ADescription`, `ASubDataTime`, `ACourseTitle`) VALUES
(7, 'Individual Project JAVA PART A', 'Description of Assignment1', '2020-02-15 10:30:00', 'CB1'),
(8, 'Individual Project JAVA PART A', 'Description of Assignment1', '2020-02-15 10:30:00', 'CB2'),
(9, 'Individual Project PYTHON PART A', 'Description of Assignment2', '2020-02-15 10:30:00', 'CB3'),
(10, 'Individual Project PYTHON PART A', 'Description of Assignment3', '2020-02-15 10:30:00', 'CB4'),
(11, 'Individual Project JAVASCRIPT PART A', 'Description of Assignment3', '2020-02-15 10:30:00', 'CB5'),
(12, 'Individual Project JAVASCRIPT PART A', 'Description of Assignment3', '2020-02-15 10:30:00', 'CB6'),
(13, 'Individual Project JAVA PART B', 'Description of Assignment4', '2020-02-15 10:30:00', 'CB1'),
(14, 'Individual Project JAVA PART C', 'Description of Assignment5', '2020-02-15 10:30:00', 'CB1'),
(15, 'Individual Project PYTHON PART B', 'Description of Assignment6', '2020-02-15 10:30:00', 'CB2'),
(16, 'Individual Project PYTHON PART C', 'Description of Assignment7', '2020-02-15 10:30:00', 'CB2');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `courses`
--

CREATE TABLE `courses` (
  `CourseID` int(11) NOT NULL,
  `CTitle` varchar(45) DEFAULT NULL,
  `CStream` varchar(45) DEFAULT NULL,
  `CType` varchar(45) DEFAULT NULL,
  `CStart_Date` date DEFAULT NULL,
  `CEnd_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `courses`
--

INSERT INTO `courses` (`CourseID`, `CTitle`, `CStream`, `CType`, `CStart_Date`, `CEnd_Date`) VALUES
(101, 'CB1', 'JAVA', 'FULL', '2020-01-01', '2020-01-31'),
(102, 'CB2', 'JAVA', 'PART', '2020-01-01', '2020-06-30'),
(103, 'CB3', 'PYTHON', 'FULL', '2020-01-01', '2020-03-31'),
(104, 'CB4', 'PYTHON', 'PART', '2020-01-01', '2020-06-30'),
(105, 'CB5', 'JAVASCRIPT', 'FULL', '2020-01-01', '2020-03-31'),
(106, 'CB6', 'JAVASCRIPT', 'FULL', '2020-01-01', '2020-03-31');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `students`
--

CREATE TABLE `students` (
  `StudentID` int(11) NOT NULL,
  `SFirstName` varchar(45) DEFAULT NULL,
  `SLastName` varchar(45) DEFAULT NULL,
  `SBirthday` date DEFAULT NULL,
  `STuitionFees` varchar(45) DEFAULT NULL,
  `SOralMark` int(11) DEFAULT NULL,
  `SWriteMark` int(11) DEFAULT NULL,
  `STotalMark` int(11) DEFAULT NULL,
  `SCourseTitle` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `students`
--

INSERT INTO `students` (`StudentID`, `SFirstName`, `SLastName`, `SBirthday`, `STuitionFees`, `SOralMark`, `SWriteMark`, `STotalMark`, `SCourseTitle`) VALUES
(26, 'GIANNIS', 'KARAMITROS', '1980-01-01', '2500', NULL, NULL, NULL, 'CB1'),
(27, 'GIANNIS', 'KARAMITROS', '1980-01-01', '2500', NULL, NULL, NULL, 'CB4'),
(28, 'ALEXIS', 'KARAPIPERIS', '1980-06-01', '2250', NULL, NULL, NULL, 'CB1'),
(29, 'ALEXIS', 'KARAPIPERIS', '1980-06-01', '2250', NULL, NULL, NULL, 'CB6'),
(30, 'BLASIS', 'KYRIAKOY', '1980-06-15', '2500', NULL, NULL, NULL, 'CB2'),
(31, 'GIORGOS', 'GOUDINAKIS', '1981-06-15', '2500', NULL, NULL, NULL, 'CB3'),
(32, 'GIORGOS', 'DRAKOULIS', '1982-07-15', '2500', NULL, NULL, NULL, 'CB4'),
(33, 'MARIA', 'DIMITRIOY', '1982-11-10', '2500', NULL, NULL, NULL, 'CB5'),
(34, 'DIMITRA', 'PAPADOPOULOU', '1981-11-01', '2500', NULL, NULL, NULL, 'CB6'),
(35, 'SOFIA', 'PAPA', '1982-03-05', '2500', NULL, NULL, NULL, 'CB6'),
(36, 'KOSTAS', 'CHRISTOU', '1981-04-06', '1500', NULL, NULL, NULL, 'CB2'),
(37, 'CHRISA', 'AUGEROPOULOU', '1984-04-06', '1500', NULL, NULL, NULL, 'CB2'),
(38, 'GIORGOS', 'MAKRIDIS', '1980-02-02', '2000', NULL, NULL, NULL, 'CB3'),
(39, 'MARIOS', 'PAPADIONYSIOY', '1984-03-06', '2000', NULL, NULL, NULL, 'CB5'),
(40, 'GIANNIS', 'POLYMEROY', '1985-05-06', '2000', NULL, NULL, NULL, 'CB6');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `trainers`
--

CREATE TABLE `trainers` (
  `TrainerID` int(11) NOT NULL,
  `TFirstName` varchar(30) DEFAULT NULL,
  `TLastName` varchar(45) DEFAULT NULL,
  `TSubject` varchar(45) DEFAULT NULL,
  `TCourseTitle` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `trainers`
--

INSERT INTO `trainers` (`TrainerID`, `TFirstName`, `TLastName`, `TSubject`, `TCourseTitle`) VALUES
(88, 'KOSTAS', 'GEORGIOY', 'JAVA', 'CB1'),
(89, 'KOSTAS', 'GEORGIOY', 'JAVA', 'CB2'),
(90, 'KOSTAS', 'GEORGIOY', 'JAVA', 'CB5'),
(91, 'DIMITRIS', 'PAPAS', 'PYTHON', 'CB3'),
(92, 'DIMITRIS', 'PAPAS', 'PYTHON', 'CB4'),
(93, 'DIMITRIS', 'PAPAS', 'PYTHON', 'CB1'),
(94, 'JOHN', 'DIMITRIOU', 'JAVASCRIPT', 'CB5'),
(95, 'JOHN', 'DIMITRIOU', 'JAVASCRIPT', 'CB6'),
(96, 'JOHN', 'DIMITRIOU', 'JAVASCRIPT', 'CB1'),
(97, 'JOHN', 'DIMITRIOU', 'JAVASCRIPT', 'CB4');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `zfk_courses_assignments`
--

CREATE TABLE `zfk_courses_assignments` (
  `AssignmentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `zfk_courses_assignments`
--

INSERT INTO `zfk_courses_assignments` (`AssignmentID`, `CourseID`) VALUES
(7, 101),
(13, 101),
(14, 101),
(8, 102),
(15, 102),
(16, 102),
(9, 103),
(10, 104),
(11, 105),
(12, 106);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `zfk_courses_students`
--

CREATE TABLE `zfk_courses_students` (
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `zfk_courses_students`
--

INSERT INTO `zfk_courses_students` (`StudentID`, `CourseID`) VALUES
(26, 101),
(28, 101),
(30, 102),
(36, 102),
(37, 102),
(31, 103),
(38, 103),
(27, 104),
(32, 104),
(33, 105),
(39, 105),
(29, 106),
(34, 106),
(35, 106),
(40, 106);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `zfk_courses_trainers`
--

CREATE TABLE `zfk_courses_trainers` (
  `TrainerID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `zfk_courses_trainers`
--

INSERT INTO `zfk_courses_trainers` (`TrainerID`, `CourseID`) VALUES
(88, 101),
(93, 101),
(96, 101),
(89, 102),
(91, 103),
(92, 104),
(97, 104),
(90, 105),
(94, 105),
(95, 106);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`AssignmentID`);

--
-- Ευρετήρια για πίνακα `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`CourseID`),
  ADD UNIQUE KEY `CourseID_UNIQUE` (`CourseID`);

--
-- Ευρετήρια για πίνακα `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`StudentID`);

--
-- Ευρετήρια για πίνακα `trainers`
--
ALTER TABLE `trainers`
  ADD PRIMARY KEY (`TrainerID`);

--
-- Ευρετήρια για πίνακα `zfk_courses_assignments`
--
ALTER TABLE `zfk_courses_assignments`
  ADD PRIMARY KEY (`AssignmentID`,`CourseID`),
  ADD KEY `FK6_courseid_idx` (`CourseID`);

--
-- Ευρετήρια για πίνακα `zfk_courses_students`
--
ALTER TABLE `zfk_courses_students`
  ADD PRIMARY KEY (`StudentID`,`CourseID`),
  ADD KEY `FK2_courseiID_idx` (`CourseID`);

--
-- Ευρετήρια για πίνακα `zfk_courses_trainers`
--
ALTER TABLE `zfk_courses_trainers`
  ADD PRIMARY KEY (`TrainerID`,`CourseID`),
  ADD KEY `FK2_courseID_idx` (`CourseID`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `assignments`
--
ALTER TABLE `assignments`
  MODIFY `AssignmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT για πίνακα `courses`
--
ALTER TABLE `courses`
  MODIFY `CourseID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;

--
-- AUTO_INCREMENT για πίνακα `students`
--
ALTER TABLE `students`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT για πίνακα `trainers`
--
ALTER TABLE `trainers`
  MODIFY `TrainerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `zfk_courses_assignments`
--
ALTER TABLE `zfk_courses_assignments`
  ADD CONSTRAINT `FK5_Assignmentid` FOREIGN KEY (`AssignmentID`) REFERENCES `assignments` (`AssignmentID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK6_courseid` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`CourseID`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Περιορισμοί για πίνακα `zfk_courses_students`
--
ALTER TABLE `zfk_courses_students`
  ADD CONSTRAINT `FK1_studentID` FOREIGN KEY (`StudentID`) REFERENCES `students` (`StudentID`),
  ADD CONSTRAINT `FK2_courseiID` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`CourseID`);

--
-- Περιορισμοί για πίνακα `zfk_courses_trainers`
--
ALTER TABLE `zfk_courses_trainers`
  ADD CONSTRAINT `FK1_trainerid` FOREIGN KEY (`TrainerID`) REFERENCES `trainers` (`TrainerID`),
  ADD CONSTRAINT `FK2_courseID` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`CourseID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
