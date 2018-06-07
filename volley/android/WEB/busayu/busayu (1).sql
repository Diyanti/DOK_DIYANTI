-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2018 pada 08.24
-- Versi server: 10.1.31-MariaDB
-- Versi PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `busayu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `budaya`
--

CREATE TABLE `budaya` (
  `id_budaya` int(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `deskripsi` varchar(500) NOT NULL,
  `gambar` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `budaya`
--

INSERT INTO `budaya` (`id_budaya`, `nama`, `deskripsi`, `gambar`) VALUES
(1, 'Ngarot', 'Ngarot merupakan perayaan tradisi masyarakat agraris di Lelea sejak tahun 1686 yang diselenggarakan pada saat tiba musim menggarap sawah, adapun hari yang diterapkan yaitu pada Rabu Wage dibulan November.\r\nUniknya adat ini hanya melibatkan muda mudi yang disebut kasinoman Ngarot dan masih menjaga kesuciannya, dimana para gadis Ngarot dihias mahkota bunga, dan berbagai perhiasan. Adat ngarot ini dimeriahkan dengan beberapa kesenian tradisional seperti tari topeng, Ronggeng ketuk dan kesen', 'ngarot.jpg'),
(2, 'Tari Topeng', 'Gerak tari yang khas, kostum yang berciri topeng Dermayon dengan tari topeng lainnya. Indramayu memiliki seorang maestro tari topeng yaitu Mimi Rasinah (alm) yang sudah banyak tampil di berbagai negara.', 'tari_topeng.JPG'),
(3, 'Ronggeng Ketuk', 'Ronggeng ketuk merupakan salah satu kesenian pergaulan, serupa tayuban dimana para penari mengajak penonton untuk menari bersama dengan gaya yang khas daerah agraris. kesenian Ronggeng Ketuk biasanya hadir dalam perayaan adat Ngarot di desa Lelea, Pesta pernikahan, serta tradisi adat lainnya', 'ronggeng_ketuk.jpg'),
(4, 'Wayang Golek Cepak', 'Wayang Golek Cepak dan wayang Golek Sunda sangat berbeda, wayang ini lebih mengaplikasikan diri kepada penokohan kerjaan-kerajaan islam di Jawa, mulai dari nama tokoh cerita (Lakon), juga karakteristiknya. Perbedaan yang paling menonjol pada bagian kepala (mahkota). Wayang ini berbentuk datar (papak), maka disebut wayang golek cepak. Keunikan wayang golek cepak inilah yang menjadi daya tarik wisata di Indramayu sebagai seni pertunjukan rakyat.', 'wayang_golek_cepak.jpg'),
(5, 'Nadran', 'Mensyukuri hasil tangkapan ikan, mengharap peningkatan hasil di tahun mendatang dan berdo\'a agar diberi keselamatan saat melaut adalah maksud dan tujuan dari perayaan adat Nadran yang di selenggarakan secara rutin tiap tahun oleh masyarakat pesisir di Indramayu. Umumnya perayaan adat Nadran diselenggarakan bulan Oktober hingga Desember di beberapa tempat seperti di Eretan, Dadap, Karangsong, Limbangan dan Glayem.', 'nadran.jpg'),
(8, 'Makam Raden Arya Wiralodra', 'Raden Arya Wiralodra adalah pendiri kota Indramayu yang merupakan salah satu putra Raden Gagak Singalodra seorang adipati dari Bagelen. Makam Arya Wiralodra terletak didesa Sindang Kecamatan Sindang dengan jarak sekitar 500M dari sebelah barat pendopo Indramayu.', 'Makam_Raden_Arya_Wiralodra_.JPG');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_pariwisata`
--

