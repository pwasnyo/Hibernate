-- beware the name of table and column must be the same in java class mapping
CREATE TABLE compte (
   id	SERIAL NOT 	NULL,
   numero VARCHAR(255) 	NOT 	NULL,
   solde float NOT NULL default 0,
   PRIMARY KEY (id)
);

CREATE TABLE compte_courant (
   id	integer NOT 	NULL,
   numero VARCHAR(255) 	NOT 	NULL,
   solde float NOT NULL default 0,
   decouvert float NOT NULL default 0
);

CREATE TABLE compte_epargne (
   id integer NOT 	NULL,
   numero VARCHAR(255) 	NOT 	NULL,
   solde float NOT NULL default 0,
   taux float NOT NULL default 0
);