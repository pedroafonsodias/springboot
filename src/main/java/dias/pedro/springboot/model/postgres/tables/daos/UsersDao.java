/*
 * This file is generated by jOOQ.
 */
package postgres.tables.daos;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import postgres.tables.Users;
import postgres.tables.records.UsersRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersDao extends DAOImpl<UsersRecord, postgres.tables.pojos.Users, UUID> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, postgres.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    public UsersDao(Configuration configuration) {
        super(Users.USERS, postgres.tables.pojos.Users.class, configuration);
    }

    @Override
    public UUID getId(postgres.tables.pojos.Users object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<postgres.tables.pojos.Users> fetchRangeOfId(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Users.USERS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<postgres.tables.pojos.Users> fetchById(UUID... values) {
        return fetch(Users.USERS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public postgres.tables.pojos.Users fetchOneById(UUID value) {
        return fetchOne(Users.USERS.ID, value);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public Optional<postgres.tables.pojos.Users> fetchOptionalById(UUID value) {
        return fetchOptional(Users.USERS.ID, value);
    }

    /**
     * Fetch records that have <code>EXTERNAL_ID BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<postgres.tables.pojos.Users> fetchRangeOfExternalId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.EXTERNAL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>EXTERNAL_ID IN (values)</code>
     */
    public List<postgres.tables.pojos.Users> fetchByExternalId(String... values) {
        return fetch(Users.USERS.EXTERNAL_ID, values);
    }

    /**
     * Fetch records that have <code>NAME BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<postgres.tables.pojos.Users> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>NAME IN (values)</code>
     */
    public List<postgres.tables.pojos.Users> fetchByName(String... values) {
        return fetch(Users.USERS.NAME, values);
    }

    /**
     * Fetch records that have <code>LAST_NAME BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<postgres.tables.pojos.Users> fetchRangeOfLastName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.LAST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>LAST_NAME IN (values)</code>
     */
    public List<postgres.tables.pojos.Users> fetchByLastName(String... values) {
        return fetch(Users.USERS.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>EMAIL BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<postgres.tables.pojos.Users> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>EMAIL IN (values)</code>
     */
    public List<postgres.tables.pojos.Users> fetchByEmail(String... values) {
        return fetch(Users.USERS.EMAIL, values);
    }
}