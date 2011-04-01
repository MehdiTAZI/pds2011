--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "CHANNEL_EVENT" DROP CONSTRAINT "FK59A8701E4FDA6073";

ALTER TABLE "CONSUMER" DROP CONSTRAINT "FKCCE73F64FDA6073";

ALTER TABLE "CONSUMER_EVENT" DROP CONSTRAINT "FKA23A00F16335CDB0";

ALTER TABLE "CHANNEL_EVENT" DROP CONSTRAINT "FK59A8701EDAF0B277";

ALTER TABLE "CONSUMER_EVENT" DROP CONSTRAINT "FKA23A00F1DCDA057D";

ALTER TABLE "CHANNEL" DROP CONSTRAINT "SQL110330000901300";

ALTER TABLE "EVENT" DROP CONSTRAINT "SQL110330000901410";

ALTER TABLE "CONSUMER_EVENT" DROP CONSTRAINT "SQL110330000901390";

ALTER TABLE "CHANNEL_EVENT" DROP CONSTRAINT "SQL110330000901340";

ALTER TABLE "CONSUMER" DROP CONSTRAINT "SQL110330000901350";

DROP INDEX "SQL110330000901460";

DROP INDEX "SQL110330000901530";

DROP INDEX "SQL110330000901340";

DROP INDEX "SQL110330000901300";

DROP INDEX "SQL110330000901410";

DROP INDEX "SQL110330000901480";

DROP INDEX "SQL110330000901391";

DROP INDEX "SQL110330000901510";

DROP INDEX "SQL110330000901390";

DROP INDEX "SQL110330000901341";

DROP INDEX "SQL110330000901470";

DROP INDEX "SQL110330000901350";

DROP TABLE "CHANNEL";

DROP TABLE "CHANNEL_EVENT";

DROP TABLE "CONSUMER_EVENT";

DROP TABLE "EVENT";

DROP TABLE "CONSUMER";

CREATE TABLE "CHANNEL" (
		"ID" INTEGER GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 2),
		"CAPACITY_QUEUE" INTEGER NOT NULL,
		"CONNECTIONCAPACITY" INTEGER,
		"IDENTIFIER" BIGINT NOT NULL,
		"TOPIC" VARCHAR(255)
	);

CREATE TABLE "CHANNEL_EVENT" (
		"CHANNEL_ID" INTEGER NOT NULL,
		"EVENT_ID" INTEGER NOT NULL
	);

CREATE TABLE "CONSUMER_EVENT" (
		"CONSUMER_ID" INTEGER NOT NULL,
		"EVENT_ID" INTEGER NOT NULL
	);

CREATE TABLE "EVENT" (
		"ID" INTEGER GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"CODE" BIGINT,
		"CREATIONDATE" BIGINT,
		"DATA" LONG VARCHAR FOR BIT DATA,
		"PRIORITY" INTEGER,
		"TTL" BIGINT,
		"TYPE" VARCHAR(255)
	);

CREATE TABLE "CONSUMER" (
		"ID" INTEGER GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"IDCONSUMER" VARCHAR(255),
		"CHANNEL_ID" INTEGER
	);

CREATE INDEX "SQL110330000901460" ON "CHANNEL_EVENT" ("EVENT_ID" ASC);

CREATE INDEX "SQL110330000901530" ON "CONSUMER_EVENT" ("EVENT_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901340" ON "CHANNEL_EVENT" ("CHANNEL_ID" ASC, "EVENT_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901300" ON "CHANNEL" ("ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901410" ON "EVENT" ("ID" ASC);

CREATE INDEX "SQL110330000901480" ON "CONSUMER" ("CHANNEL_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901391" ON "CONSUMER_EVENT" ("EVENT_ID" ASC);

CREATE INDEX "SQL110330000901510" ON "CONSUMER_EVENT" ("CONSUMER_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901390" ON "CONSUMER_EVENT" ("CONSUMER_ID" ASC, "EVENT_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901341" ON "CHANNEL_EVENT" ("EVENT_ID" ASC);

CREATE INDEX "SQL110330000901470" ON "CHANNEL_EVENT" ("CHANNEL_ID" ASC);

CREATE UNIQUE INDEX "SQL110330000901350" ON "CONSUMER" ("ID" ASC);

ALTER TABLE "CHANNEL" ADD CONSTRAINT "SQL110330000901300" PRIMARY KEY ("ID");

ALTER TABLE "EVENT" ADD CONSTRAINT "SQL110330000901410" PRIMARY KEY ("ID");

ALTER TABLE "CONSUMER_EVENT" ADD CONSTRAINT "SQL110330000901390" PRIMARY KEY ("CONSUMER_ID", "EVENT_ID");

ALTER TABLE "CHANNEL_EVENT" ADD CONSTRAINT "SQL110330000901340" PRIMARY KEY ("CHANNEL_ID", "EVENT_ID");

ALTER TABLE "CONSUMER" ADD CONSTRAINT "SQL110330000901350" PRIMARY KEY ("ID");

ALTER TABLE "CHANNEL_EVENT" ADD CONSTRAINT "FK59A8701E4FDA6073" FOREIGN KEY ("CHANNEL_ID")
	REFERENCES "CHANNEL" ("ID") ON DELETE CASCADE;

ALTER TABLE "CONSUMER" ADD CONSTRAINT "FKCCE73F64FDA6073" FOREIGN KEY ("CHANNEL_ID")
	REFERENCES "CHANNEL" ("ID") ON DELETE CASCADE;

ALTER TABLE "CONSUMER_EVENT" ADD CONSTRAINT "FKA23A00F16335CDB0" FOREIGN KEY ("CONSUMER_ID")
	REFERENCES "CONSUMER" ("ID") ON DELETE CASCADE;

ALTER TABLE "CHANNEL_EVENT" ADD CONSTRAINT "FK59A8701EDAF0B277" FOREIGN KEY ("EVENT_ID")
	REFERENCES "EVENT" ("ID") ON DELETE CASCADE;

ALTER TABLE "CONSUMER_EVENT" ADD CONSTRAINT "FKA23A00F1DCDA057D" FOREIGN KEY ("EVENT_ID")
	REFERENCES "EVENT" ("ID") ON DELETE CASCADE;

