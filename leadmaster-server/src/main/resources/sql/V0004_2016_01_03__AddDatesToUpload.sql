-- Table: dim_upload

DROP TABLE IF EXISTS "public"."dim_upload";

CREATE TABLE "public"."dim_upload"
(
  id                SERIAL NOT NULL,
  description       CHARACTER VARYING,
  upload_timestamp  TIMESTAMP WITH TIME ZONE,
  customer_id       INTEGER,
  upload_process    CHARACTER VARYING,
  file_location     CHARACTER VARYING,
  file_name         CHARACTER VARYING,
  process_timestamp TIMESTAMP WITH TIME ZONE
)
WITH (OIDS =FALSE
);

ALTER TABLE dim_upload ADD CONSTRAINT dim_upload_pkey
  PRIMARY KEY (id);

CREATE INDEX dim_upload_customer_id_idx ON dim_upload USING BTREE (customer_id);

ALTER TABLE dim_upload ADD CONSTRAINT dim_upload_customer_id_fkey
  FOREIGN KEY (customer_id) REFERENCES dim_customer (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;