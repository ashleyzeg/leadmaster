DROP TABLE IF EXISTS "public"."dim_location";

DROP SEQUENCE IF EXISTS "public"."dim_location_id_seq";

-- ----------------------------
--  Sequence structure for dim_location_id_seq
-- ----------------------------
CREATE SEQUENCE "public"."dim_location_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Table structure for dim_location
-- ----------------------------
CREATE TABLE "public"."dim_location" (
  "id"         int4 NOT NULL DEFAULT nextval('dim_location_id_seq'::regclass),
  "postalcode" varchar COLLATE "default",
  "city"       varchar COLLATE "default",
  "state"      varchar COLLATE "default",
  "country"    varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Primary key structure for table dim_location
-- ----------------------------
ALTER TABLE "public"."dim_location" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

