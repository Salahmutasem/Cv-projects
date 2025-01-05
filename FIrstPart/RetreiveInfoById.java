package FIrstPart;
import java.util.List;

public interface RetreiveInfoById <T>{
List<T> retrieveByID(String id, List<T> list);
}