CREATE TABLE `jenis_pariwisata` (
  `id_jenis` int(5) NOT NULL,
  `nama` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_pariwisata`
--

INSERT INTO `jenis_pariwisata` (`id_jenis`, `nama`) VALUES
(1, 'wisata alam'),
(2, 'wisata buatan'),
(3, 'travel'),
(4, 'kuliner'),
(5, 'hotel'),
(6, 'restoran');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kegiatan`
--

CREATE TABLE `kegiatan` (
  `id_kegiatan` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `tempat` varchar(50) NOT NULL,
  `deskripsi` varchar(500) NOT NULL,
  `gambar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kegiatan`
--

INSERT INTO `kegiatan` (`id_kegiatan`, `nama`, `tanggal`, `tempat`, `deskripsi`, `gambar`) VALUES
(8, 'Dangdut Vaganza', '2018-04-14', 'Alun-Alun Indramayu', 'Cek Sound Gladiresik Konser Tour Dangdut Vaganza Indosiar Di Indramayu', 'dangdut.jpg'),
(9, 'Upacara Adat Ngarot', '2018-11-09', 'Lelea', 'Upacara Adat Ngarot atau disebut juga Pesta Kasinoman yaitu sebuah tradisi khususnya masyarakat Desa Lelea, Desa Tamansari dan sekitarnya.', 'perawan-ngarot.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pariwisata`
--

CREATE TABLE `pariwisata` (
  `id_pariwisata` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `deskripsi` varchar(500) NOT NULL,
  `gambar` varchar(200) NOT NULL,
  `id_jenis` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data untuk tabel `pariwisata`
--

INSERT INTO `pariwisata` (`id_pariwisata`, `nama`, `deskripsi`, `gambar`, `id_jenis`) VALUES
(1, 'Pantai Tirtamaya', 'Tempat rekreasi pantai Tirtamaya adalah salah satu tujuan wisata yang banyak dikunjungi. Selain sebagai pemandian air laut yang aman, juga mempunyai panorama yang indah, terutama saat matahari terbit dan terbenam. Saat ini pantai Tirtamaya dijadikan Pool kapal cepat untuk transportasi ke pulau biawak juga dijadikan sebagai venue PON XIX tahiun 2016 untuk cabang olahraga selam dan renang laut. Pantai Tirtamaya terletak di jalur Indramayu-Cirebon sekitar 16Km dari pusat kota Indramayu.', 'tirtamaya.jpg', 1),
(17, 'Pulau Biawak', 'Objek wisata bahari dengan tanaman laut dan ikan hias yang beragam serta terumbu karang yang asli terdapat di pulau Biawak, dilengkapi dengan hamparan pasir putih, hutan mangrove dan budidaya rumput laut serta menara mercu suar yang dibangun oleh ZM. Willem pada tahun 1873. Aktifitas rekreasi yang dapat dilakukan di pulau Biawak ini diantaranya yaitu selam (diving), Snorkling, memancing dan berpetualang.\r\nPulau Biawak memiliki luas kurang lebih 120 Ha, terletak sekitar 40 Km disebelah utara\r\nInd', 'pulau-biawak-indramayu.jpg', 1),
(22, 'Hotel Istana Bangun Jagad', 'Jl.Raya Balongan-Indramayu Km.4 Telp.(0234)429123', 'HOTEL-ISTANA-BANGUN-JAGAD.JPG', 5),
(23, 'Hotel Wiwi Perkasa 2', 'Jl. Tridaya Indramayu Telp.(0234)272428', 'hotelwiwiperkasa2__931021.jpg', 5),
(24, 'Hotel Handayani', 'Jl.Kembar Bojongsari Indramayu Telp.(0234)271789-271790', 'handayani_hotel.jpg', 5),
(25, 'Pantai Balongan', 'Kabuten indramayu memiliki beberapa pantai yang berpotensi sebagai destinasi tujuan wisata,salah satu nya adalah pantai balongan indah.Pantai ini adalah salah satu pantai tercantik di indramayu,pasir pantai nya memang tidak putih,namun cukup halus dan aman untuk anak-anak. Selain itu,ada juga perahu nelayan yang bersandar dan siap untuk membawa wisatawan berkeliling disekitar perairan pantai balongan indah.Pantai balongan terletak di kecamatan balongan dengan jarak sekitar 10 Km dari pusat indra', 'Pantai-Balongan-Indah-Indramayu.jpg', 1),
(26, 'RM.Perdut', 'Jl.Juninyuat Indramayu', 'PERDUT.jpg', 6),
(27, 'RM. Mina Ayu', 'Jl.Raya Lombang Indramayu', 'Rumah Makan Mina Ayu.jpg', 6),
(28, 'Pantai Tanjung Pura', 'Pantai Tanjungpura ujung gebang adalah wisata bahari yang menyajikan wisata pantai yang kian diminati,disamping pemandian laut yang bersih juga terdapat hiburan nasional seperti sintren dan Kuda lumping serta tersedia warung yang menyajikan kuliner khas pesisir.', 'tanjung.jpg', 1),
(30, 'Situ Bolang', 'merupakan salah satu tempat wisata alternatif yang memiliki daya tersediri,seperti memancing,area perkemahan dan rekreasi air. situbolang terletak didesa jatisura kecamatan cikedung dengan jarak 20Km dari kota Indramayu,Yang memiliki nuansa pedesaan yang sangat terkenal dengan panoraman pesawahan,ternak kambing, dan pohon mangga yang tumbuh disekeliling situ.', 'situ.jpg', 2),
(31, 'Waroeng Ayam Ndeso', 'Jl.Olahraga Sport Center Indramayu', 'ayam ndeso.jpg', 6),
(32, 'Pusat Kuliner Cimanuk', 'Jl.Siliwangi Indramayu', 'Pusat Kuliner Cimanuk.jpeg', 6),
(33, 'Hutan Mangrove', 'Selain memiliki pemandangan pantai dan suasana ekowisata mangrove, wisatawan juga bisa melihat kesibukan para nelayan membongkar ikan hasil tangkapan dan para perajin kapal atau perahu. Disepanjang sungai Karangsong ini merupakan pemandangan yang jarang ditemui di objek wisata pantai lainnya. Untuk menuju kawasan hutan mangrove wisatawan harus menggunakan perahu yang sudah disediakan. Dengan terdapat jogging track sepanjang 1Km, wisatawan bisa menikmati suasana hutan mangrove yang masih asri dan', 'mangrov.jpg', 2),
(34, 'Agung Fantasi', 'Terletak di jalan pantura, Widasari, Indramayu.', 'agung.jpg', 2),
(35, 'Pedesan Entog', 'Olahan entog atau mentok adalah salah satu sajian nikmat yang ditawarkan kuliner Indramayu kepada para pencinta kuliner diseluruh penjuru, olahan ini biasanya disajikan dengan cara dibuat pedasan, sehingga rasanya sungguh menggugah selera, ditambah daging mentok yang begitu khas membuat sajian ini semakin spesial.', 'PEDESAN_ENTOG.jpg', 4),
(36, 'BURBACEK (Bubur Rumbah Cecek)', 'KULIT sapi atau yang disebut cecek oleh masyarakat Indramayu biasa \r\ndioleh menjadi sate atau disemur seperti halnya usus ayam. Olahan cecek tersebut \r\nbiasa dimakan sebagai lauk pendamping nasi. Apa jadinya bila cecek \r\ndicampur dengan bubur? Masakan tersebut dinamakan burbacek.\r\nyang berarti bubur, rumbah, dan cecek bisa ditemukan di wilayah Indramayu. \r\n\r\nMasakan tersebut sudah dianggap salah satu kuliner khas di Indramayu. Meskipun, untuk menemukan \r\nmakanan tersebut memerlukan sedikit perju', 'burbacek.jpg', 4),
(37, 'Pindang Gombyang', 'Pindang Gombyang sebetulnya terbuat dari kepala Ikan Manyung, \r\nikan laut yang biasa di buat menjadi makanan yang terkenal dengan \r\nikan asin jambal roti. Tahu kan asin jambal roti? Kepala Ikan Manyung \r\nbiasanya tidak bisa dimanfaatkan untuk ikan asin jadi dulu merupakan limbah sisa pembuatan Asin Jambal Roti. Untuk memanfaatkan kepalanya yang panjang dan cukup besar akhirnya penduduk Indramayu yang umumnya tinggal dekat pantai dan bermata pencaharian nelayan, mengolah limbah dari Asin ', 'a pindang.png', 4),
(38, 'Kue Blengep', 'Indramayu memiliki beberapa makanan khas yang dipercayai timbul dan \r\nberkembang di daerah ini, salah satunya adalah kue Blengep.\r\nSelain disebut kue Blengep, sebagian masyarakat Indramayu \r\njuga menamainya dengan sebutan kue Blengep Cotot.\r\nCotot sendiri bermaksud muncrat, sebab memang ketika \r\ndimakan kadang gula merah yang terkandung dalam kue tersebut \r\nmuncrat kedalam mulut.\r\n', 'blengep.jpg', 4),
(39, 'Kue Cikak', 'Kue Cikak adalah Kue tradisional khas indramayu. Kue cikak ini \r\nberwarna merah bulat. Isinya didalamnya kacang hijau. \r\nUntuk alasnya memakai daun pisang. Kue ini memiliki tekstur \r\nyang lembut dan Kue ini juga mempunyai rasa yang manis.\r\n', 'cikak.jpg', 4),
(40, 'Kue Dongkal', 'Makanan khas Indramayu dongkal adalah makanan ringan yang terbuat dari \r\ntepung beras, parutan kelapa, sagu, dan gula merah. Dongkal banyak \r\ntersedia di toko oleh-oleh di Indramayu. Rasanya yang manis cocok \r\nuntuk dijadikan oleh-oleh saat anda berkunjung ke Indramayu.', 'dongkalan.jpg', 4),
(41, 'Kerupuk Tike', 'Keripik tike terbuat dari umbi rumput teki yang diolah sehingga menghasilkan \r\ncemilan keripik khas Indramayu. Proses pembuatan keripik tike sama dengan cara \r\nmembuat emping melinjo. Pertama umbi rumput teki disangrai kemudian dipipihkan \r\nseperti emping melinjo. Setelah itu, umbi rumput teki dijemur dibawah matahari \r\nsampai kering dan siap digoreng.', 'a tike.jpg', 4),
(42, 'Andis Travel', 'Kantor Andis travel berada di Jl. Tanjungpura No.13 Indramayu', 'andistravel.jpg', 3),
(43, 'Kolam renang tiga bintang firdaus', 'Kolam Renang Tiga Bintang Firdaus terletak di Desa Kombo Kecamatan Terisi Kabupaten Indramayu ini banyak dikunjungi oleh masyarakat untuk berenang sambil berwisata menikmati keteduhan di sekitar kolam renang ini.', 'a bintang firdaus.jpg', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaduan`
--

CREATE TABLE `pengaduan` (
  `id_pengaduan` int(5) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `deskripsi` varchar(500) NOT NULL,
  `gambar` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `jenis`, `nama`, `deskripsi`, `gambar`) VALUES
(14, 'Budaya', 'h', 'g', 'h.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `nama`, `username`, `password`, `email`, `level`) VALUES
(11, 'firman', 'firman', 'firman', 'firman@gmail.com', 'admin'),
(12, 'user', 'user', 'user', 'user@gmail.com', 'Admin'),
(13, 'admin', 'admin', 'admin', 'admin@gmail.com', 'admin'),
(15, 'pengunjung', 'pengunjung', '123456', 'pengunjung@gmail.com', 'user'),
(17, 'syahrul gunawan', 'akunone', 'sayang', '1syahrulgunawan1@gmail.com', 'user'),
(18, 'kate', 'kate', '123456', 'kate@gmail.com', 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `budaya`
--
ALTER TABLE `budaya`
  ADD PRIMARY KEY (`id_budaya`);

--
-- Indeks untuk tabel `jenis_pariwisata`
--
ALTER TABLE `jenis_pariwisata`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indeks untuk tabel `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD PRIMARY KEY (`id_kegiatan`);

--
-- Indeks untuk tabel `pariwisata`
--
ALTER TABLE `pariwisata`
  ADD PRIMARY KEY (`id_pariwisata`);

--
-- Indeks untuk tabel `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`id_pengaduan`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `budaya`
--
ALTER TABLE `budaya`
  MODIFY `id_budaya` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `jenis_pariwisata`
--
ALTER TABLE `jenis_pariwisata`
  MODIFY `id_jenis` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `kegiatan`
--
ALTER TABLE `kegiatan`
  MODIFY `id_kegiatan` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `pariwisata`
--
ALTER TABLE `pariwisata`
  MODIFY `id_pariwisata` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT untuk tabel `pengaduan`
--
ALTER TABLE `pengaduan`
  MODIFY `id_pengaduan` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
