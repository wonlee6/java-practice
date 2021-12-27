INSERT INTO article(id, title, content) VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES (2, '나나나나', '2222');
INSERT INTO article(id, title, content) VALUES (3, '다다다다', '3333');

-- article 더미 데이터 추가
INSERT INTO article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES (5, '좋아하는 음식은?', '댓글 ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '공부하고 있는 프로그래밍 언어는?', '댓글 ㄱㄲㄱ');

-- comment 더미 데이터 추가
-- 4번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'park', '굿 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'kim', '스파이더맨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'saki', '라라랜드');

-- 5번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'kim', '물회');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'saki', '초밥');

-- 6번 게시물 댓글
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'park', '리액트');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'kim', '자바스크립트');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'saki', '자바');