insert into produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com preço exclusivo');
insert into produto (id, nome, preco, descricao) values (3, 'Poco X5 Pro', 1.500, 'Conheça o novo XIOME de 2023');

insert into cliente (id, nome) values (1, "Marcelo Viana");
insert into cliente (id, nome) values (2, "Samuel Viana");
insert into cliente (id, nome) values (4, "Rucelio Pao");

insert into pedido (id, cliente_id, data_pedido, total, status) values (1, 1, sysdate(), 100.0, 'AGUARDANDO');
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);
