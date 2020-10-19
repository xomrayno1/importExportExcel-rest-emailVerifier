-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 19, 2020 lúc 07:38 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `rest`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `confirmationtoken`
--

CREATE TABLE `confirmationtoken` (
  `token_id` int(20) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `confirmationtoken`
--

INSERT INTO `confirmationtoken` (`token_id`, `confirmation_token`, `createdDate`, `user_id`) VALUES
(2, '2555cd08-fd84-455f-a111-db465825b5e7', '2020-10-20 00:27:54', 35);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`, `username`, `img`) VALUES
(30, 'xomrayno5@gmail.com', 'Nguyễn Thị Việt Dung', '12345', 'admin', '/static/upload/1603121739458_amduongmien.jpg'),
(31, 'xomrayno5@gmail.com', 'Nguyễn Thị Việt Dung', '12345', 'xomrayno3', '/static/upload/1603124222888_amduongmien.jpg'),
(32, 'xomrayno5@gmail.com', 'Nguyễn Chí Tâm', '12345', 'xomrayno5', '/static/upload/1603124631656_55-cach-de-tu-tin.jpg'),
(33, 'xomrayno5@gmail.com', 'Nguyễn Thị Việt Dung', '12345', 'xomrayno5', '/static/upload/1603124898969_687041498a5edfc9dd2a9a5687aff00b.jpg'),
(34, 'xomrayno5@gmail.com', 'Nguyễn Thị Việt Dung', '12345', 'admin', '/static/upload/1603128344764_ART & PHOTOGRAPHY.jpg'),
(35, 'xomrayno5@gmail.com', 'Nguyễn Thị Việt Dung', '12345', 'admin', '/static/upload/1603128474912_687041498a5edfc9dd2a9a5687aff00b.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `confirmationtoken`
--
ALTER TABLE `confirmationtoken`
  ADD PRIMARY KEY (`token_id`),
  ADD KEY `FKsjwvpslamugnwqhxsp09noep2` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `confirmationtoken`
--
ALTER TABLE `confirmationtoken`
  MODIFY `token_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `confirmationtoken`
--
ALTER TABLE `confirmationtoken`
  ADD CONSTRAINT `FKsjwvpslamugnwqhxsp09noep2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
