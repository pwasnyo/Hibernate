-- beware the name of table and column must be the same in java class mapping
CREATE TABLE personne (
   id	SERIAL NOT 	NULL,
   nom VARCHAR(255) 	NOT 	NULL,
   prenom VARCHAR(255) NOT NULL default '',
   dateNais TIMESTAMP(0) default NULL,
  ligne1_adr VARCHAR(80) NOT NULL default '',
  ligne2_adr VARCHAR(80) default NULL,
  cp_adr VARCHAR(5) default NULL,
  ville_adr VARCHAR(80) default NULL,
  ligne3_adr VARCHAR(80) default NULL,
  PRIMARY KEY  (id)
);
-- etape 3 du tu to création de la table adresse donc suppression des column inapropriés dans la table personne 
ALTER TABLE personne DROP COLUMN ligne1_adr RESTRICT;
ALTER TABLE personne DROP COLUMN ligne2_adr RESTRICT;
ALTER TABLE personne DROP COLUMN cp_adr RESTRICT;
ALTER TABLE personne DROP COLUMN ville_adr RESTRICT;
ALTER TABLE personne DROP COLUMN ligne3_adr RESTRICT;

CREATE TABLE adresse (
  id	SERIAL NOT 	NULL,
  ligne1_adr VARCHAR(80) NOT NULL default '',
  ligne2_adr VARCHAR(80) default NULL,
  cp_adr VARCHAR(5) default NULL,
  ville_adr VARCHAR(80) default NULL,
  ligne3_adr VARCHAR(80) default NULL,
  PRIMARY KEY  (id)
) ;

ALTER TABLE personne ADD COLUMN adresse_id int NOT NULL default 0;