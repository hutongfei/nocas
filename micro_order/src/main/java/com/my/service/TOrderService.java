package com.my.service;

import com.my.entity.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hutf
 * @createTime 2021年03月18日 16:58:00
 */
@Service
public class TOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addOrder(TOrder tOrder) {
        StringBuffer sb = new StringBuffer();
        sb.append(" INSERT INTO `t_order`(`id`, `user_id`, `commodity_code`, `count`, `money`) VALUES (NULL, ?, ?, ?, ?)");
        jdbcTemplate.update(sb.toString(), tOrder.getUserId(), tOrder.getCommodityCode(), tOrder.getCount(), tOrder.getMoney());
    }

    public TOrder getOrder(Integer id) {
        TOrder tOrder = jdbcTemplate.queryForObject("SELECT * FROM t_order WHERE id = ? ", new RowMapper<TOrder>() {
            @Override
            public TOrder mapRow(ResultSet rs, int i) throws SQLException {
                TOrder order = new TOrder();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getString("user_id"));
                order.setCommodityCode(rs.getString("commodity_code"));
                order.setCount(rs.getInt("count"));
                order.setMoney(rs.getInt("money"));

                return order;
            }
        },id);

        return tOrder;
    }
}
