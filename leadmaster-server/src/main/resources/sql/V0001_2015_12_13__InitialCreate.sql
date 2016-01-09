/*
 Navicat Premium Data Transfer

 Source Server         : Postgres Local
 Source Server Type    : PostgreSQL
 Source Server Version : 90405
 Source Host           : localhost
 Source Database       : leadmaster
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90405
 File Encoding         : utf-8

 Date: 12/12/2015 21:47:03 PM
*/

-- ----------------------------
--  Sequence structure for company_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."company_id_seq";
CREATE SEQUENCE "public"."company_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for dim_customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dim_customer_id_seq";
CREATE SEQUENCE "public"."dim_customer_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for dim_title_classification_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dim_title_classification_id_seq";
CREATE SEQUENCE "public"."dim_title_classification_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for dim_upload_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dim_upload_id_seq";
CREATE SEQUENCE "public"."dim_upload_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for email_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."email_id_seq";
CREATE SEQUENCE "public"."email_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for fact_dedupe_resolution_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."fact_dedupe_resolution_id_seq";
CREATE SEQUENCE "public"."fact_dedupe_resolution_id_seq" INCREMENT 1 START 39798 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for lead_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."lead_id_seq";
CREATE SEQUENCE "public"."lead_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Sequence structure for phone_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."phone_id_seq";
CREATE SEQUENCE "public"."phone_id_seq" INCREMENT 1 START 1 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;

