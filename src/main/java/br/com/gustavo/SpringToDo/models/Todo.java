package br.com.gustavo.SpringToDo.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

import java.time.LocalDate;

//as anotações servem para gerar mais controle sobre a aplicação
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    //para tornar o atributo sempre no padrao brasileiro
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate deadLine;

    @Column(nullable = true)
    private LocalDate finishedAt;

    //agora aplica-se o padrão Java Bean, tendo que ter um construtor vazio
    public Todo() {
        this.createdAt = LocalDateTime.now();
    }

    //metodo para setar o finishedAt na hora em que for concluida a tarefa
    //podia ser feito diretamente no controller
    public void markAsFinished() {
        this.finishedAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }


    //incluiremos tambem o haschode and equals para comparar os objetos
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    //toString para o title e Id
    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + "]";
    }       
    

}
