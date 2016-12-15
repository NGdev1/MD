-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Хост: localhost:3306
-- Время создания: Дек 15 2016 г., 11:31
-- Версия сервера: 5.5.42
-- Версия PHP: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- База данных: `pro_poisk`
--

-- --------------------------------------------------------

--
-- Структура таблицы `feed`
--

DROP TABLE IF EXISTS `feed`;
CREATE TABLE IF NOT EXISTS `feed` (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `text` varchar(10000) NOT NULL,
  `date_time` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `feed`
--

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

-- --------------------------------------------------------

--
-- Структура таблицы `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `friends`
--

INSERT INTO `friends` (`user_id`, `friend_id`) VALUES
  (31, 28),
  (28, 30),
  (28, 31),
  (28, 38);

-- --------------------------------------------------------

--
-- Структура таблицы `squads`
--

DROP TABLE IF EXISTS `squads`;
CREATE TABLE IF NOT EXISTS `squads` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `squads`
--

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

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

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

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `gender`, `phone`, `DOB`, `city`, `image`, `squad`, `email`, `patronymic`, `surname`, `dolshnost`) VALUES
  (28, 'Михаил', 1450572480, 1, '89520340416', '2016-11-02', 'Kazan', 'picture', 1, 'anreichen.m.@mail.ru', 'Дмитревич', 'Андреичев', 'S'),
  (30, 'Artur', 63539877, 1, '89600', '1998-03-10', 'Kazan', 'picture', 1, '', '', '', ''),
  (31, 'Lesnik', -1106208330, 1, '89520340416', '1999-03-11', 'Kazan', 'picture', 2, '', '', '', ''),
  (32, 'Rustam', 1450575459, 1, '777', '1996-12-12', 'Kazan', 'picture', 3, '', '', '', ''),
  (33, 'лесник', -1121450961, 1, '89534034584', '1999-03-11', 'Kazan', 'picture', 4, '', '', '', ''),
  (34, 'Darya', 1835010204, 0, '89046606959', '1998-07-05', 'Kazan', 'picture', 5, '', '', '', ''),
  (36, 'Vlad', 867363100, 1, '89063261744', '1998-12-26', 'Kazan', 'picture', 3, '', '', '', ''),
  (38, 'кастрюлька', -378969071, 1, '89053168537', '1997-02-15', 'Kazan', 'picture', 2, '', '', '', ''),
  (40, 'Артем', 1450575459, 1, '89871884634', '1997-08-07', 'Kazan', 'picture', 1, '', '', '', '');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `feed`
--
ALTER TABLE `feed`
  ADD PRIMARY KEY (`id`),
  ADD KEY `feed_users_id_fk` (`author_id`);

--
-- Индексы таблицы `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`user_id`,`friend_id`),
  ADD KEY `friend_id` (`friend_id`);

--
-- Индексы таблицы `squads`
--
ALTER TABLE `squads`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `feed`
--
ALTER TABLE `feed`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=99;
--
-- AUTO_INCREMENT для таблицы `squads`
--
ALTER TABLE `squads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `feed`
--
ALTER TABLE `feed`
  ADD CONSTRAINT `feed_users_id_fk` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `friends`
--
ALTER TABLE `friends`
  ADD CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`friend_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
