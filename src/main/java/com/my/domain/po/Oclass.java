package com.my.domain.po;

public class Oclass {
    private Long id;
    private String name;
    private Long code;

    public Oclass(Long id, String name, Long code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Oclass() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "oclass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