-- ----------------------------
--  Table structure for dim_company
-- ----------------------------
DROP TABLE IF EXISTS "public"."dim_company";
CREATE TABLE "public"."dim_company" (
	"id" int4 NOT NULL DEFAULT nextval('company_id_seq'::regclass),
	"companyname" varchar COLLATE "default",
	"validation" varchar COLLATE "default",
	"status" varchar COLLATE "default",
	"merged_to" int4,
	"companyref" varchar COLLATE "default",
	"validation_errors" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for dim_lead
-- ----------------------------
DROP TABLE IF EXISTS "public"."dim_lead";
CREATE TABLE "public"."dim_lead" (
	"id" int4 NOT NULL DEFAULT nextval('lead_id_seq'::regclass),
	"firstname" varchar COLLATE "default",
	"lastname" varchar COLLATE "default",
	"validation" varchar COLLATE "default",
	"status" varchar COLLATE "default",
	"merged_to" int4,
	"leadref" varchar COLLATE "default",
	"validation_errors" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for dim_title_classification
-- ----------------------------
DROP TABLE IF EXISTS "public"."dim_title_classification";
CREATE TABLE "public"."dim_title_classification" (
	"id" int4 NOT NULL DEFAULT nextval('dim_title_classification_id_seq'::regclass),
	"executive_level" varchar COLLATE "default",
	"area_of_responsibility" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for dim_upload
-- ----------------------------
DROP TABLE IF EXISTS "public"."dim_upload";
CREATE TABLE "public"."dim_upload" (
	"id" int4 NOT NULL DEFAULT nextval('dim_upload_id_seq'::regclass),
	"description" varchar COLLATE "default",
	"upload_process" varchar COLLATE "default",
	"file_location" varchar COLLATE "default",
	"file_name" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_company_merge
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_company_merge";
CREATE TABLE "public"."fact_company_merge" (
	"company_id_merged_to" int4,
	"company_id_merged_from" int4,
	"distance" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_company_upload
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_company_upload";
CREATE TABLE "public"."fact_company_upload" (
	"upload_id" int4,
	"company_id" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_dedupe_resolution
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_dedupe_resolution";
CREATE TABLE "public"."fact_dedupe_resolution" (
	"id" int4 NOT NULL DEFAULT nextval('fact_dedupe_resolution_id_seq'::regclass),
	"lead_id" int4,
	"company_id" int4,
	"type" varchar COLLATE "default",
	"resolution" varchar COLLATE "default",
	"merges" varchar COLLATE "default",
	"message" varchar COLLATE "default",
	"upload_id" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_employment
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_employment";
CREATE TABLE "public"."fact_employment" (
	"lead_id" int4,
	"company_id" int4,
	"title_classification_id" int4,
	"title" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_lead_email_verification
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_lead_email_verification";
CREATE TABLE "public"."fact_lead_email_verification" (
	"id" int4 NOT NULL DEFAULT nextval('email_id_seq'::regclass),
	"lead_id" int4,
	"email" varchar COLLATE "default",
	"status" varchar COLLATE "default",
	"inserted_date" date,
	"activity_date" date
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_lead_merge
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_lead_merge";
CREATE TABLE "public"."fact_lead_merge" (
	"lead_id_merged_to" int4,
	"lead_id_merged_from" int4,
	"distance" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_lead_phone_verification
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_lead_phone_verification";
CREATE TABLE "public"."fact_lead_phone_verification" (
	"id" int4 NOT NULL DEFAULT nextval('phone_id_seq'::regclass),
	"lead_id" int4,
	"phone" varchar COLLATE "default",
	"status" varchar COLLATE "default",
	"inserted_date" date,
	"activity_date" date
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_lead_upload
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_lead_upload";
CREATE TABLE "public"."fact_lead_upload" (
	"upload_id" int4,
	"lead_id" int4
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for fact_upload_progress
-- ----------------------------
DROP TABLE IF EXISTS "public"."fact_upload_progress";
CREATE TABLE "public"."fact_upload_progress" (
	"upload_id" int4,
	"status" varchar COLLATE "default",
	"process_timestamp" timestamp(6) WITH TIME ZONE DEFAULT now(),
	"message" varchar COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Table structure for dim_customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."dim_customer";
CREATE TABLE "public"."dim_customer" (
	"id" int4 NOT NULL DEFAULT nextval('dim_customer_id_seq'::regclass),
	"customerref" varchar COLLATE "default",
	"integration_enabled" bool,
	"name" varchar COLLATE "default",
	"last_sync_date" date
)
WITH (OIDS=FALSE);

-- ----------------------------
--  Primary key structure for table dim_company
-- ----------------------------
ALTER TABLE "public"."dim_company" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table dim_company
-- ----------------------------
CREATE INDEX  "dim_company_companyname_idx" ON "public"."dim_company" USING btree(companyname COLLATE "default" ASC NULLS LAST);
CREATE INDEX  "dim_company_companyref_idx"  ON "public"."dim_company" USING btree(companyref  COLLATE "default" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table dim_lead
-- ----------------------------
ALTER TABLE "public"."dim_lead" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table dim_lead
-- ----------------------------
CREATE INDEX  "dim_lead_leadref_idx" ON "public"."dim_lead" USING btree(leadref COLLATE "default" ASC NULLS LAST);

-- ----------------------------
--  Indexes structure for table fact_employment
-- ----------------------------
CREATE INDEX  "fact_employment_company_id_lead_id_idx" ON "public"."fact_employment" USING btree(company_id ASC NULLS LAST, lead_id ASC NULLS LAST);
ALTER TABLE "public"."fact_employment" CLUSTER ON "fact_employment_company_id_lead_id_idx";
CREATE INDEX  "fact_employment_lead_id_company_id_idx" ON "public"."fact_employment" USING btree(lead_id ASC NULLS LAST, company_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table fact_lead_email_verification
-- ----------------------------
ALTER TABLE "public"."fact_lead_email_verification" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table fact_lead_email_verification
-- ----------------------------
CREATE INDEX  "fact_lead_email_verification_email_lead_id_idx" ON "public"."fact_lead_email_verification" USING btree(email COLLATE "default" ASC NULLS LAST, lead_id ASC NULLS LAST);
ALTER TABLE "public"."fact_lead_email_verification" CLUSTER ON "fact_lead_email_verification_email_lead_id_idx";
CREATE INDEX  "fact_lead_email_verification_id_idx" ON "public"."fact_lead_email_verification" USING btree("id" ASC NULLS LAST);
CREATE INDEX  "fact_lead_email_verification_lead_id_email_idx" ON "public"."fact_lead_email_verification" USING btree(lead_id ASC NULLS LAST, email COLLATE "default" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table fact_lead_phone_verification
-- ----------------------------
ALTER TABLE "public"."fact_lead_phone_verification" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;


-- ----------------------------
--  Primary key structure for table dim_customer
-- ----------------------------
ALTER TABLE dim_customer ADD CONSTRAINT dim_customer_pkey PRIMARY KEY(id);