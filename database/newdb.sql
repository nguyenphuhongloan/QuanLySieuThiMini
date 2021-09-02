-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2021 lúc 06:17 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `newdb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` int(10) NOT NULL,
  `id_admin` int(10) NOT NULL,
  `id_customer` int(10) NOT NULL,
  `date` date NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `id_admin`, `id_customer`, `date`, `total`) VALUES
(1, 1, 1, '2021-04-18', 440000),
(2, 5, 2, '2021-04-18', 130000),
(3, 6, 3, '2021-04-19', 24000),
(4, 13, 6, '2021-04-19', 15000),
(5, 32, 7, '2021-04-19', 30000),
(6, 5, 10, '2021-04-19', 15000),
(7, 5, 2, '2021-04-19', 200000),
(12, 5, 3, '2021-05-06', 216000),
(14, 35, 10, '2021-05-10', 258000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `idCategory` int(11) NOT NULL,
  `nameCategory` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`idCategory`, `nameCategory`) VALUES
(1, 'Bán Hàng'),
(2, 'Quản Lý Sản Phẩm'),
(3, 'Quản Lý Nhân Viên'),
(4, 'Quản Lý Khách Hàng'),
(5, 'Quản Lý Hóa Đơn'),
(6, 'Nhà Cung Cấp'),
(7, 'Nhập Hàng'),
(8, 'Phiếu Nhập Hàng'),
(9, 'Thống Kê'),
(10, 'Quản Lý Quyền');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(10) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `firstname`, `name`, `address`, `phone`, `status`) VALUES
(1, 'Lê', 'Văn Long ', 'Quan 8 TP Ho Chi Minh', '0774662325', 1),
(2, 'Le', 'Van A ', 'Quan 4 TP Ho Chi Minh', '0554677818', 1),
(3, 'Le', 'Thi B', 'Quan 9 TP Thu Duc', '0551446950', 1),
(6, 'Phạm', 'Việt Dũng', 'Quan 10 TP Ho Chi Minh', '0546581245', 1),
(7, 'Vu', 'Manh Cuong', 'Quan 2 TP Ho Chi Minh', '4551665487', 0),
(10, 'Phạm', 'Minh Hiếu', 'Quận 9 TP Thủ Đức', '05412375445', 1),
(14, 'Nguyễn', 'Ánh', 'Quận 4', '0123456789', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `detail_bill`
--

CREATE TABLE `detail_bill` (
  `id_bill` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `detail_bill`
--

INSERT INTO `detail_bill` (`id_bill`, `id_product`, `price`, `amount`, `total`) VALUES
(1, 2, 8000, 5, 40000),
(1, 4, 200000, 2, 400000),
(2, 6, 30000, 3, 90000),
(2, 7, 8000, 5, 40000),
(3, 7, 8000, 3, 24000),
(4, 5, 15000, 1, 15000),
(5, 3, 10000, 3, 30000),
(6, 5, 15000, 1, 15000),
(7, 4, 200000, 1, 200000),
(12, 4, 200000, 1, 200000),
(12, 2, 8000, 2, 16000),
(12, 5, 15000, 10, 150000),
(12, 7, 7000, 12, 84000),
(14, 2, 8000, 6, 48000),
(14, 5, 15000, 7, 105000),
(14, 7, 7000, 15, 105000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `detail_import`
--

CREATE TABLE `detail_import` (
  `id_import` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  `total` int(10) NOT NULL,
  `id_supplier` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `detail_import`
--

INSERT INTO `detail_import` (`id_import`, `id_product`, `amount`, `price`, `total`, `id_supplier`) VALUES
(3, 2, 100, 6000, 600000, 6),
(3, 5, 50, 20000, 1000000, 1),
(3, 6, 100, 25000, 2500000, 4),
(4, 6, 100, 20000, 2000000, 4),
(4, 3, 200, 5000, 1000000, 6),
(5, 2, 20, 6000, 120000, 6),
(5, 3, 20, 5000, 100000, 6),
(8, 3, 20, 5000, 100000, 3),
(8, 3, 10, 5000, 50000, 2),
(9, 4, 10, 12000, 120000, 6),
(9, 4, 5, 12000, 60000, 1),
(9, 6, 150, 15000, 2250000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import`
--

CREATE TABLE `import` (
  `id` int(10) NOT NULL,
  `id_account` int(10) NOT NULL,
  `date_import` date NOT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `import`
--

INSERT INTO `import` (`id`, `id_account`, `date_import`, `total`) VALUES
(3, 5, '2021-04-14', 4100000),
(4, 1, '2021-04-17', 3000000),
(5, 1, '2021-04-18', 220000),
(8, 35, '2021-05-10', 150000),
(9, 1, '2021-05-12', 2430000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `price` int(10) NOT NULL,
  `id_category` varchar(50) NOT NULL,
  `amount` int(11) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `image`, `price`, `id_category`, `amount`, `unit`, `status`) VALUES
(2, 'CocaCola', 'CocaCola.png', 8000, 'Nước', 47, 'Lon', 1),
(3, 'Pepsi chai', 'pepsi.png', 10000, 'Nước', 83, 'Chai', 1),
(4, 'Bánh Quy', 'banh.png', 200000, 'Thức Ăn', 25, 'Hộp', 1),
(5, 'Kẹo', 'candy.png', 15000, 'Thức Ăn', 10, 'Gói', 1),
(6, 'Sữa hộp', 'milk.png', 30000, 'Nước', 247, 'Hộp', 1),
(7, 'Poca', 'snack.png', 7000, 'Thức Ăn', 5, 'Gói', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `idRole` int(11) NOT NULL,
  `nameRole` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`idRole`, `nameRole`) VALUES
(1, 'admin'),
(2, 'staff'),
(3, 'test');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role_category`
--

CREATE TABLE `role_category` (
  `idRole` int(11) NOT NULL,
  `idCategory` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role_category`
--

INSERT INTO `role_category` (`idRole`, `idCategory`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(2, 1),
(2, 4),
(2, 5),
(2, 9),
(3, 1),
(3, 9),
(3, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `id` int(10) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `born` varchar(10) NOT NULL,
  `role` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`id`, `firstname`, `name`, `username`, `password`, `address`, `phone`, `gender`, `born`, `role`, `status`) VALUES
(1, 'Nguyễn', 'Thiện Trí ', 'thientri', '123456', 'Quận 2 TP Thủ Đức', '0908201298', 'Nam', '2000', 1, 1),
(5, 'Le', 'Thi Hoang ', 'lethihoang', '123456', 'Quan 9 TP Thu Duc', '0995447882', 'Nữ', '1997', 2, 1),
(6, 'Nguyễn', 'Thị Trà ', 'lethitra', '123456', 'Quan 4 TP Ho Chi Minh', '0551448667', 'Nữ', '1995', 2, 1),
(13, 'Vũ', 'Mạnh Cường ', 'manhcuong', '123456', 'TP Thủ Đức', '0122344565', 'Nam', '2001', 3, 1),
(14, 'Nguyen', 'Văn A', 'nguyenvana', '123456', 'Quan 6 TP Ho Chi Minh', '0564127885', 'Nam', '1999', 3, 0),
(32, 'Lê', 'Quang ', 'lequang', '123456', 'TP Thủ Đức', '01228772322', 'Nam', '2001', 2, 1),
(35, 'a', 'a ', 'a', 'a', 'a', '0123456789', 'Nam', '2001', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `address`, `phone`, `status`) VALUES
(1, 'VinGroup', 'TP Ho Chi Minh', '01148777', 1),
(2, 'Vissan', 'Dong Nai', '44408778', 1),
(3, 'AceCook', 'TP Ho Chi Minh', '05546689', 1),
(4, 'VinaMilk', 'TP Ho Chi Minh', '04456776', 1),
(5, 'Visaco', 'TP Ho Chi Minh', '45562433', 1),
(6, 'Pepsico', 'TP Ho Chi Minh', '05548998', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bill-staff` (`id_admin`),
  ADD KEY `bill-customer` (`id_customer`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idCategory`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `detail_bill`
--
ALTER TABLE `detail_bill`
  ADD KEY `detail_bill-bill` (`id_bill`),
  ADD KEY `detai_bill-product` (`id_product`);

--
-- Chỉ mục cho bảng `detail_import`
--
ALTER TABLE `detail_import`
  ADD KEY `detail_import-import` (`id_import`),
  ADD KEY `detail_import-product` (`id_product`),
  ADD KEY `detail_import-suppiler` (`id_supplier`);

--
-- Chỉ mục cho bảng `import`
--
ALTER TABLE `import`
  ADD PRIMARY KEY (`id`),
  ADD KEY `import-staff` (`id_account`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`idRole`);

--
-- Chỉ mục cho bảng `role_category`
--
ALTER TABLE `role_category`
  ADD KEY `idCategory` (`idCategory`),
  ADD KEY `idRole` (`idRole`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD KEY `staff-role` (`role`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `idCategory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `import`
--
ALTER TABLE `import`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `idRole` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill-customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `bill-staff` FOREIGN KEY (`id_admin`) REFERENCES `staff` (`id`);

--
-- Các ràng buộc cho bảng `detail_bill`
--
ALTER TABLE `detail_bill`
  ADD CONSTRAINT `detail_bill-bill` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `detail_bill-product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `detail_import`
--
ALTER TABLE `detail_import`
  ADD CONSTRAINT `detail_import-import` FOREIGN KEY (`id_import`) REFERENCES `import` (`id`),
  ADD CONSTRAINT `detail_import-product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `detail_import-suppiler` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`);

--
-- Các ràng buộc cho bảng `import`
--
ALTER TABLE `import`
  ADD CONSTRAINT `import-staff` FOREIGN KEY (`id_account`) REFERENCES `staff` (`id`);

--
-- Các ràng buộc cho bảng `role_category`
--
ALTER TABLE `role_category`
  ADD CONSTRAINT `category-role_category` FOREIGN KEY (`idCategory`) REFERENCES `category` (`idCategory`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `role-role_category` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff-role` FOREIGN KEY (`role`) REFERENCES `role` (`idRole`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
