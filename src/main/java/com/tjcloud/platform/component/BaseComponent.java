package com.tjcloud.platform.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseComponent {
    protected final Logger logger;

    public BaseComponent() {
        logger = LoggerFactory.getLogger(this.getClass());
    }
}
