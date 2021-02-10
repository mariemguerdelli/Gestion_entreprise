-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 25 jan. 2021 à 22:04
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_entreprise`
--

-- --------------------------------------------------------

--
-- Structure de la table `bon_livraison`
--

CREATE TABLE `bon_livraison` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_bon` varchar(255) NOT NULL,
  `date_livraison` varchar(255) NOT NULL,
  `adresse_livraison` varchar(255) NOT NULL,
  `num_cmd_vente` int(11) NOT NULL,
  `ligne_bl` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bon_livraison`
--

INSERT INTO `bon_livraison` (`code`, `code_client`, `date_bon`, `date_livraison`, `adresse_livraison`, `num_cmd_vente`, `ligne_bl`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(12, 1, '2021-01-17', '2021-01-23', 'sousse', 1, 0x5b4c69676e655f424c205b7265663d312c20636f6465436c69656e743d312c2064657369676e6174696f6e3d7364662c20756e6974655f6d65737572653d50696563652c207174655f6c69767265653d322c2050555f686f72735f5456413d31322e302c205456413d332e302c20505f746f74616c5f686f72735456413d32342e305d5d, 24, 3, 24.72);

-- --------------------------------------------------------

--
-- Structure de la table `bon_reception`
--

CREATE TABLE `bon_reception` (
  `code` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `date_bon` varchar(255) NOT NULL,
  `date_reception` varchar(255) NOT NULL,
  `adresse_reception` varchar(255) NOT NULL,
  `num_cmd_achat` int(11) NOT NULL,
  `ligne_br` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bon_reception`
--

