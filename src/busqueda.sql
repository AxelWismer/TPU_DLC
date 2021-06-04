DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `words` int DEFAULT NULL,
  `iddoc` int NOT NULL,
  PRIMARY KEY (`id`)
) ;

LOCK TABLES `documento` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `termino`;
CREATE TABLE `termino` (
  `idTermino` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `MaxTf` int DEFAULT NULL,
  `iddoc` int DEFAULT NULL,
  `cantdoc` int DEFAULT NULL,
  `idword` int NOT NULL,
  PRIMARY KEY (`idTermino`)
) ;


LOCK TABLES `termino` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `terminoxdocumento`;
CREATE TABLE `terminoxdocumento` (
  `idtxd` int NOT NULL AUTO_INCREMENT,
  `idT` int DEFAULT NULL,
  `idD` int DEFAULT NULL,
  `tf` int DEFAULT NULL,
  PRIMARY KEY (`idtxd`)
) ;


LOCK TABLES `terminoxdocumento` WRITE;

UNLOCK TABLES;

