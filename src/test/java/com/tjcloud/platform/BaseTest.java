package com.tjcloud.platform;

import com.tjcloud.platform.component.BaseComponent;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Yann.Xia on 2015/3/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class BaseTest extends BaseComponent {
}
