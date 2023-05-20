create table user
(
    id            int auto_increment,
    time          long not null,
    ip            text not null,
    userName      time not null,
    userPassword  text not null,
    userSignature text not null comment '用户签名',
    constraint user_pk
        primary key (id)
)
    comment '用户表';

create unique index user_id_uindex
    on user (id);