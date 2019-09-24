package ua.training.model.dao.impl;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

                    ds.setUrl("jdbc:mysql://localhost:1433/reg_form?useTimezone=true&serverTimezone=Europe/Kiev");
                    ds.setUsername("root");
                    ds.setPassword("11111");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}