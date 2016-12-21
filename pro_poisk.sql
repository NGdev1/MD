DROP TABLE IF EXISTS `feed`;
CREATE TABLE IF NOT EXISTS `feed` (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `text` varchar(10000) NOT NULL,
  `date_time` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

INSERT INTO `feed` (`id`, `author_id`, `text`, `date_time`) VALUES
  (58, 32, 'Hi', '2016-11-02 13:32:15'),
  (72, 33, 'даров\n', '2016-11-05 20:42:10'),
  (73, 28, 'автор 33 хуй пососи\n', '2016-11-05 20:42:29'),
  (74, 28, 'оп пердани оп перданинаа', '2016-11-05 20:43:02'),
  (75, 33, 'иди на хуй\n', '2016-11-05 20:43:26'),
  (76, 28, 'теремок походу лооох', '2016-11-05 20:43:55'),
  (77, 33, '---------', '2016-11-05 20:44:06'),
  (78, 28, 'сосал у бло', '2016-11-05 20:44:09'),
  (79, 33, 'как дела??', '2016-11-05 20:44:12'),
  (80, 28, 'хер пер нухал сер', '2016-11-05 20:44:25'),
  (81, 33, 'пиздец', '2016-11-05 20:45:02'),
  (82, 33, 'все работает', '2016-11-05 20:45:08'),
  (83, 33, 'я ебу али бабу', '2016-11-05 20:45:22'),
  (84, 28, 'пукан у когото пахне запах чувствую', '2016-11-05 20:45:35'),
  (85, 28, 'миша ебаквак походу', '2016-11-05 20:45:44'),
  (86, 33, '))))\n\n', '2016-11-05 20:45:55'),
  (87, 28, 'Блять', '2016-11-05 20:47:42'),
  (88, 28, 'Пизднесь', '2016-11-05 20:47:48'),
  (89, 28, 'ахавахаха', '2016-11-05 20:48:11'),
  (90, 28, 'Кскскс', '2016-11-05 20:48:53'),
  (91, 28, 'ти что лох что ли', '2016-11-05 20:49:18'),
  (92, 28, 'коксссс', '2016-11-05 20:49:26'),
  (94, 28, 'вася че подохли что харош геру ипать ахаах лол', '2016-11-05 20:49:55'),
  (95, 38, 'здарова бандиты', '2016-11-05 22:06:23'),
  (96, 28, 'Все мы на гитхабе есть', '2016-11-23 19:41:01'),
  (97, 28, 'спать пора а мы кодим долго', '2016-11-28 22:34:39'),
  (98, 28, 'dfsdfsadjkfnl dfsdfsadjkfnl dfsdfsadjkfnldfsdfsadjkfnl dfsdfsadjkfnl dfsdfsadjkfnldfsdfsadjkfnl dfsdfsadjkfnl dfsdfsadjkfnlvdfsdfsadjkfnl dfsdfsadjkfnl  ', '2016-12-10 12:24:27');

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `friends` (`user_id`, `friend_id`) VALUES
  (31, 28),
  (28, 30),
  (28, 31),
  (28, 38);

DROP TABLE IF EXISTS `participants`;
CREATE TABLE IF NOT EXISTS `participants` (
  `user_id` int(11) NOT NULL,
  `journey_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `participants` (`user_id`, `journey_id`) VALUES
  (33, 1),
  (40, 1),
  (32, 1),
  (28, 1);

DROP TABLE IF EXISTS `point`;
CREATE TABLE IF NOT EXISTS `point` (
  `id` int(11) NOT NULL,
  `id_expedition` int(11) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `text` varchar(2000) NOT NULL,
  `date_time` datetime NOT NULL,
  `image` varchar(1000) NOT NULL,
  `longitude` decimal(11,0) NOT NULL,
  `latitude` decimal(11,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `squads_in_journey`;
CREATE TABLE IF NOT EXISTS `squads_in_journey` (
  `journey_id` int(11) NOT NULL,
  `squad_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `squads_in_journey` (`journey_id`, `squad_id`) VALUES
  (1, 1),
  (1, 4),
  (1, 8);

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `city` varchar(50) NOT NULL,
  `image` varchar(300) NOT NULL,
  `squad` int(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `patronymic` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `dolshnost` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

INSERT INTO `users` (`id`, `login`, `password`, `gender`, `phone`, `DOB`, `city`, `image`, `squad`, `email`, `patronymic`, `surname`, `dolshnost`) VALUES
  (28, 'Михаил', 1450572480, 1, '89520340416', '2016-11-02', 'Kazan', '28', 1, 'anreichen.m.@mail.ru', 'Дмитревич', 'Андреичев', 'S'),
  (30, 'Артур', 1450572480, 1, '89600', '1998-03-10', 'Kazan', 'no_photo2.png', 1, 'balbes@ya.ru', 'Шайтанович', 'Балбесов', 'S'),
  (31, 'Лесник', 1450572480, 1, '89520340416', '1999-03-11', 'Kazan', 'no_photo2.png', 2, 'balbes@ya.ru', 'Иванович', 'Шайтанов', 'S'),
  (32, 'Рустам', 1450572480, 1, '777', '1996-12-12', 'Kazan', 'no_photo2.png', 3, 'balbes@ya.ru', 'Шайтанович', 'Щекловек', 'S'),
  (33, 'Лесник', 1450572480, 1, '89534034584', '1999-03-11', 'Kazan', 'no_photo2.png', 4, 'balbes@ya.ru', 'Шайтановна', 'Непосредственно', 'S'),
  (34, 'Дарья', 1450572480, 0, '89046606959', '1998-07-05', 'Kazan', 'no_photo2.png', 5, 'balbes@ya.ru', 'Шайтанович', 'Есть', 'S'),
  (36, 'Влад', 1450572480, 1, '89063261744', '1998-12-26', 'Kazan', 'no_photo2.png', 3, 'balbes@ya.ru', 'Шайтанович', 'Достал нож режь', 'S'),
  (38, 'Кастрюлька', 1450572480, 1, '89053168537', '1997-02-15', 'Kazan', 'no_photo2.png', 2, 'balbes@ya.ru', 'Шайтанович', 'Не достал не порезал', 'S'),
  (40, 'Артем', 1450572480, 1, '89871884634', '1997-08-07', 'Kazan', 'no_photo2.png', 1, 'balbes@ya.ru', 'Шайтанович', 'да', 'S');

DROP TABLE IF EXISTS `expedition`;
CREATE TABLE IF NOT EXISTS `expedition` (
  `id` int(11) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `place` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `expedition` (`id`, `name`, `status`, `place`) VALUES
  (1, 'В хануму', 0, 'Казань кфу');

DROP TABLE IF EXISTS `squads`;
CREATE TABLE IF NOT EXISTS `squads` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

INSERT INTO `squads` (`id`, `name`) VALUES
  (1, '"Легион" ТИСБИ г. Казань'),
  (2, '"Химик" КНИТУ-КХТИ г. Казань'),
  (3, '"Книга Памяти" КНИТУ-КАИ им.А.Н.Туполева г. Казань'),
  (4, '"Снежный десант" КФУ г. Казань'),
  (5, '"Красная стрела" ИЭУП г. Казань'),
  (6, '"Возрождение" г. Казань'),
  (7, '"Западный Фронт" г. Казань'),
  (8, '"Поисковая тропа" КГЭУ г.Казань'),
  (9, '"Разведка" г. Казань'),
  (10, '"СКИФ" ТГГПУ г. Казань'),
  (11, '"Поиск" МБОУ «Гимназия №96» г.Казань'),
  (12, '"Юные патриоты России" г. Казань');


ALTER TABLE `expedition`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `feed`
  ADD PRIMARY KEY (`id`),
  ADD KEY `feed_users_id_fk` (`author_id`);

ALTER TABLE `friends`
  ADD PRIMARY KEY (`user_id`,`friend_id`),
  ADD KEY `friend_id` (`friend_id`);

ALTER TABLE `participants`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `journey_id` (`journey_id`);

ALTER TABLE `point`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_expedition` (`id_expedition`);

ALTER TABLE `squads`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `squads_in_journey`
  ADD KEY `journey_id` (`journey_id`),
  ADD KEY `squad_id` (`squad_id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `squad_const` (`squad`);


ALTER TABLE `expedition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `feed`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=99;
ALTER TABLE `squads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
ALTER TABLE `point`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `feed`
  ADD CONSTRAINT `feed_users_id_fk` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `friends`
  ADD CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`friend_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `participants`
  ADD CONSTRAINT `participants_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participants_ibfk_2` FOREIGN KEY (`journey_id`) REFERENCES `expedition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `point`
  ADD CONSTRAINT `point_ibfk_1` FOREIGN KEY (`id_expedition`) REFERENCES `expedition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `squads_in_journey`
  ADD CONSTRAINT `squads_in_journey_ibfk_1` FOREIGN KEY (`journey_id`) REFERENCES `expedition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `squads_in_journey_ibfk_2` FOREIGN KEY (`squad_id`) REFERENCES `squads` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `users`
  ADD CONSTRAINT `squad_const` FOREIGN KEY (`squad`) REFERENCES `squads` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

