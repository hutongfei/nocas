package com.my.service;

import com.my.entity.TStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hutf
 * @createTime 2021年03月18日 17:11:00
 */
public class TStorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateStorage(int count ,String commodityCode) {
        StringBuffer sb = new StringBuffer();
        sb.append(" UPDATE t_storage SET count = count - ? where commodity_code = ? ");

        jdbcTemplate.update(sb.toString(), count, commodityCode);
    }

    public TStorage getStorage(String commodityCode) {
        TStorage tStorage = jdbcTemplate.queryForObject("SELECT * FROM  t_storage where commodity_code = ? ", new RowMapper<TStorage>() {
            @Override
            public TStorage mapRow(ResultSet rs, int i) throws SQLException {
                TStorage storage = new TStorage();
                storage.setId(rs.getInt("id"));
                storage.setUserId(rs.getString("user_id"));
                storage.setCount(rs.getInt("count"));

                return storage;
            }
        }, commodityCode);

        return tStorage;
    }

}
