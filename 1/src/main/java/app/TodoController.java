package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
import java.util.List;
 
@Controller
public class TodoController {
    private TodoService todoService;
 
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
 
    @RequestMapping(value = "index.s",method = RequestMethod.GET)
    public ModelAndView printAll() {
        List<String> all = todoService.getAll();
        ModelAndView mav = new ModelAndView("/WEB-INF/views/list.jsp");
        mav.addObject("todoList", all);
        return mav;
    }
 
    @RequestMapping(value = "index.s",method = RequestMethod.POST)
    public ModelAndView addItem(@RequestParam String item) {
        if (item != null) todoService.addItem(item);
        return new ModelAndView("redirect:index.s");
    }
}