package com.tjcloud.platform.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Yann.Xia on 2015/3/2.
 */
@Component
public class FileUtils {

    @Async
    public void copyURLToFile(URL source, File destination) throws IOException {
        org.apache.commons.io.FileUtils.copyURLToFile(source, destination);
    }
}
