package br.com.gustavo.SpringToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//para automatizar essa tarefa, é preciso informar os tipos generics do JpaRepository (T e Id)

import br.com.gustavo.SpringToDo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
// a implemetacao da interface eh automatica, so precisa ser definida
}
