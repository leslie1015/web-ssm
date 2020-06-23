create table t_article (
id                int(10) primary key not null auto_increment,
article_title     varchar(200) not null  comment '文章标题',
sub_title         varchar(200) not null  comment '文章副标题',
type_id           int(10) not null  comment '文章分类ID，对应article_category.id',
type_name         varchar(100) comment '文章分类名称',
simple_intro      varchar(500) comment '简介',
content           longtext,
title_color       varchar(2) comment '标题颜色，默认黑色。0黑色，1红色，2蓝色，3绿色',
bold_flag         tinyint(1) comment '标题是否加粗。0否，1是',
review_flag       tinyint(1) default 1 comment '是否允许评论。0否，1是',
top_flag          tinyint(1)  comment '文章是否置顶。0否1是',
ad_flag           tinyint(1)  comment '是否广告。0否1是',
delete_flag       tinyint(1) default 0 comment '是否删除。0否1是',
recommend_flag    tinyint(1) comment '是否推荐。0否1是',
keyword           varchar(100) comment '关键字',
status            tinyint(1) comment '1草稿，2待审核，3审核通过，4返回修改，5拒绝通过',
delete_no         varchar(50) comment '删除人编号',
delete_name       varchar(50) comment '删除人姓名',
delete_time       DATETIME comment '删除时间',
add_no            varchar(50) default '000001' not null comment '添加人编号',
add_name          varchar(50) default 'system' not null comment '添加人姓名',
add_time          DATETIME not null comment '添加时间',
update_no         varchar(50) comment '修改人编号',
update_name       varchar(50) comment '修改人姓名',
update_time       DATETIME comment '修改时间'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='文章表';


