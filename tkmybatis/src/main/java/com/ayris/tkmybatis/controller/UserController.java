package com.ayris.tkmybatis.controller;

import com.ayris.tkmybatis.base.Page;
import com.ayris.tkmybatis.base.Response;
import com.ayris.tkmybatis.domain.TUser;
import com.ayris.tkmybatis.domain.dto.UserDto;
import com.ayris.tkmybatis.domain.mapper.UserMapper;
import com.ayris.tkmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page")
    public Response<Page<TUser>> pageList() {
        Example example = new Example(TUser.class);
        Page<TUser> page = userService.selectPageByExample(example, 1, 10, null);
        return Response.success(page);
    }

    @GetMapping("mapDto")
    public Response<List<UserDto>> mapDto() {
        Example example = new Example(TUser.class);
        Page<TUser> page = userService.selectPageByExample(example, 1, 10, null);

        List<UserDto> userDtoList=page.getContents().stream().map(UserMapper.INSTANCE::toDto).collect(Collectors.toList());
        return Response.success(userDtoList);
    }

}
