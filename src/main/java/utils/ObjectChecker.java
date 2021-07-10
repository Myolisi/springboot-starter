package utils;
import java.util.Objects;

// check for nulls
public class ObjectChecker {
    public boolean check(String field){
        return  (Objects.nonNull(field) && !"".equalsIgnoreCase((String) field));
    }
}
