----<ScriptOptions statementTerminator=";"/>
SHOW Databases;

use kiki;----<ScriptOptions statementTerminator=";"/>

--테이블 생성
--CREATE TABLE BOARD (
--	TITLE VARCHAR(255) NOT NULL,
--	CONTENT VARCHAR(255) NOT NULL,
--);


--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST1', '내용 테스트입니다1');
--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST2', '내용 테스트입니다2');
--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST3', '내용 테스트입니다3');
--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST4', '내용 테스트입니다4');
--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST5', '내용 테스트입니다5');
--INSERT BOARD (TITLE, CONTENT, BOARD_DATE) Values('TEST8', '내용 테스트입니다8');

select * from board;

--delete from board where idx = 5;
--현재 시간으로 날짜 입력
--update BOARD set BOARD_DATE = date_format(now(),'2015-07-18 09:39:00');

update board set title = 'TEEST14' , content = '테스트 14번 입니다' where idx = '14';

--테이블 변경
--ALTER table board  add ( idx integer NOT NULL auto_increment primary key  );

--칼럼명 수정
--alter table BOARD change idx IDX integer;

--테이블 칼럼 삭제
--alter table board drop  IDX   

--PRIMARY KEY 추가
--ALTER TABLE BOARD ADD PRIMARY KEY (IDX);

--ALTER table board  add ( IDx integer NOT NULL auto_increment primary key  )

