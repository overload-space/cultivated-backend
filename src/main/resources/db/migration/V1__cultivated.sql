create table `user`
(
  `id`           bigint(20) unsigned not null auto_increment comment '主键',
  `wechat_id`    bigint(20)          not null default 0 comment '用户微信id',
  `username`     varchar(200)        not null default '' comment '用户名称',
  `role`         varchar(200)        not null default '' comment '管理员:0,普通用户:1,按权限角色划分',
  `activity_num` bigint(20)          not null default 0 comment '活跃度',
  `create_time`  timestamp           not null default current_timestamp comment '创建时间',
  `update_time`  timestamp           not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key (`wechat_id`)
) engine = innodb
  auto_increment = 1
  default charset = utf8 comment ='用户列表';

create table `group`
(
  `id`          bigint(20) unsigned not null auto_increment comment '主键',
  `group`       varchar(200)        not null default '' comment '组名称',
  `type`        varchar(200)        not null default '' comment '组类别: 单词组, 试题组',
  `create_time` timestamp           not null default current_timestamp comment '创建时间',
  `update_time` timestamp           not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key (`group`)
) engine = innodb
  auto_increment = 1
  default charset = utf8 comment ='分组';

create table `word`
(
  `id`          bigint(20) unsigned not null auto_increment comment '主键',
  `word`        varchar(200)        not null default '' comment '单词',
  `create_time` timestamp           not null default current_timestamp comment '创建时间',
  `update_time` timestamp           not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key (`word`)
) engine = innodb
  auto_increment = 1
  default charset = utf8 comment ='单词';

create table `definition`
(
  `id`          bigint(20) unsigned not null auto_increment comment '主键',
  `word`        varchar(200)        not null default '' comment '单词',
  `definition`  varchar(200)        not null default '' comment '词意',
  `pos`         varchar(200)        not null default '' comment '词性',
  `create_time` timestamp           not null default current_timestamp comment '创建时间',
  `update_time` timestamp           not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key (`word`, `definition`, `pos`),
  foreign key (`word`) references `word` (`word`) on delete cascade on update cascade
) engine = innodb
  auto_increment = 1
  default charset = utf8 comment ='单词词意';

create table `word_group`
(
  `id`          bigint(20) unsigned not null auto_increment comment '主键',
  `word`        varchar(200)        not null default '' comment '单词',
  `group`       varchar(200)        not null default '' comment '分组',
  `create_time` timestamp           not null default current_timestamp comment '创建时间',
  `update_time` timestamp           not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key (`word`, `group`),
  foreign key (`word`) references `word` (`word`) on delete cascade on update cascade,
  foreign key (`group`) references `group` (`group`) on delete cascade on update cascade
) engine = innodb
  auto_increment = 1
  default charset = utf8 comment ='词与组';