-- phpMyAdmin SQL Dump
-- version 3.5.3
-- http://www.phpmyadmin.net
--
-- 主机: 10.10.6.19:3306
-- 生成日期: 2014 年 11 月 10 日 21:32
-- 服务器版本: 5.5.24-ucloudrel1-log
-- PHP 版本: 5.4.31

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `platform`
--

-- --------------------------------------------------------

--
-- 表的结构 `D_CATEGORY`
--

CREATE TABLE IF NOT EXISTS `D_CATEGORY` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `sta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `D_STADIUM`
--

CREATE TABLE IF NOT EXISTS `D_STADIUM` (
  `stadium_id` int(32) NOT NULL,
  `tenant_id` int(32) DEFAULT NULL,
  `stadium_name` varchar(255) DEFAULT NULL,
  `stadium_address` varchar(255) DEFAULT NULL,
  `stadium_category_id` int(32) DEFAULT NULL,
  `stadium_category_name` varchar(255) DEFAULT NULL,
  `stadium_img` varchar(255) DEFAULT NULL,
  `stadium_rank` int(2) DEFAULT NULL,
  `stadium_summary` longtext,
  PRIMARY KEY (`stadium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `D_TICKET`
--

CREATE TABLE IF NOT EXISTS `D_TICKET` (
  `ticket_id` int(32) NOT NULL,
  `ticket_info` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `D_VALUES`
--

CREATE TABLE IF NOT EXISTS `D_VALUES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_word` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `val` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- 表的结构 `L_ACTIVITY_COMPOSE`
--

CREATE TABLE IF NOT EXISTS `L_ACTIVITY_COMPOSE` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `activtiy_id` int(32) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `orderline_id` int(32) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1844 ;

-- --------------------------------------------------------

--
-- 表的结构 `L_COACH_CATEGORY_COMPOSE`
--

CREATE TABLE IF NOT EXISTS `L_COACH_CATEGORY_COMPOSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `L_COACH_STADIUM_COMPOSE`
--

CREATE TABLE IF NOT EXISTS `L_COACH_STADIUM_COMPOSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coach_id` int(11) DEFAULT NULL,
  `stadium_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_access_token`
--

CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_approvals`
--

CREATE TABLE IF NOT EXISTS `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_client_details`
--

CREATE TABLE IF NOT EXISTS `oauth_client_details` (
  `client_id` varchar(256) CHARACTER SET latin1 NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET latin1 DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_client_token`
--

CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_code`
--

CREATE TABLE IF NOT EXISTS `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `oauth_refresh_token`
--

CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `T_ACTIVITY`
--

CREATE TABLE IF NOT EXISTS `T_ACTIVITY` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `activtiy_name` varchar(255) DEFAULT NULL,
  `stadium_id` int(32) DEFAULT NULL,
  `order_id` int(32) DEFAULT NULL,
  `own_id` int(32) DEFAULT NULL,
  `activity_start` datetime DEFAULT NULL,
  `activity_end` datetime DEFAULT NULL,
  `is_public` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=816 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_COACHE`
--

CREATE TABLE IF NOT EXISTS `T_COACHE` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `rank` int(2) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `coaching_years` int(2) DEFAULT NULL,
  `coaching_specialty` varchar(255) DEFAULT NULL,
  `sports_history` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_COMMENT`
--

CREATE TABLE IF NOT EXISTS `T_COMMENT` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `comment` varchar(2000) DEFAULT NULL,
  `rank` int(2) DEFAULT NULL,
  `stadium_id` int(32) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `coach_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_COURSE`
--

CREATE TABLE IF NOT EXISTS `T_COURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `summary` varchar(10000) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `stadium_id` int(11) DEFAULT NULL,
  `coache_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_ORDER`
--

CREATE TABLE IF NOT EXISTS `T_ORDER` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(30) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `tenant_order_id` int(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `amount` int(32) DEFAULT NULL,
  `order_no` varchar(30) DEFAULT NULL,
  `order_status` varchar(30) DEFAULT NULL,
  `order_type` varchar(30) DEFAULT NULL,
  `paid_amount` int(11) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `order_pay_type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creation_time` (`creation_time`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=100023 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_ORDER_LINE`
--

CREATE TABLE IF NOT EXISTS `T_ORDER_LINE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `tenant_order_line_id` int(32) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `resource_name` varchar(40) DEFAULT NULL,
  `field_id` int(32) DEFAULT NULL,
  `resource_date` datetime DEFAULT NULL,
  `resource_start_time` varchar(10) DEFAULT NULL,
  `resource_end_time` varchar(10) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `stadium_id` int(32) DEFAULT NULL,
  `ticket_id` int(32) DEFAULT NULL,
  `resource_type` varchar(20) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creation_time` (`creation_time`),
  KEY `creation_time_2` (`creation_time`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=240698 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_TENANT`
--

CREATE TABLE IF NOT EXISTS `T_TENANT` (
  `id` int(32) NOT NULL,
  `tenant_name` varchar(255) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `T_TENANT_USER`
--

CREATE TABLE IF NOT EXISTS `T_TENANT_USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ic_number` varchar(30) DEFAULT NULL,
  `member_account` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `tenant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10526 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_TRANS`
--

CREATE TABLE IF NOT EXISTS `T_TRANS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `amount` int(255) DEFAULT NULL,
  `trans_no` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `type` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_paid` tinyint(4) DEFAULT NULL,
  `operator` varchar(30) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=407 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_USER`
--

CREATE TABLE IF NOT EXISTS `T_USER` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `nickname` varchar(128) DEFAULT NULL,
  `mobile` varchar(16) DEFAULT NULL,
  `mobile_validated` tinyint(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email_validated` tinyint(1) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `account_balance` int(11) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `modification_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `is_tenant` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27571 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_USER_WEIXIN`
--

CREATE TABLE IF NOT EXISTS `T_USER_WEIXIN` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=29 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_VALIDATE_TEMP_DATA`
--

CREATE TABLE IF NOT EXISTS `T_VALIDATE_TEMP_DATA` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `validate_code` varchar(255) DEFAULT NULL,
  `expires_time` datetime DEFAULT NULL,
  `is_invalid` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=273 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_WX_FEED_BACK`
--

CREATE TABLE IF NOT EXISTS `T_WX_FEED_BACK` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `msg_type` varchar(10) DEFAULT NULL,
  `feed_back_id` varchar(255) DEFAULT NULL,
  `trans_id` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `solution` varchar(255) DEFAULT NULL,
  `extinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `T_WX_WARN`
--

CREATE TABLE IF NOT EXISTS `T_WX_WARN` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `error_type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `alarmcontent` varchar(255) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
