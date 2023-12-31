insert into coffee_machine.drink (name, cost, volume, description)
values ('Эспрессо', 15, 0.10, 'Крепки бодрящий кофе.'),
       ('Капучино', 30, 0.5, 'Кофе на основе эспрессо с добавлением подогретого молока.'),
       ('Раф', 50, 0.5, 'Кофе на основе эспрессо с небольшим кол-вом пены. Подается с сиропом.'),
       ('Латте', 30, 0.5, 'Кофе на основе молока. Трехслойная смесь из пены, молока и эспрессо:'),
       ('Гляссе', 70, 0.7, 'Холодный напиток на основе кофе с добавлением мороженного.'),
       ('Мокко', 22, 0.33, 'Кофе с добавлением шоколада. Разновидность Латте.');

insert into coffee_machine.ingredients (drink_id, key, value)
values (1, 'Эспрессо', '7 грамм молотого кофе'),
       (2, 'Капучино', 'эспрессо, молоко, взбитое молоко'),
       (3, 'Раф', 'сироп эспрессо, взбитое молоко'),
       (4, 'Латте', 'эспрессо, молоко, взбитое молоко'),
       (5, 'Гляссе', 'эспрессо, мороженное, тертый шоколад'),
       (6, 'Мокко', 'шоколад, эспрессо, молоко, взбитые сливки');
