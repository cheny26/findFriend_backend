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

