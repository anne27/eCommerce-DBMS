-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2017 at 03:32 PM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbms website`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(100) NOT NULL,
  `AdminName` varchar(100) NOT NULL,
  `AdminPassword` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `AdminName`, `AdminPassword`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryID` int(10) NOT NULL,
  `CategoryName` varchar(100) NOT NULL,
  `Description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryID`, `CategoryName`, `Description`) VALUES
(111, 'Women', 'All products under women category.'),
(112, 'Men', 'All products under men category.'),
(113, 'Kids', 'All products under kids category.');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(100) NOT NULL,
  `CustomerName` varchar(100) NOT NULL,
  `Address` varchar(10) NOT NULL,
  `City` varchar(10) NOT NULL,
  `Country` varchar(10) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `ShipAddress` varchar(10) NOT NULL,
  `PendingShipments` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `CustomerName`, `Address`, `City`, `Country`, `Phone`, `Email`, `Password`, `ShipAddress`, `PendingShipments`) VALUES
(1, 'Ram', 'Delhi', 'Delhi', 'India', '9999111111', 'ram@gmail.com', 'ram', 'Delhi', 5),
(2, 'Rita', 'LA', 'LA', 'USA', '1234567890', 'rita@gmail.com', 'rita', 'LA', 5),
(3, 'Anannya Uberoi', 'Shalimar', 'Delhi', 'India', '8881', 'anannya@gmail.com', 'anannya', 'Shalimar', 5),
(4, 'Sarthika', 'Rohini', 'Delhi', 'India', '998', 'sarthika@gmail.com', 'sarthika', 'Rohini', 5),
(5, 'Katy', 'Albany', 'NY', 'USA', '773', 'katy@gmail.com', 'katy', 'NY', 5),
(6, 'Logan', 'Mumbai', 'Mumbai', 'India', '8711', 'logan@gmail.com', 'logan', 'Mumbai', 5);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrderID` int(100) NOT NULL,
  `ProductID` int(100) NOT NULL,
  `CustomerID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`OrderID`, `ProductID`, `CustomerID`) VALUES
(1, 11, 1),
(2, 15, 5),
(3, 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(100) NOT NULL,
  `CustomerID` int(100) NOT NULL,
  `SupplierID` int(100) NOT NULL,
  `PaymentID` int(100) NOT NULL,
  `DeliveryCharges` int(100) NOT NULL,
  `Amount` float NOT NULL,
  `TransactionStatus` varchar(100) NOT NULL,
  `ShipDate` varchar(100) NOT NULL,
  `OrderDate` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrderID`, `CustomerID`, `SupplierID`, `PaymentID`, `DeliveryCharges`, `Amount`, `TransactionStatus`, `ShipDate`, `OrderDate`) VALUES
(1, 1, 11111, 1, 50, 500, 'success', '2017-04-20', '2017-04-15'),
(2, 5, 11112, 2, 50, 500, 'success', '2017-04-20', '2017-04-15'),
(3, 1, 11111, 3, 50, 500, 'success', '2017-04-20', '2017-04-15');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `OrderID` int(100) NOT NULL,
  `PaymentID` int(100) NOT NULL,
  `DeliveryCharges` int(100) NOT NULL,
  `Amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`OrderID`, `PaymentID`, `DeliveryCharges`, `Amount`) VALUES
(1, 1, 50, 500),
(2, 2, 50, 500),
(3, 3, 50, 500);

-- --------------------------------------------------------

--
-- Table structure for table `productorder`
--

CREATE TABLE `productorder` (
  `ProductID` int(100) NOT NULL,
  `Quantity` int(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `DeliveryDate` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productorder`
--

INSERT INTO `productorder` (`ProductID`, `Quantity`, `Status`, `DeliveryDate`) VALUES
(11, 1, '', ''),
(15, 1, '', ''),
(11, 1, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductID` int(10) NOT NULL,
  `CategoryID` int(10) NOT NULL,
  `SupplierID` int(10) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Price` float NOT NULL,
  `Size` varchar(10) NOT NULL,
  `Color` varchar(10) NOT NULL,
  `GarmentType` varchar(10) NOT NULL,
  `Rating` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `CategoryID`, `SupplierID`, `ProductName`, `Price`, `Size`, `Color`, `GarmentType`, `Rating`) VALUES
(11, 111, 11111, 'Top', 500, 'M', 'Red', 'Cotton', 7),
(12, 111, 11111, 'Trouser', 1000, 'M', 'Blue', 'Cotton', 5),
(13, 113, 11114, 'Frock', 200, 'S', 'Pink', 'Cotton', 5),
(14, 112, 11114, 'Trouser', 1000, 'M', 'Black', 'Silk', 8),
(15, 113, 11112, 'Baby Suit', 500, 'S', 'Blue', 'Hosiery', 9),
(16, 113, 11113, 'Baby Suit', 200, 'S', 'Grey', 'Cotton', 7),
(17, 112, 11114, 'Shirt', 780, 'L', 'Blue', 'Cotton', 3),
(18, 112, 11115, 'Shirt', 735, 'L', 'Blue', 'Cotton', 9),
(19, 112, 11115, 'Jeans', 400, 'S', 'Blue', 'Denim', 9),
(20, 111, 11113, 'Skirt', 290, 'M', 'Yellow', 'Hosiery', 8),
(21, 111, 11114, 'Skirt', 879, 'S', 'Brown', 'Denim', 7),
(22, 111, 11112, 'Top', 700, 'S', 'Blue', 'Hosiery', 8),
(23, 111, 11115, 'Top', 250, 'M', 'Pink', 'Cotton', 8),
(24, 111, 11115, 'Top', 988, 'S', 'Red', 'Wool', 9),
(25, 113, 11114, 'Baby Suit', 788, 'S', 'Orange', 'Cotton', 8),
(26, 113, 11113, 'Baby Suit', 877, 'M', 'Grey', 'Cotton', 6),
(27, 113, 11111, 'Baby Suit', 900, 'S', 'Pink', 'Cotton', 6),
(28, 113, 11111, 'Fancy Clothes', 100, 'S', 'Red', 'Cotton', 7),
(29, 113, 11112, 'Fancy Clothes', 800, 'S', 'Blue', 'Cotton', 7),
(30, 112, 11111, 'Sweater', 1000, 'L', 'Grey', 'Wool', 7),
(31, 112, 11112, 'Tuxedo', 2900, 'L', 'Black', 'Cotton', 8),
(32, 112, 11111, 'Jeans', 700, 'S', 'Blue', 'Denim', 6),
(33, 112, 11111, 'Sweater', 800, 'S', 'Black', 'Wool', 5),
(34, 112, 11111, 'Tee Shirt', 500, 'S', 'Yellow', 'Knit', 7);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(100) NOT NULL,
  `SupplierName` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Country` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`SupplierID`, `SupplierName`, `Address`, `Country`) VALUES
(11111, 'Dhanraj Textiles', 'Delhi', 'India'),
(11112, 'Pricely', 'LA', 'USA'),
(11113, 'ABCD Suppliers', 'Noida', 'India'),
(11114, 'Mango Biz', 'South Delhi', 'India'),
(11115, 'Lilliput Clothing', 'Delhi', 'India');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrderID`,`CustomerID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
