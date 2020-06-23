create table article_audit_log (
article_id       int(10) not null,
audit_status     int(2) not null comment '审核状态',
status_desc      varchar(50) comment '状态描述',
audit_advice     varchar(200) comment '审核意见',
audit_name       varchar(200) comment '审核人名称',
audit_time       date comment '审核时间',
audit_id        int(10) comment '审核人id'
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment='审核记录表';

