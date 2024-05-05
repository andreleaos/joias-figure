CREATE TABLE `tb_cliente` (
    `codigo_cliente` varchar(255) NOT NULL,
    `cliente_esta_ativo` bit(1) NOT NULL,
    `nome_cliente` varchar(255) DEFAULT NULL,
    `cpf_cliente` varchar(255) DEFAULT NULL,
    `email_cliente` varchar(255) DEFAULT NULL,
    `fone_cliente` varchar(255) DEFAULT NULL,
    `rg_cliente` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`codigo_cliente`)
);

CREATE TABLE `tb_produto` (
    `codigo_produto` bigint NOT NULL AUTO_INCREMENT,
    `nome_produto` varchar(100) DEFAULT NULL,
    `preco_produto` double NOT NULL,
    PRIMARY KEY (`codigo_produto`)
);

CREATE TABLE `tb_status_pedido` (
    `codigo_status_pedido` int NOT NULL,
    `descricao_status_pedido` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`codigo_status_pedido`)
);

CREATE TABLE `tb_pedido` (
     `codigo_pedido` bigint NOT NULL AUTO_INCREMENT,
     `codigo_cliente` varchar(36) DEFAULT NULL,
     `data_cadastro` date DEFAULT NULL,
     `data_atualizacao` date DEFAULT NULL,
     `codigo_status_pedido` int DEFAULT NULL,
     `valor_total_pedido` double NOT NULL,
     PRIMARY KEY (`codigo_pedido`)
);

CREATE TABLE `tb_item_pedido` (
  `codigo_item_pedido` bigint NOT NULL AUTO_INCREMENT,
  `codigo_pedido` bigint DEFAULT NULL,
  `codigo_produto` bigint DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`codigo_item_pedido`)
);
