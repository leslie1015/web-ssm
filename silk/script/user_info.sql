create table user_info (
id                int(10) primary key not null auto_increment,
nickname     		  varchar(100) not null comment '昵称',
username          varchar(20) not null comment '用户名',
password          varchar(20) not null comment '密码',
phone	            varchar(20) comment '电话',
email						  varchar(50) comment '邮箱',
address					  varchar(300) comment '地址',
admin_flag				TINYINT(1) default 0 not null comment '是否管理员。0否1是',
STATUS						TINYINT(20) default 0 not null comment '状态。0正常，1冻结',
delete_flag				TINYINT(20) default 0 not null comment '是否删除。0否1是',
create_time				DATETIME comment '注册时间',
update_time				DATETIME comment '修改时间',
update_no				  varchar(20) comment '修改人ID',
update_name				varchar(20) comment '修改人用户名',
last_time				  DATETIME    comment '最后登录时间',
last_ip                 varchar(30) comment '最后登录IP'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='用户表';

