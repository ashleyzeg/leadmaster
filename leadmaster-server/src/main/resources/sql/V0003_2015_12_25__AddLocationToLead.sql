-- Table: dim_lead

DROP TABLE IF EXISTS "public"."dim_lead";

-- ----------------------------
--  Sequence structure for lead_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."lead_id_seq";
CREATE SEQUENCE "public"."lead_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

CREATE TABLE "public"."dim_lead"
(
  id                INTEGER NOT NULL DEFAULT nextval('lead_id_seq' :: REGCLASS),
  leadref           CHARACTER VARYING,
  firstname         CHARACTER VARYING,
  lastname          CHARACTER VARYING,
  postalcode        CHARACTER VARYING,
  city              CHARACTER VARYING,
  state             CHARACTER VARYING,
  country           CHARACTER VARYING,
  status            CHARACTER VARYING,
  merged_to         INTEGER,
  validation        CHARACTER VARYING,
  validation_errors CHARACTER VARYING,
  CONSTRAINT dim_lead_pkey PRIMARY KEY (id)
)
WITH (OIDS=FALSE);

-- Index: dim_lead_leadref_idx

-- DROP INDEX dim_lead_leadref_idx;

CREATE INDEX dim_lead_leadref_idx ON dim_lead USING BTREE (leadref COLLATE pg_catalog."default");

