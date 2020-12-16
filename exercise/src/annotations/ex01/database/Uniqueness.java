package annotations.ex01.database;

/**
 * @author wangzhichao
 * @since 2020/4/13
 */
public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
}
