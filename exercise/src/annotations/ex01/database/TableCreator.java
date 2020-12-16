package annotations.ex01.database;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器的例子
 * <p>
 * 读取一个类文件，检查其上的数据库注解，并生成用来创建数据库的SQL命令
 *
 * @author wangzhichao
 * @since 2020/4/14
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
        // 判断类是否使用@DBTable注解
        Class<Member> memberClass = Member.class;
        DBTable dbTable = memberClass.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("Member 类没有使用 @DBTable 注解");
            return;
        }
        // 获取数据表名：不存在的话，就是类的名字作为表名
        String tableName = dbTable.name();
        if (tableName.length() < 1) {
            // 注解里没有指定表名，就使用类名作为表名
            tableName = memberClass.getName().toUpperCase();
        }
        // 遍历类中声明的字段，获取在字段上使用的注解（注意可以是多个）
        List<String> columnDefs = new ArrayList<>();
        Field[] declaredFields = memberClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Annotation[] fieldDeclaredAnnotations = declaredField.getDeclaredAnnotations();
            if (fieldDeclaredAnnotations.length == 0) {
                continue;// 字段上没有注解
            }
            // 根据字段上的注解类型，获取数据表的列名，列的生成语句，以及约束
            for (Annotation fieldDeclaredAnnotation : fieldDeclaredAnnotations) {
                if (fieldDeclaredAnnotation instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) fieldDeclaredAnnotation;
                    String columnName = sqlInteger.name();
                    if (columnName.length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    }
                    columnDefs.add(columnName + " INT"
                            + getConstraints(sqlInteger.constraints()));
                }
                if (fieldDeclaredAnnotation instanceof SQLString) {
                    SQLString sqlString = (SQLString) fieldDeclaredAnnotation;
                    String columnName = sqlString.name();
                    if (columnName.length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" +
                            getConstraints(sqlString.constraints()));
                }
                if (fieldDeclaredAnnotation instanceof  SQLDouble) {
                    SQLDouble sqlDouble = (SQLDouble) fieldDeclaredAnnotation;
                    String columnName = sqlDouble.name();
                    if (columnName.length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    }
                    columnDefs.add(columnName + " DOUBLE"
                            + getConstraints(sqlDouble.constraints()));
                }
            }
        }
        // 最后，得到创建表的完整语句
        StringBuilder create = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (int i = 0; i < columnDefs.size(); i++) {
            create.append("\n    " + columnDefs.get(i));
            if (i == columnDefs.size() - 1) {
                create.append(");");
            } else {
                create.append(",");
            }
        }
        System.out.println("Table Creation SQL for " + memberClass.getName()
        + " is: \n" + create);
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
