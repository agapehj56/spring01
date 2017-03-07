--
-- sequence 생성
--
drop SEQUENCE MESSAGE_ID_SEQ;
create SEQUENCE message_id_seq START WITH 10000;

select message_id_seq.nextval from dual;

--
-- table 생성
--
drop table GUESTBOOK_MESSAGE;

create TABLE guestbook_message (
	message_id 	number primary KEY,
	guest_name	varchar2(50 CHAR) not null,
	password	varchar2(10 CHAR) not null,
	message 	long not null
);

SELECT * from GUESTBOOK_MESSAGE;

insert INTO GUESTBOOK_MESSAGE
 values
 (message_id_seq.nextval, 'xxx', '1234', 'hello...');