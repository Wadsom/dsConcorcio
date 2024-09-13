CREATE TABLE tb_users_roles
(
    role_id UUID NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT pk_tb_users_roles PRIMARY KEY (role_id, user_id)
);

ALTER TABLE tb_users_roles
    ADD CONSTRAINT fk_tbuserol_on_role_entity FOREIGN KEY (role_id) REFERENCES tb_role (id);

ALTER TABLE tb_users_roles
    ADD CONSTRAINT fk_tbuserol_on_user_entity FOREIGN KEY (user_id) REFERENCES tb_users (id);