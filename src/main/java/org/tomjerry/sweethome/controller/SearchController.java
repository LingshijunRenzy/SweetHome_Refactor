package org.tomjerry.sweethome.controller;

import org.tomjerry.sweethome.vo.response.SearchResponse;

public interface SearchController {
    public SearchResponse<?> search(String keyword, String type, Integer page, Integer size);
}
