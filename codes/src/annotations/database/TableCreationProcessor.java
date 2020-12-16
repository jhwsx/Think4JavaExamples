package annotations.database;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.SimpleElementVisitor8;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"annotations.database.DBTable", "annotations.database.Constraints",
        "annotations.database.SQLInteger", "annotations.database.SQLString"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TableCreationProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            messager.printMessage(Diagnostic.Kind.NOTE, "annotation=" + annotation);
        }
        TableCreationVisitor visitor = new TableCreationVisitor();
        Set<? extends Element> elementsAnnotatedWithDBTable = roundEnv.getElementsAnnotatedWith(DBTable.class);
        Set<? extends Element> elementsAnnotatedWithConstraints = roundEnv.getElementsAnnotatedWith(Constraints.class);
        Set<? extends Element> elementsAnnotatedWithSQLString = roundEnv.getElementsAnnotatedWith(SQLString.class);
        Set<? extends Element> elementsAnnotatedWithSQLInteger = roundEnv.getElementsAnnotatedWith(SQLInteger.class);
        for (Element element : elementsAnnotatedWithDBTable) {
            element.accept(visitor, null);
        }
        for (Element elementAnnotatedWithConstraints : elementsAnnotatedWithConstraints) {
            elementAnnotatedWithConstraints.accept(visitor, null);
        }
        for (Element element : elementsAnnotatedWithSQLString) {
            element.accept(visitor, null);
        }
        for (Element element : elementsAnnotatedWithSQLInteger) {
            element.accept(visitor, null);
        }
        sql = sql.substring(0, sql.length() - 1) + ");";
        messager.printMessage(Diagnostic.Kind.NOTE, "sql=" + sql);
        return false;
    }

    private String sql = "";
    private  class TableCreationVisitor extends SimpleElementVisitor8<Void, Void> {
        // 访问类型元素
        @Override
        public Void visitType(TypeElement e, Void unused) {
            DBTable dbTable = e.getAnnotation(DBTable.class);
            if (dbTable != null) {
                sql += "CREATE TABLE ";
                sql += (dbTable.name().length() < 1)
                        ? e.getSimpleName().toString().toUpperCase()
                        : dbTable.name();
                sql += " (";
            }
            return super.visitType(e, unused);
        }

        @Override
        public Void visitVariable(VariableElement e, Void unused) {
            if (e.getAnnotation(SQLInteger.class) != null) {
                SQLInteger sqlInteger = e.getAnnotation(SQLInteger.class);
                String columnName;
                if (sqlInteger.name().length() < 1) {
                    columnName = e.getSimpleName().toString().toUpperCase();
                } else {
                    columnName = sqlInteger.name();
                }
                sql += "\n    " + columnName + " INT" + getConstraints(sqlInteger.constraints()) + ",";
            }
            if (e.getAnnotation(SQLString.class) != null) {
                SQLString sqlString = e.getAnnotation(SQLString.class);
                String columnName;
                if (sqlString.name().length() < 1) {
                    columnName = e.getSimpleName().toString().toUpperCase();
                } else {
                    columnName = sqlString.name();
                }
                sql += "\n    " + columnName + " VARCHAR(" +
                        sqlString.value() + ")" +
                        getConstraints(sqlString.constraints()) + ",";
            }
            return super.visitVariable(e, unused);
        }

        private  String getConstraints(Constraints con) {
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
}

//I:\AndroidProjects\Think4JavaExamples\codes\src>javac -encoding utf-8 annotations/database/TableCreationProcessor.java
//
//I:\AndroidProjects\Think4JavaExamples\codes\src>javac -encoding utf-8 -processor annotations.database.TableCreationProcessor annotations/database
///Member.java
//注: annotation=annotations.database.SQLInteger
//注: annotation=annotations.database.DBTable
//注: annotation=annotations.database.SQLString
//注: sql=CREATE TABLE MEMBER (
//      FIRSTNAME VARCHAR(30),
//      LASTNAME VARCHAR(50),
//      HANDLE VARCHAR(30) PRIMARY KEY,
//      AGE INT);
//注: sql=CREATE TABLE MEMBER (
//      FIRSTNAME VARCHAR(30),
//      LASTNAME VARCHAR(50),
//      HANDLE VARCHAR(30) PRIMARY KEY,
//      AGE INT);
