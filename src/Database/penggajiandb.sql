-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29 Nov 2017 pada 16.41
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penggajiandb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(10) NOT NULL,
  `nama_jabatan` varchar(20) NOT NULL,
  `gaji_pokok` double NOT NULL,
  `deskripsi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `nama_jabatan`, `gaji_pokok`, `deskripsi`) VALUES
(963001, 'Presiden Direktur', 30000000, 'Mengatur dan memimpin sebuah perusahaan'),
(963002, 'Executive (GM)', 25000000, 'Membantu Direktur Utama dalam memimpin dan mengarahkan perusahaann'),
(963003, 'General Manager', 20000000, 'Mengatur dan memanage bagian bagian perusahaan'),
(963004, 'Manager Keuangan', 10000000, 'Mengepalai Bidang keuangan perusahaan'),
(963005, 'Manager Personalia', 10000000, 'Kepala Bidang SDM'),
(963006, 'Kepala HRD', 10000000, 'Mengepalai HRD'),
(963007, 'Manager Produksi', 10000000, 'Mengepalai Bagian Produksi'),
(963008, 'Manager Marketing', 10000000, 'Mengepalai Bagian Pemasaran'),
(963009, 'Staf Keuangan', 20000000, 'Staf Bidang Keuangan'),
(963010, 'Staf HRD', 2000000, 'Staf Bidang HRD'),
(963012, 'Kepala Pengadaan', 3000000, 'Mengepalai Bidang Pengadaan'),
(963013, 'Kepala Keamanan', 3000000, 'Mengepalai Bidang Keamanan'),
(963014, 'Kepala Gudang', 3000000, 'Mengepalai dan Mengatur Sistem Pergudangan'),
(963015, 'Security A', 2000000, 'Petugas Keamanan level 1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id_user` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan') NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` varchar(10) NOT NULL,
  `agama` varchar(15) NOT NULL,
  `id_jabatan` int(10) NOT NULL,
  `status` enum('Admin','User') NOT NULL,
  `kontak` varchar(60) DEFAULT NULL,
  `alamat` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_user`, `nama`, `jenis_kelamin`, `tempat_lahir`, `tanggal_lahir`, `agama`, `id_jabatan`, `status`, `kontak`, `alamat`) VALUES
(33001, 'Mohammad Afif Khoirul Insani', 'Laki-Laki', 'Tuban', '02-12-2000', 'Islam', 963001, 'Admin', '082330660295', 'Tuban'),
(33002, 'Yuli', 'Perempuan', 'Malang', '28-07-2000', 'Islam', 963002, 'User', '085769131133', 'Tuban'),
(33003, 'Rezky', 'Laki-Laki', 'Surabaya', '05-12-2001', 'Islam', 963003, 'User', '081222333444', 'Perum Sawojajar'),
(33004, 'Adji ', 'Laki-Laki', 'Malang', '07-12-1999', 'Islam', 963014, 'User', '087913556245', 'Jl. danau ranau'),
(33005, 'Aziz', 'Laki-Laki', 'Papua', '04-03-1994', 'Islam', 963005, 'Admin', '0899991123', 'Jl. Danau poso 2, No. 63'),
(33006, 'Ani', 'Perempuan', 'Bali', '09-12-1993', 'Islam', 963004, 'User', '089627164495', 'Yogyakarta'),
(33007, 'Ahmad', 'Laki-Laki', 'Madura', '24-12-1995', 'Islam', 963013, 'User', '089992223344', 'Madura'),
(33009, 'Dwi', 'Laki-Laki', 'Tuban', '04-02-2001', 'Islam', 963012, 'User', '0899898783', 'Rengel'),
(33010, 'Sugeng', 'Laki-Laki', 'Malang', '28-07-1989', 'Islam', 963015, 'User', '08954323551', 'Sawojajar'),
(33011, 'Eka', 'Perempuan', 'Solo', '28-07-1999', 'Islam', 963007, 'User', 'eka@gmail.com', 'Sawojajar 1'),
(33012, 'Nopal', 'Laki-Laki', 'Banyuwangi', '28-07-2000', 'Islam', 963010, 'User', '082330113555', 'Banyuwangi'),
(33013, 'afiiff', 'Laki-Laki', 'tuban', '29-11-2017', 'islam', 963002, 'Admin', '08', 'mzdad\r\n\r\n');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id_user` int(10) NOT NULL,
  `kata_sandi` varchar(32) NOT NULL DEFAULT 'masuk'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id_user`, `kata_sandi`) VALUES
(33001, '12345'),
(33002, 'masuk'),
(33003, 'masuk'),
(33004, 'masuk'),
(33005, 'masuk'),
(33006, 'masuk'),
(33007, 'masuk'),
(33009, 'masuk'),
(33010, 'masuk'),
(33011, 'masuk'),
(33012, 'masuk'),
(33013, 'masuk');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`),
  ADD UNIQUE KEY `id_jabatan` (`id_jabatan`),
  ADD UNIQUE KEY `nama_jabatan` (`nama_jabatan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_jabatan_2` (`id_jabatan`),
  ADD KEY `id_jabatan_3` (`id_jabatan`),
  ADD KEY `id_jabatan` (`id_jabatan`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=963016;
--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33014;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33014;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `fk_karyawan` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `fk_pengguna` FOREIGN KEY (`id_user`) REFERENCES `karyawan` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
