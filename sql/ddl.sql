drop table if exists member CASCADE;
create table member(
                       id bigint generated by default as identity,
                       name varchar(255),
                       primary key (id)
)  // 이런식으로 sql 관리