INSERT INTO `bon_reception` (`code`, `code_fournisseur`, `date_bon`, `date_reception`, `adresse_reception`, `num_cmd_achat`, `ligne_br`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(983, 2, '2021-01-14', '2021-01-17', 'monastir', 1, 0x5b4c69676e655f4252205b7265663d312c20636f6465466f75726e6973736575723d322c2064657369676e6174696f6e3d6d6d2c20756e6974655f6d65737572653d4b672c207174655f726563657074696f6e6e65653d322c2050555f686f72735f5456413d34352e302c205456413d31322e302c20505f746f74616c5f686f72735456413d39302e305d5d, 12, 90, 100.8);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `code` int(11) NOT NULL,
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tlf_fixe` int(11) NOT NULL,
  `num_tlf_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`code`, `matricule_fiscale`, `raison_sociale`, `type`, `description`, `compte_bancaire`, `adresse`, `num_tlf_fixe`, `num_tlf_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
(1, 'hjjg', 'jgfjhg', 'morale', 'kkh', 'fghf/fhg/56', '54/jgg/fghf/ghf/45456/hfh/fhgf', 7879, 87979, 45454, 'hgfhgf', 'ghjk', 'hff'),
(22, 'df', 'dfg', 'physique', 'dfg', 'dfg/dfg/555', '66/gfh/fgh/fgh/555/fgh/fg', 55, 55, 5585, 'dfg', 'hgjhgj', 'fg'),
(99, '20IFJ45', 'sldfk', 'physique', 'dfl', 'sdlfk/sldfk/56', '5/sdmlfk/sdlfk/lmskdf/65/mskd/dskfm', 4561, 56, 8456, 'sdflk', 'm?sf', 'sdmlf');

-- --------------------------------------------------------

--
-- Structure de la table `compte_bancaire`
--

CREATE TABLE `compte_bancaire` (
  `id` int(11) NOT NULL,
  `nom_banque` varchar(255) NOT NULL,
  `agence` varchar(255) NOT NULL,
  `Rib` int(11) NOT NULL,
  `code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

CREATE TABLE `devis` (
  `code` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `client` int(11) NOT NULL,
  `ligne_devis` blob NOT NULL,
  `m_total_TVA` float NOT NULL,
  `m_total_hors_TVA` float NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `devis`
--

INSERT INTO `devis` (`code`, `date`, `client`, `ligne_devis`, `m_total_TVA`, `m_total_hors_TVA`, `m_total_Payer`) VALUES
(5, '2021-01-13', 1, 0x5b4d6f64656c2e4c69676e655f64657669734031636435366164395d, 12, 48, 53.76);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description_activite` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tel_fixe` int(11) NOT NULL,
  `num_tel_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`matricule_fiscale`, `raison_sociale`, `type`, `description_activite`, `compte_bancaire`, `adresse`, `num_tel_fixe`, `num_tel_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
('aaaaa', 'dfgdfg', 'physique', 'dfgdfg', 'dfgfd/dgdfg/4545', '645/ksdj/kjsdj/sdflk/5011/lsdj/lkk', 45, 2222, 455454, 'ldkllk', 'mdklvmdls', 'ljsdlmf');

-- --------------------------------------------------------

--
-- Structure de la table `facture_avoir`
--

CREATE TABLE `facture_avoir` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `code_facture_client` int(11) NOT NULL,
  `qte_retour` int(11) NOT NULL,
  `desig_prod` varchar(255) NOT NULL,
  `MTPayer` float NOT NULL,
  `MRetour` float NOT NULL,
  `MAR` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture_avoir`
--

INSERT INTO `facture_avoir` (`code`, `code_client`, `date_facture`, `mode_payement`, `code_facture_client`, `qte_retour`, `desig_prod`, `MTPayer`, `MRetour`, `MAR`) VALUES
(1, 1, '2021-01-17', 'espece', 1, 1, 'sdf', 24.72, 12.36, 12.36);

-- --------------------------------------------------------

--
-- Structure de la table `facture_client`
--

CREATE TABLE `facture_client` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `client` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_de_payement` varchar(255) NOT NULL,
  `facture_client_BL` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_client_bl`
--

CREATE TABLE `facture_client_bl` (
  `code` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `code_bon_livr` int(11) NOT NULL,
  `m_total_Payer` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture_client_bl`
--

INSERT INTO `facture_client_bl` (`code`, `code_client`, `date_facture`, `mode_payement`, `type_facture`, `code_bon_livr`, `m_total_Payer`) VALUES
(1, 1, '2021-01-17', 'espece', 'F.C.BL', 12, 24.72);

-- --------------------------------------------------------

--
-- Structure de la table `facture_client_libre`
--

CREATE TABLE `facture_client_libre` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `client` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_livrée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur`
--

CREATE TABLE `facture_fournisseur` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur_bl`
--

CREATE TABLE `facture_fournisseur_bl` (
  `code` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `date_facture` varchar(255) NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `code_bon_recep` int(11) NOT NULL,
  `m_total_Payer` float NOT NULL,
  `m_Payer` float NOT NULL,
  `m_Reste` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fournisseur_libre`
--

CREATE TABLE `facture_fournisseur_libre` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `date_facture` date NOT NULL,
  `mode_payement` varchar(255) NOT NULL,
  `type_facture` varchar(255) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_receptionnée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `code` int(11) NOT NULL,
  `matricule_fiscale` varchar(255) NOT NULL,
  `raison_sociale` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `compte_bancaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `num_tlf_fixe` int(11) NOT NULL,
  `num_tlf_mobile` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `site_web` varchar(255) NOT NULL,
  `etat_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`code`, `matricule_fiscale`, `raison_sociale`, `type`, `description`, `compte_bancaire`, `adresse`, `num_tlf_fixe`, `num_tlf_mobile`, `fax`, `email`, `site_web`, `etat_fiscale`) VALUES
(2, '20IFJ54', 'dljsdf', 'morale', 'dgdfg', 'skldjf/skdjf/44', '454/skdfj/sljdf/lsjf/4545/lsjf/dfkljdfk', 56454, 6545648, 54545, 'dsfllk', 'lsdf', 'lsdkfld'),
(3, '19IFJ068', 'aaa', 'physique', 'aa', 'UIB/ss/45688', '55/qsqsq/sdf/sousse/5010/sousse/qsd', 45566, 556, 53454, 'slkdj', 'klsdj', 'ksqj');

-- --------------------------------------------------------

--
-- Structure de la table `ligne_bl`
--

CREATE TABLE `ligne_bl` (
  `ref` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_livree` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_bl`
--

INSERT INTO `ligne_bl` (`ref`, `code_client`, `designation`, `unite_mesure`, `qte_livree`, `PU_hors_TVA`, `TVA`, `P_total_horsTVA`) VALUES
(1, 1, 'sdf', 'Piece', 2, 12, 3, 24);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_br`
--

CREATE TABLE `ligne_br` (
  `ref` int(11) NOT NULL,
  `code_fournisseur` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_receptionnee` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_br`
--

INSERT INTO `ligne_br` (`ref`, `code_fournisseur`, `designation`, `unite_mesure`, `qte_receptionnee`, `PU_hors_TVA`, `TVA`, `P_total_horsTVA`) VALUES
(1, 2, 'mm', 'Kg', 2, 45, 12, 90),
(2, 2, 'sdf', 'Piece', 2, 1122, 44, 2244);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_devis`
--

CREATE TABLE `ligne_devis` (
  `ref` int(11) NOT NULL,
  `code_client` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `qte_receptionnee` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquee` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_devis`
--

INSERT INTO `ligne_devis` (`ref`, `code_client`, `designation`, `unite_mesure`, `qte_receptionnee`, `PU_hors_TVA`, `TVA_appliquee`, `P_total_horsTVA`) VALUES
(1, 1, 'mm', 'kg', 2, 24, 12, 48),
(2, 1, 'dd', 'mm', 3, 45, 12, 135),
(3, 99, 'sdfkkh', 'sk', 2, 14, 12, 28);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_client`
--

CREATE TABLE `ligne_facture_client` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_livrée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_fournisseur`
--

CREATE TABLE `ligne_facture_fournisseur` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_receptionnée` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_facture_produit_rendu`
--

CREATE TABLE `ligne_facture_produit_rendu` (
  `id` int(11) NOT NULL,
  `réf` varchar(255) NOT NULL,
  `désignation` varchar(255) NOT NULL,
  `unité_mésure` varchar(255) NOT NULL,
  `qté_retour` int(11) NOT NULL,
  `PU_hors_TVA` float NOT NULL,
  `TVA_appliquée` float NOT NULL,
  `P_total_horsTVA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `code` int(11) NOT NULL,
  `ref` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unite_mesure` varchar(255) NOT NULL,
  `fournisseur` varchar(255) NOT NULL,
  `famille_produit` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `stock_min` int(11) NOT NULL,
  `PU_hors_taxe` int(11) NOT NULL,
  `TVA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`code`, `ref`, `designation`, `unite_mesure`, `fournisseur`, `famille_produit`, `stock`, `stock_min`, `PU_hors_taxe`, `TVA`) VALUES
(1, 22, 'sdf', 'Piece', 'dljsdf', '55/fgf', 14, 3, 12, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bon_livraison`
--
ALTER TABLE `bon_livraison`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `bon_reception`
--
ALTER TABLE `bon_reception`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `devis`
--
ALTER TABLE `devis`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`matricule_fiscale`);

--
-- Index pour la table `facture_avoir`
--
ALTER TABLE `facture_avoir`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_client`
--
ALTER TABLE `facture_client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_client_bl`
--
ALTER TABLE `facture_client_bl`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_client_libre`
--
ALTER TABLE `facture_client_libre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_fournisseur`
--
ALTER TABLE `facture_fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture_fournisseur_bl`
--
ALTER TABLE `facture_fournisseur_bl`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `facture_fournisseur_libre`
--
ALTER TABLE `facture_fournisseur_libre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `ligne_bl`
--
ALTER TABLE `ligne_bl`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_br`
--
ALTER TABLE `ligne_br`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_devis`
--
ALTER TABLE `ligne_devis`
  ADD PRIMARY KEY (`ref`);

--
-- Index pour la table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ligne_facture_fournisseur`
--
ALTER TABLE `ligne_facture_fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ligne_facture_produit_rendu`
--
ALTER TABLE `ligne_facture_produit_rendu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bon_livraison`
--
ALTER TABLE `bon_livraison`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `bon_reception`
--
ALTER TABLE `bon_reception`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=985;

--
-- AUTO_INCREMENT pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `devis`
--
ALTER TABLE `devis`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `facture_avoir`
--
ALTER TABLE `facture_avoir`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `facture_client`
--
ALTER TABLE `facture_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_client_libre`
--
ALTER TABLE `facture_client_libre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fournisseur`
--
ALTER TABLE `facture_fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fournisseur_libre`
--
ALTER TABLE `facture_fournisseur_libre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_bl`
--
ALTER TABLE `ligne_bl`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_facture_fournisseur`
--
ALTER TABLE `ligne_facture_fournisseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne_facture_produit_rendu`
--
ALTER TABLE `ligne_facture_produit_rendu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
