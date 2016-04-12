# Host: localhost  (Version: 5.5.40)
# Date: 2016-04-12 18:24:20
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "dept"
#

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(30) DEFAULT NULL,
  `dept_manager_id` varchar(255) DEFAULT '',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "dept"
#


#
# Source for table "staff"
#

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(20) DEFAULT '',
  `dept_id` int(11) DEFAULT '0',
  `staff_sex` varchar(20) DEFAULT '',
  `staff_phone_num` varchar(20) DEFAULT NULL,
  `staff_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "staff"
#


#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(12) DEFAULT '',
  `password` varchar(20) DEFAULT '',
  `flag` varchar(10) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#


#
# Source for table "xm_reply"
#

DROP TABLE IF EXISTS `xm_reply`;
CREATE TABLE `xm_reply` (
  `xw_id` int(11) NOT NULL AUTO_INCREMENT,
  `xm_reply` text,
  PRIMARY KEY (`xw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "xm_reply"
#


#
# Source for table "xw"
#

DROP TABLE IF EXISTS `xw`;
CREATE TABLE `xw` (
  `xw_id` int(11) NOT NULL AUTO_INCREMENT,
  `xw_name` varchar(30) DEFAULT NULL,
  `xw_author` varchar(20) DEFAULT NULL,
  `xw_reciever` varchar(20) DEFAULT NULL,
  `xw_content` text,
  `xm_date` varchar(30) DEFAULT NULL,
  `xw_state` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`xw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "xw"
#

