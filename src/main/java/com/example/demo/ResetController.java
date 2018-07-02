package com.example.demo;


import com.example.demo.entity.OAuthUser;
import com.example.demo.entity.TestYang;
import com.example.demo.repository.OAuthUserRepository;
import com.example.demo.repository.TestYangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ResetController {

    @Autowired
    private OAuthUserRepository oAuthUserRepository;

    private static Long count = 301L;

    @Autowired
    private TestYangRepository testYangRepository;

    @Autowired
    private JDBCTemplate jdbcTemplate;

    @RequestMapping("yang")
    public String test() {
//        testYangRepository.findByaID("");
        jdbcTemplate.getList();
        return "success";
    }

    @RequestMapping("yang1")
    public String test1() {
        TestYang testYang = new TestYang();
        testYang.setId(count++);
        testYang.setName("");
        testYang.setArea("faefawef");
        testYangRepository.save(testYang);
        return "success";
    }



    @RequestMapping("")
    public Object home() {
        Map map = new HashMap<String, Object>();
        map.put("time", new Date());
        return map;
    }

    @RequestMapping("findAll")
    public Object findAll() {
        return oAuthUserRepository.findAll();
    }

    @RequestMapping("save")
    public Object save() {
        OAuthUser user = new OAuthUser();
        user.setProviderType(UUID.randomUUID().toString());
        user.setProviderUserId(UUID.randomUUID().toString());
        user.setTenantId(UUID.randomUUID().hashCode());
        user.setAgentUserId(UUID.randomUUID().toString());
        user.setCreateAt(new Date());
        oAuthUserRepository.save(user);
        return user;
    }


    @RequestMapping("update")
    public Object update() {
        Optional<OAuthUser> user = oAuthUserRepository.findById(60L);
        if (user.isPresent()) {
            OAuthUser u = user.get();
            u.setProviderType(UUID.randomUUID().toString());
            u.setProviderUserId(UUID.randomUUID().toString());
            u.setTenantId(UUID.randomUUID().hashCode());
            u.setAgentUserId(UUID.randomUUID().toString());
            oAuthUserRepository.save(u);
            return u;
        }
        return null;
    }

}
