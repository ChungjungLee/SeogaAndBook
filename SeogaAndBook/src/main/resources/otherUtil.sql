
	
-- 계층형 쿼리를 이용한 카테고리 불러오기
SELECT
    LEVEL,
    LPAD(' ', 2*(LEVEL-1)) || name as name,
    categoryNum,
    parentNum
FROM
    sab_categories
START WITH
    parentNum IS NULL   -- root node
CONNECT BY PRIOR
    categoryNum = parentNum;-- set parent and child rel

-- resource busy 해결
SELECT
	o.object_name, s.sid, s.serial#,
	p.spid, s.program, s.username, s.machine,
	s.port, s.logon_time, sq.sql_fulltext
FROM
	v$locked_object l, dba_objects o, v$session s,
	v$process p, v$sql sq
WHERE
	l.object_id = o.object_id
	AND l.session_id = s.sid
	AND s.paddr = p.addr
	AND s.sql_address = sq.address;
	

-- 현재 테이블의 정보를 복사해서 불리기
INSERT INTO sab_questions
	(questionNum, memberNum, title, content)
SELECT
	sab_questions_SEQ.nextval, memberNum, title, content
FROM
	sab_questions;


	
-- 서평 리플
DROP TABLE sab_replies;
CREATE TABLE sab_replies(
	replyNum	NUMBER,
	reviewNum	NUMBER,
	memberNum	NUMBER,
	indate		DATE DEFAULT SYSDATE,
	parentNum	NUMBER,
	CONSTRAINT sab_replies_PK	PRIMARY KEY(replyNum),
	CONSTRAINT srep_srev_FK		FOREIGN KEY(reviewNum)
								REFERENCES sab_reviews(reviewNum) ON DELETE CASCADE,
	CONSTRAINT srep_sm_FK		FOREIGN KEY(memberNum)
								REFERENCES sab_members(memberNum) ON DELETE CASCADE
); 

DROP SEQUENCE sab_replies_SEQ;
CREATE SEQUENCE sab_replies_SEQ;


-- 독서 기록
DROP TABLE sab_readingHistories;
CREATE TABLE sab_readingHistories(
	historyNum	NUMBER,
	memberNum	NUMBER,
	isbn13		NUMBER(13),
	CONSTRAINT sab_readHis_PK PRIMARY KEY(historyNum),
	CONSTRAINT srh_sm_FK	FOREIGN KEY(memberNum)
							REFERENCES sab_members(memberNum) ON DELETE CASCADE,
	CONSTRAINT srh_sb_FK	FOREIGN KEY(isbn13)
							REFERENCES sab_books(isbn13) ON DELETE CASCADE
);

DROP SEQUENCE sab_readingHistories_SEQ;
CREATE SEQUENCE sab_readingHistories_SEQ;



-- 한 줄 평 테이블
DROP TABLE sab_comments;
CREATE TABLE sab_comments(
	commentNum		NUMBER,
	isbn13			NUMBER(13),
	memberNum		NUMBER,
	onelineReview	VARCHAR2(300)	CONSTRAINT sab_comments_NN_comment NOT NULL,
	indate			DATE 			DEFAULT SYSDATE,
	score			NUMBER 			DEFAULT 0,
	CONSTRAINT sab_comments_PK	PRIMARY KEY(commentNum),
	CONSTRAINT sc_sb_FK			FOREIGN KEY(isbn13)
								REFERENCES sab_books(isbn13) ON DELETE CASCADE,
	CONSTRAINT sc_sm_FK			FOREIGN KEY(memberNum)
								REFERENCES sab_members(memberNum) ON DELETE CASCADE
);

DROP SEQUENCE sab_comments_SEQ;
CREATE SEQUENCE sab_comments_SEQ;
