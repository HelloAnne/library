-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.19-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 library 的数据库结构
DROP DATABASE IF EXISTS `library`;
CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

-- 导出  表 library.book 结构
DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BOOK_SHELF_ID` bigint(20) NOT NULL,
  `BOOK_NAME` varchar(200) NOT NULL,
  `AUTHOR_NAME` varchar(200) NOT NULL,
  `BOOK_COVER_IMG` varchar(200) DEFAULT NULL,
  `BOOK_INTRODUCTION` varchar(2000) DEFAULT NULL,
  `BOOK_PRICE` decimal(10,2) NOT NULL,
  `BOOK_STOCK` int(11) NOT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DELETED_FLAG` char(1) NOT NULL DEFAULT '0',
  `MODIFICATION_NUM` char(1) NOT NULL DEFAULT '0',
  `CREATE_BY` bigint(20) NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  library.book 的数据：~4 rows (大约)
DELETE FROM `book`;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`ID`, `BOOK_SHELF_ID`, `BOOK_NAME`, `AUTHOR_NAME`, `BOOK_COVER_IMG`, `BOOK_INTRODUCTION`, `BOOK_PRICE`, `BOOK_STOCK`, `CREATE_DATE`, `LAST_MODIFIED_DATE`, `DELETED_FLAG`, `MODIFICATION_NUM`, `CREATE_BY`, `LAST_MODIFIED_BY`) VALUES
	(1, 4, '解忧杂货店', '东野圭吾', NULL, '现代人内心流失的东西，这家杂货店能帮你找回。僻静的街道旁有一家杂货店，只要写下烦恼投进卷帘门的投信口，第二天就会在店后的牛奶箱里得到回答。因男友身患绝症，年轻女孩静子在爱情与梦想间徘徊；克郎为了音乐梦想离家漂泊，却在现实中寸步难行；少年浩介面临家庭巨变，挣扎在亲情与未来的迷茫中……他们将困惑写成信投进杂货店，随即奇妙的事情竟不断发生。生命中的一次偶然交会，将如何演绎出截然不同的人生？', 39.50, 6, '2018-01-21 00:24:55', '2018-01-21 00:24:55', '0', '0', -1, -1),
	(2, 2, '我的前半生', '亦舒', NULL, '一个三十几岁的美丽女人子君，在家做全职家庭主妇。却被一个平凡女人夺走丈夫，一段婚姻的失败，让女主角不得不坚强，变得更美丽，有了事业，最终遇见一个更值得爱的男人……', 22.00, 6, '2018-01-21 00:26:17', '2018-01-21 00:26:17', '0', '0', -1, -1),
	(3, 5, '巨人的陨落', '肯·福莱特', NULL, '在第一次世界大战的硝烟中，每一个迈向死亡的生命都在热烈地生长——威尔士的矿工少年、刚失恋的美国法律系大学生、穷困潦倒的俄国兄弟、富有英俊的英格兰伯爵，以及痴情的德国特工… 从充满灰尘和危险的煤矿到闪闪发光的皇室宫殿，从代表着权力的走廊到爱恨纠缠的卧室，五个家族迥然不同又纠葛不断的命运逐渐揭晓，波澜壮阔地展现了一个我们自认为了解，但从未如此真切感受过的20世纪。', 129.80, 6, '2018-01-21 00:27:46', '2018-01-21 00:27:46', '0', '0', -1, -1),
	(4, 3, '沉默的大多数', '王小波', NULL, '这本杂文随笔集包括思想文化方面的文章，涉及知识分子的处境及思考，社会道德伦理，文化论争，国学与新儒家，民族主义等问题；包括从日常生活中发掘出来的各种真知灼见，涉及科学与邪道，女权主义等；包括对社会科学研究的评论，涉及性问题，生育问题，同性恋问题，社会研究的伦理问题和方法问题等；包括创作谈和文论，如写作的动机，作者的师承，作者对小说艺术的看法，作者对文体格调的看法，对影视的看法等；包括少量的书评，其中既有对文学经典的评论，也有对当代作家作品的一些看法；最后，还包括一些域外生活的杂感以及对某些社会现象的评点。', 27.00, 6, '2018-01-21 00:29:32', '2018-01-21 00:29:52', '0', '0', -1, -1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- 导出  表 library.book_record 结构
DROP TABLE IF EXISTS `book_record`;
CREATE TABLE IF NOT EXISTS `book_record` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `BOOK_ID` bigint(20) NOT NULL,
  `BORROW_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `RETURN_TIME` timestamp NULL DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DELETED_FLAG` char(1) NOT NULL DEFAULT '0',
  `MODIFICATION_NUM` char(1) NOT NULL DEFAULT '0',
  `CREATE_BY` bigint(20) NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  library.book_record 的数据：~0 rows (大约)
DELETE FROM `book_record`;
/*!40000 ALTER TABLE `book_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_record` ENABLE KEYS */;

-- 导出  表 library.book_shelf 结构
DROP TABLE IF EXISTS `book_shelf`;
CREATE TABLE IF NOT EXISTS `book_shelf` (
  `ID` bigint(64) NOT NULL AUTO_INCREMENT,
  `READING_ROOM_ID` bigint(64) DEFAULT '0',
  `BOOK_SHELF_NAME` varchar(200) DEFAULT '',
  `STATUS` char(1) DEFAULT '1',
  `CREATE_BY` bigint(64) DEFAULT '0',
  `LAST_MODIFIED_BY` bigint(64) DEFAULT '0',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DELETED_FLAG` char(1) NOT NULL DEFAULT '0',
  `MODIFICATION_NUM` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  library.book_shelf 的数据：~4 rows (大约)
DELETE FROM `book_shelf`;
/*!40000 ALTER TABLE `book_shelf` DISABLE KEYS */;
INSERT INTO `book_shelf` (`ID`, `READING_ROOM_ID`, `BOOK_SHELF_NAME`, `STATUS`, `CREATE_BY`, `LAST_MODIFIED_BY`, `CREATE_DATE`, `LAST_MODIFIED_DATE`, `DELETED_FLAG`, `MODIFICATION_NUM`) VALUES
	(2, 1, '小说类', '1', 2, 2, '2018-01-21 00:15:43', '2018-01-21 00:18:45', '0', '0'),
	(3, 1, '随笔类', '1', 2, 2, '2018-01-21 00:16:18', '2018-01-21 00:18:46', '0', '0'),
	(4, 2, '日本文学', '1', 2, 2, '2018-01-21 00:16:59', '2018-01-21 00:18:47', '0', '0'),
	(5, 2, '英国文学', '1', 2, 2, '2018-01-21 00:17:09', '2018-01-21 00:18:48', '0', '0');
/*!40000 ALTER TABLE `book_shelf` ENABLE KEYS */;

-- 导出  表 library.reading_room 结构
DROP TABLE IF EXISTS `reading_room`;
CREATE TABLE IF NOT EXISTS `reading_room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `READING_ROOM_NAME` varchar(200) NOT NULL,
  `LOCATION` varchar(200) NOT NULL,
  `STATUS` char(1) NOT NULL DEFAULT '1',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DELETED_FLAG` char(1) NOT NULL DEFAULT '0',
  `MODIFICATION_NUM` char(1) NOT NULL DEFAULT '0',
  `CREATE_BY` bigint(20) NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  library.reading_room 的数据：~2 rows (大约)
DELETE FROM `reading_room`;
/*!40000 ALTER TABLE `reading_room` DISABLE KEYS */;
INSERT INTO `reading_room` (`ID`, `READING_ROOM_NAME`, `LOCATION`, `STATUS`, `CREATE_DATE`, `LAST_MODIFIED_DATE`, `DELETED_FLAG`, `MODIFICATION_NUM`, `CREATE_BY`, `LAST_MODIFIED_BY`) VALUES
	(1, '中文阅览室', '图书馆2楼西侧', '1', '2018-01-21 00:13:32', '2018-01-21 00:13:32', '0', '0', -1, -1),
	(2, '外文阅览室', '图书馆2楼东侧', '1', '2018-01-21 00:13:51', '2018-01-21 00:13:51', '0', '0', -1, -1);
/*!40000 ALTER TABLE `reading_room` ENABLE KEYS */;

-- 导出  表 library.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(200) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `TEL_NUM` varchar(200) NOT NULL,
  `REAL_NAME` varchar(200) NOT NULL,
  `STATUS` char(1) NOT NULL DEFAULT '1',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_MODIFIED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DELETED_FLAG` char(1) NOT NULL DEFAULT '0',
  `MODIFICATION_NUM` char(1) NOT NULL DEFAULT '0',
  `CREATE_BY` bigint(20) NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  library.user 的数据：~1 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `USER_NAME`, `PASSWORD`, `TEL_NUM`, `REAL_NAME`, `STATUS`, `CREATE_DATE`, `LAST_MODIFIED_DATE`, `DELETED_FLAG`, `MODIFICATION_NUM`, `CREATE_BY`, `LAST_MODIFIED_BY`) VALUES
	(2, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '18765953881', '超级管理员', '1', '2018-01-20 23:00:30', '2018-01-20 23:01:07', '0', '0', -1, -1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
