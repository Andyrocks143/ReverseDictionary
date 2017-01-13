CREATE DATABASE  IF NOT EXISTS `sharfu` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sharfu`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: sharfu
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `usertype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (19,'mur','mur','HOD'),(20,'sun','sun','REG'),(21,'day','day','REG'),(22,'sha','sha','HOD'),(23,'shar','shar','REG'),(24,'ais','ais','HOD'),(25,'par','par','REG'),(26,'kur','kur','LEC'),(27,'kur','kur','LEC'),(28,'man','man','HOD'),(29,'pri','pri','REG'),(30,'san','san','student'),(31,'sans','sans','student');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questiondirectory`
--

DROP TABLE IF EXISTS `questiondirectory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questiondirectory` (
  `PersonID` varchar(11) NOT NULL,
  `UserType` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `specialisation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PersonID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questiondirectory`
--

LOCK TABLES `questiondirectory` WRITE;
/*!40000 ALTER TABLE `questiondirectory` DISABLE KEYS */;
INSERT INTO `questiondirectory` VALUES ('1001','LEC','cse','java,ajax,spring'),('1002','HOD','cse','java,ajax,spring,.net,struts'),('1003','REG','cse','java,ajax,spring,.net,struts,Hr,Mba'),('1004','REG','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb'),('1005','HOD','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop'),('1006','REG','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop,c  '),('1007','HOD','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop,c  ,c'),('1008','REG','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop,c  ,c'),('1009','LEC','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop,c  ,c'),('1010','HOD','cse','java,ajax,spring,.net,struts,Hr,Mba,core java,vb,hadoop,c  ,c'),('1011','REG','cse','java'),('1012','REG','cse','a');
/*!40000 ALTER TABLE `questiondirectory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffregister`
--

DROP TABLE IF EXISTS `staffregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staffregister` (
  `regid` int(15) NOT NULL AUTO_INCREMENT,
  `staffid` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`regid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffregister`
--

LOCK TABLES `staffregister` WRITE;
/*!40000 ALTER TABLE `staffregister` DISABLE KEYS */;
INSERT INTO `staffregister` VALUES (17,'1001','santhosh','san','san',1,'lec','santhoshlfms@gmail.com'),(18,'1002','Murugan','mur','mur',1,'hod','santhoshlfms@gmail.com'),(19,'1003','Sundar','sun','sun',1,'reg','santhoshlfms@gmail.com'),(20,'1004','Dayana','day','day',2,'reg','santhoshlfms@gmail.com'),(21,'1005','Shara','sha','sha',1,'hod','santhoshlfms@gmail.com'),(22,'1006','Sharf','shar','shar',1,'reg','santhoshlfms@gmail.com'),(23,'1007','Aiswarya','ais','ais',2,'hod','santhoshlfms@gmail.com'),(24,'1008','Parthiba','par','par',2,'reg','santhoshlfms@gmail.com'),(25,'1008','kumar','kur','kur',2,'lec','santhoshlfms@gmail.com'),(26,'1009','kumar','kur','kur',2,'lec','santhoshlfms@gmail.com'),(27,'1010','Mani','man','man',1,'hod','santhoshlfms@gmail.com'),(28,'1011','priya','pri','pri',2,'reg','santhoshlfms@gmail.com');
/*!40000 ALTER TABLE `staffregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stopwords`
--

DROP TABLE IF EXISTS `stopwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stopwords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stopWords` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1402 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stopwords`
--

