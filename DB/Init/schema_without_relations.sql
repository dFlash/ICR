
CREATE TABLE icr.team_tool (
                tools_id INTEGER NOT NULL,
                team_id INTEGER NOT NULL,
                CONSTRAINT id_4 PRIMARY KEY (tools_id, team_id)
);


CREATE SEQUENCE icr.tool_id_seq;

CREATE TABLE icr.tool (
                id INTEGER NOT NULL DEFAULT nextval('icr.tool_id_seq'),
                name VARCHAR(100) NOT NULL,
                CONSTRAINT id_3 PRIMARY KEY (id)
);


ALTER SEQUENCE icr.tool_id_seq OWNED BY icr.tool.id;

CREATE SEQUENCE icr.skill_type_id_seq;

CREATE TABLE icr.skill_type (
                id INTEGER NOT NULL DEFAULT nextval('icr.skill_type_id_seq'),
                type VARCHAR(50) NOT NULL,
                CONSTRAINT id_2 PRIMARY KEY (id)
);


ALTER SEQUENCE icr.skill_type_id_seq OWNED BY icr.skill_type.id;

CREATE TABLE icr.employee_skill (
                skill_id INTEGER NOT NULL,
                employee_id INTEGER NOT NULL,
                CONSTRAINT id_1_2 PRIMARY KEY (skill_id, employee_id)
);


CREATE SEQUENCE icr.skill_id_seq;

CREATE TABLE icr.skill (
                id INTEGER NOT NULL DEFAULT nextval('icr.skill_id_seq'),
                name VARCHAR(50),
                skill_type_id INTEGER NOT NULL,
                level VARCHAR(1),
                CONSTRAINT id_1_1_1 PRIMARY KEY (id)
);


ALTER SEQUENCE icr.skill_id_seq OWNED BY icr.skill.id;

CREATE TABLE icr.private_info (
                employee_id INTEGER NOT NULL,
                phone VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL,
                additional_info TEXT,
                CONSTRAINT id_1_1 PRIMARY KEY (employee_id)
);


CREATE SEQUENCE icr.employee_id_seq;

CREATE TABLE icr.employee (
                id INTEGER NOT NULL DEFAULT nextval('icr.employee_id_seq'),
                first_name VARCHAR(50),
                last_name VARCHAR(100),
                photo BYTEA,
                gender VARCHAR(1),
                education TEXT,
                phone VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL,
                additional_note TEXT,
                CONSTRAINT id_1 PRIMARY KEY (id)
);


ALTER SEQUENCE icr.employee_id_seq OWNED BY icr.employee.id;

CREATE SEQUENCE icr.posiion_id_seq;

CREATE TABLE icr.posiion (
                id INTEGER NOT NULL DEFAULT nextval('icr.posiion_id_seq'),
                name VARCHAR(50),
                CONSTRAINT posiion_pk PRIMARY KEY (id)
);


ALTER SEQUENCE icr.posiion_id_seq OWNED BY icr.posiion.id;

CREATE TABLE icr.employee_history (
                team_id INTEGER NOT NULL,
                employee_id INTEGER NOT NULL,
                start_date DATE NOT NULL,
                position_id INTEGER NOT NULL,
                end_date DATE NOT NULL,
                CONSTRAINT employee_history_pk PRIMARY KEY (team_id, employee_id, start_date)
);


CREATE SEQUENCE icr.team_id_seq;

CREATE TABLE icr.team (
                id INTEGER NOT NULL DEFAULT nextval('icr.team_id_seq'),
                name VARCHAR(50) NOT NULL,
                description TEXT NOT NULL,
                project_id INTEGER NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER SEQUENCE icr.team_id_seq OWNED BY icr.team.id;

CREATE SEQUENCE icr.project_id_seq;

CREATE TABLE icr.project (
                id INTEGER NOT NULL DEFAULT nextval('icr.project_id_seq'),
                name VARCHAR(100) NOT NULL,
                description TEXT NOT NULL,
                start_date DATE NOT NULL,
                end_date DATE,
                isActiv BOOLEAN NOT NULL,
                company_id INTEGER NOT NULL,
                CONSTRAINT project_pk PRIMARY KEY (id)
);


ALTER SEQUENCE icr.project_id_seq OWNED BY icr.project.id;

CREATE SEQUENCE icr.bonus_type_id_seq;

CREATE TABLE icr.bonus_type (
                id INTEGER NOT NULL DEFAULT nextval('icr.bonus_type_id_seq'),
                name VARCHAR(50) NOT NULL,
                CONSTRAINT bonus_type_pk PRIMARY KEY (id)
);


ALTER SEQUENCE icr.bonus_type_id_seq OWNED BY icr.bonus_type.id;

CREATE SEQUENCE icr.bonus_id_seq;

CREATE TABLE icr.bonus (
                id INTEGER NOT NULL DEFAULT nextval('icr.bonus_id_seq'),
                description VARCHAR(255) NOT NULL,
                company_id INTEGER NOT NULL,
                bonus_type_id INTEGER NOT NULL,
                CONSTRAINT bonus_pk PRIMARY KEY (id)
);


ALTER SEQUENCE icr.bonus_id_seq OWNED BY icr.bonus.id;

CREATE SEQUENCE icr.company_id_seq;

CREATE TABLE icr.company (
                id INTEGER NOT NULL DEFAULT nextval('icr.company_id_seq'),
                description TEXT,
                owners VARCHAR(255),
                email VARCHAR(50),
                phone VARCHAR(25),
                CONSTRAINT company_pk PRIMARY KEY (id)
);


ALTER SEQUENCE icr.company_id_seq OWNED BY icr.company.id;