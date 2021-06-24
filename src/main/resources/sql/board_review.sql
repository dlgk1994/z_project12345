create table board_review (
  review_no number(10) primary key,
  review_content VARCHAR2(500),
  review_score number(10),
  org_file_name VARCHAR2(500),
  save_file_name VARCHAR2(500),
  review_id VARCHAR2(100),
  review_writedate date default sysdate
);

create sequence review_seq;