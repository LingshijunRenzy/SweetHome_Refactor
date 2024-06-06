package org.tomjerry.sweethome.vo.response;

import org.springframework.data.domain.Page;

public class SearchResponse <T>{
    private Integer code;
    private String message;
    private T data;
    private Integer totalPages;
    private Long totalElements;

    public SearchResponse(Integer code, String message, Page<T> data) {
        this.code = code;
        this.message = message;
        this.data = (T) data.getContent();
        this.totalPages = data.getTotalPages();
        this.totalElements = data.getTotalElements();
    }

    //Getter and Setter

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
