insert into roles
    (name)
values ('ROLE_MODERATOR'),
       ('ROLE_VOLUNTEER'),
       ('ROLE_COMPANY');

insert into users
    (login, password, role_id)
values
       -- password == login
       ('mod', '$2a$12$L5.NuVH/8M53G5r6XwydaOUkW2i7TvREZjQ/6rHxLA5wawaR7DDt6', 1),
       ('user', '$2a$12$qQUkbLa32AktphPOFvZrzeOGnQEKXzxh1v1vukbSIhA4wKbFso3Ly', 2),
       ('com', '$2a$12$YabWTnC.ZPRPYolMlROaCunTA1PzfCg7U/a7B0sQfqnwiFHjNoGXa', 3);
insert into moderators