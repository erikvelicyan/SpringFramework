package com.example.skillboxthirdtask.repository;

import com.example.skillboxthirdtask.contact.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Contact> findAll() {
        String sql = "SELECT * FROM contacts";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }


    public Contact findById(Long id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ContactRowMapper());
    }

    public int addContact(Contact contact) {
        String sql = "INSERT INTO contacts (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
    }

    public int updateContact(Long id, Contact contact) {
        String sql = "UPDATE contacts SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
        return jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), id);
    }

    public int deleteContact(Long id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class ContactRowMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getString("phone"));
            return contact;
        }
    }
}
