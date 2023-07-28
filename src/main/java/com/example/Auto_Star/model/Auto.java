package com.example.Auto_Star.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTO")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Model", columnDefinition = "text")
    private String model;
    @Column(name = "City")
    private String city;
    @Column(name = "Owner")
    private String owner;
    @Column(name = "Price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auto")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreate;
    public void init(){
        dateOfCreate = LocalDateTime.now();
    } //Якунин 4 Видео 13:58 Делаем метод для сохранения данных о Картинке
}