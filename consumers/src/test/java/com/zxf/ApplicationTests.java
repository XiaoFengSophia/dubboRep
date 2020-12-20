package com.zxf;

import com.zxf.entities.Emp;
import com.zxf.service.IEhcacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//    @Autowired
//    private CacheManager cacheManager;

    @Autowired
    private IEhcacheService ehcacheService;

	@Test
	public void contextLoads() {
//        Cache cache= cacheManager.getCache("empCache");
        List<Emp> emps = ehcacheService.queryAllEmp();
	}

}
