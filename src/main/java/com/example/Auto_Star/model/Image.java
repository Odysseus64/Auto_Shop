package com.example.Auto_Star.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Original_File_Name")
    private String originalFileName;
    @Column(name = "Size")
    private Long size;
    @Column(name = "Content_Type")
    private String contentType;
    @Column(name = "Is_Preview_Image")
    boolean isPreviewImage;
    @Lob
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Auto auto;
}

