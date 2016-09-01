/*
Navicat MySQL Data Transfer

Source Server         : 鸟云
Source Server Version : 50547
Source Host           : 110.173.17.140:3306
Source Database       : RuanHu

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-09-01 12:06:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for AlibabaKey
-- ----------------------------
DROP TABLE IF EXISTS `AlibabaKey`;
CREATE TABLE `AlibabaKey` (
  `AccessKeySecret` varchar(255) DEFAULT NULL,
  `AccessKeyId` varchar(255) NOT NULL,
  PRIMARY KEY (`AccessKeyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of AlibabaKey
-- ----------------------------
INSERT INTO `AlibabaKey` VALUES ('SbeRhCKLikomA4IQeB5P68fUYGU76K', 'ARp1KJhOtHbQ1TU9');
INSERT INTO `AlibabaKey` VALUES ('iGjVxQ2pKBNjvxHcUru9axvz37FMnG', 'kZK04yLb1juqauX5');
INSERT INTO `AlibabaKey` VALUES ('j50nMt4WReBaMpBlbSdetb6ylcCrNp', 'NtyKt0jSsK0gG5CM');
INSERT INTO `AlibabaKey` VALUES ('oiGGbep8qtrqXnC4FdG02MMVr9aaAV', 'rdKaILFkmvaPJl0B');

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `author_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vote_count` bigint(20) DEFAULT '0',
  `solution` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_3q5s4b88xp78n3c49dtxfs97e` (`author_id`),
  KEY `FK_10g8xii7lw9kq0kcsobgmtw72` (`question_id`),
  CONSTRAINT `FK_10g8xii7lw9kq0kcsobgmtw72` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_3q5s4b88xp78n3c49dtxfs97e` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=509 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('354', ' ?mn', '5', '279', '2016-07-15 19:24:25', '2016-07-15 19:24:25', '0', '0');
INSERT INTO `answer` VALUES ('355', ' ?mn', '5', '279', '2016-07-15 19:26:45', '2016-07-15 19:26:45', '0', '0');
INSERT INTO `answer` VALUES ('356', ' ?mnzsbvszb', '5', '279', '2016-07-15 19:46:18', '2016-07-22 11:28:48', '0', '0');
INSERT INTO `answer` VALUES ('359', '太高级了看不懂', '1', '281', '2016-07-15 19:49:06', '2016-07-15 19:49:06', '0', '0');
INSERT INTO `answer` VALUES ('360', '现在就可以了', '1', '277', '2016-07-15 19:49:19', '2016-07-21 14:50:30', '0', '0');
INSERT INTO `answer` VALUES ('456', '不知道为什么就好了:joy:', '3', '277', '2016-07-17 11:32:26', '2016-07-21 14:50:12', '0', '0');
INSERT INTO `answer` VALUES ('458', '\n#### Disabled options\n\n- TeX (Based on KaTeX);\n- Emoji;\n- Task lists;\n- HTML tags decode;\n- Flowchart and Sequence Diagram;\n\n#### Editor.md directory\n\n    editor.md/\n            lib/\n            css/\n            scss/\n            tests/\n            fonts/\n            images/\n            plugins/\n            examples/\n            languages/     \n            editormd.js\n            ...\n\n```html\n<!-- English -->\n<script src=\"../dist/js/languages/en.js\"></script>\n\n<!-- 繁體中文 -->\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\n```\n:joy:', '3', '323', '2016-07-17 16:39:38', '2016-07-22 11:28:48', '0', '0');
INSERT INTO `answer` VALUES ('462', '回答一下', '3', '336', '2016-07-22 14:28:39', '2016-07-22 14:28:39', '0', '0');
INSERT INTO `answer` VALUES ('463', '回答一下', '3', '334', '2016-07-22 14:29:11', '2016-07-22 14:29:11', '0', '0');
INSERT INTO `answer` VALUES ('467', '前期在红火箭维修站安家，接兄弟会的支援任务，干掉克罗格后就可以到飞艇上领取**T60动力装甲**\n\n![](http://images.ali213.net/picfile/pic/2015/06/04/927_2015060410483536.jpg)\n\nPERK建议点**开锁两级，hack两级**，魅力要高，运气也很重要', '2', '345', '2016-07-22 18:02:33', '2016-07-22 18:04:20', '2', '0');
INSERT INTO `answer` VALUES ('468', ':expressionless:', '4', '345', '2016-07-22 18:24:52', '2016-07-22 18:24:52', '0', '0');
INSERT INTO `answer` VALUES ('469', ':expressionless:', '4', '345', '2016-07-22 18:25:08', '2016-07-22 18:25:08', '0', '0');
INSERT INTO `answer` VALUES ('470', '', '4', '345', '2016-07-22 18:30:51', '2016-07-22 18:30:51', '0', '0');
INSERT INTO `answer` VALUES ('471', '6点去:smiley:\n           ', '3', '344', '2016-07-23 00:44:51', '2016-07-23 00:44:51', '0', '0');
INSERT INTO `answer` VALUES ('472', 'hhhh', '5', '345', '2016-07-25 11:11:42', '2016-07-25 11:11:42', '0', '0');
INSERT INTO `answer` VALUES ('473', '带引用的答案', '3', '345', '2016-07-25 12:06:32', '2016-07-25 12:06:32', '0', '0');
INSERT INTO `answer` VALUES ('475', '这是一条带引用的回答', '3', '335', '2016-07-25 14:48:25', '2016-07-25 14:48:25', '0', '0');
INSERT INTO `answer` VALUES ('476', '这是带引用的回答', '3', '335', '2016-07-25 14:52:33', '2016-07-25 14:52:33', '0', '0');
INSERT INTO `answer` VALUES ('495', '', '3', '346', '2016-07-25 15:19:40', '2016-07-25 15:19:40', '0', '0');
INSERT INTO `answer` VALUES ('496', '', '3', '346', '2016-07-25 15:43:18', '2016-07-25 15:43:18', '0', '0');
INSERT INTO `answer` VALUES ('498', '这是一个带引用的回答\n让我来编辑一下', '3', '347', '2016-07-25 16:34:01', '2016-07-25 16:35:55', '1', '0');
INSERT INTO `answer` VALUES ('500', '提交', '3', '347', '2016-07-25 16:37:17', '2016-07-25 16:37:17', '0', '0');
INSERT INTO `answer` VALUES ('501', '这是一个带引用的回答', '3', '349', '2016-07-25 22:25:21', '2016-07-25 22:25:21', '0', '0');
INSERT INTO `answer` VALUES ('502', '这是一个[[测试](http://121.42.184.4:8080/html/entry_content.html?entry=测试)](http://121.42.184.4:8080/html/entry_content.html?entry=测试)\n               	 						', '3', '351', '2016-07-26 17:14:57', '2016-07-26 17:14:57', '0', '0');
INSERT INTO `answer` VALUES ('503', '回答', '2', '352', '2016-07-27 12:02:53', '2016-07-27 12:02:53', '0', '0');
INSERT INTO `answer` VALUES ('505', '修改我的回答\n                \n                \n			', '4', '356', '2016-07-29 10:02:37', '2016-07-29 10:03:50', '1', '0');
INSERT INTO `answer` VALUES ('506', '\n没有packet.\n                \n无效import。', '1', '357', '2016-07-29 10:10:52', '2016-07-29 10:11:18', '0', '0');

-- ----------------------------
-- Table structure for answer_document
-- ----------------------------
DROP TABLE IF EXISTS `answer_document`;
CREATE TABLE `answer_document` (
  `answer_id` bigint(20) NOT NULL,
  `document_id` bigint(20) NOT NULL,
  PRIMARY KEY (`answer_id`,`document_id`),
  KEY `answer_idx` (`answer_id`),
  CONSTRAINT `answer` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of answer_document
-- ----------------------------
INSERT INTO `answer_document` VALUES ('496', '16072000002');
INSERT INTO `answer_document` VALUES ('498', '16072000000');
INSERT INTO `answer_document` VALUES ('500', '16072000000');
INSERT INTO `answer_document` VALUES ('501', '16072000001');
INSERT INTO `answer_document` VALUES ('505', '16072600002');

-- ----------------------------
-- Table structure for answer_wiki
-- ----------------------------
DROP TABLE IF EXISTS `answer_wiki`;
CREATE TABLE `answer_wiki` (
  `answer_id` bigint(20) NOT NULL,
  `wiki_id` bigint(20) NOT NULL,
  PRIMARY KEY (`answer_id`,`wiki_id`),
  KEY `answer_idx` (`answer_id`),
  CONSTRAINT `answer_wiki` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of answer_wiki
-- ----------------------------
INSERT INTO `answer_wiki` VALUES ('495', '219');
INSERT INTO `answer_wiki` VALUES ('496', '222');
INSERT INTO `answer_wiki` VALUES ('498', '231');
INSERT INTO `answer_wiki` VALUES ('501', '219');
INSERT INTO `answer_wiki` VALUES ('501', '232');
INSERT INTO `answer_wiki` VALUES ('505', '219');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `author_id` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `answer_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j94pith5sd971k29j6ysxuk7` (`author_id`),
  KEY `comment_answer_idx` (`answer_id`),
  KEY `comment_question_idx` (`question_id`),
  CONSTRAINT `comment_answer` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `comment_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_j94pith5sd971k29j6ysxuk7` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mesg_type` enum('voteQuestion','voteAnswer','comment','answer','invite') CHARACTER SET latin1 NOT NULL,
  `source_id` bigint(20) NOT NULL,
  `sender_id` bigint(20) NOT NULL,
  `receiver_id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `checked` smallint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `constr1` (`mesg_type`,`source_id`,`sender_id`,`receiver_id`),
  KEY `sender` (`sender_id`),
  KEY `receiver` (`receiver_id`),
  CONSTRAINT `receiver` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sender` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('129', 'voteQuestion', '335', '2', '3', 'ss14赞了我', '2016-07-22 17:33:00', '1');
INSERT INTO `message` VALUES ('130', 'voteQuestion', '345', '2', '2', 'ss14赞了我', '2016-07-22 17:54:41', '0');
INSERT INTO `message` VALUES ('131', 'answer', '345', '2', '2', 'ss14回答了我的问题', '2016-07-22 18:02:34', '0');
INSERT INTO `message` VALUES ('132', 'voteAnswer', '467', '2', '2', 'ss14赞了我', '2016-07-22 18:02:44', '0');
INSERT INTO `message` VALUES ('133', 'voteAnswer', '467', '1', '2', 'ch赞了我', '2016-07-22 18:04:11', '0');
INSERT INTO `message` VALUES ('134', 'voteQuestion', '345', '1', '2', 'ch赞了我', '2016-07-22 18:05:49', '0');
INSERT INTO `message` VALUES ('135', 'answer', '345', '4', '2', 'Dora回答了我的问题', '2016-07-22 18:30:51', '0');
INSERT INTO `message` VALUES ('136', 'voteQuestion', '344', '3', '5', 'sbin14赞了我', '2016-07-22 23:52:32', '0');
INSERT INTO `message` VALUES ('137', 'answer', '344', '3', '5', 'sbin14回答了我的问题', '2016-07-23 00:44:52', '0');
INSERT INTO `message` VALUES ('138', 'voteQuestion', '343', '3', '3', 'sbin14赞了我', '2016-07-23 01:11:20', '1');
INSERT INTO `message` VALUES ('139', 'voteQuestion', '334', '3', '3', 'sbin14赞了我', '2016-07-23 10:11:14', '1');
INSERT INTO `message` VALUES ('140', 'voteQuestion', '324', '3', '3', 'sbin14赞了我', '2016-07-23 10:11:28', '1');
INSERT INTO `message` VALUES ('141', 'answer', '345', '5', '2', 'zxf14回答了我的问题', '2016-07-25 11:11:44', '0');
INSERT INTO `message` VALUES ('142', 'invite', '343', '3', '2', 'sbin14邀请我回答问题', '2016-07-25 11:49:17', '0');
INSERT INTO `message` VALUES ('143', 'invite', '343', '3', '3', 'sbin14邀请我回答问题', '2016-07-25 11:49:41', '1');
INSERT INTO `message` VALUES ('145', 'invite', '343', '3', '4', 'sbin14邀请我回答问题', '2016-07-25 11:57:48', '1');
INSERT INTO `message` VALUES ('147', 'invite', '343', '3', '1', 'sbin14邀请我回答问题', '2016-07-25 11:59:00', '0');
INSERT INTO `message` VALUES ('148', 'invite', '343', '3', '5', 'sbin14邀请我回答问题', '2016-07-25 11:59:38', '0');
INSERT INTO `message` VALUES ('151', 'answer', '345', '3', '2', 'sbin14回答了我的问题', '2016-07-25 12:06:32', '0');
INSERT INTO `message` VALUES ('152', 'invite', '335', '3', '4', 'sbin14邀请我回答问题', '2016-07-25 12:07:13', '1');
INSERT INTO `message` VALUES ('153', 'invite', '335', '3', '5', 'sbin14邀请我回答问题', '2016-07-25 12:07:26', '0');
INSERT INTO `message` VALUES ('154', 'invite', '335', '3', '1', 'sbin14邀请我回答问题', '2016-07-25 12:11:15', '0');
INSERT INTO `message` VALUES ('156', 'invite', '335', '3', '2', 'sbin14邀请我回答问题', '2016-07-25 12:12:41', '0');
INSERT INTO `message` VALUES ('157', 'invite', '282', '3', '2', 'sbin14邀请我回答问题', '2016-07-25 12:21:19', '0');
INSERT INTO `message` VALUES ('158', 'invite', '282', '3', '3', 'sbin14邀请我回答问题', '2016-07-25 12:21:19', '1');
INSERT INTO `message` VALUES ('164', 'invite', '282', '3', '4', 'sbin14邀请我回答问题', '2016-07-25 12:27:00', '1');
INSERT INTO `message` VALUES ('166', 'invite', '282', '3', '5', 'sbin14邀请我回答问题', '2016-07-25 12:27:17', '0');
INSERT INTO `message` VALUES ('167', 'answer', '344', '5', '5', 'zxf14回答了我的问题', '2016-07-25 12:49:45', '0');
INSERT INTO `message` VALUES ('168', 'invite', '323', '4', '4', 'Dora邀请我回答问题', '2016-07-25 14:12:31', '1');
INSERT INTO `message` VALUES ('170', 'invite', '284', '4', '4', 'Dora邀请我回答问题', '2016-07-25 14:20:54', '1');
INSERT INTO `message` VALUES ('172', 'invite', '334', '4', '4', 'Dora邀请我回答问题', '2016-07-25 14:27:19', '1');
INSERT INTO `message` VALUES ('173', 'invite', '336', '4', '4', 'Dora邀请我回答问题', '2016-07-25 14:28:11', '1');
INSERT INTO `message` VALUES ('174', 'voteQuestion', '345', '4', '2', 'Dora赞了我', '2016-07-25 14:31:04', '0');
INSERT INTO `message` VALUES ('175', 'answer', '335', '3', '3', 'sbin14回答了我的问题', '2016-07-25 14:48:26', '1');
INSERT INTO `message` VALUES ('176', 'answer', '346', '3', '3', 'sbin14回答了我的问题', '2016-07-25 15:10:04', '1');
INSERT INTO `message` VALUES ('177', 'invite', '347', '3', '4', 'sbin14邀请我回答问题', '2016-07-25 16:33:20', '1');
INSERT INTO `message` VALUES ('178', 'invite', '347', '3', '1', 'sbin14邀请我回答问题', '2016-07-25 16:33:20', '0');
INSERT INTO `message` VALUES ('179', 'invite', '347', '3', '3', 'sbin14邀请我回答问题', '2016-07-25 16:33:29', '1');
INSERT INTO `message` VALUES ('180', 'answer', '347', '3', '3', 'sbin14回答了我的问题', '2016-07-25 16:34:02', '1');
INSERT INTO `message` VALUES ('181', 'voteQuestion', '347', '3', '3', 'sbin14赞了我', '2016-07-25 16:35:44', '1');
INSERT INTO `message` VALUES ('182', 'voteAnswer', '498', '3', '3', 'sbin14赞了我', '2016-07-25 16:35:50', '1');
INSERT INTO `message` VALUES ('183', 'voteQuestion', '349', '3', '3', 'sbin14赞了我', '2016-07-25 22:25:18', '1');
INSERT INTO `message` VALUES ('184', 'answer', '349', '3', '3', 'sbin14回答了我的问题', '2016-07-25 22:25:21', '1');
INSERT INTO `message` VALUES ('185', 'answer', '351', '3', '3', 'sbin14回答了我的问题', '2016-07-26 17:14:58', '1');
INSERT INTO `message` VALUES ('186', 'answer', '352', '2', '2', 'ss14回答了我的问题', '2016-07-27 12:02:53', '0');
INSERT INTO `message` VALUES ('187', 'answer', '353', '3', '3', 'sbin14回答了我的问题', '2016-07-28 12:18:33', '1');
INSERT INTO `message` VALUES ('191', 'voteQuestion', '356', '3', '3', 'sbin14赞了我', '2016-07-29 09:59:35', '0');
INSERT INTO `message` VALUES ('192', 'invite', '356', '4', '4', 'Dora邀请我回答问题', '2016-07-29 10:00:58', '1');
INSERT INTO `message` VALUES ('194', 'answer', '356', '4', '3', 'Dora回答了我的问题', '2016-07-29 10:02:37', '0');
INSERT INTO `message` VALUES ('195', 'voteAnswer', '505', '4', '4', 'Dora赞了我', '2016-07-29 10:03:50', '0');
INSERT INTO `message` VALUES ('196', 'voteQuestion', '356', '4', '3', 'Dora赞了我', '2016-07-29 10:04:53', '0');
INSERT INTO `message` VALUES ('197', 'invite', '357', '1', '3', 'ch邀请我回答问题', '2016-07-29 10:10:19', '0');
INSERT INTO `message` VALUES ('198', 'invite', '357', '1', '4', 'ch邀请我回答问题', '2016-07-29 10:10:19', '0');
INSERT INTO `message` VALUES ('199', 'invite', '357', '1', '2', 'ch邀请我回答问题', '2016-07-29 10:10:19', '0');
INSERT INTO `message` VALUES ('200', 'answer', '357', '1', '1', 'ch回答了我的问题', '2016-07-29 10:10:52', '0');
INSERT INTO `message` VALUES ('201', 'voteAnswer', '506', '1', '1', 'ch赞了我', '2016-07-29 10:11:09', '0');
INSERT INTO `message` VALUES ('204', 'answer', '358', '3', '3', 'sbin14回答了我的问题', '2016-07-29 10:20:10', '0');
INSERT INTO `message` VALUES ('207', 'answer', '359', '3', '3', 'sbin14回答了我的问题', '2016-07-29 16:13:57', '0');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer_count` bigint(20) DEFAULT '0',
  `vote_count` bigint(20) DEFAULT '0',
  `view_count` bigint(20) DEFAULT '0',
  `author_id` bigint(20) NOT NULL,
  `title` varchar(100) DEFAULT '',
  `content` longtext,
  `created_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_a3dib35x299yvhfk7pau0kw5w` (`author_id`),
  CONSTRAINT `question_user` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('276', '0', '0', '0', '3', '这是一个酷炫的测试问题.', '#### Disabled options\r\n\r\n- TeX (Based on KaTeX);\r\n- Emoji;\r\n- Task lists;\r\n- HTML tags decode;\r\n- Flowchart and Sequence Diagram;\r\n\r\n#### Editor.md directory\r\n\r\n    editor.md/\r\n            lib/\r\n            css/\r\n            scss/\r\n            tests/\r\n            fonts/\r\n            images/\r\n            plugins/\r\n            examples/\r\n            languages/     \r\n            editormd.js\r\n            ...\r\n\r\n```html\r\n<!-- English -->\r\n<script src=\"../dist/js/languages/en.js\"></script>\r\n\r\n<!-- 繁體中文 -->\r\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\r\n```', '2016-07-15 18:31:00', '2016-07-22 14:43:26');
INSERT INTO `question` VALUES ('277', '2', '0', '0', '4', '救命！我不能提交答案了！', '**感到非常的难过**\r\n```python\r\nprint \"what ghost\"\r\n```\r\n:tired_face: :tired_face: :tired_face: :tired_face:', '2016-07-15 18:59:32', '2016-07-17 11:32:26');
INSERT INTO `question` VALUES ('279', '3', '0', '0', '5', 'dfasshwges', '![](http://img.ui.cn/data/file/3/5/6/701653.jpg)', '2016-07-15 19:11:03', '2016-07-15 19:46:10');
INSERT INTO `question` VALUES ('280', '0', '0', '0', '3', '申彬的问题', '', '2016-07-15 19:17:16', '2016-07-15 19:17:16');
INSERT INTO `question` VALUES ('281', '1', '0', '0', '3', '申彬的第二个提问', '#### Disabled options\r\n\r\n- TeX (Based on KaTeX);\r\n- Emoji;\r\n- Task lists;\r\n- HTML tags decode;\r\n- Flowchart and Sequence Diagram;\r\n\r\n#### Editor.md directory\r\n\r\n    editor.md/\r\n            lib/\r\n            css/\r\n            scss/\r\n            tests/\r\n            fonts/\r\n            images/\r\n            plugins/\r\n            examples/\r\n            languages/     \r\n            editormd.js\r\n            ...\r\n\r\n```html\r\n<!-- English -->\r\n<script src=\"../dist/js/languages/en.js\"></script>\r\n\r\n<!-- 繁體中文 -->\r\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\r\n```', '2016-07-15 19:24:29', '2016-07-15 19:49:11');
INSERT INTO `question` VALUES ('282', '0', '0', '0', '5', 'asgfag', '![](http://img.ui.cn/data/file/3/5/6/701653.jpg)', '2016-07-15 19:46:41', '2016-07-22 16:36:09');
INSERT INTO `question` VALUES ('284', '0', '0', '0', '3', '这是一个问题', '#### Disabled options\r\n\r\n- TeX (Based on KaTeX);\r\n- Emoji;\r\n- Task lists;\r\n- HTML tags decode;\r\n- Flowchart and Sequence Diagram;\r\n\r\n#### Editor.md directory\r\n\r\n    editor.md/\r\n            lib/\r\n            css/\r\n            scss/\r\n            tests/\r\n            fonts/\r\n            images/\r\n            plugins/\r\n            examples/\r\n            languages/     \r\n            editormd.js\r\n            ...\r\n\r\n```html\r\n<!-- English -->\r\n<script src=\"../dist/js/languages/en.js\"></script>\r\n\r\n<!-- 繁體中文 -->\r\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\r\n```', '2016-07-15 20:04:49', '2016-07-17 10:07:31');
INSERT INTO `question` VALUES ('323', '1', '0', '0', '3', '第三个问题', '\r\n#### Disabled options\r\n\r\n- TeX (Based on KaTeX);\r\n- Emoji;\r\n- Task lists;\r\n- HTML tags decode;\r\n- Flowchart and Sequence Diagram;\r\n\r\n#### Editor.md directory\r\n\r\n    editor.md/\r\n            lib/\r\n            css/\r\n            scss/\r\n            tests/\r\n            fonts/\r\n            images/\r\n            plugins/\r\n            examples/\r\n            languages/     \r\n            editormd.js\r\n            ...\r\n\r\n```html\r\n<!-- English -->\r\n<script src=\"../dist/js/languages/en.js\"></script>\r\n\r\n<!-- 繁體中文 -->\r\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\r\n```\r\n:joy:', '2016-07-17 16:39:19', '2016-07-22 11:28:48');
INSERT INTO `question` VALUES ('324', '0', '1', '0', '3', '这是一个问题\n			       		\n			       		\n			       		\n			       		\n			       		\n			       		\n			       		\n		', '\n#### Disabl    options\n\n- TeX (Based on KaTeX);\n- Emoji;\n- Task lists;\n- HTML tags decode;\n- Flowchart and Sequence Diagram;\n\n#### Editor.md directory\n\n    editor.md/\n            lib/\n            css/\n            scss/\n            tests/\n            fonts/\n            images/\n            plugins/\n            examples/\n            languages/     \n            editormd.js\n            ...\n\n```html\n<!-- English -->\n<script src=\"../dist/js/languages/en.js\"></script>\n\n<!-- 繁體中文 -->\n<script src=\"../dist/js/languages/zh-tw.js\"></script>\n```\n:joy:\n               	 						\n               	 						\n               	 						\n               	 						\n               	 						\n               	 						\n               	 						\n               	 						', '2016-07-18 14:46:50', '2016-07-23 10:11:28');
INSERT INTO `question` VALUES ('334', '1', '1', '0', '3', '测试\n			       		', '测试在不在对象的\n> DVSZ\nDVS\nV\n               	 						', '2016-07-21 11:14:30', '2016-07-23 10:11:14');
INSERT INTO `question` VALUES ('335', '2', '-1', '0', '3', '带引用的问题\n			       		', '##这是一个带引用的问题\n进行了一些修改', '2016-07-21 17:49:30', '2016-07-25 15:17:31');
INSERT INTO `question` VALUES ('336', '1', '0', '0', '3', '这是一个带wiki引用的问题', 'wiki引用', '2016-07-21 17:51:34', '2016-07-22 17:21:31');
INSERT INTO `question` VALUES ('343', '0', '1', '0', '3', '带引用', '', '2016-07-22 16:21:47', '2016-07-23 01:11:26');
INSERT INTO `question` VALUES ('344', '1', '1', '0', '5', '我也来提一个问题\r\n			       		\r\n			       		', '几点能去吃饭啊:confused:\r\n               	 						\r\n										s . \r\n               	 						', '2016-07-22 17:05:44', '2016-07-25 12:52:06');
INSERT INTO `question` VALUES ('345', '6', '2', '0', '2', '如何在废土横着走', '如题', '2016-07-22 17:41:23', '2016-07-25 15:23:20');
INSERT INTO `question` VALUES ('346', '2', '0', '0', '3', '带引用的问题\r\n			       		', '带引用的问题', '2016-07-25 15:08:51', '2016-07-25 15:50:14');
INSERT INTO `question` VALUES ('347', '2', '1', '0', '3', '这是一个展示时候提的问题,带引用的', '这是问题的描述', '2016-07-25 16:32:55', '2016-07-25 16:37:22');
INSERT INTO `question` VALUES ('348', '0', '0', '0', '3', '这是一个带引用的问题', '', '2016-07-25 22:23:22', '2016-07-25 22:23:22');
INSERT INTO `question` VALUES ('349', '1', '1', '0', '3', '这是一个引用了wiki和ppt的问题', '这是一个带引用的问题', '2016-07-25 22:24:45', '2016-07-25 22:25:21');
INSERT INTO `question` VALUES ('350', '0', '0', '0', '3', '测试标签能不能用的问题\r\n			       		', '这是一个 <a> 标签 </a>\r\n', '2016-07-26 15:46:43', '2016-07-26 15:46:43');
INSERT INTO `question` VALUES ('351', '1', '0', '0', '3', '测试一下会不会自动变蓝\r\n			       		\r\n			       		', '这是一个[测试](http://121.42.184.4:8080/html/entry_content.html?entry=测试)\r\n\r\n               	 						', '2016-07-26 17:14:23', '2016-07-26 17:15:03');
INSERT INTO `question` VALUES ('352', '1', '0', '0', '2', 'wenti ', 'hh', '2016-07-27 12:02:34', '2016-07-27 12:03:06');
INSERT INTO `question` VALUES ('356', '1', '2', '0', '3', '什么是软件需求?', '什么是[软件需求](http://121.42.184.4:8080/html/entry_content.html?entry=软件需求)?', '2016-07-29 09:59:31', '2016-07-29 10:04:53');
INSERT INTO `question` VALUES ('357', '1', '0', '0', '1', '第一个问什么问题？', '```java\r\nimport java.util.*;\r\npublic class Cui{\r\n	public void main(String[] args){\r\n		System.out.println();\r\n	}\r\n}\r\n```\r\n\r\n错误在哪/', '2016-07-29 10:09:33', '2016-07-29 10:10:52');

-- ----------------------------
-- Table structure for question_document
-- ----------------------------
DROP TABLE IF EXISTS `question_document`;
CREATE TABLE `question_document` (
  `question_id` bigint(20) NOT NULL,
  `document_id` bigint(20) NOT NULL,
  PRIMARY KEY (`question_id`,`document_id`),
  KEY `question_docu_idx` (`question_id`),
  CONSTRAINT `question_docu` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of question_document
-- ----------------------------
INSERT INTO `question_document` VALUES ('335', '16072000000');
INSERT INTO `question_document` VALUES ('343', '16072000000');
INSERT INTO `question_document` VALUES ('343', '16072000001');
INSERT INTO `question_document` VALUES ('346', '16072000002');
INSERT INTO `question_document` VALUES ('347', '16072000002');
INSERT INTO `question_document` VALUES ('349', '16072000000');
INSERT INTO `question_document` VALUES ('352', '16072000000');
INSERT INTO `question_document` VALUES ('356', '16072600002');
INSERT INTO `question_document` VALUES ('356', '16072600004');
INSERT INTO `question_document` VALUES ('357', '16072700004');

-- ----------------------------
-- Table structure for question_wiki
-- ----------------------------
DROP TABLE IF EXISTS `question_wiki`;
CREATE TABLE `question_wiki` (
  `question_id` bigint(20) NOT NULL,
  `wiki_id` bigint(20) NOT NULL,
  PRIMARY KEY (`wiki_id`,`question_id`),
  KEY `question_wiki_idx` (`question_id`),
  CONSTRAINT `question_wiki` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of question_wiki
-- ----------------------------
INSERT INTO `question_wiki` VALUES ('335', '219');
INSERT INTO `question_wiki` VALUES ('352', '219');
INSERT INTO `question_wiki` VALUES ('357', '219');
INSERT INTO `question_wiki` VALUES ('336', '222');
INSERT INTO `question_wiki` VALUES ('346', '231');
INSERT INTO `question_wiki` VALUES ('349', '231');
INSERT INTO `question_wiki` VALUES ('356', '231');
INSERT INTO `question_wiki` VALUES ('347', '232');
INSERT INTO `question_wiki` VALUES ('348', '232');
INSERT INTO `question_wiki` VALUES ('356', '232');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `aid` bigint(20) NOT NULL,
  `bid` bigint(20) NOT NULL,
  PRIMARY KEY (`aid`,`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT 'unknow',
  `location` varchar(100) DEFAULT 'unknow',
  `user_name` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `photo_uri` varchar(255) DEFAULT NULL,
  `description` longtext,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'unknow', '南京', 'ch', '123456', 'http://www.gravatar.com/avatar/36b38e6c0a867d9e4f0a438cd015fd68.jpg?s=100&d=identicon', 'zhuangbi！', '2016-07-15 09:39:21', '2016-06-28');
INSERT INTO `user` VALUES ('2', 'unknown', '南京', 'ss14', '123456', 'http://n.sinaimg.cn/games/transform/20160303/Xu6U-fxqafhk7415746.jpg', '这位同学很懒，什么都没写', '2016-07-17 09:40:05', null);
INSERT INTO `user` VALUES ('3', 'unknow', '南京', 'sbin14', '123456', 'http://www.gravatar.com/avatar/2d1dc9299711e0d5fa5342d737af963a.jpg?s=100&d=identicon', '这是一个酷炫的内测账号???', '2016-07-15 09:41:18', '1997-01-17');
INSERT INTO `user` VALUES ('4', '569450503@qq.com', '南京', 'Dora', '123456', 'http://www.gravatar.com/avatar/9f02efb20bf07a9a910ae7a8099c758a.jpg?s=100&d=identicon', '就是这把了！最后一次', '2016-07-15 09:37:31', '1996-08-10');
INSERT INTO `user` VALUES ('5', '1048043763', '南京', 'zxf14', '123456', 'http://www.gravatar.com/avatar/9f02efb20bf07a9a010ae7a8099c758a.jpg?s=100&d=identicon', 'hahahaha', '2016-07-15 11:24:44', '1996-08-10');

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` enum('down','up') NOT NULL DEFAULT 'up',
  `author_id` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `last_updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `answer_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6nch3y92lphrbsh0o5c7o0jov` (`author_id`),
  KEY `vote_answer_idx` (`answer_id`),
  KEY `vote_question_idx` (`question_id`),
  CONSTRAINT `FK_6nch3y92lphrbsh0o5c7o0jov` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `vote_answer` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `vote_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('184', 'down', '2', '2016-07-22 17:38:41', '2016-07-22 17:38:41', null, '335');
INSERT INTO `vote` VALUES ('187', 'up', '2', '2016-07-22 17:54:44', '2016-07-22 17:54:44', null, '345');
INSERT INTO `vote` VALUES ('188', 'up', '2', '2016-07-22 18:02:44', '2016-07-22 18:02:44', '467', null);
INSERT INTO `vote` VALUES ('189', 'up', '1', '2016-07-22 18:04:10', '2016-07-22 18:04:10', '467', null);
INSERT INTO `vote` VALUES ('190', 'up', '1', '2016-07-22 18:05:48', '2016-07-22 18:05:48', null, '345');
INSERT INTO `vote` VALUES ('191', 'up', '3', '2016-07-22 23:52:35', '2016-07-22 23:52:35', null, '344');
INSERT INTO `vote` VALUES ('195', 'up', '3', '2016-07-23 01:11:26', '2016-07-23 01:11:26', null, '343');
INSERT INTO `vote` VALUES ('196', 'up', '3', '2016-07-23 10:11:14', '2016-07-23 10:11:14', null, '334');
INSERT INTO `vote` VALUES ('197', 'up', '3', '2016-07-23 10:11:28', '2016-07-23 10:11:28', null, '324');
INSERT INTO `vote` VALUES ('200', 'up', '3', '2016-07-25 16:35:43', '2016-07-25 16:35:43', null, '347');
INSERT INTO `vote` VALUES ('202', 'up', '3', '2016-07-25 16:35:49', '2016-07-25 16:35:49', '498', null);
INSERT INTO `vote` VALUES ('203', 'up', '3', '2016-07-25 22:25:18', '2016-07-25 22:25:18', null, '349');
INSERT INTO `vote` VALUES ('206', 'up', '3', '2016-07-29 09:59:38', '2016-07-29 09:59:38', null, '356');
INSERT INTO `vote` VALUES ('208', 'up', '4', '2016-07-29 10:03:50', '2016-07-29 10:03:50', '505', null);
INSERT INTO `vote` VALUES ('209', 'up', '4', '2016-07-29 10:04:53', '2016-07-29 10:04:53', null, '356');
DROP TRIGGER IF EXISTS `update_question_insert`;
DELIMITER ;;
CREATE TRIGGER `update_question_insert` AFTER INSERT ON `answer` FOR EACH ROW begin
        update question
        set answer_count = answer_count + 1
        where id = new.question_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_question_delete`;
DELIMITER ;;
CREATE TRIGGER `update_question_delete` AFTER DELETE ON `answer` FOR EACH ROW begin
        update question
        set answer_count = answer_count - 1
        where id = old.question_id;

        delete 
        from message
        where (mesg_type = "voteAnswer" or mesg_type = "answer" ) and source_id = old.id;

end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_message_when_delete_question`;
DELIMITER ;;
CREATE TRIGGER `update_message_when_delete_question` AFTER DELETE ON `question` FOR EACH ROW begin
        delete 
        from message 
        where  (mesg_type = "voteQuestion" or mesg_type = "invite") and source_id = old.id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_question_or_answer_insert`;
DELIMITER ;;
CREATE TRIGGER `update_question_or_answer_insert` AFTER INSERT ON `vote` FOR EACH ROW begin
     declare num int;
     if new.type = 'up'  then
     set num = 1;
     else
     set num = -1;
     end if;

      if new.question_id is not null then
          update question set vote_count = vote_count+num where id = new.question_id;
     else
          update answer set vote_count = vote_count+num where id = new.answer_id;
    end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_question_or_answer_delete`;
DELIMITER ;;
CREATE TRIGGER `update_question_or_answer_delete` AFTER DELETE ON `vote` FOR EACH ROW begin
     declare num int;
     if old.type = 'up'  then
     set num = 1;
     else
     set num = -1;
     end if;

      if old.question_id is not null then
          update question set vote_count = vote_count-num where id = old.question_id;
     else
          update answer set vote_count = vote_count-num where id = old.answer_id;
    end if;
end
;;
DELIMITER ;
