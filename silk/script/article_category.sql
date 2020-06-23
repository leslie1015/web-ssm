create table article_category (
id                int(10) primary key not null auto_increment,
category_name     varchar(100) not null comment '分类名',
active_flag       int(1) comment '是否启用。0否1是',
order_num         int(3) comment '排序，从小到大'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='文章分类表';

----------------
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (1, '测试栏目名1', 1, 6);
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (2, '测试栏目名2', 1, 2);
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (3, '测试栏目名3', 1, 9);
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (4, '测试栏目名称4', 1, 5);
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (5, '测试栏目名5', 1, 20);
INSERT INTO cms.article_category (id, category_name, active_flag, order_num) VALUES (6, '测试栏目名6', 1, 4);