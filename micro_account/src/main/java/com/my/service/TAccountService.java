package com.my.service;

import com.my.entity.TAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hutf
 * @createTime 2021年03月18日 16:43:00
 */
@Service
public class TAccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TAccount getAccount(String userId) {
        TAccount tAccount = null;
        try {
            tAccount = jdbcTemplate.queryForObject("SELECT * FROM t_account where user_id = ? ", new RowMapper<TAccount>() {
                @Override
                public TAccount mapRow(ResultSet resultSet, int i) throws SQLException {
                    TAccount account = new TAccount();
                    account.setId(resultSet.getInt("id"));
                    account.setMoney(resultSet.getInt("money"));
                    account.setUserId(resultSet.getString("user_id"));
                    return account;
                }
            }, userId);

        } catch (DataAccessException e) {
            return null;
        }

        return tAccount;
    }

    public void reduceMoney(String userId,int reduceNumber) {
        StringBuffer sb = new StringBuffer();
        sb.append(" UPDATE t_account SET money = money - ? WHERE user_id = ? AND money > 0 ");
        jdbcTemplate.update(sb.toString(), userId, reduceNumber);
    }
}
