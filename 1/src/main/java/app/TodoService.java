package app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
 
@Service
public class TodoService {
    private ArrayList<String> todos = new ArrayList<String>();
 
    public List<String> getAll() {
        return new ArrayList<String>(todos);
    }
 
    public void addItem(String item) {
        todos.add(item);
    }
}