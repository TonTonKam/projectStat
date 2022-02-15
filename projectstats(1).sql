-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 15 fév. 2022 à 09:27
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projectstats`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id_article` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `id_vue` int(11) DEFAULT NULL,
  `id_signe` int(11) DEFAULT NULL,
  `titre` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `contenu` text NOT NULL,
  `resume` varchar(200) DEFAULT NULL,
  `image` text DEFAULT NULL,
  `isVisible` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `id_user`, `id_categorie`, `id_vue`, `id_signe`, `titre`, `date`, `contenu`, `resume`, `image`, `isVisible`) VALUES
(1, 1, 1, 0, 0, '1er article', '2022-02-13', 'Salut, ceci est mon 1er article', NULL, NULL, 1),
(2, 1, 1, 0, 0, 'mon 1er article', '2022-02-13', 'salut, ceci est mon 1er article', NULL, NULL, 1),
(3, 3, 2, 0, 0, 'cuisine vapeur', '2022-02-14', 'Bonjour, la cuisine vapeur permet d\'avoir des elements cuit tout en gardant leurs apports en nutiments', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `article_delete`
--

CREATE TABLE `article_delete` (
  `id_article` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `titre` varchar(250) NOT NULL,
  `date` date NOT NULL,
  `contenu` text NOT NULL,
  `resume` text NOT NULL,
  `image` text NOT NULL,
  `isVisible` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `libelle`) VALUES
(1, 'Salutation'),
(2, 'Cuisine');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `date` date NOT NULL,
  `isVisible` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `id_user`, `id_article`, `contenu`, `date`, `isVisible`) VALUES
(1, 1, 1, 'ca fonctionne?', '2022-02-13', 1);

-- --------------------------------------------------------

--
-- Structure de la table `signe`
--

CREATE TABLE `signe` (
  `id_signe` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `signe_positif` tinyint(1) NOT NULL DEFAULT 0,
  `signe_negatif` tinyint(1) NOT NULL DEFAULT 0,
  `date` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `status`
--

INSERT INTO `status` (`id_status`, `libelle`) VALUES
(1, 'client'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_user` int(11) NOT NULL,
  `id_status` int(11) NOT NULL DEFAULT 1,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `civilite` varchar(10) DEFAULT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `dateInscription` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_user`, `id_status`, `nom`, `prenom`, `age`, `civilite`, `email`, `password`, `dateInscription`) VALUES
(1, 1, 'test', 'test', NULL, NULL, 'test@test.fr', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', '2022-02-13'),
(2, 1, 'tester', 'tester', NULL, NULL, 'test@tester.fr', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', '2022-02-13'),
(3, 1, 'TonKar', 'TonKam', NULL, NULL, 'yannkrz@gmail.com', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', '2022-02-13'),
(4, 2, 'admin', 'admin', NULL, NULL, 'admin@admin.fr', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', '2022-02-13');

-- --------------------------------------------------------

--
-- Structure de la table `vue`
--

CREATE TABLE `vue` (
  `id_vue` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL,
  `nb_vue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`),
  ADD KEY `fk_id_user_article` (`id_user`),
  ADD KEY `fk_id_categorie` (`id_categorie`),
  ADD KEY `fk_article_id_vue` (`id_vue`),
  ADD KEY `fk_article_id_signe` (`id_signe`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `fk_commentaire_id_user` (`id_user`),
  ADD KEY `fk_commentaire_id_article` (`id_article`);

--
-- Index pour la table `signe`
--
ALTER TABLE `signe`
  ADD PRIMARY KEY (`id_signe`),
  ADD KEY `fk_signe_id_user` (`id_user`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_utilisateur_id_status` (`id_status`);

--
-- Index pour la table `vue`
--
ALTER TABLE `vue`
  ADD PRIMARY KEY (`id_vue`),
  ADD KEY `fk_vue_id_user` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `signe`
--
ALTER TABLE `signe`
  MODIFY `id_signe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
