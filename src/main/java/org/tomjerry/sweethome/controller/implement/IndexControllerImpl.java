package org.tomjerry.sweethome.controller.implement;

import org.tomjerry.sweethome.controller.IndexController;

public class IndexControllerImpl implements IndexController {
    @Override
    public String index() {
        return "Hello World!";
    }
}
