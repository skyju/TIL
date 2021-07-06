-- STEP 01 : SELECT 

-- SELECT 1. 모든 레코드 조회하기
SELECT ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- SELECT 2. 역순 정렬하기
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;

-- SELECT 3. 아픈 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION='Sick'
ORDER BY ANIMAL_ID;

-- SELECT 4. 어린 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;

-- SELECT 5. 동물의 아이디와 이름
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- SELECT 6. 여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;

-- SELECT 7. 상위 n개 레코드
SELECT NAME
FROM (SELECT NAME FROM ANIMAL_INS ORDER BY DATETIME)
WHERE ROWNUM = 1 ;