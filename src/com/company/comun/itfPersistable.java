package com.company.comun;

import java.sql.ResultSet;

public interface itfPersistable {
    void resultsetLoad(ResultSet rs) throws Exception;
}
