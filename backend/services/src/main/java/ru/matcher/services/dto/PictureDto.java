package ru.matcher.services.dto;

/**
 * Dto класс для картинки.
 *
 * @author Николай Евсюков
 */
public class PictureDto {

    private Integer id;
    private String name;
    private String type;
    private byte[] data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
