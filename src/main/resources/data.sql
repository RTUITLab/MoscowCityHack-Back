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

insert into events
(title, online, photo_url, address, region, date_start, date_end, published, current_amount, max_amount, email, owner_id)
values ('Волонтеры охотники за приведениями', false, 'https://images.unsplash.com/photo-1634840647366-e755dc76882d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1620&q=80',
        'адрес проспект вернадского', 'center', 1654666200, 1654678800, true, 1, 10, 'pomogite@help.me', 3);

insert into tags
(name)
values ('festival'),
       ('contest'),
       ('sport');

insert into directions
(name)
values ('blood'),
       ('nature'),
       ('old');

insert into tags_event
(tag_id, event_id)
values (1, 1),
       (2, 1),
       (3, 1);

insert into directions_event
(direction_id, event_id)
values (1,1),
       (2,1),
       (3,1);

insert into event_task_description
(event_id, task_description)
values (1,'поимка приведений'),
       (1,'мытье пола'),
       (1,'ааааааа');

insert into event_requirements
(event_id, requirements)
values (1,'прохождение обучения'),
       (1,'есть машина'),
       (1,'любите зефир'),
       (1,'старше 18');

insert into event_facilities
(event_id, facilities)
values (1,'питание'),
       (1,'поможем лайками');

insert into event_materials
(event_id, materials)
values (1,'https://images.unsplash.com/photo-1634840647366-e755dc76882d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1620&q=80'','),
       (1,'https://images.unsplash.com/photo-1634840647366-e755dc76882d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1620&q=80'','),
       (1,'https://images.unsplash.com/photo-1634840647366-e755dc76882d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1620&q=80'','),
       (1,'https://images.unsplash.com/photo-1634840647366-e755dc76882d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1620&q=80'',');

insert into events_participants
(event_id, participants_id)
values (1, 2);
