-- 1. Inserindo Usuários (TB_USER)
INSERT INTO tb_user (id, name, email, password) VALUES (1, 'Shinji Ikari', 'shinji@nerv.com', '123456');
INSERT INTO tb_user (id, name, email, password) VALUES (2, 'Asuka Langley', 'asuka@nerv.com', '123456');
INSERT INTO tb_user (id, name, email, password) VALUES (3, 'Rei Ayanami', 'rei@nerv.com', '123456');

-- 2. Inserindo Produtos (TB_PRODUCT)
-- Os nomes das colunas seguem o padrão snake_case (imgUrl -> img_url)
INSERT INTO tb_product (id, name, description, price, img_url, stock_quantity) VALUES (1, 'Eva Unit-01 Model', 'Action figure detalhado do Eva 01', 450.00, 'url_img_01', 10);
INSERT INTO tb_product (id, name, description, price, img_url, stock_quantity) VALUES (2, 'Nerv Coffee Mug', 'Caneca oficial da Nerv', 50.00, 'url_img_02', 100);
INSERT INTO tb_product (id, name, description, price, img_url, stock_quantity) VALUES (3, 'Plug Suit Interface', 'Interface de conexão neural', 1200.00, 'url_img_03', 5);
INSERT INTO tb_product (id, name, description, price, img_url, stock_quantity) VALUES (4, 'Progressive Knife', 'Réplica da faca progressiva', 300.00, 'url_img_04', 15);

-- 3. Inserindo Pedidos (TB_ORDER)
INSERT INTO tb_order (id, moment, order_status, client_id) VALUES (1, '2025-06-20T19:53:07Z', 1, 1); -- Pedido do Shinji
INSERT INTO tb_order (id, moment, order_status, client_id) VALUES (2, '2025-07-21T03:42:10Z', 2, 2); -- Pedido da Asuka
INSERT INTO tb_order (id, moment, order_status, client_id) VALUES (3, '2025-07-22T15:21:22Z', 1, 1); -- Outro pedido do Shinji

-- 4. Inserindo Itens de Pedido (TB_ORDER_ITEM)
-- Esta é a tabela de ligação (Muitos-para-Muitos com atributos extras)
-- A chave primária é composta por (order_id, product_id)

-- Itens do Pedido 1 (Shinji comprou 1 Eva-01 e 2 Canecas)
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 1, 1, 450.00);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 2, 2, 50.00);

-- Itens do Pedido 2 (Asuka comprou 1 Plug Suit)
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (2, 3, 1, 1200.00);

-- Itens do Pedido 3 (Shinji comprou 1 Faca Progressiva)
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (3, 4, 1, 300.00);