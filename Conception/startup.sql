DROP TABLE CANDIDAT_COMPETENCE;
DROP TABLE EQUIPE_CANDIDAT;
DROP TABLE CANDIDAT;
DROP TABLE EQUIPE;
DROP TABLE COMPETENCE;


INSERT INTO COMPETENCE VALUES (1, 'Développeur JAVA', 'DevJava');
INSERT INTO COMPETENCE VALUES (2, 'Développeur C', 'DevC');
INSERT INTO COMPETENCE VALUES (3, 'Développeur PHP', 'DevPHP');
INSERT INTO COMPETENCE VALUES (4, 'Développeur C++', 'DevC++');
INSERT INTO COMPETENCE VALUES (5, 'Développeur Javascript', 'DevJavaScript');
INSERT INTO COMPETENCE VALUES (6, 'Scrum master', 'Scrum');

INSERT INTO EQUIPE VALUES (1, 'Ekip667');
INSERT INTO EQUIPE VALUES (2, 'Equipe2');
INSERT INTO EQUIPE VALUES (3, 'LaTeam');

INSERT INTO CANDIDAT VALUES (1, 'Collaborateur', 'Dias', 'Nathan', 0, 0, 1);
INSERT INTO CANDIDAT VALUES (2, 'Collaborateur', 'aaa', 'zzz', 0, 0, 1);
INSERT INTO CANDIDAT VALUES (3, 'Collaborateur', 'bbb', 'yyy', 1, 0, 2);
INSERT INTO CANDIDAT VALUES (4, 'Collaborateur', 'ccc', 'xxx', 1, 1, 2);
INSERT INTO CANDIDAT VALUES (5, 'Collaborateur', 'ddd', 'www', 0, 1, 2);

INSERT INTO EQUIPE_CANDIDAT VALUES (1, 1);
INSERT INTO EQUIPE_CANDIDAT VALUES (1, 2);
INSERT INTO EQUIPE_CANDIDAT VALUES (2, 3);
INSERT INTO EQUIPE_CANDIDAT VALUES (2, 4);
INSERT INTO EQUIPE_CANDIDAT VALUES (2, 5);

INSERT INTO CANDIDAT_COMPETENCE VALUES (1, 1);
INSERT INTO CANDIDAT_COMPETENCE VALUES (2, 1);
INSERT INTO CANDIDAT_COMPETENCE VALUES (6, 1);
INSERT INTO CANDIDAT_COMPETENCE VALUES (1, 2);
INSERT INTO CANDIDAT_COMPETENCE VALUES (1, 3);
INSERT INTO CANDIDAT_COMPETENCE VALUES (6, 3);
INSERT INTO CANDIDAT_COMPETENCE VALUES (2, 4);
INSERT INTO CANDIDAT_COMPETENCE VALUES (4, 4);
INSERT INTO CANDIDAT_COMPETENCE VALUES (3, 5);
INSERT INTO CANDIDAT_COMPETENCE VALUES (4, 5);
INSERT INTO CANDIDAT_COMPETENCE VALUES (5, 5);