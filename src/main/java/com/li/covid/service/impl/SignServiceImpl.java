package com.li.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.covid.entity.Sign;
import com.li.covid.mapper.SignMapper;
import com.li.covid.service.ISignService;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign> implements ISignService {

}
