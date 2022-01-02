--테이블/시퀀스 삭제
drop table person;
drop sequence seq_person_id;


--테이블 생성 person table
create table person(
    person_id  number(5),
    name varchar2(30) not null,
    hp varchar2(20),
    company varchar2(20),
    primary key(person_id)
);

--시퀀스 생성 seq_person_id
create sequence seq_person_id
increment by 1
start with 1;


--테이블/시퀀스 조회
select * from person;
select * from user_sequences;


--insert문
insert into person
values(seq_person_id.nextval, '이효리', '010-1111-1111', '02-1111-1111');

insert into person
values(seq_person_id.nextval, '정우성', '010-2222-2222', '02-2222-2222');

insert into person
values(seq_person_id.nextval, '유재석', '010-3333-3333', '02-3333-3333');

insert into person
values(seq_person_id.nextval, '이정재', '010-4444-4444', '02-4444-4444');

insert into person
values(seq_person_id.nextval, '서장훈', '010-5555-5555', '02-5555-5555');

select * 
from person;


--update/ delete문
update person
set name = '유정재',
    hp = '010-9999-9999',
    company = '02-9999-9999'
where person_id = 4;

delete from person
where person_id = 5;

--검색하기
select name,
       hp,
       company
from person
where name like '%유%'
or hp like '%5%'
or company like '%1%';