
-- AI 분류 테이블
CREATE TABLE CATEGORY_AI (
	CATEGORY_CODE INT(2) NOT NULL,
	CATEGORY_NAME VARCHAR(20) NOT NULL 
);

-- AI 스크립트  테이블
CREATE TABLE AI_SCRIPT (
	CATEGORY_CODE INT(2) NOT NULL,
	CONTENT VARCHAR(300) NOT NULL,
	IDX INT(10) unsigned NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (IDX)
);

-- AI 분류 테이블
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(1, 'GREETING_MORNING');
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(2, 'GREETING_AFTERNOON');
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(3, 'GREETING_NIGHT');
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(4, 'INTEREST');
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(5, 'PROMOTION');
INSERT CATEGORY_AI (CATEGORY_CODE, CATEGORY_NAME) Values(6, 'CHEER');

-- AI 스크립트 내용 테이블
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, '안녕하세요? 반가워요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, '오늘도 좋은 하루 되세요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, '좋은 아침이에요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, '하루를 기분좋게 시작하는 것은 어떨까요?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, '오늘도 화이팅!');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(2, '맛있는 점심 시간 되세요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(2, '오늘 날씨가 좋다면 산책하는 건 어떨까요?');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(3, '저녁은 즐겁게 사랑하는 사람과~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(3, '열심히 하루를 보낸 당신, 저녁먹고 힘을 내요!');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(3, '우리는 먹기 위해 사는거죠? ㅋㅋㅋ');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '당신은 삶에서 가장 중요하게 여기는게 무엇인가요?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '당신은 세상에서 사랑을 가장 중요히 여기는 군요. 멋져요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '당신은 일에 열심히네요~ 가끔은 쉬엄쉬엄 하는게 어때여?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '당신은 자기계발에 많이 투자하는군요. 대단해요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '가족과 함께 시간을 보내는 건 정말 행복한거에요.');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '운동하는 당신, 땀은 절대로 거짓말을 하지 않는다고 믿어요.');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '공부는 죽을때까지~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(4, '재테크는 어떻게 하는 건가요? 한수 가르쳐주시죠~!');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '가지를 공유하는 법은 간단해요! 내가 이룬 꿈가지 중에 하나를 꾹 눌러요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '다른 사람들의 버킷이 궁금하시면 세상의 가지들을 확인해볼까요?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '다른 사람의 버킷에 댓글을 달수 있어요. 알고 있었나요?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '내가 공유한 버킷에 다른 사람들의 댓글을 확인할 수 있어요.');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '만족스럽지 않은 결과라도 후에는 열심히했다고, 후회는 하지 않다는다고 생각하는 삶을 살아요!');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '힘힘!!');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '내꿈을 찾아서 가자~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '익숙함에 속아 소중함을 잃지 말아요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '지나간 일에 후회말고 앞으로의 일을 후회없이 살아요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '나는 행복해질꼬에욤');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '노력한 만큼 결과가 찾아올꺼에요');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '이 또한 지나가리라');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '맨날 하루에  한번씩 자기 자신을 꼭 생각하기');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '나는 나만의 길을 간다! 남의 시선이나 방식 생각하지 말아요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, 'It is not the end of the world, it is not even the end of the day');


-- AI 스크립트 내용 테이블 2
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(1, 'Good Morning~');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(2, '밥을 먹고 힘을 냅시다! ^^');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(2, '점심 시간, 하루 15분이라도 자기 자신에게 투자해보세요.');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '당신의 소망이 모이는 곳은 어디라구요? 가지입니다~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '환경설정에 가면 튜토리얼이 있어요. 앱을 아직 잘 모르시겠다면 튜토리얼을 한번 확인해보시는건 어때요?');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '당신이 원하는 대로 App을 개선시킬 수 있어요. 환경설정에 문의하기로 희망사항을 보내주세요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(5, '암호를 설정하여 다른 사람이 핸드폰을 만질때에는 나의 가지를 비공개 해놓아요~');

INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '함께~~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '힘들어도 언젠간 끝난다. 시간은 계속 흐르니까 힘내요~');
INSERT AI_SCRIPT (CATEGORY_CODE, CONTENT) Values(6, '인생은 가까이에서 보면 비극, 멀리서 보면 희극이래요~');

