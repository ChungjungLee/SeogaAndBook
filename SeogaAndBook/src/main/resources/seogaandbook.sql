-- 회원
DROP TABLE sab_members;
CREATE TABLE sab_members(
	memberNum	NUMBER,
	id			VARCHAR2(10),
	password	VARCHAR2(10) CONSTRAINT sab_members_NN_password NOT NULL,
	email		VARCHAR2(30),
	phone		VARCHAR2(11) CONSTRAINT sab_members_NN_phone NOT NULL,
	CONSTRAINT sab_members_PK 			PRIMARY KEY(memberNum),
	CONSTRAINT sab_members_UK_id 		UNIQUE(id),
	CONSTRAINT sab_members_UK_email 	UNIQUE(email)
);

DROP SEQUENCE sab_members_SEQ; 
CREATE SEQUENCE sab_members_SEQ;


-- 작가
DROP TABLE sab_authors;
CREATE TABLE sab_authors(
	authorNum		NUMBER,
	name			VARCHAR2(60) CONSTRAINT sab_authors_NN_name NOT NULL,
	introduction	VARCHAR2(1000),
	CONSTRAINT sab_authors_PK	PRIMARY KEY(authorNum)
);

DROP SEQUENCE sab_authors_SEQ;
CREATE SEQUENCE sab_authors_SEQ;


-- 출판사
DROP TABLE sab_publishers;
CREATE TABLE sab_publishers(
	publisherNum		NUMBER,
	name			VARCHAR2(60) CONSTRAINT sab_publishers_NN_name NOT NULL,
	CONSTRAINT sab_publishers_PK PRIMARY KEY(publisherNum)
);

DROP SEQUENCE sab_publishers_SEQ;
CREATE SEQUENCE sab_publishers_SEQ;


-- 카테고리
DROP TABLE sab_categories;
CREATE TABLE sab_categories(
	categoryNum		NUMBER,
	name			VARCHAR2(30) CONSTRAINT sab_categories_NN_name NOT NULL,
	parentNum		NUMBER,
	CONSTRAINT sab_categories_PK PRIMARY KEY(categoryNum)
);

DROP SEQUENCE sab_categories_SEQ;
CREATE SEQUENCE sab_categories_SEQ;


-- 책
DROP TABLE sab_books;
CREATE TABLE sab_books(
	isbn13			NUMBER(13),
	title			VARCHAR2(150) CONSTRAINT sab_books_NN_title NOT NULL,
	introduction	VARCHAR2(3000) CONSTRAINT sab_books_NN_intro NOT NULL,
	categoryNum		NUMBER,
	publisherNum	NUMBER,
	authorNum		NUMBER,
	CONSTRAINT sab_books_PK PRIMARY KEY(isbn13),
	CONSTRAINT sb_sc_FK		FOREIGN KEY(categoryNum) 
							REFERENCES sab_categories(categoryNum) ON DELETE CASCADE,
	CONSTRAINT sb_sp_FK		FOREIGN KEY(publisherNum)
							REFERENCES sab_publishers(publisherNum) ON DELETE CASCADE,
	CONSTRAINT sb_sa_FK		FOREIGN KEY(authorNum)
							REFERENCES sab_authors(authorNum) ON DELETE CASCADE
);


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


-- 서평
DROP TABLE sab_reviews;
CREATE TABLE sab_reviews(
	reviewNum	NUMBER,
	isbn13		NUMBER,
	memberNum	NUMBER,
	title		VARCHAR2(150) CONSTRAINT sab_reviews_NN_title NOT NULL,
	content		VARCHAR2(3000) CONSTRAINT sab_reviews_NN_content NOT NULL,
	indate		DATE 	DEFAULT SYSDATE,
	views		NUMBER	DEFAULT 0,
	hits		NUMBER 	DEFAULT 0,
	CONSTRAINT sab_reviews_PK 	PRIMARY KEY(reviewNum),
	CONSTRAINT srev_sb_FK		FOREIGN KEY(isbn13)
								REFERENCES sab_books(isbn13) ON DELETE CASCADE,
	CONSTRAINT srev_sm_FK		FOREIGN KEY(memberNum)
								REFERENCES sab_members(memberNum) ON DELETE CASCADE
);

DROP SEQUENCE sab_reviews_SEQ;
CREATE SEQUENCE sab_reviews_SEQ;


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


-- 질문
DROP TABLE sab_questions;
CREATE TABLE sab_questions(
	questionNum		NUMBER,
	memberNum		NUMBER,
	title			VARCHAR2(150)	CONSTRAINT sab_questions_NN_title NOT NULL,
	content			VARCHAR2(3000)	CONSTRAINT sab_questions_NN_content NOT NULL,
	indate			DATE			DEFAULT SYSDATE,
	views			NUMBER			DEFAULT 0,
	CONSTRAINT sab_questions_PK		PRIMARY KEY(questionNum),
	CONSTRAINT sq_sm_FK				FOREIGN KEY(memberNum)
									REFERENCES sab_members(memberNum) ON DELETE CASCADE
);

DROP SEQUENCE sab_questions_SEQ;
CREATE SEQUENCE sab_questions_SEQ;


-- 답변
DROP TABLE sab_answers;
CREATE TABLE sab_answers(
	answerNum		NUMBER,
	questionNum		NUMBER,
	memberNum		NUMBER,
	content			VARCHAR2(1000) CONSTRAINT sab_answers_NN_content NOT NULL,
	indate			DATE	DEFAULT SYSDATE,
	hits			NUMBER	DEFAULT 0,
	CONSTRAINT sab_answers_PK			PRIMARY KEY(answerNum),
	CONSTRAINT sa_sq_FK		FOREIGN KEY(questionNum)
							REFERENCES sab_questions(questionNum) ON DELETE CASCADE,
	CONSTRAINT sa_sm_FK		FOREIGN KEY(memberNum)
							REFERENCES sab_members(memberNum) ON DELETE CASCADE
);

DROP SEQUENCE sab_answers_SEQ;
CREATE SEQUENCE sab_answers_SEQ;


-- 독서 기록
DROP TABLE sab_readingHistories;
CREATE TABLE sab_readingHistories(
	historyNum	NUMBER,
	memberNum	NUMBER,
	isbn13		NUMBER,
	CONSTRAINT sab_readHis_PK PRIMARY KEY(historyNum),
	CONSTRAINT srh_sm_FK	FOREIGN KEY(memberNum)
							REFERENCES sab_members(memberNum) ON DELETE CASCADE,
	CONSTRAINT srh_sb_FK	FOREIGN KEY(isbn13)
							REFERENCES sab_books(isbn13) ON DELETE CASCADE
);

DROP SEQUENCE sab_readingHistories_SEQ;
CREATE SEQUENCE sab_readingHistories_SEQ;

