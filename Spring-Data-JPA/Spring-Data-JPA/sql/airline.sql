-- CREATE TABLE IF NOT EXISTS info_airline
-- (
--     airline_no INT PRIMARY KEY AUTO_INCREMENT COMMENT '항공번호',
--     airline_name VARCHAR(30) NOT NULL COMMENT '항공사 이름',
--     flight_code INT NOT NULL COMMENT '비행 코드'
--     CONSTRAINT fk_flight_code FOREIGN  KEY (flight_code) REFERENCES info_flight (flight_code)
-- ) ENGINE=INNODB COMMENT 'J 항공사';
--
-- CREATE TABLE IF NOT EXISTS info_flight
-- (
--     flight_code INT PRIMARY KEY AUTO_INCREMENT COMMENT '비행 코드',
--     flight_date LOCAL DATE NOT NULL,
--     destination VARCHAR (50) NOT NULL,
--     ticket_price DOUBLE NOT NULL,
--     depart_time LOCAL TIME NOT NULL,
--     arrival_time LOCAL TIME NOT NULL
-- ) ENGINE=INNODB COMMENT '비행 정보';

