CREATE TABLE personne (
   Id	SERIAL NOT 	NULL,
   Nom VARCHAR(255) 	NOT 	NULL,
   Prenom VARCHAR(255) NOT NULL default '',
   DateNais TIMESTAMP(0) default NULL,
  ligne1_adr VARCHAR(80) NOT NULL default '',
  ligne2_adr VARCHAR(80) default NULL,
  cp_adr VARCHAR(5) default NULL,
  ville_adr VARCHAR(80) default NULL,
  ligne3_adr VARCHAR(80) default NULL,
  PRIMARY KEY  (Id)
);
