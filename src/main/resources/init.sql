DROP TABLE IF EXISTS flights;

CREATE TABLE flights(
	id SERIAL PRIMARY KEY,
	company VARCHAR(20),
	estimated_departure TIMESTAMP,
	departure TIMESTAMP,
	arrival TIMESTAMP
);

INSERT INTO flights (company, estimated_departure, departure, arrival) VALUES
	('company 1', '2019-01-01 09:00:00', '2019-01-01 10:25:00', '2019-01-01 15:00:00'),
	('company 2', '2019-01-01 11:00:00', '2019-01-01 11:25:00', '2019-01-01 16:00:00'),
	('company 3', '2019-01-01 15:22:00', '2019-01-01 15:22:00', '2019-01-01 17:00:00');