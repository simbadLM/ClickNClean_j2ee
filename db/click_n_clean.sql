-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 08 mars 2024 à 16:32
-- Version du serveur : 8.0.32
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `click_n_clean`
--

-- --------------------------------------------------------

--
-- Structure de la table `activity`
--

CREATE TABLE `activity` (
  `id_activity` int NOT NULL,
  `type` int NOT NULL,
  `read` tinyint(1) NOT NULL,
  `id_owner` int UNSIGNED DEFAULT NULL,
  `id_cleaner` int UNSIGNED DEFAULT NULL,
  `id_mission` int UNSIGNED DEFAULT NULL,
  `id_dispute` int UNSIGNED DEFAULT NULL,
  `id_admin` int UNSIGNED DEFAULT NULL,
  `id_target` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`id_activity`, `type`, `read`, `id_owner`, `id_cleaner`, `id_mission`, `id_dispute`, `id_admin`, `id_target`) VALUES
(1, 4, 0, NULL, NULL, NULL, NULL, NULL, 3),
(2, 5, 0, NULL, NULL, 1, NULL, NULL, 2);

-- --------------------------------------------------------
--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_admin`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `cleaner`
--

CREATE TABLE `cleaner` (
  `id_cleaner` int UNSIGNED NOT NULL,
  `address_display` varchar(100) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `km_range` int NOT NULL,
  `hourly_rate` int NOT NULL,
  `biography` varchar(100) NOT NULL,
  `photo_identity` varchar(36) NOT NULL,
  `photo_profile` varchar(36) NOT NULL,
  `photo_live` varchar(36) NOT NULL,
  `motivation` varchar(250) NOT NULL,
  `experience` int NOT NULL,
  `confirmed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `cleaner`
--

INSERT INTO `cleaner` (`id_cleaner`, `address_display`, `latitude`, `longitude`, `km_range`, `hourly_rate`, `biography`, `photo_identity`, `photo_profile`, `photo_live`, `motivation`, `experience`, `confirmed`) VALUES
(2, '28 av yves thepot 29000 quimper', 47.988373, -4.088107, 0, 0, 'A cool cleaner biography', 'null', 'null', 'null', 'This should be an acceptable motivation', 1, 1);

-- --------------------------------------------------------
--
-- Structure de la table `dispute`
--

CREATE TABLE `dispute` (
  `id_dispute` int UNSIGNED NOT NULL,
  `content` varchar(200) NOT NULL,
  `decision` varchar(200) NOT NULL,
  `id_owner` int UNSIGNED NOT NULL,
  `id_cleaner` int UNSIGNED NOT NULL,
  `id_mission` int UNSIGNED NOT NULL,
  `id_dispute_creator` int UNSIGNED NOT NULL,
  `id_admin` int UNSIGNED DEFAULT NULL,
  `decision_type` int UNSIGNED DEFAULT '0'

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `id_mission` int UNSIGNED NOT NULL,
  `date_start` datetime NOT NULL,
  `cost` double NOT NULL DEFAULT '0',
  `duration` double NOT NULL,
  `commission` double NOT NULL DEFAULT '0',
  `state` int NOT NULL,
  `before_photo` varchar(50) DEFAULT NULL,
  `after_photo` varchar(50) DEFAULT NULL,
  `id_owner` int UNSIGNED NOT NULL,
  `id_cleaner` int UNSIGNED DEFAULT NULL,
  `id_property` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`id_mission`, `date_start`, `cost`, `duration`, `commission`, `state`, `before_photo`, `after_photo`, `id_owner`, `id_cleaner`, `id_property`) VALUES
