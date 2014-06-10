package com.devx.testapp;

import java.sql.*;
import javax.sql.*;
import javax.annotation.Resource;

public class DbMysql {
    //
    @Resource(name="jdbc/myTestDb")
    private DataSource ds;

    public String getMySqlVersion() throws SQLException{
            Connection con = ds.getConnection();
            DatabaseMetaData meta = con.getMetaData();
            con.close();
            return meta.getDatabaseProductVersion();
    }

}
