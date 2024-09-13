CREATE TABLE tb_motocycles
(
    id    UUID        NOT NULL,
    model VARCHAR(10) NOT NULL,
    age   INTEGER     NOT NULL,
    plate VARCHAR(7)  NOT NULL,
    color VARCHAR(5)  NOT NULL,
    CONSTRAINT pk_tb_motocycles PRIMARY KEY (id)
);

CREATE TABLE tb_role
(
    id   UUID         NOT NULL,
    type VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tb_role PRIMARY KEY (id)
);

CREATE TABLE tb_users
(
    id       UUID        NOT NULL,
    name     VARCHAR(12) NOT NULL,
    email    VARCHAR(12) NOT NULL,
    password VARCHAR(10) NOT NULL,
    CONSTRAINT pk_tb_users PRIMARY KEY (id)
);

CREATE TABLE tb_users_motocycles
(
    car_id  UUID NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT pk_tb_users_motocycles PRIMARY KEY (car_id, user_id)
);

ALTER TABLE tb_motocycles
    ADD CONSTRAINT uc_tb_motocycles_plate UNIQUE (plate);

ALTER TABLE tb_users_motocycles
    ADD CONSTRAINT fk_tbusemot_on_motorcycler_entity FOREIGN KEY (car_id) REFERENCES tb_motocycles (id);

ALTER TABLE tb_users_motocycles
    ADD CONSTRAINT fk_tbusemot_on_user_entity FOREIGN KEY (user_id) REFERENCES tb_users (id);