(1, "2040-01-01 08:00:00", 0, 3.5, 0, 1, NULL, NULL, 3, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `mission_proposal`
--

CREATE TABLE `mission_proposal` (
  `id_mission` int NOT NULL,
  `id_cleaner` int NOT NULL,
  `starting_hour` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `owner`
--

CREATE TABLE `owner` (
  `id_owner` int UNSIGNED NOT NULL,
  `type_service` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `owner`
--

INSERT INTO `owner` (`id_owner`, `type_service`) VALUES
(3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `id_cleaner` int UNSIGNED NOT NULL,
  `datetime` datetime NOT NULL,
  `durationH` double NOT NULL,

  `id_mission` int DEFAULT -1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



--
-- Structure de la table `property`
--

CREATE TABLE `property` (
  `id_property` int UNSIGNED NOT NULL,
  `address_display` varchar(100) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `surface` int UNSIGNED NOT NULL,
  `id_owner` int UNSIGNED NOT NULL,
  `acces_code` varchar(15) DEFAULT NULL,
  `key_box_code` varchar(10) DEFAULT NULL,
  `special_instruction` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `property`
--

INSERT INTO `property` (`id_property`, `address_display`, `latitude`, `longitude`, `surface`, `id_owner`, `acces_code`, `key_box_code`, `special_instruction`) VALUES
(1, "28 av yves thepot 29000 quimper", 47.988373, -4.088107, 100, 3, null, null, null);


-- --------------------------------------------------------

--
-- Structure de la table `review`
--

CREATE TABLE `review` (
  `id_review` int UNSIGNED NOT NULL,
  `content` varchar(100) NOT NULL,
  `grade` int NOT NULL,
  `id_user` int UNSIGNED NOT NULL,
  `id_mission` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `id_status` int UNSIGNED NOT NULL,
  `name_status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `status`
--

INSERT INTO `status` (`id_status`, `name_status`) VALUES
(1, 'Admin'),
(2, 'Cleaner'),
(3, 'Owner');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int UNSIGNED NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(90) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  `account_date` date NOT NULL,
  `suspended` tinyint(1) NOT NULL DEFAULT '0',
  `status` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `name`, `password`, `surname`, `email`, `phone_number`, `birth_date`, `account_date`, `suspended`, `status`) VALUES
(1, 'NomAdmin', 'fb0aff9960bdd8512c1251da49c2771a29c5d2e32998f2379104bf4bfbcba612', 'PrenomAdmin', 'admin@admin.fr', '0000000000', '1970-01-01', '1970-01-01', 0, 1),
(2, 'NomCleaner', '84d6d0bc649e64593040df1519800d82b89a46b76fc58a9bbecd651be008eddc', 'PrenomCleaner', 'cleaner@cleaner.fr', '0000000000', '1970-01-01', '1970-01-01', 0, 2),
(3, 'NomOwner', '94c190aaf502a2a0f6e86008abbedaf4153e4b16250869f2e6a4a270993ac81c', 'PrenomOwner', 'owner@owner.fr', '0000000000', '1970-01-01', '1970-01-01 ', 0, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`id_activity`),
  ADD KEY `owner_of_the_activity` (`id_owner`),
  ADD KEY `cleaner_of_the_activity` (`id_cleaner`),
  ADD KEY `mission_of_the_activity` (`id_mission`),
  ADD KEY `dispute_of_the_mission` (`id_dispute`),
  ADD KEY `admin_of_the_mission` (`id_admin`),
  ADD KEY `user_receiving_activity` (`id_target`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD KEY `admin_is_a_user` (`id_admin`);

--
-- Index pour la table `cleaner`
--
ALTER TABLE `cleaner`
  ADD PRIMARY KEY (`id_cleaner`),
  ADD KEY `cleaner_is_an_user` (`id_cleaner`);

--
-- Index pour la table `dispute`
--
ALTER TABLE `dispute`
  ADD PRIMARY KEY (`id_dispute`),
  ADD KEY `owner_of_the_mission_disputed` (`id_owner`),
  ADD KEY `cleaner_of_the_mission_disputed` (`id_cleaner`),
  ADD KEY `mission_being_disputed` (`id_mission`),
  ADD KEY `creator_of_the_dispute` (`id_dispute_creator`),
  ADD KEY `admin_of_the_dispute` (`id_admin`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`id_mission`),
  ADD KEY `owner_of_the_mission` (`id_owner`),
  ADD KEY `property_being_cleaned` (`id_property`),
  ADD KEY `cleaner_of_the_mission` (`id_cleaner`);

--
-- Index pour la table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id_owner`),
  ADD KEY `owner_is_a_user` (`id_owner`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD KEY `cleaner_owns_a_planning` (`id_cleaner`);

--
-- Index pour la table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`id_property`),
  ADD KEY `owner_own_property` (`id_owner`);

--
-- Index pour la table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id_review`),
  ADD KEY `mission_of_the_review` (`id_mission`),
  ADD KEY `target_of_the_review` (`id_user`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `status` (`status`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activity`
--
ALTER TABLE `activity`
  MODIFY `id_activity` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `dispute`
--
ALTER TABLE `dispute`
  MODIFY `id_dispute` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `id_mission` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `property`
--
ALTER TABLE `property`
  MODIFY `id_property` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `review`
--
ALTER TABLE `review`
  MODIFY `id_review` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activity`
--
ALTER TABLE `activity`
  ADD CONSTRAINT `admin_of_the_mission` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `cleaner_of_the_activity` FOREIGN KEY (`id_cleaner`) REFERENCES `cleaner` (`id_cleaner`),
  ADD CONSTRAINT `dispute_of_the_mission` FOREIGN KEY (`id_dispute`) REFERENCES `dispute` (`id_dispute`),
  ADD CONSTRAINT `mission_of_the_activity` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id_mission`),
  ADD CONSTRAINT `owner_of_the_activity` FOREIGN KEY (`id_owner`) REFERENCES `owner` (`id_owner`),
  ADD CONSTRAINT `user_receiving_activity` FOREIGN KEY (`id_target`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_is_a_user` FOREIGN KEY (`id_admin`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `cleaner`
--
ALTER TABLE `cleaner`
  ADD CONSTRAINT `cleaner_is_an_user` FOREIGN KEY (`id_cleaner`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `dispute`
--
ALTER TABLE `dispute`
  ADD CONSTRAINT `admin_of_the_dispute` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `cleaner_of_the_mission_disputed` FOREIGN KEY (`id_cleaner`) REFERENCES `cleaner` (`id_cleaner`),
  ADD CONSTRAINT `creator_of_the_dispute` FOREIGN KEY (`id_dispute_creator`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `mission_being_disputed` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id_mission`),
  ADD CONSTRAINT `owner_of_the_mission_disputed` FOREIGN KEY (`id_owner`) REFERENCES `owner` (`id_owner`);

--
-- Contraintes pour la table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `cleaner_of_the_mission` FOREIGN KEY (`id_cleaner`) REFERENCES `cleaner` (`id_cleaner`),
  ADD CONSTRAINT `owner_of_the_mission` FOREIGN KEY (`id_owner`) REFERENCES `owner` (`id_owner`),
  ADD CONSTRAINT `property_being_cleaned` FOREIGN KEY (`id_property`) REFERENCES `property` (`id_property`);

--
-- Contraintes pour la table `owner`
--
ALTER TABLE `owner`
  ADD CONSTRAINT `owner_is_a_user` FOREIGN KEY (`id_owner`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `owner_own_property` FOREIGN KEY (`id_owner`) REFERENCES `owner` (`id_owner`);

--
-- Contraintes pour la table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `mission_of_the_review` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id_mission`),
  ADD CONSTRAINT `target_of_the_review` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