LOCK TABLES `stopwords` WRITE;
/*!40000 ALTER TABLE `stopwords` DISABLE KEYS */;
INSERT INTO `stopwords` VALUES (1,'i'),(2,'a'),(3,'about'),(4,'an'),(5,'are'),(6,'as'),(7,'at'),(8,'be'),(9,'by'),(10,'com'),(11,'for'),(12,'from'),(13,'how'),(14,'in'),(15,'is'),(16,'it'),(17,'of'),(18,'on'),(19,'or'),(20,'that'),(21,'the'),(22,'this'),(23,'to'),(24,'was'),(25,'what'),(26,'when'),(27,'where'),(28,'who'),(29,'will'),(30,'with'),(31,'meaning'),(32,'mean'),(33,'a'),(34,'about'),(35,'above'),(36,'above'),(37,'across'),(38,'after'),(39,'afterwards'),(40,'again'),(41,'against'),(42,'all'),(43,'almost'),(44,'alone'),(45,'along'),(46,'already'),(47,'also'),(48,'although'),(49,'always'),(50,'am'),(51,'among'),(52,'amongst'),(53,'amoungst'),(54,'amount'),(55,'an'),(56,'and'),(57,'another'),(58,'any'),(59,'anyhow'),(60,'anyone'),(61,'anything'),(62,'anyway'),(63,'anywhere'),(64,'are'),(65,'around'),(66,'as'),(67,'at'),(68,'back'),(69,'be'),(70,'became'),(71,'because'),(72,'become'),(73,'becomes'),(74,'becoming'),(75,'been'),(76,'before'),(77,'beforehand'),(78,'behind'),(79,'being'),(80,'below'),(81,'beside'),(82,'besides'),(83,'between'),(84,'beyond'),(85,'bill'),(86,'both'),(87,'bottom'),(88,'but'),(89,'by'),(90,'call'),(91,'can'),(92,'cannot'),(93,'cant'),(94,'co'),(95,'con'),(96,'could'),(97,'couldnt'),(98,'cry'),(99,'de'),(100,'describe'),(101,'detail'),(102,'do'),(103,'done'),(104,'down'),(105,'due'),(106,'during'),(107,'each'),(108,'eg'),(109,'eight'),(110,'either'),(111,'eleven'),(112,'else'),(113,'elsewhere'),(114,'empty'),(115,'enough'),(116,'etc'),(117,'even'),(118,'ever'),(119,'every'),(120,'everyone'),(121,'everything'),(122,'everywhere'),(123,'except'),(124,'few'),(125,'fifteen'),(126,'fify'),(127,'fill'),(128,'find'),(129,'fire'),(130,'first'),(131,'five'),(132,'for'),(133,'former'),(134,'formerly'),(135,'forty'),(136,'found'),(137,'four'),(138,'from'),(139,'front'),(140,'full'),(141,'further'),(142,'get'),(143,'give'),(144,'go'),(145,'had'),(146,'has'),(147,'hasnt'),(148,'have'),(149,'he'),(150,'hence'),(151,'her'),(152,'here'),(153,'hereafter'),(154,'hereby'),(155,'herein'),(156,'hereupon'),(157,'hers'),(158,'herself'),(159,'him'),(160,'himself'),(161,'his'),(162,'how'),(163,'however'),(164,'hundred'),(165,'ie'),(166,'if'),(167,'in'),(168,'inc'),(169,'indeed'),(170,'interest'),(171,'into'),(172,'is'),(173,'it'),(174,'its'),(175,'itself'),(176,'keep'),(177,'last'),(178,'latter'),(179,'latterly'),(180,'least'),(181,'less'),(182,'ltd'),(183,'made'),(184,'many'),(185,'may'),(186,'me'),(187,'meanwhile'),(188,'might'),(189,'mill'),(190,'mine'),(191,'more'),(192,'moreover'),(193,'most'),(194,'mostly'),(195,'move'),(196,'much'),(197,'must'),(198,'my'),(199,'myself'),(200,'name'),(201,'namely'),(202,'neither'),(203,'never'),(204,'nevertheless'),(205,'next'),(206,'nine'),(207,'no'),(208,'nobody'),(209,'none'),(210,'noone'),(211,'nor'),(212,'not'),(213,'nothing'),(214,'now'),(215,'nowhere'),(216,'of'),(217,'off'),(218,'often'),(219,'on'),(220,'once'),(221,'one'),(222,'only'),(223,'onto'),(224,'or'),(225,'other'),(226,'others'),(227,'otherwise'),(228,'our'),(229,'ours'),(230,'ourselves'),(231,'out'),(232,'over'),(233,'own'),(234,'part'),(235,'per'),(236,'perhaps'),(237,'please'),(238,'put'),(239,'rather'),(240,'re'),(241,'same'),(242,'see'),(243,'seem'),(244,'seemed'),(245,'seeming'),(246,'seems'),(247,'serious'),(248,'several'),(249,'she'),(250,'should'),(251,'show'),(252,'side'),(253,'since'),(254,'sincere'),(255,'six'),(256,'sixty'),(257,'so'),(258,'some'),(259,'somehow'),(260,'someone'),(261,'something'),(262,'sometime'),(263,'sometimes'),(264,'somewhere'),(265,'still'),(266,'such'),(267,'system'),(268,'take'),(269,'ten'),(270,'than'),(271,'that'),(272,'the'),(273,'their'),(274,'them'),(275,'themselves'),(276,'then'),(277,'thence'),(278,'there'),(279,'thereafter'),(280,'thereby'),(281,'therefore'),(282,'therein'),(283,'thereupon'),(284,'these'),(285,'they'),(286,'thickv'),(287,'thin'),(288,'third'),(289,'this'),(290,'those'),(291,'though'),(292,'three'),(293,'through'),(294,'throughout'),(295,'thru'),(296,'thus'),(297,'to'),(298,'together'),(299,'too'),(300,'top'),(301,'toward'),(302,'towards'),(303,'twelve'),(304,'twenty'),(305,'two'),(306,'un'),(307,'under'),(308,'until'),(309,'up'),(310,'upon'),(311,'us'),(312,'very'),(313,'via'),(314,'was'),(315,'we'),(316,'well'),(317,'were'),(318,'what'),(319,'whatever'),(320,'when'),(321,'whence'),(322,'whenever'),(323,'where'),(324,'whereafter'),(325,'whereas'),(326,'whereby'),(327,'wherein'),(328,'whereupon'),(329,'wherever'),(330,'whether'),(331,'which'),(332,'while'),(333,'whither'),(334,'who'),(335,'whoever'),(336,'whole'),(337,'whom'),(338,'whose'),(339,'why'),(340,'will'),(341,'with'),(342,'within'),(343,'without'),(344,'would'),(345,'yet'),(346,'you'),(347,'your'),(348,'yours'),(349,'yourself'),(350,'yourselves'),(351,'1'),(352,'2'),(353,'3'),(354,'4'),(355,'5'),(356,'6'),(357,'7'),(358,'8'),(359,'9'),(360,'10'),(361,'1.'),(362,'2.'),(363,'3.'),(364,'4.'),(365,'5.'),(366,'6.'),(367,'11'),(368,'7.'),(369,'8.'),(370,'9.'),(371,'12'),(372,'13'),(373,'14'),(374,'A'),(375,'B'),(376,'C'),(377,'D'),(378,'E'),(379,'F'),(380,'G'),(381,'H'),(382,'I'),(383,'J'),(384,'K'),(385,'L'),(386,'M'),(387,'N'),(388,'O'),(389,'P'),(390,'Q'),(391,'R'),(392,'S'),(393,'T'),(394,'U'),(395,'V'),(396,'W'),(397,'X'),(398,'Y'),(399,'Z'),(400,'terms'),(401,'CONDITIONS'),(402,'conditions'),(403,'values'),(404,'interested.'),(405,'care'),(406,'sure'),(407,'.'),(408,'!'),(409,'@'),(410,'#'),(411,'$'),(412,'%'),(413,'^'),(414,'&'),(415,'*'),(416,'('),(417,')'),(418,'{'),(419,'}'),(420,'['),(421,']'),(422,':'),(423,';'),(424,','),(425,'<'),(426,'.'),(427,'>'),(428,'/'),(429,'?'),(430,'_'),(431,'-'),(432,'+'),(433,'='),(434,'a'),(435,'b'),(436,'c'),(437,'d'),(438,'e'),(439,'f'),(440,'g'),(441,'h'),(442,'i'),(443,'j'),(444,'k'),(445,'l'),(446,'m'),(447,'n'),(448,'o'),(449,'p'),(450,'q'),(451,'r'),(452,'s'),(453,'t'),(454,'u'),(455,'v'),(456,'w'),(457,'x'),(458,'y'),(459,'z'),(460,'contact'),(461,'grounds'),(462,'buyers'),(463,'tried'),(464,'said,'),(465,'plan'),(466,'value'),(467,'principle.'),(468,'forces'),(469,'sent:'),(470,'is,'),(471,'was'),(472,'like'),(473,'discussion'),(474,'tmus'),(475,'diffrent.'),(476,'layout'),(477,'area.'),(478,'thanks'),(479,'thankyou'),(480,'hello'),(481,'bye'),(482,'rise'),(483,'fell'),(484,'fall'),(485,'psqft.'),(486,'http://'),(487,'km'),(488,'miles'),(489,'know'),(490,'a'),(491,'about'),(492,'above'),(493,'above'),(494,'across'),(495,'after'),(496,'afterwards'),(497,'again'),(498,'against'),(499,'all'),(500,'almost'),(501,'alone'),(502,'along'),(503,'already'),(504,'also'),(505,'although'),(506,'always'),(507,'am'),(508,'among'),(509,'amongst'),(510,'amoungst'),(511,'amount'),(512,'an'),(513,'and'),(514,'another'),(515,'any'),(516,'anyhow'),(517,'anyone'),(518,'anything'),(519,'anyway'),(520,'anywhere'),(521,'are'),(522,'around'),(523,'as'),(524,'at'),(525,'back'),(526,'be'),(527,'became'),(528,'because'),(529,'become'),(530,'becomes'),(531,'becoming'),(532,'been'),(533,'before'),(534,'beforehand'),(535,'behind'),(536,'being'),(537,'below'),(538,'beside'),(539,'besides'),(540,'between'),(541,'beyond'),(542,'bill'),(543,'both'),(544,'bottom'),(545,'but'),(546,'by'),(547,'call'),(548,'can'),(549,'cannot'),(550,'cant'),(551,'co'),(552,'con'),(553,'could'),(554,'couldnt'),(555,'cry'),(556,'de'),(557,'describe'),(558,'detail'),(559,'do'),(560,'done'),(561,'down'),(562,'due'),(563,'during'),(564,'each'),(565,'eg'),(566,'eight'),(567,'either'),(568,'eleven'),(569,'else'),(570,'elsewhere'),(571,'empty'),(572,'enough'),(573,'etc'),(574,'even'),(575,'ever'),(576,'every'),(577,'everyone'),(578,'everything'),(579,'everywhere'),(580,'except'),(581,'few'),(582,'fifteen'),(583,'fify'),(584,'fill'),(585,'find'),(586,'fire'),(587,'first'),(588,'five'),(589,'for'),(590,'former'),(591,'formerly'),(592,'forty'),(593,'found'),(594,'four'),(595,'from'),(596,'front'),(597,'full'),(598,'further'),(599,'get'),(600,'give'),(601,'go'),(602,'had'),(603,'has'),(604,'hasnt'),(605,'have'),(606,'he'),(607,'hence'),(608,'her'),(609,'here'),(610,'hereafter'),(611,'hereby'),(612,'herein'),(613,'hereupon'),(614,'hers'),(615,'herself'),(616,'him'),(617,'himself'),(618,'his'),(619,'how'),(620,'however'),(621,'hundred'),(622,'ie'),(623,'if'),(624,'in'),(625,'inc'),(626,'indeed'),(627,'interest'),(628,'into'),(629,'is'),(630,'it'),(631,'its'),(632,'itself'),(633,'keep'),(634,'last'),(635,'latter'),(636,'latterly'),(637,'least'),(638,'less'),(639,'ltd'),(640,'made'),(641,'many'),(642,'may'),(643,'me'),(644,'meanwhile'),(645,'might'),(646,'mill'),(647,'mine'),(648,'more'),(649,'moreover'),(650,'most'),(651,'mostly'),(652,'move'),(653,'much'),(654,'must'),(655,'my'),(656,'myself'),(657,'name'),(658,'namely'),(659,'neither'),(660,'never'),(661,'nevertheless'),(662,'next'),(663,'nine'),(664,'no'),(665,'nobody'),(666,'none'),(667,'noone'),(668,'nor'),(669,'not'),(670,'nothing'),(671,'now'),(672,'nowhere'),(673,'of'),(674,'off'),(675,'often'),(676,'on'),(677,'once'),(678,'one'),(679,'only'),(680,'onto'),(681,'or'),(682,'other'),(683,'others'),(684,'otherwise'),(685,'our'),(686,'ours'),(687,'ourselves'),(688,'out'),(689,'over'),(690,'own'),(691,'part'),(692,'per'),(693,'perhaps'),(694,'please'),(695,'put'),(696,'rather'),(697,'re'),(698,'same'),(699,'see'),(700,'seem'),(701,'seemed'),(702,'seeming'),(703,'seems'),(704,'serious'),(705,'several'),(706,'she'),(707,'should'),(708,'show'),(709,'side'),(710,'since'),(711,'sincere'),(712,'six'),(713,'sixty'),(714,'so'),(715,'some'),(716,'somehow'),(717,'someone'),(718,'something'),(719,'sometime'),(720,'sometimes'),(721,'somewhere'),(722,'still'),(723,'such'),(724,'system'),(725,'take'),(726,'ten'),(727,'than'),(728,'that'),(729,'the'),(730,'their'),(731,'them'),(732,'themselves'),(733,'then'),(734,'thence'),(735,'there'),(736,'thereafter'),(737,'thereby'),(738,'therefore'),(739,'therein'),(740,'thereupon'),(741,'these'),(742,'they'),(743,'thickv'),(744,'thin'),(745,'third'),(746,'this'),(747,'those'),(748,'though'),(749,'three'),(750,'through'),(751,'throughout'),(752,'thru'),(753,'thus'),(754,'to'),(755,'together'),(756,'too'),(757,'top'),(758,'toward'),(759,'towards'),(760,'twelve'),(761,'twenty'),(762,'two'),(763,'un'),(764,'under'),(765,'until'),(766,'up'),(767,'upon'),(768,'us'),(769,'very'),(770,'via'),(771,'was'),(772,'we'),(773,'well'),(774,'were'),(775,'what'),(776,'whatever'),(777,'when'),(778,'whence'),(779,'whenever'),(780,'where'),(781,'whereafter'),(782,'whereas'),(783,'whereby'),(784,'wherein'),(785,'whereupon'),(786,'wherever'),(787,'whether'),(788,'which'),(789,'while'),(790,'whither'),(791,'who'),(792,'whoever'),(793,'whole'),(794,'whom'),(795,'whose'),(796,'why'),(797,'will'),(798,'with'),(799,'within'),(800,'without'),(801,'would'),(802,'yet'),(803,'you'),(804,'your'),(805,'yours'),(806,'yourself'),(807,'yourselves'),(808,'1'),(809,'2'),(810,'3'),(811,'4'),(812,'5'),(813,'6'),(814,'7'),(815,'8'),(816,'9'),(817,'10'),(818,'1.'),(819,'2.'),(820,'3.'),(821,'4.'),(822,'5.'),(823,'6.'),(824,'11'),(825,'7.'),(826,'8.'),(827,'9.'),(828,'12'),(829,'13'),(830,'14'),(831,'A'),(832,'B'),(833,'C'),(834,'D'),(835,'E'),(836,'F'),(837,'G'),(838,'H'),(839,'I'),(840,'J'),(841,'K'),(842,'L'),(843,'M'),(844,'N'),(845,'O'),(846,'P'),(847,'Q'),(848,'R'),(849,'S'),(850,'T'),(851,'U'),(852,'V'),(853,'W'),(854,'X'),(855,'Y'),(856,'Z'),(857,'terms'),(858,'CONDITIONS'),(859,'conditions'),(860,'values'),(861,'interested.'),(862,'care'),(863,'sure'),(864,'.'),(865,'!'),(866,'@'),(867,'#'),(868,'$'),(869,'%'),(870,'^'),(871,'&'),(872,'*'),(873,'('),(874,')'),(875,'{'),(876,'}'),(877,'['),(878,']'),(879,':'),(880,';'),(881,','),(882,'<'),(883,'.'),(884,'>'),(885,'/'),(886,'?'),(887,'_'),(888,'-'),(889,'+'),(890,'='),(891,'a'),(892,'b'),(893,'c'),(894,'d'),(895,'e'),(896,'f'),(897,'g'),(898,'h'),(899,'i'),(900,'j'),(901,'k'),(902,'l'),(903,'m'),(904,'n'),(905,'o'),(906,'p'),(907,'q'),(908,'r'),(909,'s'),(910,'t'),(911,'u'),(912,'v'),(913,'w'),(914,'x'),(915,'y'),(916,'z'),(917,'contact'),(918,'grounds'),(919,'buyers'),(920,'tried'),(921,'said,'),(922,'plan'),(923,'value'),(924,'principle.'),(925,'forces'),(926,'sent:'),(927,'is,'),(928,'was'),(929,'like'),(930,'discussion'),(931,'tmus'),(932,'diffrent.'),(933,'layout'),(934,'area.'),(935,'thanks'),(936,'thankyou'),(937,'hello'),(938,'bye'),(939,'rise'),(940,'fell'),(941,'fall'),(942,'psqft.'),(943,'http://'),(944,'km'),(945,'miles'),(946,'a'),(947,'about'),(948,'above'),(949,'above'),(950,'across'),(951,'after'),(952,'afterwards'),(953,'again'),(954,'against'),(955,'all'),(956,'almost'),(957,'alone'),(958,'along'),(959,'already'),(960,'also'),(961,'although'),(962,'always'),(963,'am'),(964,'among'),(965,'amongst'),(966,'amoungst'),(967,'amount'),(968,'an'),(969,'and'),(970,'another'),(971,'any'),(972,'anyhow'),(973,'anyone'),(974,'anything'),(975,'anyway'),(976,'anywhere'),(977,'are'),(978,'around'),(979,'as'),(980,'at'),(981,'back'),(982,'be'),(983,'became'),(984,'because'),(985,'become'),(986,'becomes'),(987,'becoming'),(988,'been'),(989,'before'),(990,'beforehand'),(991,'behind'),(992,'being'),(993,'below'),(994,'beside'),(995,'besides'),(996,'between'),(997,'beyond'),(998,'bill'),(999,'both'),(1000,'bottom'),(1001,'but'),(1002,'by'),(1003,'call'),(1004,'can'),(1005,'cannot'),(1006,'cant'),(1007,'co'),(1008,'con'),(1009,'could'),(1010,'couldnt'),(1011,'cry'),(1012,'de'),(1013,'describe'),(1014,'detail'),(1015,'do'),(1016,'done'),(1017,'down'),(1018,'due'),(1019,'during'),(1020,'each'),(1021,'eg'),(1022,'eight'),(1023,'either'),(1024,'eleven'),(1025,'else'),(1026,'elsewhere'),(1027,'empty'),(1028,'enough'),(1029,'etc'),(1030,'even'),(1031,'ever'),(1032,'every'),(1033,'everyone'),(1034,'everything'),(1035,'everywhere'),(1036,'except'),(1037,'few'),(1038,'fifteen'),(1039,'fify'),(1040,'fill'),(1041,'find'),(1042,'fire'),(1043,'first'),(1044,'five'),(1045,'for'),(1046,'former'),(1047,'formerly'),(1048,'forty'),(1049,'found'),(1050,'four'),(1051,'from'),(1052,'front'),(1053,'full'),(1054,'further'),(1055,'get'),(1056,'give'),(1057,'go'),(1058,'had'),(1059,'has'),(1060,'hasnt'),(1061,'have'),(1062,'he'),(1063,'hence'),(1064,'her'),(1065,'here'),(1066,'hereafter'),(1067,'hereby'),(1068,'herein'),(1069,'hereupon'),(1070,'hers'),(1071,'herself'),(1072,'him'),(1073,'himself'),(1074,'his'),(1075,'how'),(1076,'however'),(1077,'hundred'),(1078,'ie'),(1079,'if'),(1080,'in'),(1081,'inc'),(1082,'indeed'),(1083,'interest'),(1084,'into'),(1085,'is'),(1086,'it'),(1087,'its'),(1088,'itself'),(1089,'keep'),(1090,'last'),(1091,'latter'),(1092,'latterly'),(1093,'least'),(1094,'less'),(1095,'ltd'),(1096,'made'),(1097,'many'),(1098,'may'),(1099,'me'),(1100,'meanwhile'),(1101,'might'),(1102,'mill'),(1103,'mine'),(1104,'more'),(1105,'moreover'),(1106,'most'),(1107,'mostly'),(1108,'move'),(1109,'much'),(1110,'must'),(1111,'my'),(1112,'myself'),(1113,'name'),(1114,'namely'),(1115,'neither'),(1116,'never'),(1117,'nevertheless'),(1118,'next'),(1119,'nine'),(1120,'no'),(1121,'nobody'),(1122,'none'),(1123,'noone'),(1124,'nor'),(1125,'not'),(1126,'nothing'),(1127,'now'),(1128,'nowhere'),(1129,'of'),(1130,'off'),(1131,'often'),(1132,'on'),(1133,'once'),(1134,'one'),(1135,'only'),(1136,'onto'),(1137,'or'),(1138,'other'),(1139,'others'),(1140,'otherwise'),(1141,'our'),(1142,'ours'),(1143,'ourselves'),(1144,'out'),(1145,'over'),(1146,'own'),(1147,'part'),(1148,'per'),(1149,'perhaps'),(1150,'please'),(1151,'put'),(1152,'rather'),(1153,'re'),(1154,'same'),(1155,'see'),(1156,'seem'),(1157,'seemed'),(1158,'seeming'),(1159,'seems'),(1160,'serious'),(1161,'several'),(1162,'she'),(1163,'should'),(1164,'show'),(1165,'side'),(1166,'since'),(1167,'sincere'),(1168,'six'),(1169,'sixty'),(1170,'so'),(1171,'some'),(1172,'somehow'),(1173,'someone'),(1174,'something'),(1175,'sometime'),(1176,'sometimes'),(1177,'somewhere'),(1178,'still'),(1179,'such'),(1180,'system'),(1181,'take'),(1182,'ten'),(1183,'than'),(1184,'that'),(1185,'the'),(1186,'their'),(1187,'them'),(1188,'themselves'),(1189,'then'),(1190,'thence'),(1191,'there'),(1192,'thereafter'),(1193,'thereby'),(1194,'therefore'),(1195,'therein'),(1196,'thereupon'),(1197,'these'),(1198,'they'),(1199,'thickv'),(1200,'thin'),(1201,'third'),(1202,'this'),(1203,'those'),(1204,'though'),(1205,'three'),(1206,'through'),(1207,'throughout'),(1208,'thru'),(1209,'thus'),(1210,'to'),(1211,'together'),(1212,'too'),(1213,'top'),(1214,'toward'),(1215,'towards'),(1216,'twelve'),(1217,'twenty'),(1218,'two'),(1219,'un'),(1220,'under'),(1221,'until'),(1222,'up'),(1223,'upon'),(1224,'us'),(1225,'very'),(1226,'via'),(1227,'was'),(1228,'we'),(1229,'well'),(1230,'were'),(1231,'what'),(1232,'whatever'),(1233,'when'),(1234,'whence'),(1235,'whenever'),(1236,'where'),(1237,'whereafter'),(1238,'whereas'),(1239,'whereby'),(1240,'wherein'),(1241,'whereupon'),(1242,'wherever'),(1243,'whether'),(1244,'which'),(1245,'while'),(1246,'whither'),(1247,'who'),(1248,'whoever'),(1249,'whole'),(1250,'whom'),(1251,'whose'),(1252,'why'),(1253,'will'),(1254,'with'),(1255,'within'),(1256,'without'),(1257,'would'),(1258,'yet'),(1259,'you'),(1260,'your'),(1261,'yours'),(1262,'yourself'),(1263,'yourselves'),(1264,'1'),(1265,'2'),(1266,'3'),(1267,'4'),(1268,'5'),(1269,'6'),(1270,'7'),(1271,'8'),(1272,'9'),(1273,'10'),(1274,'1.'),(1275,'2.'),(1276,'3.'),(1277,'4.'),(1278,'5.'),(1279,'6.'),(1280,'11'),(1281,'7.'),(1282,'8.'),(1283,'9.'),(1284,'12'),(1285,'13'),(1286,'14'),(1287,'A'),(1288,'B'),(1289,'C'),(1290,'D'),(1291,'E'),(1292,'F'),(1293,'G'),(1294,'H'),(1295,'I'),(1296,'J'),(1297,'K'),(1298,'L'),(1299,'M'),(1300,'N'),(1301,'O'),(1302,'P'),(1303,'Q'),(1304,'R'),(1305,'S'),(1306,'T'),(1307,'U'),(1308,'V'),(1309,'W'),(1310,'X'),(1311,'Y'),(1312,'Z'),(1313,'terms'),(1314,'CONDITIONS'),(1315,'conditions'),(1316,'values'),(1317,'interested.'),(1318,'care'),(1319,'sure'),(1320,'.'),(1321,'!'),(1322,'@'),(1323,'#'),(1324,'$'),(1325,'%'),(1326,'^'),(1327,'&'),(1328,'*'),(1329,'('),(1330,')'),(1331,'{'),(1332,'}'),(1333,'['),(1334,']'),(1335,':'),(1336,';'),(1337,','),(1338,'<'),(1339,'.'),(1340,'>'),(1341,'/'),(1342,'?'),(1343,'_'),(1344,'-'),(1345,'+'),(1346,'='),(1347,'a'),(1348,'b'),(1349,'c'),(1350,'d'),(1351,'e'),(1352,'f'),(1353,'g'),(1354,'h'),(1355,'i'),(1356,'j'),(1357,'k'),(1358,'l'),(1359,'m'),(1360,'n'),(1361,'o'),(1362,'p'),(1363,'q'),(1364,'r'),(1365,'s'),(1366,'t'),(1367,'u'),(1368,'v'),(1369,'w'),(1370,'x'),(1371,'y'),(1372,'z'),(1373,'contact'),(1374,'grounds'),(1375,'buyers'),(1376,'tried'),(1377,'said,'),(1378,'plan'),(1379,'value'),(1380,'principle.'),(1381,'forces'),(1382,'sent:'),(1383,'is,'),(1384,'was'),(1385,'like'),(1386,'discussion'),(1387,'tmus'),(1388,'diffrent.'),(1389,'layout'),(1390,'area.'),(1391,'thanks'),(1392,'thankyou'),(1393,'hello'),(1394,'bye'),(1395,'rise'),(1396,'fell'),(1397,'fall'),(1398,'psqft.'),(1399,'http://'),(1400,'km'),(1401,'miles');
/*!40000 ALTER TABLE `stopwords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storekeyword`
--

DROP TABLE IF EXISTS `storekeyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storekeyword` (
  `id` int(11) NOT NULL,
  `keyWord` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storekeyword`
--

LOCK TABLES `storekeyword` WRITE;
/*!40000 ALTER TABLE `storekeyword` DISABLE KEYS */;
/*!40000 ALTER TABLE `storekeyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storewords`
--

DROP TABLE IF EXISTS `storewords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storewords` (
  `Id` int(11) NOT NULL,
  `words` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storewords`
--

LOCK TABLES `storewords` WRITE;
/*!40000 ALTER TABLE `storewords` DISABLE KEYS */;
/*!40000 ALTER TABLE `storewords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentregister`
--

DROP TABLE IF EXISTS `studentregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentregister` (
  `regid` int(20) NOT NULL AUTO_INCREMENT,
  `studid` varchar(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`regid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentregister`
--

LOCK TABLES `studentregister` WRITE;
/*!40000 ALTER TABLE `studentregister` DISABLE KEYS */;
INSERT INTO `studentregister` VALUES (1,'sdgcg','cvgxc','xcvxcv','xcvxc',1,'cxvxc','3'),(2,'as',NULL,NULL,NULL,NULL,NULL,NULL),(3,'1234','San','Santhosh','Santhosh',1,'sa@g.com','MCA'),(4,'1','san','san','san',1,'santhoshlfms@gmail.com','ME'),(5,'2001','Santhosh','san','san',1,'santhoshlfms@gmail.com','ME'),(6,'2005','san','sans','sans',1,'santhoshlfms@gmail.com','ME');
/*!40000 ALTER TABLE `studentregister` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-28  2:25:59
