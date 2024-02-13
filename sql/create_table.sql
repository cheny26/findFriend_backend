-- 用户表
create table user
(
    id           bigint auto_increment comment 'id'    primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    phone        varchar(128)                           null comment '电话',
    email        varchar(128)                           null comment '邮箱',
    gender       int                                    null comment '0-男，1-女',
    tags         varchar(1024)                          null comment '用户标签',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '用户' collate = utf8mb4_unicode_ci;

-- 标签表
create table if not exists tags
(
    id           bigint auto_increment comment 'id' primary key,
    tagName      varchar(256)                           not null comment '标签名',
    userId       bigint                                 null comment '上传标签的用户id',
    parentId     bigint                                 null comment '父标签id',
    isParent     tinyint default 0                      not null comment '0 不是父标签、1父标签',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '标签' collate = utf8mb4_unicode_ci;

-- 队伍表
create table team
(
    id              bigint auto_increment comment 'id' primary key,
    teamName        varchar(256)                       not null comment '队伍名称',
    teamDescription varchar(1024)                      null comment '描述',
    maxNum          int      default 1                 not null comment '最大人数',
    expireTime      datetime                           null comment '过期时间',
    userId          bigint                             null comment '用户id',
    teamStatus      int      default 0                 not null comment '0 - 公开，1 - 私有，2 - 加密',
    teamPassword    varchar(512)                       null comment '密码',
    createTime      datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime      datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete        tinyint  default 0                 not null comment '是否删除'
)
    comment '队伍';

-- 用户-队伍表
create table user_team
(
    id           bigint auto_increment comment 'id'
        primary key,
    userId            bigint comment '用户id',
    teamId            bigint comment '队伍id',
    joinTime datetime  null comment '加入时间',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0                 not null comment '是否删除'
)
    comment '用户队伍关系';