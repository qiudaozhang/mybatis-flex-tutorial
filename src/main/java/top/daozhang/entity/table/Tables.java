package top.daozhang.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class Tables {


    public static final UserTableDef USER = new UserTableDef("t_user");

    public static class UserTableDef extends TableDef {

        public QueryColumn ID = new QueryColumn(this, "id");
        public QueryColumn NICKNAME = new QueryColumn(this, "nickname");
        public QueryColumn BIRTHDAY = new QueryColumn(this, "birthday");
        public QueryColumn CREATED = new QueryColumn(this, "created");
        public QueryColumn SEX = new QueryColumn(this, "sex");

        public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NICKNAME, BIRTHDAY, CREATED, SEX};
        public QueryColumn[] ALL_COLUMNS = new QueryColumn[]{ID, NICKNAME, BIRTHDAY, CREATED, SEX};


        public UserTableDef(String tableName) {
            super(tableName);
        }
    }
}
