# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: efit
# ------------------------------------------------------
# Server version 5.1.62-community

DROP DATABASE IF EXISTS `efit`;
CREATE DATABASE `efit` /*!40100 DEFAULT CHARACTER SET gb2312 */;
USE `efit`;

#
# Source for table administrator
#

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Dumping data for table administrator
#
LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;

/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table clothes
#

DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `clothes_id` varchar(17) NOT NULL DEFAULT '',
  `name` varchar(11) DEFAULT NULL,
  `type` char(1) NOT NULL DEFAULT '',
  `sex` char(1) NOT NULL DEFAULT '',
  `size` char(1) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `keyword` text,
  `detail` text,
  `thumb_adress` text,
  `image_adress` text,
  `match_value` int(11) DEFAULT NULL,
  `sub_time` date DEFAULT NULL,
  PRIMARY KEY (`clothes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 ROW_FORMAT=COMPACT;

#
# Dumping data for table clothes
#
LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;

INSERT INTO `clothes` VALUES ('20130602193451640','T恤打底衫','T','M','l','阿迪达斯','三楼40号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','三叶草阿迪达斯爱情公寓关谷熊猫纯棉男士长袖T恤打底衫','cd99cd71-4131-44ed-9c63-ff92636d4d90.jpg','1d36e43e-a90f-4941-b156-d9495cbc5422.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602193551687','T恤打底衫','T','M','m','阿迪达斯','三楼40号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','三叶草阿迪达斯爱情公寓关谷熊猫纯棉男士长袖T恤打底衫','cd99cd71-4131-44ed-9c63-ff92636d4d90.jpg','cca91b43-c3cd-4e1d-a2ca-798b3a0c1cf9.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602193618781','T恤打底衫','T','M','s','阿迪达斯','三楼40号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','三叶草阿迪达斯爱情公寓关谷熊猫纯棉男士长袖T恤打底衫','cd99cd71-4131-44ed-9c63-ff92636d4d90.jpg','d2a0c13b-6999-4da5-ad09-cab751e6b0b7.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602193828500','长毛毛T恤','T','M','s','阿迪达斯','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男长袖T恤V领保暖长毛毛T恤男','5b8b3d4a-f93f-4203-9e6d-5a6d58502e41.jpg','d90dfc23-fa15-4381-ac27-ca36474ebb50.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602193858906','长毛毛T恤','T','M','m','阿迪达斯','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男长袖T恤V领保暖长毛毛T恤男','5b8b3d4a-f93f-4203-9e6d-5a6d58502e41.jpg','628253a0-cfd5-4d58-8f88-f54cd40cd91c.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602193919984','长毛毛T恤','T','M','l','阿迪达斯','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男长袖T恤V领保暖长毛毛T恤男','5b8b3d4a-f93f-4203-9e6d-5a6d58502e41.jpg','c000a7b8-1f02-47d6-8dce-e10edacbbb84.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194101109','嘻哈T恤','T','M','l','金属天堂','二楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','金属天堂夜光长袖T恤宽松嘻哈T恤男潮荧光骷髅头t恤男圆领长T','87e7ab45-13e6-4dfd-b9a3-a8188b0811f1.jpg','f7dde6c0-435b-48bc-b9ba-e79a41dffe43.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194441265','嘻哈T恤','T','M','m','金属天堂','二楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','金属天堂夜光长袖T恤宽松嘻哈T恤男潮荧光骷髅头t恤男圆领长T','87e7ab45-13e6-4dfd-b9a3-a8188b0811f1.jpg','b1da3f56-c644-4f33-a54b-869b5292e032.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194505468','嘻哈T恤','T','M','s','金属天堂','二楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','金属天堂夜光长袖T恤宽松嘻哈T恤男潮荧光骷髅头t恤男圆领长T','87e7ab45-13e6-4dfd-b9a3-a8188b0811f1.jpg','cd4d25de-9817-465c-b930-230036895aad.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194810890','长袖t恤','T','M','l','耐克','五楼28号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','中国风男款长袖t恤2013韩版纯棉圆领刺绣加大衣男士长袖t恤打底衫','4bfcf410-cb54-4954-8fa1-70adf75fa5f2.jpg','4bf72767-4a96-4622-9fb1-ee7ca825b243.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194838000','长袖t恤','T','M','s','耐克','五楼28号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','中国风男款长袖t恤2013韩版纯棉圆领刺绣加大衣男士长袖t恤打底衫','4bfcf410-cb54-4954-8fa1-70adf75fa5f2.jpg','ab0533c2-df86-47d2-a6ad-f3e87f069cd3.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602194905093','长袖t恤','T','M','m','耐克','五楼28号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','中国风男款长袖t恤2013韩版纯棉圆领刺绣加大衣男士长袖t恤打底衫','4bfcf410-cb54-4954-8fa1-70adf75fa5f2.jpg','15f04da6-5273-41b4-8727-fc46a7c2f56d.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195347343','小西装','T','M','s','耐克','十楼48号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装秋冬装新品休闲西服男韩版修身潮小西装男单西外套便西','816d5ea8-9e57-4d59-b49e-d76d669b99ff.jpg','2e30203c-1ded-4485-87d2-0547ec3988d5.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195407421','小西装','T','M','m','耐克','十楼48号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装秋冬装新品休闲西服男韩版修身潮小西装男单西外套便西','816d5ea8-9e57-4d59-b49e-d76d669b99ff.jpg','44bd8672-ef21-49ec-9e58-f063e93502c1.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195425437','小西装','T','M','l','耐克','十楼48号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装秋冬装新品休闲西服男韩版修身潮小西装男单西外套便西','816d5ea8-9e57-4d59-b49e-d76d669b99ff.jpg','54715a36-8b63-4dc3-a624-6d5f6d234491.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195729437','休闲西服','T','M','l','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装春装新款男士休闲西服男韩版修身潮流时尚小西装外套','183cf2e3-a4eb-4bdd-82cf-37aa488e84c2.jpg','8f2db87e-211f-46e0-83f1-bea004cb9813.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195804609','休闲西服','T','M','m','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装春装新款男士休闲西服男韩版修身潮流时尚小西装外套','183cf2e3-a4eb-4bdd-82cf-37aa488e84c2.jpg','07746c44-eb37-4ad8-8b4a-5d3571e2196e.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602195833718','休闲西服','T','M','s','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','男装春装新款男士休闲西服男韩版修身潮流时尚小西装外套','183cf2e3-a4eb-4bdd-82cf-37aa488e84c2.jpg','e49b4e35-0c1e-446b-9542-6077812d5afa.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200111546','休闲裤','D','M','l','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','外贸秋冬户外男裤休闲裤宽松加厚加绒裤大码工装裤男长裤运动裤子','70ea010e-c34e-4990-a7d3-499989b699fe.jpg','ed542dca-0c24-484f-a5c9-cdafc796c947.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200234640','休闲裤','D','M','s','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','外贸秋冬户外男裤休闲裤宽松加厚加绒裤大码工装裤男长裤运动裤子','70ea010e-c34e-4990-a7d3-499989b699fe.jpg','72a9a2b4-b168-4cff-9035-400bd2005c91.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200353406','休闲裤','D','M','m','啄木鸟','八楼50号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','外贸秋冬户外男裤休闲裤宽松加厚加绒裤大码工装裤男长裤运动裤子','70ea010e-c34e-4990-a7d3-499989b699fe.jpg','33613de8-77b6-49e8-a772-5bb95da734c8.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200559265','修身平绒裤','D','M','l','阿迪达斯','七楼64号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版休闲裤 男 长裤 微弹力修身平绒裤 松紧腰休闲男裤','dc251671-cae5-4850-acf6-4c93454c7adc.jpg','e196de73-1e5a-40d5-90b2-cc5b167d6a70.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200652718','修身平绒裤','D','M','m','阿迪达斯','七楼64号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版休闲裤 男 长裤 微弹力修身平绒裤 松紧腰休闲男裤','dc251671-cae5-4850-acf6-4c93454c7adc.jpg','57d13987-9270-40cf-8ea3-40ff0577309f.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200717046','修身平绒裤','D','M','s','阿迪达斯','七楼64号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版休闲裤 男 长裤 微弹力修身平绒裤 松紧腰休闲男裤','dc251671-cae5-4850-acf6-4c93454c7adc.jpg','6131895b-4f82-4383-a4ac-2dfb47274a4c.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200835687','休闲松紧腰裤','D','M','l','阿迪达斯','五楼49号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版平绒裤 休闲松紧腰裤','972003d1-f96e-4b90-b0fe-52456091a127.jpg','f629f71b-306b-4e86-857a-e44091d1d5b1.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200854078','休闲松紧腰裤','D','M','m','阿迪达斯','五楼49号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版平绒裤 休闲松紧腰裤','972003d1-f96e-4b90-b0fe-52456091a127.jpg','0f28b968-76b2-4e7e-9a54-f4aaccce4939.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602200914546','休闲松紧腰裤','D','M','s','阿迪达斯','五楼49号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春秋韩版平绒裤 休闲松紧腰裤','972003d1-f96e-4b90-b0fe-52456091a127.jpg','ba5a7f72-668d-4e0a-a3c2-bbd20fd0ed1f.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201124734','修身裤','D','M','l','耐克','三楼60号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤外贸秋冬户外男裤休闲裤宽松加厚加绒裤','bd793db4-2823-4a5f-be75-f89b168569e6.jpg','bfd502c4-f571-4d61-90cf-a01728b471cb.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201153500','修身裤','D','M','m','耐克','三楼60号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤外贸秋冬户外男裤休闲裤宽松加厚加绒裤','bd793db4-2823-4a5f-be75-f89b168569e6.jpg','d5612ddc-4963-4a83-93e1-d360fedfdb5f.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201223609','修身裤','D','M','s','耐克','三楼60号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤外贸秋冬户外男裤休闲裤宽松加厚加绒裤','bd793db4-2823-4a5f-be75-f89b168569e6.jpg','25af1378-5262-438f-877e-8a98545e8760.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201421343','纯棉潮长裤','D','M','l','耐克','四楼43号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤纯棉潮长裤小脚裤男裤子','0a348f8e-bb53-45b3-bfa2-3ad017db2277.jpg','99e664f3-31f0-4f01-b9a2-107e61f0e83d.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201524562','纯棉潮长裤','D','M','m','耐克','四楼43号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤纯棉潮长裤小脚裤男裤子','0a348f8e-bb53-45b3-bfa2-3ad017db2277.jpg','eac844a1-acee-4539-9761-3cc4b04cd912.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130602201546281','纯棉潮长裤','D','M','s','耐克','四楼43号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','春夏装新款韩版男装修身裤男士休闲裤纯棉潮长裤小脚裤男裤子','0a348f8e-bb53-45b3-bfa2-3ad017db2277.jpg','eac844a1-acee-4539-9761-3cc4b04cd912.png',50,'2013-06-02');
INSERT INTO `clothes` VALUES ('20130603174150109','打底衫','T','W','s','声雨竹','四楼8号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012年女装新品 条纹 蕾丝 花边 T恤 打底衫 森女系 爆款宽松大码','593a1f92-f067-43d7-925a-e3f5c32abc5d.jpg','a731424e-ff52-4417-beb9-c2548d65e535.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603174241687','打底衫','T','W','m','声雨竹','四楼8号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012年女装新品 条纹 蕾丝 花边 T恤 打底衫 森女系 爆款宽松大码','593a1f92-f067-43d7-925a-e3f5c32abc5d.jpg','15abf9f8-d22e-45df-acbf-9bd63660e1cc.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603174355031','打底衫','T','W','l','声雨竹','四楼8号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012年女装新品 条纹 蕾丝 花边 T恤 打底衫 森女系 爆款宽松大码','593a1f92-f067-43d7-925a-e3f5c32abc5d.jpg','2b4299c9-271b-4776-b220-0a8844246994.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603174629890','百搭毛衣外套','T','W','s','声雨竹','七楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','依恋专柜秋装新品韩版蝙蝠袖宽松针织百搭毛衣外套','0e273c62-e26c-415e-8f60-9402a0f5db5a.jpg','68dadda2-03e6-4958-ac65-dcced95fdc03.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603174656968','百搭毛衣外套','T','W','m','声雨竹','七楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','依恋专柜秋装新品韩版蝙蝠袖宽松针织百搭毛衣外套','0e273c62-e26c-415e-8f60-9402a0f5db5a.jpg','d1d60ee4-7483-4fe3-afac-8f4554d4ee78.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603175236093','百搭毛衣外套','T','W','l','声雨竹','七楼18号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','依恋专柜秋装新品韩版蝙蝠袖宽松针织百搭毛衣外套','0e273c62-e26c-415e-8f60-9402a0f5db5a.jpg','d632072f-e4ff-4e71-ba0b-29e2bcebd768.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603175515093','全棉淑女衬衫','T','W','s','红人','三楼26号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新款小熊维尼专柜韩版百搭英伦学院风修身休闲打底 全棉淑女衬衫','fe143a56-fedd-4883-ad78-d93dfc1323f5.jpg','a1c65753-1702-4b06-b9f5-3ebbfcf98a56.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603175540515','全棉淑女衬衫','T','W','m','红人','三楼26号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新款小熊维尼专柜韩版百搭英伦学院风修身休闲打底 全棉淑女衬衫','fe143a56-fedd-4883-ad78-d93dfc1323f5.jpg','eb6f6173-fa54-4c06-88d5-c7f22f188a46.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603175715937','全棉淑女衬衫','T','W','l','红人','三楼26号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新款小熊维尼专柜韩版百搭英伦学院风修身休闲打底 全棉淑女衬衫','fe143a56-fedd-4883-ad78-d93dfc1323f5.jpg','e16aa679-4ecf-43a7-8b62-08abcb93b247.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603180000953','羊毛针织衫','T','W','s','红人','六楼32号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身打底羊毛针织衫','0697e2cc-eab6-4eff-affb-72973b2815cb.jpg','fe98143c-7e28-4a2e-b07a-aa38a2b76f6d.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603180223671','羊毛针织衫','T','W','m','红人','六楼32号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身打底羊毛针织衫','0697e2cc-eab6-4eff-affb-72973b2815cb.jpg','a2973e99-76b4-4bd8-820a-99d85afc2677.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603180602296','羊毛针织衫','T','W','l','红人','二楼12号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身打底羊毛针织衫','becea94a-f7dd-4669-9894-ed73b1ec85e2.jpg','ec4c2147-c527-4c4d-bd24-34fc69326c7e.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603181017250','淑女衬衫','T','W','s','沐兰','三楼12号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身休闲打底 全棉淑女衬衫','b3fb5e92-8e04-437c-99c8-3e2198899f60.jpg','31828b69-4a11-45ba-8afa-7a2914ee3476.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603181040375','淑女衬衫','T','W','m','沐兰','三楼12号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身休闲打底 全棉淑女衬衫','b3fb5e92-8e04-437c-99c8-3e2198899f60.jpg','549d4a8f-efdd-446d-a385-011bc3dbd9ec.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603181100187','淑女衬衫','T','W','l','沐兰','三楼12号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','新品爆款百搭英伦风修身休闲打底 全棉淑女衬衫','b3fb5e92-8e04-437c-99c8-3e2198899f60.jpg','6493f624-93a5-428b-b103-a26743ffc9b0.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182214531','修身羊毛衣','T','W','s','沐兰','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜正品冬新款打底衫厚高领长袖修身羊毛衣','7ea2c366-668a-410c-b75c-5afe5e138328.jpg','fe801595-f44e-4a6d-95da-53a1f9922590.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182231875','修身羊毛衣','T','W','m','沐兰','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜正品冬新款打底衫厚高领长袖修身羊毛衣','7ea2c366-668a-410c-b75c-5afe5e138328.jpg','07307e44-315f-4b31-af30-687979700333.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182251343','修身羊毛衣','T','W','l','沐兰','四楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜正品冬新款打底衫厚高领长袖修身羊毛衣','7ea2c366-668a-410c-b75c-5afe5e138328.jpg','ffa43ccd-acab-459f-8565-ad4c8d4be568.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182542968','小脚牛仔裤','D','W','s','沐兰','三楼25号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜秋冬新品韩版女式高档修腿型个性腰带小脚牛仔裤','f6274fc0-be8d-4619-9ceb-41d2c814cb07.jpg','2d0b9ca1-7ad7-4f4f-abe9-196294698533.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182618046','小脚牛仔裤','D','W','m','沐兰','三楼25号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜秋冬新品韩版女式高档修腿型个性腰带小脚牛仔裤','f6274fc0-be8d-4619-9ceb-41d2c814cb07.jpg','4be3bc14-f4bd-4455-b110-f42f7cf4ab9b.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603182845828','小脚牛仔裤','D','W','l','沐兰','三楼25号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜秋冬新品韩版女式高档修腿型个性腰带小脚牛仔裤','64e12711-4cac-4836-a707-658e2ff41188.jpg','610985b1-3e40-48aa-a820-8d4326579679.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183019906','直筒毛呢靴裤','D','W','s','沐兰','二楼20号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012秋冬拼皮短裤韩版女装新款直筒毛呢靴裤L-18','cb3cf666-2676-47db-9184-02a3791e1b04.jpg','cfa2154a-cffc-4d43-abb4-795208c1a235.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183101156','直筒毛呢靴裤','D','W','m','沐兰','二楼20号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012秋冬拼皮短裤韩版女装新款直筒毛呢靴裤L-18','cb3cf666-2676-47db-9184-02a3791e1b04.jpg','c4cbec3a-942b-45df-8f02-45d57e4c7ea7.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183356906','直筒毛呢靴裤','D','W','l','沐兰','二楼20号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','2012秋冬拼皮短裤韩版女装新款直筒毛呢靴裤L-18','cb3cf666-2676-47db-9184-02a3791e1b04.jpg','37844d82-5c0d-4935-b6ad-e3347ff7124e.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183844531','休闲系腰带长裤','D','W','s','红人','四楼35号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜春款新品英伦风韩版休闲系腰带长裤','9f7c8ca9-65a3-4c72-b6a9-cd58160746fb.jpg','6de4775f-3cda-4fa4-89e5-1512eb62a16a.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183922468','休闲系腰带长裤','D','W','m','红人','四楼35号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜春款新品英伦风韩版休闲系腰带长裤','9f7c8ca9-65a3-4c72-b6a9-cd58160746fb.jpg','eed05b3c-2012-4af5-a79d-977a3bac26a6.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603183947578','休闲系腰带长裤','D','W','l','红人','四楼35号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','小熊维尼专柜春款新品英伦风韩版休闲系腰带长裤','9f7c8ca9-65a3-4c72-b6a9-cd58160746fb.jpg','1fceef49-2b69-4717-85d1-2022548d88f4.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184206984','短裙','D','W','s','红人','五楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','黑色短裙','b53ad067-2c72-4b05-98b6-947f199e6102.jpg','98f41b12-33a4-4fb6-a516-1a1c4ddbb7f6.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184259531','短裙','D','W','m','红人','五楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','黑色短裙','b53ad067-2c72-4b05-98b6-947f199e6102.jpg','4f48d90e-4e29-4af8-a0d9-5c3d33c7852a.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184412546','短裙','D','W','l','红人','五楼15号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','黑色短裙','b53ad067-2c72-4b05-98b6-947f199e6102.jpg','689a5b49-486d-475f-bf4f-7982093b3756.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184801890','加厚裙裤','D','W','s','声雨竹','三楼31号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','加厚裙裤打底裤K-22','7aee3a12-0de7-4022-a852-5b5d7aea3b93.jpg','018f6771-704f-4cb5-99dd-39cbb3fa24cc.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184829875','加厚裙裤','D','W','m','声雨竹','三楼31号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','加厚裙裤打底裤K-22','7aee3a12-0de7-4022-a852-5b5d7aea3b93.jpg','445184e3-eed7-49d4-9b81-93da6e937c69.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184844953','加厚裙裤','D','W','l','声雨竹','三楼31号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','加厚裙裤打底裤K-22','7aee3a12-0de7-4022-a852-5b5d7aea3b93.jpg','659c5c82-6a15-407e-83b4-8b640091e256.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603184949468','短裙','D','W','s','声雨竹','三楼24号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','花纹短裙','1118c83d-27a4-48a5-9292-1f1b2a09999f.jpg','eaa2fbbd-a99e-4763-9fd9-87c6af41fc99.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603185009156','短裙','D','W','m','声雨竹','三楼24号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','花纹短裙','1118c83d-27a4-48a5-9292-1f1b2a09999f.jpg','2f33cb68-9662-4db8-bc88-9f77b39efd62.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603185037796','短裙','D','W','l','声雨竹','三楼24号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁','花纹短裙','1118c83d-27a4-48a5-9292-1f1b2a09999f.jpg','76297b97-2077-4cd8-a86d-e63adb15764d.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603185305343','网纱短裙','D','W','s','沐兰','二楼30号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁',' 韩版秋冬新款女装加绒网纱短裙','e95e7d9f-7b2d-448e-a2eb-9537dee78cf2.jpg','f04a804c-fc11-460b-a13d-2e0855889b08.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603185328203','网纱短裙','D','W','m','沐兰','二楼30号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁',' 韩版秋冬新款女装加绒网纱短裙','e95e7d9f-7b2d-448e-a2eb-9537dee78cf2.jpg','d53df2de-1e9f-4229-b2ef-b8d6c43c78fe.png',50,'2013-06-03');
INSERT INTO `clothes` VALUES ('20130603185345312','网纱短裙','D','W','l','沐兰','二楼30号柜台','帅气，时尚，尊贵，大方，潇洒，成熟，可爱，有魅力，有气质，整洁',' 韩版秋冬新款女装加绒网纱短裙','e95e7d9f-7b2d-448e-a2eb-9537dee78cf2.jpg','31264843-4f33-421d-ae80-688583344db3.png',50,'2013-06-03');
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table comment
#

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `share_id` varchar(17) NOT NULL DEFAULT '',
  `username` varchar(11) DEFAULT NULL,
  `content` text,
  `score` int(11) DEFAULT NULL,
  `sub_time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=gb2312;

#
# Dumping data for table comment
#
LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;

INSERT INTO `comment` VALUES (32,'20130602212153156','匿名','撒旦撒',1,'2013-06-03 20:26:16');
INSERT INTO `comment` VALUES (33,'20130602212153156','匿名','撒旦撒啊 ',1,'2013-06-03 20:26:37');
INSERT INTO `comment` VALUES (34,'20130602212153156','匿名','大幅杀跌',1,'2013-06-03 20:27:15');
INSERT INTO `comment` VALUES (35,'20130602212153156','匿名','地方',1,'2013-06-03 20:30:36');
INSERT INTO `comment` VALUES (36,'20130602212153156','匿名','20130602212153156',1,'2013-06-03 20:39:10');
INSERT INTO `comment` VALUES (37,'20130603174150109','匿名','撒旦 ',1,'2013-06-03 20:46:36');
INSERT INTO `comment` VALUES (38,'20130602212153156','匿名','sd',5,'2013-06-03 22:15:00');
INSERT INTO `comment` VALUES (39,'20130603182542968','匿名','werw',1,'2013-06-03 22:15:17');
INSERT INTO `comment` VALUES (40,'20130603230855625','555555','sadasd',5,'2013-06-03 23:09:09');
INSERT INTO `comment` VALUES (41,'20130603180223671','zyg123','衣服料子还可以，穿着也挺舒服的，还合身。。。。',5,'2013-06-05 18:01:34');
INSERT INTO `comment` VALUES (42,'20130605175527453','zyg123','好，不错。',4,'2013-06-05 18:03:16');
INSERT INTO `comment` VALUES (43,'20130605175527453','匿名','好',5,'2013-06-05 18:18:28');
INSERT INTO `comment` VALUES (46,'20130605175527453','test123','good',4,'2013-06-05 19:27:45');
INSERT INTO `comment` VALUES (47,'20130602195407421','test123','good',5,'2013-06-05 19:29:29');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table search
#

DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `search_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(11) DEFAULT NULL,
  `keyword` varchar(10) DEFAULT NULL,
  `sub_time` datetime DEFAULT NULL,
  PRIMARY KEY (`search_id`)
) ENGINE=InnoDB AUTO_INCREMENT=409 DEFAULT CHARSET=gb2312;

#
# Dumping data for table search
#
LOCK TABLES `search` WRITE;
/*!40000 ALTER TABLE `search` DISABLE KEYS */;

INSERT INTO `search` VALUES (5,'匿名','帅气','2013-02-12 21:34:57');
INSERT INTO `search` VALUES (7,'who247','帅气','2013-02-13 20:57:55');
INSERT INTO `search` VALUES (8,'匿名','甜美','2013-02-15 16:31:06');
INSERT INTO `search` VALUES (9,'匿名','淑女','2013-02-15 16:31:27');
INSERT INTO `search` VALUES (10,'匿名','可爱','2013-02-15 16:31:47');
INSERT INTO `search` VALUES (11,'匿名','帅气','2013-02-15 16:33:13');
INSERT INTO `search` VALUES (12,'匿名','帅气','2013-02-15 16:33:36');
INSERT INTO `search` VALUES (13,'cathy1217','帅气','2013-02-15 19:09:02');
INSERT INTO `search` VALUES (14,'123456','衣','2013-02-15 19:44:59');
INSERT INTO `search` VALUES (15,'who247','帅气','2013-02-15 20:54:34');
INSERT INTO `search` VALUES (16,'who247','帅气','2013-02-15 20:55:35');
INSERT INTO `search` VALUES (17,'who247','帅气','2013-02-15 20:56:37');
INSERT INTO `search` VALUES (18,'匿名','时尚','2013-02-15 21:43:24');
INSERT INTO `search` VALUES (19,'who247','时尚','2013-02-15 21:43:51');
INSERT INTO `search` VALUES (20,'匿名','冬装','2013-02-16 14:00:13');
INSERT INTO `search` VALUES (21,'匿名','冬装','2013-02-16 14:00:33');
INSERT INTO `search` VALUES (22,'匿名','西装','2013-02-16 14:02:39');
INSERT INTO `search` VALUES (23,'匿名','帅气','2013-02-16 14:09:12');
INSERT INTO `search` VALUES (24,'匿名','晚会','2013-02-16 19:22:10');
INSERT INTO `search` VALUES (25,'匿名','胃饭','2013-02-16 20:50:52');
INSERT INTO `search` VALUES (26,'匿名','帅气','2013-02-18 15:28:03');
INSERT INTO `search` VALUES (27,'匿名','帅气','2013-02-18 19:44:58');
INSERT INTO `search` VALUES (28,'123456','时尚','2013-02-18 19:54:36');
INSERT INTO `search` VALUES (29,'匿名','帅气','2013-02-18 20:03:21');
INSERT INTO `search` VALUES (30,'匿名','时尚','2013-02-18 20:37:00');
INSERT INTO `search` VALUES (31,'376515867','帅气','2013-02-18 21:09:40');
INSERT INTO `search` VALUES (32,'376515867','帅气','2013-02-18 21:16:15');
INSERT INTO `search` VALUES (33,'匿名','晚会','2013-02-19 21:37:42');
INSERT INTO `search` VALUES (34,'匿名','帅气','2013-03-03 00:04:21');
INSERT INTO `search` VALUES (35,'匿名','帅气','2013-03-03 00:04:59');
INSERT INTO `search` VALUES (36,'匿名','帅气','2013-03-03 00:08:42');
INSERT INTO `search` VALUES (37,'匿名','帅气','2013-03-03 00:09:24');
INSERT INTO `search` VALUES (38,'匿名','帅气','2013-03-03 00:09:44');
INSERT INTO `search` VALUES (39,'匿名','帅气','2013-03-03 00:11:01');
INSERT INTO `search` VALUES (40,'匿名','帅气','2013-03-03 00:12:39');
INSERT INTO `search` VALUES (41,'匿名','帅气','2013-03-04 17:29:23');
INSERT INTO `search` VALUES (42,'匿名','帅气','2013-03-04 17:29:32');
INSERT INTO `search` VALUES (43,'who247','帅气','2013-03-04 17:55:17');
INSERT INTO `search` VALUES (44,'匿名','帅气','2013-03-04 17:57:59');
INSERT INTO `search` VALUES (45,'匿名','帅气','2013-03-04 17:58:11');
INSERT INTO `search` VALUES (46,'匿名','帅气','2013-03-04 18:01:37');
INSERT INTO `search` VALUES (47,'who247','帅气','2013-03-04 18:49:57');
INSERT INTO `search` VALUES (48,'who247','帅气','2013-03-04 18:50:09');
INSERT INTO `search` VALUES (49,'who247','帅气','2013-03-04 18:50:21');
INSERT INTO `search` VALUES (50,'匿名','帅气','2013-03-04 18:51:56');
INSERT INTO `search` VALUES (51,'who247','帅气','2013-03-05 18:46:08');
INSERT INTO `search` VALUES (52,'who247','帅气','2013-03-05 18:46:18');
INSERT INTO `search` VALUES (53,'who247','帅气','2013-03-05 18:46:34');
INSERT INTO `search` VALUES (54,'who247','帅气','2013-03-05 19:08:29');
INSERT INTO `search` VALUES (55,'匿名','帅气','2013-03-05 19:10:16');
INSERT INTO `search` VALUES (56,'who247','帅气','2013-03-05 19:10:40');
INSERT INTO `search` VALUES (57,'匿名','帅气','2013-03-05 19:12:37');
INSERT INTO `search` VALUES (58,'匿名','帅气','2013-03-05 19:15:20');
INSERT INTO `search` VALUES (59,'who247','帅气','2013-03-05 19:29:17');
INSERT INTO `search` VALUES (60,'who247','帅气','2013-03-05 19:32:07');
INSERT INTO `search` VALUES (61,'who247','帅气','2013-03-05 19:33:34');
INSERT INTO `search` VALUES (62,'who247','帅气','2013-03-05 19:34:59');
INSERT INTO `search` VALUES (63,'who247','帅气','2013-03-05 19:36:12');
INSERT INTO `search` VALUES (64,'who247','帅气','2013-03-05 19:38:41');
INSERT INTO `search` VALUES (65,'who247','帅气','2013-03-05 19:39:52');
INSERT INTO `search` VALUES (66,'who247','帅气','2013-03-05 19:40:41');
INSERT INTO `search` VALUES (67,'who247','帅气','2013-03-05 19:41:06');
INSERT INTO `search` VALUES (68,'匿名','帅气','2013-03-05 19:49:16');
INSERT INTO `search` VALUES (69,'who247','帅气','2013-03-05 19:49:42');
INSERT INTO `search` VALUES (70,'who247','帅气','2013-03-05 19:56:31');
INSERT INTO `search` VALUES (71,'who247','帅气','2013-03-05 19:58:26');
INSERT INTO `search` VALUES (72,'匿名','帅气','2013-03-05 20:15:31');
INSERT INTO `search` VALUES (73,'匿名','帅气','2013-03-05 20:16:11');
INSERT INTO `search` VALUES (74,'test123','晚会','2013-03-06 15:47:57');
INSERT INTO `search` VALUES (75,'test123','时尚','2013-03-06 16:26:08');
INSERT INTO `search` VALUES (76,'test123','时尚','2013-03-06 16:31:25');
INSERT INTO `search` VALUES (77,'test123','时尚','2013-03-06 16:34:21');
INSERT INTO `search` VALUES (78,'test124','帅气','2013-03-06 16:46:55');
INSERT INTO `search` VALUES (79,'test124','帅气','2013-03-06 16:49:48');
INSERT INTO `search` VALUES (80,'archenemy','帅气','2013-03-06 17:29:03');
INSERT INTO `search` VALUES (81,'archenemy','帅气','2013-03-06 17:33:08');
INSERT INTO `search` VALUES (82,'zzy123','帅气','2013-03-06 18:05:13');
INSERT INTO `search` VALUES (83,'匿名','帅气','2013-03-06 18:07:36');
INSERT INTO `search` VALUES (84,'匿名','帅气','2013-03-06 18:08:01');
INSERT INTO `search` VALUES (85,'匿名','帅气','2013-03-06 18:08:21');
INSERT INTO `search` VALUES (86,'匿名','帅气','2013-03-06 18:08:48');
INSERT INTO `search` VALUES (87,'匿名','帅气','2013-03-06 18:09:49');
INSERT INTO `search` VALUES (88,'匿名','帅气','2013-03-06 18:09:54');
INSERT INTO `search` VALUES (89,'匿名','帅气','2013-03-06 18:09:56');
INSERT INTO `search` VALUES (90,'匿名','帅气','2013-03-06 18:09:59');
INSERT INTO `search` VALUES (91,'匿名','帅气','2013-03-06 18:10:01');
INSERT INTO `search` VALUES (92,'匿名','帅气','2013-03-06 18:10:09');
INSERT INTO `search` VALUES (93,'匿名','帅气','2013-03-06 18:10:10');
INSERT INTO `search` VALUES (94,'匿名','帅气','2013-03-06 18:10:12');
INSERT INTO `search` VALUES (95,'匿名','帅气','2013-03-06 18:11:33');
INSERT INTO `search` VALUES (96,'匿名','帅气','2013-03-06 18:12:03');
INSERT INTO `search` VALUES (97,'匿名','帅气','2013-03-06 18:12:08');
INSERT INTO `search` VALUES (98,'匿名','帅气','2013-03-06 18:12:37');
INSERT INTO `search` VALUES (99,'匿名','帅气','2013-03-06 18:12:48');
INSERT INTO `search` VALUES (100,'匿名','帅气','2013-03-06 18:12:53');
INSERT INTO `search` VALUES (101,'匿名','帅气','2013-03-06 18:13:26');
INSERT INTO `search` VALUES (102,'匿名','帅气','2013-03-06 18:13:32');
INSERT INTO `search` VALUES (103,'匿名','帅气','2013-03-06 18:13:41');
INSERT INTO `search` VALUES (104,'匿名','帅气','2013-03-06 18:13:47');
INSERT INTO `search` VALUES (105,'匿名','帅气','2013-03-06 18:13:52');
INSERT INTO `search` VALUES (106,'匿名','帅气','2013-03-06 18:18:16');
INSERT INTO `search` VALUES (107,'archenemy','帅气','2013-03-06 18:20:31');
INSERT INTO `search` VALUES (108,'archenemy','时尚','2013-03-06 18:21:28');
INSERT INTO `search` VALUES (109,'archenemy','帅气','2013-03-06 18:39:45');
INSERT INTO `search` VALUES (110,'匿名','帅气','2013-03-06 18:53:16');
INSERT INTO `search` VALUES (111,'匿名','帅气','2013-03-06 18:53:25');
INSERT INTO `search` VALUES (112,'who248','帅气','2013-03-06 18:56:02');
INSERT INTO `search` VALUES (113,'匿名','帅气','2013-03-06 18:57:33');
INSERT INTO `search` VALUES (114,'匿名','帅气','2013-03-06 18:57:39');
INSERT INTO `search` VALUES (115,'匿名','帅气','2013-03-06 18:57:46');
INSERT INTO `search` VALUES (116,'匿名','帅气','2013-03-06 18:57:49');
INSERT INTO `search` VALUES (117,'匿名','帅气','2013-03-06 19:11:47');
INSERT INTO `search` VALUES (118,'匿名','帅气','2013-03-06 19:12:23');
INSERT INTO `search` VALUES (119,'匿名','帅气','2013-03-06 19:12:30');
INSERT INTO `search` VALUES (120,'匿名','帅气','2013-03-06 19:12:38');
INSERT INTO `search` VALUES (121,'匿名','帅气','2013-03-06 19:12:46');
INSERT INTO `search` VALUES (122,'匿名','帅气','2013-03-06 19:12:52');
INSERT INTO `search` VALUES (123,'匿名','帅气','2013-03-06 19:16:49');
INSERT INTO `search` VALUES (124,'匿名','帅气','2013-03-06 19:16:53');
INSERT INTO `search` VALUES (125,'匿名','帅气','2013-03-06 19:16:57');
INSERT INTO `search` VALUES (126,'匿名','帅气','2013-03-06 19:17:11');
INSERT INTO `search` VALUES (127,'匿名','帅气','2013-03-06 19:17:39');
INSERT INTO `search` VALUES (128,'匿名','帅气','2013-03-06 19:17:53');
INSERT INTO `search` VALUES (129,'匿名','帅气','2013-03-06 19:18:12');
INSERT INTO `search` VALUES (130,'匿名','帅气','2013-03-06 19:18:33');
INSERT INTO `search` VALUES (131,'who249','帅气','2013-03-06 19:23:36');
INSERT INTO `search` VALUES (132,'who249','帅气','2013-03-06 19:26:08');
INSERT INTO `search` VALUES (133,'efit1234','帅气','2013-03-06 19:32:21');
INSERT INTO `search` VALUES (134,'efit12345','帅气','2013-03-06 19:36:26');
INSERT INTO `search` VALUES (135,'efit12345','帅气','2013-03-06 19:36:36');
INSERT INTO `search` VALUES (136,'efit12345','帅气','2013-03-06 19:36:49');
INSERT INTO `search` VALUES (137,'efit12345','帅气','2013-03-06 19:38:08');
INSERT INTO `search` VALUES (138,'efit12345','帅气','2013-03-06 19:38:34');
INSERT INTO `search` VALUES (139,'efit12345','帅气','2013-03-06 19:38:52');
INSERT INTO `search` VALUES (140,'efit12345','帅气','2013-03-06 19:39:13');
INSERT INTO `search` VALUES (141,'efit12345','帅气','2013-03-06 19:42:30');
INSERT INTO `search` VALUES (142,'efit123456','帅气','2013-03-06 19:45:16');
INSERT INTO `search` VALUES (143,'efit123456','帅气','2013-03-06 19:45:29');
INSERT INTO `search` VALUES (144,'efit123456','帅气','2013-03-06 19:45:36');
INSERT INTO `search` VALUES (145,'匿名','帅气','2013-03-06 20:01:30');
INSERT INTO `search` VALUES (146,'efit1234567','帅气','2013-03-06 20:37:25');
INSERT INTO `search` VALUES (147,'efit123456','帅气','2013-03-06 21:17:22');
INSERT INTO `search` VALUES (148,'匿名','帅气','2013-03-07 00:16:16');
INSERT INTO `search` VALUES (149,'匿名','帅气','2013-03-07 00:16:25');
INSERT INTO `search` VALUES (150,'efit123456','帅气','2013-03-07 09:47:28');
INSERT INTO `search` VALUES (151,'efit123456','帅气','2013-03-07 09:47:40');
INSERT INTO `search` VALUES (152,'efit123456','帅气','2013-03-07 09:48:32');
INSERT INTO `search` VALUES (153,'efit123456','帅气','2013-03-07 09:48:35');
INSERT INTO `search` VALUES (154,'efit123456','帅气','2013-03-07 09:48:53');
INSERT INTO `search` VALUES (155,'efit123456','帅气','2013-03-07 09:56:59');
INSERT INTO `search` VALUES (156,'efit123456','帅气','2013-03-07 09:57:10');
INSERT INTO `search` VALUES (157,'efit123456','帅气','2013-03-07 09:57:13');
INSERT INTO `search` VALUES (158,'匿名','帅气','2013-03-07 10:02:27');
INSERT INTO `search` VALUES (159,'efit123456','帅气','2013-03-07 10:11:05');
INSERT INTO `search` VALUES (160,'efit123456','帅气','2013-03-07 10:36:56');
INSERT INTO `search` VALUES (161,'efit123456','帅气','2013-03-07 10:37:19');
INSERT INTO `search` VALUES (162,'efit123456','帅气','2013-03-07 10:37:23');
INSERT INTO `search` VALUES (163,'efit123456','帅气','2013-03-07 10:37:31');
INSERT INTO `search` VALUES (164,'efit123456','帅气','2013-03-07 10:37:33');
INSERT INTO `search` VALUES (165,'efit123456','时尚','2013-03-07 10:39:09');
INSERT INTO `search` VALUES (166,'efit123456','帅气','2013-03-07 10:39:27');
INSERT INTO `search` VALUES (167,'efit123456','帅气','2013-03-07 10:40:41');
INSERT INTO `search` VALUES (168,'efit123456','帅气','2013-03-07 10:57:35');
INSERT INTO `search` VALUES (169,'efit123456','帅气','2013-03-07 10:58:57');
INSERT INTO `search` VALUES (170,'efit123456','帅气','2013-03-07 10:59:01');
INSERT INTO `search` VALUES (171,'efit123456','帅气','2013-03-07 10:59:04');
INSERT INTO `search` VALUES (172,'efit123456','帅气','2013-03-07 10:59:06');
INSERT INTO `search` VALUES (173,'efit123456','帅气','2013-03-07 11:00:54');
INSERT INTO `search` VALUES (174,'efit123456','帅气','2013-03-07 11:00:59');
INSERT INTO `search` VALUES (175,'efit123456','帅气','2013-03-07 11:01:56');
INSERT INTO `search` VALUES (176,'efit123456','帅气','2013-03-07 11:01:58');
INSERT INTO `search` VALUES (177,'efit123456','帅气','2013-03-07 11:03:06');
INSERT INTO `search` VALUES (178,'efit123456','帅气','2013-03-07 11:03:11');
INSERT INTO `search` VALUES (179,'efit123456','帅气','2013-03-07 11:03:12');
INSERT INTO `search` VALUES (180,'efit123456','帅气','2013-03-07 12:48:09');
INSERT INTO `search` VALUES (181,'efit123456','帅气','2013-03-07 12:48:18');
INSERT INTO `search` VALUES (182,'efit123456','帅气','2013-03-07 12:48:22');
INSERT INTO `search` VALUES (183,'efit123456','帅气','2013-03-07 13:36:40');
INSERT INTO `search` VALUES (184,'efit123456','帅气','2013-03-07 13:36:45');
INSERT INTO `search` VALUES (185,'efit123456','帅气','2013-03-07 13:36:48');
INSERT INTO `search` VALUES (186,'efit123456','帅气','2013-03-07 13:46:02');
INSERT INTO `search` VALUES (187,'efit123456','帅气','2013-03-07 13:46:09');
INSERT INTO `search` VALUES (188,'efit123456','帅气','2013-03-07 13:46:13');
INSERT INTO `search` VALUES (189,'efit123456','帅气','2013-03-07 13:51:02');
INSERT INTO `search` VALUES (190,'efit123456','帅气','2013-03-07 13:51:09');
INSERT INTO `search` VALUES (191,'efit123456','帅气','2013-03-07 13:51:11');
INSERT INTO `search` VALUES (192,'efit123456','帅气','2013-03-07 13:53:34');
INSERT INTO `search` VALUES (193,'efit123456','帅气','2013-03-07 13:53:39');
INSERT INTO `search` VALUES (194,'efit123456','帅气','2013-03-07 13:53:41');
INSERT INTO `search` VALUES (195,'匿名','帅气','2013-03-07 15:19:59');
INSERT INTO `search` VALUES (196,'efit123456','帅气','2013-03-07 16:09:26');
INSERT INTO `search` VALUES (197,'efit123456','帅气','2013-03-07 16:09:33');
INSERT INTO `search` VALUES (198,'efit123456','帅气','2013-03-07 16:09:37');
INSERT INTO `search` VALUES (199,'匿名','帅气','2013-03-08 13:44:03');
INSERT INTO `search` VALUES (200,'匿名','帅气','2013-03-08 13:46:22');
INSERT INTO `search` VALUES (201,'匿名','帅气','2013-03-08 13:48:00');
INSERT INTO `search` VALUES (202,'匿名','帅气','2013-03-08 13:48:03');
INSERT INTO `search` VALUES (203,'匿名','帅气','2013-03-08 13:49:04');
INSERT INTO `search` VALUES (204,'efit1234567','帅气','2013-03-25 17:37:19');
INSERT INTO `search` VALUES (205,'efit123456','帅气','2013-03-25 17:38:05');
INSERT INTO `search` VALUES (206,'efit123456','帅气','2013-03-25 18:13:33');
INSERT INTO `search` VALUES (207,'匿名','帅气','2013-03-29 15:41:42');
INSERT INTO `search` VALUES (208,'efit123456','帅气','2013-03-29 15:42:07');
INSERT INTO `search` VALUES (209,'efit123456','帅气','2013-03-29 15:42:07');
INSERT INTO `search` VALUES (210,'匿名','帅气','2013-03-29 15:47:22');
INSERT INTO `search` VALUES (211,'efit123456','帅气','2013-03-29 15:47:44');
INSERT INTO `search` VALUES (212,'匿名','帅气','2013-03-29 16:04:59');
INSERT INTO `search` VALUES (213,'匿名','帅气','2013-03-29 17:52:15');
INSERT INTO `search` VALUES (214,'匿名','帅气','2013-03-29 17:52:25');
INSERT INTO `search` VALUES (215,'匿名','帅气','2013-03-29 17:52:32');
INSERT INTO `search` VALUES (216,'123456','帅气','2013-03-29 18:02:38');
INSERT INTO `search` VALUES (217,'123456','帅气','2013-03-29 18:03:51');
INSERT INTO `search` VALUES (218,'1234566','帅气','2013-03-29 18:04:11');
INSERT INTO `search` VALUES (219,'匿名','帅气','2013-04-02 16:04:54');
INSERT INTO `search` VALUES (220,'efit123456','帅气','2013-04-02 17:30:53');
INSERT INTO `search` VALUES (221,'efit123456','帅气','2013-04-02 17:32:50');
INSERT INTO `search` VALUES (222,'efit123456','时尚','2013-04-06 17:01:13');
INSERT INTO `search` VALUES (223,'efit123456','时尚','2013-04-06 17:01:23');
INSERT INTO `search` VALUES (224,'efit123456','时尚','2013-04-06 17:05:42');
INSERT INTO `search` VALUES (225,'efit123456','时尚','2013-04-06 17:31:39');
INSERT INTO `search` VALUES (226,'efit123456','时尚','2013-04-06 17:37:21');
INSERT INTO `search` VALUES (227,'efit123456','时尚','2013-04-06 17:37:53');
INSERT INTO `search` VALUES (228,'efit123456','时尚','2013-04-06 17:43:18');
INSERT INTO `search` VALUES (229,'efit123456','时尚','2013-04-06 17:44:01');
INSERT INTO `search` VALUES (230,'efit123456','时尚','2013-04-06 17:47:44');
INSERT INTO `search` VALUES (231,'efit123456','时尚','2013-04-06 17:47:56');
INSERT INTO `search` VALUES (232,'efit123456','时尚','2013-04-06 17:48:57');
INSERT INTO `search` VALUES (233,'efit123456','时尚','2013-04-06 17:50:58');
INSERT INTO `search` VALUES (234,'efit123456','时尚','2013-04-06 17:51:31');
INSERT INTO `search` VALUES (235,'efit123456','时尚','2013-04-06 17:52:20');
INSERT INTO `search` VALUES (236,'efit123456','时尚','2013-04-06 17:52:27');
INSERT INTO `search` VALUES (237,'efit123456','时尚','2013-04-07 15:17:57');
INSERT INTO `search` VALUES (238,'匿名','时尚','2013-05-16 19:39:20');
INSERT INTO `search` VALUES (239,'who247','时尚','2013-05-16 19:42:48');
INSERT INTO `search` VALUES (240,'who247','时尚','2013-05-16 19:43:32');
INSERT INTO `search` VALUES (241,'who247','时尚','2013-05-16 19:55:52');
INSERT INTO `search` VALUES (242,'who247','时尚','2013-05-16 19:56:28');
INSERT INTO `search` VALUES (243,'who247','时尚','2013-05-16 19:57:08');
INSERT INTO `search` VALUES (244,'who247','时尚','2013-05-16 19:57:29');
INSERT INTO `search` VALUES (245,'who247','时尚','2013-05-16 19:58:01');
INSERT INTO `search` VALUES (246,'who247','时尚','2013-05-16 20:11:39');
INSERT INTO `search` VALUES (247,'who247','时尚','2013-05-17 15:19:07');
INSERT INTO `search` VALUES (248,'who247','时尚','2013-05-17 15:19:25');
INSERT INTO `search` VALUES (249,'who247','时尚','2013-05-17 15:19:27');
INSERT INTO `search` VALUES (250,'who247','时尚','2013-05-17 15:27:49');
INSERT INTO `search` VALUES (251,'匿名','时尚','2013-05-17 15:28:28');
INSERT INTO `search` VALUES (252,'who247','时尚','2013-05-17 16:22:51');
INSERT INTO `search` VALUES (253,'匿名','时尚','2013-05-21 17:31:29');
INSERT INTO `search` VALUES (254,'匿名','帅气','2013-05-22 15:49:18');
INSERT INTO `search` VALUES (255,'匿名','帅气','2013-05-22 15:51:40');
INSERT INTO `search` VALUES (256,'匿名','时尚','2013-05-27 18:35:17');
INSERT INTO `search` VALUES (257,'匿名','时尚','2013-05-27 18:35:40');
INSERT INTO `search` VALUES (258,'匿名','时尚','2013-05-27 18:35:58');
INSERT INTO `search` VALUES (259,'匿名','时尚','2013-05-27 18:36:10');
INSERT INTO `search` VALUES (260,'who247','时尚','2013-05-27 18:37:02');
INSERT INTO `search` VALUES (261,'匿名','时尚','2013-05-28 15:45:38');
INSERT INTO `search` VALUES (262,'匿名','时尚','2013-05-28 15:48:35');
INSERT INTO `search` VALUES (263,'匿名','时尚','2013-05-28 16:03:16');
INSERT INTO `search` VALUES (264,'who123','时尚','2013-05-28 16:47:28');
INSERT INTO `search` VALUES (265,'匿名','时尚','2013-05-29 17:23:14');
INSERT INTO `search` VALUES (266,'匿名','时尚','2013-05-29 17:32:35');
INSERT INTO `search` VALUES (267,'匿名','时尚','2013-05-29 18:26:08');
INSERT INTO `search` VALUES (268,'efit12345','时尚','2013-05-30 19:15:26');
INSERT INTO `search` VALUES (269,'efit12345','时尚','2013-05-30 19:25:55');
INSERT INTO `search` VALUES (270,'efit12345','时尚','2013-05-30 19:27:47');
INSERT INTO `search` VALUES (271,'efit12345','时尚','2013-05-30 19:41:27');
INSERT INTO `search` VALUES (272,'efit12345','时尚','2013-05-30 20:01:07');
INSERT INTO `search` VALUES (273,'111111','帅气','2013-05-30 20:15:43');
INSERT INTO `search` VALUES (274,'匿名','帅气','2013-05-30 21:12:19');
INSERT INTO `search` VALUES (275,'efit12345','帅气','2013-05-30 21:12:40');
INSERT INTO `search` VALUES (276,'efit123456','帅气','2013-05-30 21:13:03');
INSERT INTO `search` VALUES (277,'efit123456','帅气','2013-05-30 21:13:40');
INSERT INTO `search` VALUES (278,'efit123456','帅气','2013-05-30 21:14:10');
INSERT INTO `search` VALUES (279,'efit123456','时尚','2013-05-30 21:14:20');
INSERT INTO `search` VALUES (280,'efit123456','帅气','2013-05-30 21:14:56');
INSERT INTO `search` VALUES (281,'efit123456','时尚','2013-05-30 21:17:47');
INSERT INTO `search` VALUES (282,'efit123456','时尚','2013-05-30 21:17:55');
INSERT INTO `search` VALUES (283,'efit123456','时尚','2013-05-30 21:18:08');
INSERT INTO `search` VALUES (284,'efit123456','时尚','2013-05-30 21:18:34');
INSERT INTO `search` VALUES (285,'efit123456','时尚','2013-05-30 21:19:11');
INSERT INTO `search` VALUES (286,'efit123456','时尚','2013-05-30 21:20:14');
INSERT INTO `search` VALUES (287,'efit123456','时尚','2013-05-30 21:22:12');
INSERT INTO `search` VALUES (288,'efit123456','帅气','2013-05-30 21:25:52');
INSERT INTO `search` VALUES (289,'efit123456','帅气','2013-05-30 21:29:10');
INSERT INTO `search` VALUES (290,'efit123456','时尚','2013-05-30 21:31:09');
INSERT INTO `search` VALUES (291,'222222222','帅气','2013-05-30 21:36:05');
INSERT INTO `search` VALUES (292,'3333333','帅气','2013-05-31 14:35:10');
INSERT INTO `search` VALUES (293,'3333333','帅气','2013-05-31 14:38:09');
INSERT INTO `search` VALUES (294,'555555','帅气','2013-05-31 14:42:18');
INSERT INTO `search` VALUES (295,'匿名','帅气','2013-05-31 14:43:12');
INSERT INTO `search` VALUES (296,'555555','帅气','2013-05-31 14:43:51');
INSERT INTO `search` VALUES (297,'222222222','帅气','2013-05-31 14:46:49');
INSERT INTO `search` VALUES (298,'222222222','帅气','2013-05-31 14:47:01');
INSERT INTO `search` VALUES (299,'222222222','帅气','2013-05-31 14:47:05');
INSERT INTO `search` VALUES (300,'222222222','帅气','2013-05-31 14:47:10');
INSERT INTO `search` VALUES (301,'222222222','帅气','2013-05-31 14:47:22');
INSERT INTO `search` VALUES (302,'222222222','帅气','2013-05-31 14:47:37');
INSERT INTO `search` VALUES (303,'3333333','帅气','2013-05-31 14:48:03');
INSERT INTO `search` VALUES (304,'555555','帅气','2013-05-31 14:48:23');
INSERT INTO `search` VALUES (305,'zyg123','帅气','2013-05-31 14:53:36');
INSERT INTO `search` VALUES (306,'zyg123','帅气','2013-05-31 14:55:07');
INSERT INTO `search` VALUES (307,'zyg123','帅气','2013-05-31 14:55:18');
INSERT INTO `search` VALUES (308,'zyg123','帅气','2013-05-31 14:55:47');
INSERT INTO `search` VALUES (309,'zyg123','帅气','2013-05-31 14:56:00');
INSERT INTO `search` VALUES (310,'zyg123','帅气','2013-05-31 14:56:05');
INSERT INTO `search` VALUES (311,'zyg123','帅气','2013-05-31 14:56:06');
INSERT INTO `search` VALUES (312,'zyg123','帅气','2013-05-31 15:04:06');
INSERT INTO `search` VALUES (313,'zyg123','帅气','2013-05-31 15:04:11');
INSERT INTO `search` VALUES (314,'zyg123','帅气','2013-05-31 15:04:27');
INSERT INTO `search` VALUES (315,'zyg123','帅气','2013-05-31 15:04:28');
INSERT INTO `search` VALUES (316,'zyg123','帅气','2013-05-31 15:04:29');
INSERT INTO `search` VALUES (317,'zyg123','帅气','2013-05-31 15:04:48');
INSERT INTO `search` VALUES (318,'zyg123','帅气','2013-05-31 15:05:52');
INSERT INTO `search` VALUES (319,'zyg123','帅气','2013-05-31 15:06:47');
INSERT INTO `search` VALUES (320,'zyg123','帅气','2013-05-31 15:06:58');
INSERT INTO `search` VALUES (321,'555555','帅气','2013-05-31 15:08:18');
INSERT INTO `search` VALUES (322,'555555','帅气','2013-05-31 15:08:34');
INSERT INTO `search` VALUES (323,'555555','帅气','2013-05-31 15:08:37');
INSERT INTO `search` VALUES (324,'555555','帅气','2013-05-31 15:08:39');
INSERT INTO `search` VALUES (325,'555555','帅气','2013-05-31 15:08:50');
INSERT INTO `search` VALUES (326,'555555','帅气','2013-05-31 15:08:51');
INSERT INTO `search` VALUES (327,'555555','帅气','2013-05-31 15:08:53');
INSERT INTO `search` VALUES (328,'555555','帅气','2013-05-31 22:36:41');
INSERT INTO `search` VALUES (329,'555555','帅气','2013-05-31 22:36:50');
INSERT INTO `search` VALUES (330,'555555','帅气','2013-05-31 22:37:07');
INSERT INTO `search` VALUES (331,'555555','帅气','2013-06-02 20:44:58');
INSERT INTO `search` VALUES (332,'555555','帅气','2013-06-02 20:44:58');
INSERT INTO `search` VALUES (333,'555555','帅气','2013-06-02 20:45:18');
INSERT INTO `search` VALUES (334,'555555','帅气','2013-06-02 20:45:30');
INSERT INTO `search` VALUES (335,'555555','时尚','2013-06-02 20:46:12');
INSERT INTO `search` VALUES (336,'555555','时尚','2013-06-02 20:46:18');
INSERT INTO `search` VALUES (337,'555555','时尚','2013-06-02 20:46:23');
INSERT INTO `search` VALUES (338,'555555','时尚','2013-06-02 20:47:04');
INSERT INTO `search` VALUES (339,'555555','帅气','2013-06-02 20:50:26');
INSERT INTO `search` VALUES (340,'555555','帅气','2013-06-02 20:50:29');
INSERT INTO `search` VALUES (341,'555555','帅气','2013-06-02 20:50:30');
INSERT INTO `search` VALUES (342,'555555','帅气','2013-06-02 20:50:31');
INSERT INTO `search` VALUES (343,'555555','帅气','2013-06-02 20:50:32');
INSERT INTO `search` VALUES (344,'555555','时尚','2013-06-02 21:00:55');
INSERT INTO `search` VALUES (345,'555555','帅气','2013-06-02 21:21:41');
INSERT INTO `search` VALUES (346,'555555','帅气','2013-06-02 21:21:45');
INSERT INTO `search` VALUES (347,'555555','帅气','2013-06-02 21:21:46');
INSERT INTO `search` VALUES (348,'555555','帅气','2013-06-02 21:21:47');
INSERT INTO `search` VALUES (349,'555555','帅气','2013-06-02 21:21:48');
INSERT INTO `search` VALUES (350,'555555','帅气','2013-06-02 21:22:03');
INSERT INTO `search` VALUES (351,'555555','帅气','2013-06-02 21:22:40');
INSERT INTO `search` VALUES (352,'555555','帅气','2013-06-02 21:22:41');
INSERT INTO `search` VALUES (353,'555555','帅气','2013-06-02 21:22:42');
INSERT INTO `search` VALUES (354,'555555','帅气','2013-06-02 21:22:43');
INSERT INTO `search` VALUES (355,'匿名','帅气','2013-06-03 16:40:53');
INSERT INTO `search` VALUES (356,'555555','帅气','2013-06-03 23:07:00');
INSERT INTO `search` VALUES (357,'555555','帅气','2013-06-03 23:08:50');
INSERT INTO `search` VALUES (358,'555555','时尚','2013-06-04 15:50:10');
INSERT INTO `search` VALUES (359,'555555','帅气','2013-06-04 15:50:33');
INSERT INTO `search` VALUES (360,'555555','帅气','2013-06-04 15:53:11');
INSERT INTO `search` VALUES (361,'555555','帅气','2013-06-04 15:54:17');
INSERT INTO `search` VALUES (362,'555555','帅气','2013-06-04 15:54:58');
INSERT INTO `search` VALUES (363,'555555','帅气','2013-06-04 15:55:09');
INSERT INTO `search` VALUES (364,'555555','帅气','2013-06-04 15:55:13');
INSERT INTO `search` VALUES (365,'555555','帅气','2013-06-04 15:55:15');
INSERT INTO `search` VALUES (366,'555555','帅气','2013-06-04 15:55:28');
INSERT INTO `search` VALUES (367,'555555','帅气','2013-06-04 15:55:31');
INSERT INTO `search` VALUES (368,'555555','帅气','2013-06-04 15:55:37');
INSERT INTO `search` VALUES (369,'555555','帅气','2013-06-04 15:55:42');
INSERT INTO `search` VALUES (370,'匿名','帅气','2013-06-04 16:33:49');
INSERT INTO `search` VALUES (371,'匿名','帅气','2013-06-04 16:34:30');
INSERT INTO `search` VALUES (372,'匿名','帅气','2013-06-05 15:55:28');
INSERT INTO `search` VALUES (373,'555555','时尚','2013-06-05 17:54:38');
INSERT INTO `search` VALUES (374,'555555','时尚','2013-06-05 17:54:39');
INSERT INTO `search` VALUES (375,'555555','时尚','2013-06-05 17:54:45');
INSERT INTO `search` VALUES (376,'555555','时尚','2013-06-05 17:54:46');
INSERT INTO `search` VALUES (377,'555555','时尚','2013-06-05 17:54:48');
INSERT INTO `search` VALUES (378,'555555','时尚','2013-06-05 17:54:49');
INSERT INTO `search` VALUES (379,'555555','时尚','2013-06-05 17:54:50');
INSERT INTO `search` VALUES (380,'555555','时尚','2013-06-05 17:55:34');
INSERT INTO `search` VALUES (381,'zyg123','帅气','2013-06-05 17:58:56');
INSERT INTO `search` VALUES (382,'zyg123','帅气','2013-06-05 18:39:57');
INSERT INTO `search` VALUES (383,'zyg123','帅气','2013-06-05 18:40:00');
INSERT INTO `search` VALUES (384,'zyg123','帅气','2013-06-05 18:40:03');
INSERT INTO `search` VALUES (385,'zyg123','帅气','2013-06-05 18:40:06');
INSERT INTO `search` VALUES (386,'3333333','时尚','2013-06-05 18:54:52');
INSERT INTO `search` VALUES (387,'3333333','时尚','2013-06-05 18:54:57');
INSERT INTO `search` VALUES (388,'3333333','时尚','2013-06-05 18:54:59');
INSERT INTO `search` VALUES (389,'3333333','时尚','2013-06-05 18:55:02');
INSERT INTO `search` VALUES (390,'3333333','时尚','2013-06-05 18:55:22');
INSERT INTO `search` VALUES (391,'3333333','时尚','2013-06-05 18:55:27');
INSERT INTO `search` VALUES (392,'3333333','时尚','2013-06-05 18:55:44');
INSERT INTO `search` VALUES (393,'3333333','时尚','2013-06-05 18:56:50');
INSERT INTO `search` VALUES (394,'3333333','时尚','2013-06-05 18:56:55');
INSERT INTO `search` VALUES (395,'3333333','时尚','2013-06-05 18:56:57');
INSERT INTO `search` VALUES (396,'3333333','时尚','2013-06-05 18:57:00');
INSERT INTO `search` VALUES (397,'test1234','时尚','2013-06-05 20:22:24');
INSERT INTO `search` VALUES (398,'test1234','时尚','2013-06-05 20:22:30');
INSERT INTO `search` VALUES (399,'test1234','时尚','2013-06-05 20:22:36');
INSERT INTO `search` VALUES (400,'test1234','时尚','2013-06-05 20:22:43');
INSERT INTO `search` VALUES (401,'test1234','时尚','2013-06-05 20:22:52');
INSERT INTO `search` VALUES (402,'test1234','时尚','2013-06-05 20:24:19');
INSERT INTO `search` VALUES (403,'test1234','时尚','2013-06-05 20:24:33');
INSERT INTO `search` VALUES (404,'test1234','时尚','2013-06-05 20:24:36');
INSERT INTO `search` VALUES (405,'test12345','时尚','2013-06-05 20:36:16');
INSERT INTO `search` VALUES (406,'test12345','时尚','2013-06-05 20:36:22');
INSERT INTO `search` VALUES (407,'test12345','时尚','2013-06-05 20:36:23');
INSERT INTO `search` VALUES (408,'test12345','时尚','2013-06-05 20:36:26');
/*!40000 ALTER TABLE `search` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table share
#

DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `share_id` varchar(17) NOT NULL DEFAULT '',
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(11) DEFAULT NULL,
  `share_path` text,
  `share_time` date DEFAULT NULL,
  `t_id` varchar(17) DEFAULT NULL,
  `t_name` varchar(11) DEFAULT NULL,
  `t_detail` text,
  `d_id` varchar(17) DEFAULT NULL,
  `d_name` varchar(11) DEFAULT NULL,
  `d_detail` text,
  PRIMARY KEY (`share_id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_2` (`t_id`),
  KEY `FK_Reference_3` (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

#
# Dumping data for table share
#
LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;

INSERT INTO `share` VALUES ('20130603230855625',65,'555555','share//20130603230855625.png','2013-06-03','20130602193551687','T恤打底衫','三叶草阿迪达斯爱情公寓关谷熊猫纯棉男士长袖T恤打底衫','20130602200353406','休闲裤','外贸秋冬户外男裤休闲裤宽松加厚加绒裤大码工装裤男长裤运动裤子');
INSERT INTO `share` VALUES ('20130605175527453',65,'555555','share//20130605175527468.png','2013-06-05','20130602195407421','小西装','男装秋冬装新品休闲西服男韩版修身潮小西装男单西外套便西','20130602200652718','修身平绒裤','春秋韩版休闲裤 男 长裤 微弹力修身平绒裤 松紧腰休闲男裤');
INSERT INTO `share` VALUES ('20130605175559437',65,'555555','share//20130605175559437.png','2013-06-05','20130602195804609','休闲西服','男装春装新款男士休闲西服男韩版修身潮流时尚小西装外套','20130602201524562','纯棉潮长裤','春夏装新款韩版男装修身裤男士休闲裤纯棉潮长裤小脚裤男裤子');
INSERT INTO `share` VALUES ('20130605184021796',66,'zyg123','share//20130605184021796.png','2013-06-05','20130602195407421','小西装','男装秋冬装新品休闲西服男韩版修身潮小西装男单西外套便西','20130602200652718','修身平绒裤','春秋韩版休闲裤 男 长裤 微弹力修身平绒裤 松紧腰休闲男裤');
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `head_adreess` text,
  `sex` char(1) DEFAULT NULL,
  `t_size` char(1) DEFAULT NULL,
  `d_size` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=gb2312;

#
# Dumping data for table user
#
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` VALUES (19,'cathy1217','12345','','M','m','m');
INSERT INTO `user` VALUES (23,'who246','1234','pz/pzimage/20130216170954031.png','W','l','m');
INSERT INTO `user` VALUES (25,'efit123','123','','M','s','s');
INSERT INTO `user` VALUES (28,'archenemy','1234','pz/pzimage/20130306173040031.png','M','m','m');
INSERT INTO `user` VALUES (29,'zzy123','123','','M','m','m');
INSERT INTO `user` VALUES (30,'who248','1234','pz/pzimage/20130306185534250.png','M','s','s');
INSERT INTO `user` VALUES (31,'who249','1234','pz/pzimage/20130306192529578.png','M','s','s');
INSERT INTO `user` VALUES (32,'efit1234','efit1234','pz/pzimage/20130306193758671.png','M','m','m');
INSERT INTO `user` VALUES (33,'efit12345','efit1234','pz/pzimage/20130306193758671.png','M','m','m');
INSERT INTO `user` VALUES (34,'efit123456','efit123456','\\pz\\pzimage\\20130530210901015.png','M','m','m');
INSERT INTO `user` VALUES (35,'efit1234567','efit1234567','pz/pzimage/20130306203650453.png','M','m','m');
INSERT INTO `user` VALUES (36,'qqqqqq','qqqqqq','pz/pzimage/20130307094103265.png','M','m','m');
INSERT INTO `user` VALUES (37,'tester1','12','pz/pzimage/20130312163751156.png','M','s','s');
INSERT INTO `user` VALUES (38,'1234566','123','pz/pzimage/20130329180036468.png','M','s','s');
INSERT INTO `user` VALUES (54,'who247','65605090','\\user\\who247\\20130516164702921.png','W','s','s');
INSERT INTO `user` VALUES (56,'who123','65605090','\\user\\who123\\20130521155205203.png','M','s','m');
INSERT INTO `user` VALUES (57,'123456','123456','\\user\\123456\\20130530193212296.png','M','m','m');
INSERT INTO `user` VALUES (58,'111111','111111','\\user\\111111\\20130530201425265.png','M','m','m');
INSERT INTO `user` VALUES (59,'222222222','222222222','\\user\\222222222\\20130531144642171.png','M','m','m');
INSERT INTO `user` VALUES (60,'223333','223333',NULL,'M','m','m');
INSERT INTO `user` VALUES (61,'1111111','44',NULL,'M','m','m');
INSERT INTO `user` VALUES (62,'111112','111112','\\user\\111112\\20130530221523046.png','M','m','m');
INSERT INTO `user` VALUES (64,'test123','123456','\\user\\test123\\20130531143721515.png','M','m','m');
INSERT INTO `user` VALUES (65,'555555','555555','\\user\\555555\\20130531144343921.png','M','m','m');
INSERT INTO `user` VALUES (66,'zyg123','zyg123','\\user\\zyg123\\20130531145029062.png','M','m','m');
INSERT INTO `user` VALUES (67,'0123456','123','\\user\\0123456\\20130602201942765.png','M','s','s');
INSERT INTO `user` VALUES (68,'android','123','\\user\\android\\20130605182037125.png','M','m','m');
INSERT INTO `user` VALUES (69,'test1234','123456','\\user\\test1234\\20130605202144359.png','M','m','m');
INSERT INTO `user` VALUES (70,'test12345','123456','\\user\\test12345\\20130605203518296.png','M','m','m');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
