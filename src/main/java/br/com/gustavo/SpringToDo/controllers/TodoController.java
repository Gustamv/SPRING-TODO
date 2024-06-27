package br.com.gustavo.SpringToDo.controllers;

import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.gustavo.SpringToDo.models.Todo;
import br.com.gustavo.SpringToDo.repositories.TodoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;






@Controller
public class TodoController {

    private final TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @GetMapping("/")
    public ModelAndView list() {
        // var modelAndView = new ModelAndView("todo/list");
        // modelAndView.addObject("todos", todoRepository.findAll());
        // return modelAndView;

        //forma sintetica de fazer o que as 3 linhas acima fazem
        return new ModelAndView(
            "todo/list", 
            //modificacao no findAll para organizar as tarefas por ordem de data de entrega
            Map.of("todos", todoRepository.findAll(Sort.by("deadLine")))
        );
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("todo/form", Map.of("todo", new Todo()));
    }

    @PostMapping("/create")
    public String create(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo/form";
        }
        
        todoRepository.save(todo);
        return "redirect:/";
    }

    //necessario saber o id da tarefa, por isso a rota é mais específica
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        //precisa buscar essa tarefa especifica no bd
        var todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        //o todo nesse Map.of() eh um optional
        return new ModelAndView("todo/form", Map.of("todo", todo.get()));
    }
    
    @PostMapping("/edit/{id}")
    public String edit(@Valid Todo todo, BindingResult result) {
        //a JPA sabera se deve cadastrar ou editar baseado no id
        //todo.setId(id); se tornou obsoleto pois no formulario, ha um input hidden onde eh gerado o id
        if (result.hasErrors()) {
            return "todo/form";
        }
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        var todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("todo/delete", Map.of("todo", todo.get()));
    }

    @PostMapping("/delete/{id}")
    public String delete(Todo todo) {
        todoRepository.delete(todo);
        return "redirect:/";
    }
    
    //Sempre que criar uma rota que, ao ser executada, ela muda o estado da aplicacao, setando algo por ex, ela deve ser executada via POST ao inves de GET
    @PostMapping("/finish/{id}") 
    public String finish(@PathVariable Long id) {
        //primeiro, buscar a tarefa
        var optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var todo = optionalTodo.get();
        todo.markAsFinished();
        todoRepository.save(todo);
        return "redirect:/";
    }
    
    
}
