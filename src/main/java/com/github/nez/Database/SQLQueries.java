package com.github.nez.Database;

public enum SQLQueries {
    COLUMNS("SELECT * FROM INFORMATION_SCHEMA.COLUMNS"),
    //CREATEACCOUNTTABLE("CREATE TABLE ACCOUNT(username nchar(30) NOTNULL)"),
    SELECTACCOUNT("SELECT * FROM ACCOUNT");

    SQLQueries(String Query) {
    }
}
