/* [jooq ignore start] */CREATE EXTENSION IF NOT EXISTS "uuid-ossp" /* [jooq ignore stop] */;

DROP TABLE IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS
(
    "ID"             UUID NOT NULL /* [jooq ignore start] */ default uuid_generate_v4() /* [jooq ignore stop] */,
    "EXTERNAL_ID"   VARCHAR(32),
    "NAME"          VARCHAR(32),
    "LAST_NAME"     VARCHAR(32),
    "EMAIL"         VARCHAR(256)
    );

ALTER TABLE USERS
    ADD CONSTRAINT PK_USERS PRIMARY KEY ("ID");